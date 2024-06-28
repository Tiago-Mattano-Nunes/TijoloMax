/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Base64;

/**
 *
 * @author Senai
 */
public class Produtos {

    private int idProdutos;
    private String nomeProdutos;
    private int categoria;
    private String descricao;
    private float preco;
    private int quantidade;
    private byte[] imagem;

    public Produtos() {
    }

    public String getImagemBase64() {
        if (imagem != null) {
            return Base64.getEncoder().encodeToString(imagem);
        } else {
            return "";
        }
    }

    public Produtos(int idProdutos, String nomeProdutos, int categoria, String descricao, float preco, int quantidade, byte[] imagem) {
        this.idProdutos = idProdutos;
        this.nomeProdutos = nomeProdutos;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imagem = imagem;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getNomeProdutos() {
        return nomeProdutos;
    }

    public void setNomeProdutos(String nomeProdutos) {
        this.nomeProdutos = nomeProdutos;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

   
}
