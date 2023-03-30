/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abstratas.BaseDao;
import java.sql.SQLException;
import model.Produto;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.Categoria;

/**
 *
 * @author lucas
 */
public class daoProduto extends BaseDao{
    public int create(Produto produto) throws SQLException {
        String SQL = "insert into  produto (nome, descricao, preco, categoria) values (?, ?, ?, ?)";
        return super.executeUpdate(SQL, produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getCategoria().getId());
    }
    
    public int update(Produto produto) throws SQLException {
        String SQL = "update produto set nome = ?, descricao = ?, preco = ?, categoria = ? where id = ?";
        return super.executeUpdate(SQL, produto.getNome(), 
                                        produto.getDescricao(),
                                        produto.getPreco(),
                                        produto.getCategoria().getId(),
                                        produto.getId());
    }
    
    public int delete(Produto produto) throws SQLException {
        String SQL = "delete from produto where id = ?";
        return super.executeUpdate(SQL, produto.getId());
    }
    
    public Produto read(int id) throws SQLException {
        String SQL = "select * from produto where id = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return (rs.next() ? createObject(rs) : null);
    }
    
    public List<Produto> read() throws SQLException {
        String SQL = "select * from produto";
        ResultSet rs = super.executeQuery(SQL);
        List<Produto> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(createObject(rs));
        }
        return retorno;
    }
    
    public Produto createObject(ResultSet rs) throws SQLException{
       return new Produto (rs.getInt("id"),
                           rs.getString("nome"),
                           rs.getString("descricao"),
                           rs.getDouble("preco"),
                           new daoCategoria().read(rs.getInt("categoria")));
    }
    
}
