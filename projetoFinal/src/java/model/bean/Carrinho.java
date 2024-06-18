/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Base64;

public class Carrinho {

    private int idCarrinho;
    private String nomeCarrinho;
    private byte[] imagemCarrinho;
    private String categoriaCarrinho;
    private String descricaoCarrinho;
    private float precoCarrinho;
    private int quantidadeCarrinho;
    private int idProdutos;
    private int tamanhoCarrinho;
    private int idUsuario;
    private float total_preco;

    public Carrinho() {
    }

    public String getImagemBase64() {
        if (imagemCarrinho != null) {
            return Base64.getEncoder().encodeToString(imagemCarrinho);
        } else {
            return "";
        }
    }

    public Carrinho(int idCarrinho, String nomeCarrinho, byte[] imagemCarrinho, String categoriaCarrinho, String descricaoCarrinho, float precoCarrinho, int quantidadeCarrinho, int idProdutos, int tamanhoCarrinho, int idUsuario, float total_preco) {
        this.idCarrinho = idCarrinho;
        this.nomeCarrinho = nomeCarrinho;
        this.imagemCarrinho = imagemCarrinho;
        this.categoriaCarrinho = categoriaCarrinho;
        this.descricaoCarrinho = descricaoCarrinho;
        this.precoCarrinho = precoCarrinho;
        this.quantidadeCarrinho = quantidadeCarrinho;
        this.idProdutos = idProdutos;
        this.tamanhoCarrinho = tamanhoCarrinho;
        this.idUsuario = idUsuario;
        this.total_preco = total_preco;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getNomeCarrinho() {
        return nomeCarrinho;
    }

    public void setNomeCarrinho(String nomeCarrinho) {
        this.nomeCarrinho = nomeCarrinho;
    }

    public byte[] getImagemCarrinho() {
        return imagemCarrinho;
    }

    public void setImagemCarrinho(byte[] imagemCarrinho) {
        this.imagemCarrinho = imagemCarrinho;
    }

    public String getCategoriaCarrinho() {
        return categoriaCarrinho;
    }

    public void setCategoriaCarrinho(String categoriaCarrinho) {
        this.categoriaCarrinho = categoriaCarrinho;
    }

    public String getDescricaoCarrinho() {
        return descricaoCarrinho;
    }

    public void setDescricaoCarrinho(String descricaoCarrinho) {
        this.descricaoCarrinho = descricaoCarrinho;
    }

    public float getPrecoCarrinho() {
        return precoCarrinho;
    }

    public void setPrecoCarrinho(float precoCarrinho) {
        this.precoCarrinho = precoCarrinho;
    }

    public int getQuantidadeCarrinho() {
        return quantidadeCarrinho;
    }

    public void setQuantidadeCarrinho(int quantidadeCarrinho) {
        this.quantidadeCarrinho = quantidadeCarrinho;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public int getTamanhoCarrinho() {
        return tamanhoCarrinho;
    }

    public void setTamanhoCarrinho(int tamanhoCarrinho) {
        this.tamanhoCarrinho = tamanhoCarrinho;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getTotal_preco() {
        return total_preco;
    }

    public void setTotal_preco(float total_preco) {
        this.total_preco = total_preco;
    }

}
