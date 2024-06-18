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
import model.bean.Carrinho;
import model.bean.Historico_compras;

/**
 *
 * @author arlin
 */
public class Historico_comprasDAO {

    public List<Historico_compras> listarCompras(int idUsuario) {
        List<Historico_compras> compras = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareCall("SELECT * FROM Historico_compras WHERE IdUsuario = ?");
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Historico_compras a = new Historico_compras();
                a.setIdCompra(rs.getInt("idCompra"));
                a.setIdProdutos(rs.getInt("idProdutos"));
                a.setIdUsuario(rs.getInt("idUsuario"));            
                a.setNome(rs.getString("nome"));
      
                a.setCategoria(rs.getString("categoria"));
                a.setDescricao(rs.getString("descricao"));
                a.setPreco(rs.getFloat("preco"));

                a.setQuantidade(rs.getInt("quantidade"));
                a.setTotal_preco(rs.getInt("total_preco"));
                compras.add(a);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compras;
    }
}
