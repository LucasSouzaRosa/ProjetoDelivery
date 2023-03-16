/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import controller.daoCidade;
import java.sql.SQLException;
import model.Cidade;

/**
 *
 * @author lucas
 */
public class crudCidade {
    public static void main(String[] args) {
        Cidade c1 = new Cidade(0, "Criciuma");
        Cidade c2 = new Cidade(0, "Içara");
        Cidade c3 = new Cidade(0, "Cocal do Sul");
        Cidade c4 = new Cidade(0, "Siderópolis");
        
        //criar umobjeto para acessar os recursos da table cidade
        
        daoCidade dao = new daoCidade();
        
        try {
            //dao.create(c1);
            //Cidade c = new Cidade(3, "Cocal");
            //System.out.println(dao.update(c));
            //System.out.println(dao.delete(c));
            Cidade c = dao.read(2);
            System.out.println(c == null ? "Não localizado" : c.getNome());
            
            //
            //
            for (Cidade cidade : dao.read()) {
                System.out.println(cidade.getId() + "\t" + cidade.getNome());
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
