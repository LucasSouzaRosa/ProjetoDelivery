/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstratas;

/**
 *
 * @author lucas
 */
abstract public class Base implements java.io.Serializable{
    
    private int id;
    private String nome;

    public Base() {
        this.setId(0);
        this.setNome("Sem nome");
    }
    
    public Base(int id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }
    //
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "Sem nome" : nome.toUpperCase();
    }
    //
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
    //
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
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
        final Base other = (Base) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
