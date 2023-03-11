/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author lucas
 */
public enum TipoEntrega {
    E("Entrega"),
    R("Retirada");
    
    private String descricao;

    private TipoEntrega(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
}
