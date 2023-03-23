/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abstratas.BaseDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Categoria;

/**
 *
 * @author lucas
 */
public class daoCategoria extends BaseDao{
    public int create (Categoria categoria) throws SQLException {
        String SQL = "insert into categoria (nome) values(?)";
        
        return super.executeUpdate(SQL, categoria.getNome());
    }
    
    public Categoria read (int id) throws SQLException {
        String SQL = "select * from categoria where id = ?";
        
        ResultSet rs = super.executeQuery(SQL, id);
        return (rs.next() ? createObject(rs) : null);
    }
    
        
    //retornar a lista com todas as categorias
    public List<Categoria> read() throws SQLException{
        String SQL = "select * from categoria order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Categoria> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }
    
    //transformar o ResultSet em um objeto categoria
    private Categoria createObject(ResultSet rs) throws SQLException{
        return new Categoria(rs.getInt("id"), rs.getString("nome"));
    }
    
    
    public int update(Categoria categoria) throws SQLException {
        String SQL = "update categoria set nome=? where id=?";
        return super.executeUpdate(SQL, categoria.getNome(), categoria.getId());
    }
    
    public int delete(Categoria categoria) throws SQLException{
        return super.executeUpdate("delete from categoria where id="+categoria.getId());
    }
}
