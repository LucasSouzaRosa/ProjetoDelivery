/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import abstratas.BasePessoa;

/**
 *
 * @author lucas
 */
public class Cliente extends BasePessoa{
    private String referencia;
    private String endereco;
    private Cidade cidade;

    public Cliente() {
        super();
        this.setReferencia("Vazio");
        this.setEndereco("Vazio");
        this.setCidade(null);
    }

    public Cliente(String referencia, String endereco, Cidade cidade, int id, String nome, String telefone) {
        super(id, nome, telefone);
        this.setReferencia(referencia);
        this.setEndereco(endereco);
        this.setCidade(cidade);
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia.trim().isEmpty() ? "Vazio" : referencia.toUpperCase();
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty() ? "Vazio" : endereco.toUpperCase();
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public Cidade getCidade() {
        return this.cidade;
    }
    
    
    
}
