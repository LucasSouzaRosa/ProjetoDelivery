/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enums.TipoEntrega;
import enums.TipoPagamento;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author lucas
 */
public class Pedido implements java.io.Serializable{
    private int id;
    private LocalDate data;
    private Cliente cliente;
    private Entregador entregador;
    private double total;
    private TipoEntrega tipoEntrega;
    private TipoPagamento tipoPagamento;
    //o pedido deve conhecer os seus itens
    private LinkedList<Item> listaItem = new LinkedList<>();
    

    public Pedido() {
        this.setId(0);
        this.setData(null);
        this.setCliente(null);
        this.setEntregador(null);
        this.setTotal(0);
        this.setTipoEntrega(tipoEntrega.E);
        this.setTipoPagamento(tipoPagamento.D);
    }
     
    
    public Pedido(int id, LocalDate data, Cliente cliente, Entregador entregador, double total, TipoEntrega tipoEntrega, TipoPagamento tipoPagamento) {
        this.setId(id);
        this.setData(data);
        this.setCliente(cliente);
        this.setEntregador(entregador);
        this.setTotal(total);
        this.setTipoEntrega(tipoEntrega);
        this.setTipoPagamento(tipoPagamento);
    }
    
    public void addItem(Item item){
        this.listaItem.add(item);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data  == null ? LocalDate.now() : data;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public void setTotal(double total) {
        this.total = total < 0.0 ? 0.0 : total;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void setListaItem(LinkedList<Item> listaItem) {
        this.listaItem = listaItem;
    }
    

    public int getId() {
        return this.id;
    }

    public LocalDate getData() {
        return this.data;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Entregador getEntregador() {
        return this.entregador;
    }

    public double getTotal() {
        return this.total;
    }

    public TipoEntrega getTipoEntrega() {
        return this.tipoEntrega;
    }

    public TipoPagamento getTipoPagamento() {
        return this.tipoPagamento;
    }

    public LinkedList<Item> getListaItem() {
        return listaItem;
    }
    
    

    @Override
    public String toString() {
        return "Cliente: " + cliente + " - Data: " + data + " - Total: R$" + total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
