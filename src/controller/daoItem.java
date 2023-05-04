/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abstratas.BaseDao;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.Item;
import model.Pedido;

/**
 *
 * @author lucas
 */
public class daoItem extends BaseDao{
    public int create(Item item) throws SQLException {
        String SQL = "insert into item id_pedido, id_produto, observacoes, quantidade, preco values (?,?,?,?,?,?)";
        return super.executeUpdate(SQL, item.getId(), item.getPedido().getId(), item.getProduto().getId(), item.getObservacoes(), item.getQuantidade(),
                                   item.getPreco());
    }
    
    public int update(Item item)throws SQLException{
        String SQL = "update item set id_pedido=?, id_produto=?, observacoes=?, quantidade=?, preco=? where id=?";
        return super.executeUpdate(SQL, item.getId(), item.getPedido().getId(), item.getProduto().getId(), item.getObservacoes(), item.getQuantidade(),
                                   item.getPreco(), item.getId());
    }
    
    public int delete(Item item) throws SQLException {
        String SQL = "delete from item where id = " + item.getId();
        return super.executeUpdate(SQL);
    }
    
    public Item read(int id) throws SQLException{
        String SQL = "select * from item where id=" + id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? createObject(rs) : null);
    }
    
    public List<Item> read(Pedido pedido) throws SQLException {
        String SQL = "select * from item where id_pedido = ? order by id";
        ResultSet rs = super.executeQuery(SQL, pedido.getId());
        List<Item> retorno = new LinkedList<>();
        
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        
        return retorno;
    }
    
    public Item createObject(ResultSet rs) throws SQLException{
        return new Item (rs.getInt("id"), 
                            new daoPedido().read(rs.getInt("id_pedido")), 
                            new daoProduto().read(rs.getInt("id_produto")), 
                            rs.getString("observacoes"), 
                            rs.getDouble("quantidade"), 
                            rs.getDouble("preco"));
    }
}
