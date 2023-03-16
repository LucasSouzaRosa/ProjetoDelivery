/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstratas;

import banco.Dados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author lucas
 */
abstract public class BaseDao {
    
    //retorna um preparedStatement criado com um SQL
    private PreparedStatement getStatement(String sql) throws SQLException{
        return Dados.getConnection().prepareStatement(sql);
    }
    
    //recebe uma lista de parâmetros e faz a execução em um preparedStatement
    protected int executeUpdate(String sql, Object... args) throws SQLException{
        PreparedStatement pst = this.getStatement(sql);
        //passagem de parâmetros
        for (int i =0; i < args.length; i++){
            pst.setObject((i+1), args[i]);
        }
        //executar
        return pst.executeUpdate();
    }
    
    //
    protected ResultSet executeQuery(String sql, Object... args) throws SQLException{
        PreparedStatement pst = this.getStatement(sql);
        //passagem de parâmetros
        for (int i =0; i < args.length; i++){
            pst.setObject((i+1), args[i]);
        }
        //executar
        return pst.executeQuery();
    }
}
