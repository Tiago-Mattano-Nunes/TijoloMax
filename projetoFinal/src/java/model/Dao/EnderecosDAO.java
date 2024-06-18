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
import javax.activation.DataSource;
import model.bean.Cadastro;
import model.bean.Carrinho;
import model.bean.Enderecos;

public class EnderecosDAO {

    public void create(Enderecos endereco) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            // Inserindo os dados na tabela "Enderecos" junto com o idUsuario
            stmt = conexao.prepareStatement("INSERT INTO Enderecos(idUsuario, Cep, Estado, Cidade, Complemento, Numero, Rua) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, endereco.getIdUsuario()); // Fornecendo o idUsuario
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getEstado());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getComplemento());
            stmt.setString(6, endereco.getNumero());
            stmt.setString(7, endereco.getRua());
  

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    public List<Enderecos> listarEndereco(int idUsuario) {
        List<Enderecos> endereco = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareCall("SELECT * FROM enderecos WHERE IdUsuario = ?");
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Enderecos cad = new Enderecos();
                cad.setIdEndereco(rs.getInt("idEndereco"));
                cad.setIdUsuario(rs.getInt("idUsuario"));
                
                cad.setCep(rs.getString("cep"));
                cad.setEstado(rs.getString("estado"));
                cad.setCidade(rs.getString("cidade"));
                cad.setComplemento(rs.getString("complemento"));
                cad.setNumero(rs.getString("numero"));
                cad.setRua(rs.getString("rua"));
                endereco.add(cad);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

}
