/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Categorias;


/**
 *
 * @author Senai
 */
public class CategoriasDAO {
    public void cat(Categorias user) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO categorias(nome) VALUES (?)");
            stmt.setString(1, user.getNome());
            

            stmt.executeUpdate();
            stmt.close();                                                              
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
