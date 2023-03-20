/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abstratas.BaseDao;
import java.sql.SQLException;
import model.Entregador;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.Cidade;

/**
 *
 * @author lucas
 */
public class daoEntregador extends BaseDao{
    
    public int Create (Entregador entregador) throws SQLException {
        String SQL = "insert into entregador (nome) values(?)";
        
        return super.executeUpdate(SQL, entregador.getNome());
    }
    
    public Entregador Read (int id) throws SQLException {
        String SQL = "select * from entregador where id = ?";
        
        ResultSet rs = super.executeQuery(SQL, id);
        return (rs.next() ? createObject(rs) : null);
    }
    
        
    //retornar a lista com todas os entregadores
    public List<Entregador> read() throws SQLException{
        String SQL = "select * from entregador order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Entregador> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }
    
    //transformar o ResultSet em um objeto entregador
    private Entregador createObject(ResultSet rs) throws SQLException{
        return new Entregador(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"));
    }
    
    
    public int update(Entregador entregador) throws SQLException {
        String SQL = "update entregador set nome=? where id=?";
        return super.executeUpdate(SQL, entregador.getNome(), entregador.getId());
    }
    
    public int delete(Entregador entregador) throws SQLException{
        return super.executeUpdate("delete from entregador where id="+entregador.getId());
    }
}
    

