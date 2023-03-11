/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lucas
 */
public class Item implements java.io.Serializable{
    private int id;
    private Pedido pedido;
    private Produto produto;
    private String observacoes;
    private double quantidade;
    private double preco;

    public Item() {
        this.setId(0);
        this.setPedido(null);
        this.setProduto(null);
        this.setObservacoes("Vazio");
        this.setQuantidade(0);
        this.setPreco(0);
    }
    
    public Item(int id, Pedido pedido, Produto produto, String observacoes, double quantidade, double preco) {
        this.setId(id);
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setObservacoes(observacoes);
        this.setQuantidade(quantidade);
        this.setPreco(preco);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes.toUpperCase();
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade < 0 ? 1 : quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco < 0 ? 0.1 : preco;
    }

    public int getId() {
        return this.id;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public double getQuantidade() {
        return this.quantidade;
    }

    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "Item: "
                + "Id: " + id 
                + " - Pedido: " + pedido 
                + " - Poduto: " + produto 
                + " - Quantidade: " + quantidade 
                + " - Preco: R$ " + preco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
