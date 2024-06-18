/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Base64;

/**
 *
 * @author arlin
 */
public class Estoque {
    
    private int idEstoque;
    private String nome;
    private byte[] imagem;
    private String categoria;
    private String descricao;
    private double preco;
    private int quantidade;
    private int idProdutos;

    public Estoque() {
    }
    
      public String getImagemBase64() {
        if (imagem != null) {
            return Base64.getEncoder().encodeToString(imagem);
        } else {
            return "";
        }
    }

    public Estoque(int idEstoque, String nome, byte[] imagem, String categoria, String descricao, double preco, int quantidade, int idProdutos) {
        this.idEstoque = idEstoque;
        this.nome = nome;
        this.imagem = imagem;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.idProdutos = idProdutos;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    
}
