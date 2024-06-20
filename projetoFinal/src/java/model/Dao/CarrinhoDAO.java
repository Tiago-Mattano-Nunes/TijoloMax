/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Cadastro;
import model.bean.Carrinho;
import model.bean.Produtos;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {

    
public List<Carrinho> listar(int idUsuario) {
        List<Carrinho> carrinho = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareCall("SELECT * FROM carrinho WHERE IdUsuario = ?");
             stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Carrinho a = new Carrinho();
                a.setIdCarrinho(rs.getInt("idCarrinho"));
                a.setIdProdutos(rs.getInt("idProdutos"));
                a.setIdUsuario(rs.getInt("idUsuario"));
                a.setNomeCarrinho(rs.getString("nome_carrinho"));
                a.setImagemCarrinho(rs.getBytes("imagem_carrinho"));
            
                a.setDescricaoCarrinho(rs.getString("descricao_carrinho"));
                a.setPrecoCarrinho(rs.getFloat("preco_carrinho"));
               
                a.setQuantidadeCarrinho(rs.getInt("quantidade_carrinho"));
                a.setTotal_preco(rs.getInt("total_preco"));
                carrinho.add(a);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinho;
    }
   

   public void criar(Carrinho carrinho) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO carrinho(idProdutos, idUsuario ,nome_carrinho, imagem_carrinho, descricao_carrinho, preco_carrinho, quantidade_carrinho)VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, carrinho.getIdProdutos());
            stmt.setInt(2, carrinho.getIdUsuario());
            stmt.setString(3, carrinho.getNomeCarrinho());
            stmt.setBytes(4, carrinho.getImagemCarrinho());
            stmt.setString(5, carrinho.getDescricaoCarrinho());
            stmt.setFloat(6, carrinho.getPrecoCarrinho());
            stmt.setInt(7, carrinho.getQuantidadeCarrinho());;
           
            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
   
   public float calcular(int idUsuario) {
    float totalPreco = 0.0f;
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        stmt = conexao.prepareStatement("SELECT SUM(total_preco) AS total_preco FROM carrinho where idUsuario = ?;");
         stmt.setInt(1, idUsuario);
        rs = stmt.executeQuery();
        if (rs.next()) {
            totalPreco = rs.getFloat("total_preco");
        }

        rs.close();
        stmt.close();
        conexao.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return totalPreco;
}

}
