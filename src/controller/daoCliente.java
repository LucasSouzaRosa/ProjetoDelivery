/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abstratas.BaseDao;
import java.sql.SQLException;
import model.Cliente;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class daoCliente extends BaseDao {
    
    public int create (Cliente cliente) throws SQLException {
        String SQL = "insert into cliente (nome, endereco, telefone, referencia, cidade) values (?,?,?,?,?)";
        return super.executeUpdate(SQL, cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getReferencia(), cliente.getCidade().getId());
        
    }
    
    public int update(Cliente cliente) throws SQLException {
        String SQL = "update cliente set nome = ?, endereco = ?, telefone = ?, referencia = ?, cidade= ?, where id = ?";
        return super.executeUpdate(SQL, cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getReferencia(), cliente.getCidade().getId(), cliente.getId());
    }
    
    public int delete(Cliente cliente) throws SQLException {
        String SQL = "delete from cliente where id = " + cliente.getId();
        return super.executeUpdate(SQL);
    }
    
    //retorno de objetos
    public Cliente read(int id) throws SQLException{
        String SQL = "select * from cliente where id=" + id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? createObject(rs) : null);
    }
    //retorna uma lista com todos os clientes
    public List<Cliente> read() throws SQLException {
        String SQL = "select * from cliente order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Cliente> retorno = new LinkedList<>();
        
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        
        return retorno;
    }
    //
    public List<Cliente> read(String filtroNome) throws SQLException {
        String SQL = "select * from cliente where nome = ? order by nome";
        ResultSet rs = super.executeQuery(SQL, filtroNome.toUpperCase()+"%");
        List<Cliente> retorno = new LinkedList<>();
        
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        
        return retorno;
    }
    
    
    public Cliente createObject(ResultSet rs) throws SQLException{
        return new Cliente (rs.getInt("id"), 
                            rs.getString("nome"), 
                            rs.getString("telefone"), 
                            rs.getString("endereco"), 
                            rs.getString("referencia"),  
                            new daoCidade().read(rs.getInt("cidade")));
    }
    
}
