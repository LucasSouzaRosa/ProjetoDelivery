/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import abstratas.Base;

/**
 *
 * @author lucas
 */
public class Produto extends Base{
    
    private String descricao;
    private double preco;
    private Categoria categoria;

    public Produto() {
        super();
        this.setDescricao("Vazio");
        this.setPreco(0.0);
        this.setCategoria(null);
    }

    public Produto(String descricao, double preco, Categoria categoria, int id, String nome) {
        super(id, nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setCategoria(categoria);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().isEmpty() ? "Vazio" : descricao.toUpperCase();
    }

    public void setPreco(double preco) {
        this.preco = preco < 0.0 ? 0.01 : preco;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    public String getDescricao() {
        return this.descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }
    
    
    
    
    
}
