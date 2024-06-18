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
import model.bean.Categorias;

/**
 *
 * @author Senai
 */
public class CatDAO {
    public List<Categorias> leia() {
        List<Categorias> categoria = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM categorias");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Categorias cro = new Categorias();
                cro.setIdCategoria(rs.getInt("idCategoria"));
                cro.setNome(rs.getString("nome"));
                categoria.add(cro);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria;
        }
}
