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
import model.bean.Produtos;

/**
 *
 * @author Senai
 */
public class ProdutosDAO {

    public List<Produtos> ler() {
        List<Produtos> produtos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setIdProdutos(rs.getInt("idProdutos"));
                produto.setNomeProdutos(rs.getString("nomeProdutos"));
                produto.setCategoria(rs.getInt("categoria"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getInt("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setImagem(rs.getBytes("imagem"));

                produtos.add(produto);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public void create(Produtos produto) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO produtos(nomeProdutos, imagem, categoria, descricao, preco, quantidade)VALUES(?,?,?,?,?,?)");
            stmt.setString(1, produto.getNomeProdutos());
            stmt.setBytes(2, produto.getImagem());
            stmt.setInt(3, produto.getCategoria());
            stmt.setString(4, produto.getDescricao());
            stmt.setFloat(5, produto.getPreco());
            stmt.setInt(6, produto.getQuantidade());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produtos> ler2(int id) {
        List<Produtos> produto = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE idProdutos = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos prt = new Produtos();
                prt.setIdProdutos(rs.getInt("idProdutos"));
                prt.setIdCategoria(rs.getInt("idCategoria"));
                prt.setNomeProdutos(rs.getString("nomeProdutos"));
                prt.setImagem(rs.getBytes("imagem"));
                prt.setCategoria(rs.getInt("categoria"));
                prt.setDescricao(rs.getString("descricao"));
                prt.setPreco(rs.getFloat("preco"));
                prt.setQuantidade(rs.getInt("quantidade"));
                produto.add(prt);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<Produtos> buscar(String pesquisar) {
        List<Produtos> produto = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nomeProdutos LIKE ?");
            stmt.setString(1, "%" + pesquisar + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos prt = new Produtos();
                prt.setIdProdutos(rs.getInt("idProdutos"));
                prt.setIdCategoria(rs.getInt("idCategoria"));
                prt.setNomeProdutos(rs.getString("nomeProdutos"));
                prt.setImagem(rs.getBytes("imagem"));
                prt.setCategoria(rs.getInt("categoria"));
                prt.setDescricao(rs.getString("descricao"));
                prt.setPreco(rs.getFloat("preco"));
                prt.setQuantidade(rs.getInt("quantidade"));
                produto.add(prt);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    
    /*
    public List<Produtos> ler(String categoria) {
        List<Produtos> livros = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM Produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos produtos = new Produtos();
                produtos.setIdProdutos(rs.getInt("idprodutos"));
                produtos.setIdCategoria(rs.getInt("idCategoria"));
                produtos.setNomeProdutos(rs.getString("nomeProdutos"));
                produtos.setCategoria(rs.getInt("categoria"));
                produtos.setDescricao(rs.getString("descricao"));
                produtos.setPreco(rs.getInt("preco"));
                produtos.setQuantidade(rs.getInt("quantidade"));
                produtos.setImagem(rs.getBytes("imagem"));
                livros.add(produtos);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }*/

    public List<Produtos> ler3(int categoria) {
        List<Produtos> produto = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE categoria = ?");
            stmt.setInt(1, categoria);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos prt = new Produtos();
                prt.setIdProdutos(rs.getInt("idProdutos"));
                prt.setIdCategoria(rs.getInt("idCategoria"));
                prt.setNomeProdutos(rs.getString("nomeProdutos"));
                prt.setImagem(rs.getBytes("imagem"));
                prt.setCategoria(rs.getInt("categoria"));
                prt.setDescricao(rs.getString("descricao"));
                prt.setPreco(rs.getFloat("preco"));
                prt.setQuantidade(rs.getInt("quantidade"));
                produto.add(prt);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }
}
