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
import model.bean.Categorias;

/**
 *
 * @author Senai
 */
public class CadastroDAO {

    public int validaUser(Cadastro user) {
        int idUsuario = 0;

        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = con.prepareStatement("SELECT idUsuario FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();

            if (rs.next()) {
                idUsuario = rs.getInt("idUsuario"); 
                System.out.println("DAO: " + idUsuario);
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUsuario; 
    }

    public void createq(Cadastro user) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO Usuario(nome, senha, email, telefone, cpf) VALUES (?,?,?,?,?)");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getTelefone());
            stmt.setString(5, user.getCpf());

            stmt.executeUpdate();
            stmt.close();                                                              
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cadastro> leia(int Cadastro) {
        List<Cadastro> usuario = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE IdUsuario = (?,?,?,?,?)");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cadastro cad = new Cadastro();
                cad.setIdUsuario(rs.getInt("idUsuario"));
                cad.setNome(rs.getString("nome"));
                cad.setSenha(rs.getString("senha"));
                cad.setTelefone(rs.getString("telefone"));
                cad.setCpf(rs.getString("cpf"));
                usuario.add(cad);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<Cadastro> leiar() {
        List<Cadastro> usuario = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cadastro cad = new Cadastro();
                cad.setIdUsuario(rs.getInt("idUsuario"));
                cad.setNome(rs.getString("nome"));
                cad.setSenha(rs.getString("senha"));
                cad.setEmail(rs.getString("email"));
                cad.setTelefone(rs.getString("telefone"));
                cad.setCpf(rs.getString("cpf"));
                usuario.add(cad);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
 public Cadastro pegarPorId(int id){
       Cadastro cad = new Cadastro();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario where idUsuario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                
                cad.setIdUsuario(rs.getInt("idUsuario"));
                cad.setNome(rs.getString("nome"));
                cad.setSenha(rs.getString("senha"));
                cad.setEmail(rs.getString("email"));
                cad.setTelefone(rs.getString("telefone"));
                cad.setCpf(rs.getString("cpf"));
               
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cad;
    }

}
