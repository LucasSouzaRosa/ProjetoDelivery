/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abstratas.BaseDao;
import java.sql.SQLException;
import model.Cidade;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class daoCidade extends BaseDao{
    
    public int create(Cidade cidade) throws SQLException{
        String SQL = "insert into cidade (nome) values(?)";
        
        return super.executeUpdate(SQL, cidade.getNome());
    }
    
    //retorna um objeto cidade a partir de um id
    public Cidade read(int id) throws SQLException{
        String SQL = "select * from cidade where id=?";
        ResultSet rs = super.executeQuery(SQL, id);
        
        return (rs.next() ? createObject(rs) : null);
    } 
    
    //retornar a lista com todas as cidades
    public List<Cidade> read() throws SQLException{
        String SQL = "select * from cidade order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Cidade> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }
    
    //transformar o ResultSet em um objeto cidade
    private Cidade createObject(ResultSet rs) throws SQLException{
        return new Cidade(rs.getInt("id"), rs.getString("nome"));
    }
    
    
    public int update(Cidade cidade) throws SQLException {
        String SQL = "update cidade set nome=? where id=?";
        return super.executeUpdate(SQL, cidade.getNome(), cidade.getId());
    }
    
    public int delete(Cidade cidade) throws SQLException{
        return super.executeUpdate("delete from cidade where id="+cidade.getId());
    }
}
