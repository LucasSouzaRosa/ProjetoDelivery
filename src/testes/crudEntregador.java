/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import controller.daoEntregador;
import java.sql.SQLException;
import model.Entregador;

/**
 *
 * @author lucas
 */
public class crudEntregador {
     public static void main(String[] args) {
        Entregador c1 = new Entregador(0, "Carlinhos", "4854121615");
        Entregador c2 = new Entregador(0, "Huguinho", "4854121615");
        Entregador c3 = new Entregador(0, "Zezinho", "4854121615");
        
        
        
        //criar umobjeto para acessar os recursos da table cidade
        
         daoEntregador dao = new daoEntregador();
        
        try {
            dao.create(c1);
            //Entregador c = new Entregador(4, "Rodrigo", "4851615161");
            //dao.create(c2);
            //dao.create(c3);
            //System.out.println(dao.update(c));
            //System.out.println(dao.delete(c));
            //Cidade c = dao.read(2);
            //System.out.println(c == null ? "Não localizado" : c.getNome());
            
            //
            //
            //for (Entregador entregador : dao.read()) {
            //   System.out.println(entregador.getId() + "\t" + entregador.getNome() + "\t" + entregador.getNome() + "\n");
            //}
            
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
     }
}
