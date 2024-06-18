package model.bean;

import java.util.Base64;

public class Historico_compras {

    private int idCompra;
    private int idUsuario;
    private int idProdutos;
    private String nome;
    private String categoria;
    private String descricao;
    private float preco;
    private int quantidade;
    private float total_preco;

    public Historico_compras() {
    }

    public Historico_compras(int idCompra, int idUsuario, int idProdutos, String nome, String categoria, String descricao, float preco, int quantidade, float total_preco) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.idProdutos = idProdutos;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.total_preco = total_preco;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public float getTotal_preco() {
        return total_preco;
    }

    public void setTotal_preco(float total_preco) {
        this.total_preco = total_preco;
    }
    
    
 

   
    
    

}
