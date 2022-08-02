package DAO;

import Model.Produto;
import Utils.GerenciadorConexao;
import java.sql.*;

public class ProdutoDAO {

    public static boolean cadastrarDB(Produto produtoObj){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;

        //Tenta fazer a inserção no DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            //Tenta fazer a inserção no DB
            if (produtoObj.getReservados() == 0){
                //Caso nao tenha reservados
                instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome, codigoDeBarras, estoque, valor, fornecedor, cor) VALUES (?,?,?,?,?,?)");
                 
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, produtoObj.getNome());
                instrucaoSQL.setDouble(2, produtoObj.getCodigoDeBarras());
                instrucaoSQL.setInt(3, produtoObj.getEstoque());
                instrucaoSQL.setDouble(4, produtoObj.getValor());
                instrucaoSQL.setString(5, produtoObj.getFornecedor());
                instrucaoSQL.setString(6, produtoObj.getCor());
            } else { 
                //Caso tenha reservados
                instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome, codigoDeBarras, estoque, reservado, valor, fornecedor, cor) VALUES (?,?,?,?,?,?,?)");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, produtoObj.getNome());
                instrucaoSQL.setDouble(2, produtoObj.getCodigoDeBarras());
                instrucaoSQL.setInt(3, produtoObj.getEstoque());
                instrucaoSQL.setInt(4, produtoObj.getReservados());
                instrucaoSQL.setDouble(5, produtoObj.getValor());
                instrucaoSQL.setString(6, produtoObj.getFornecedor());
                instrucaoSQL.setString(7, produtoObj.getCor());
            }
            
            //Executa o comando no SGBD
            linhasAfetadas = instrucaoSQL.executeUpdate();
            
            //Caso tenha dado certo o insert
            if (linhasAfetadas > 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static ResultSet consultarDB(Produto produtoObj){
        //Infos DB
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
        
            //Verifica qual dos 3 campos o usuário preencheu (e se nao preencheu nenhum)
            if (produtoObj.getCodigo() != 0){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE codProduto = ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setInt(1, produtoObj.getCodigo());
            } else if (produtoObj.getCodigo() == 0 && !produtoObj.getNome().isEmpty() && !produtoObj.getFornecedor().isEmpty()){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto codProduto WHERE nome like ? and fornecedor like ?");
                 
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, produtoObj.getNome() + "%");
                instrucaoSQL.setString(2, produtoObj.getFornecedor() + "%");
            } else if (produtoObj.getCodigo() == 0 && !produtoObj.getNome().isEmpty() && produtoObj.getCor().isEmpty() && produtoObj.getFornecedor().isEmpty()){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE nome like ?"); 
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, produtoObj.getNome() + "%");
            } else if (produtoObj.getCodigo() == 0 && produtoObj.getNome().isEmpty() && !produtoObj.getCor().isEmpty() && !produtoObj.getFornecedor().isEmpty()){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE nome like ? and cor like ? and fornecedor like ?"); 
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, produtoObj.getNome() + "%");
                instrucaoSQL.setString(2, produtoObj.getCor() + "%");
                instrucaoSQL.setString(3, produtoObj.getFornecedor() + "%");
            } else if (produtoObj.getCodigo() == 0 && produtoObj.getNome().isEmpty() && produtoObj.getCor().isEmpty() && !produtoObj.getFornecedor().isEmpty()){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE fornecedor like ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, produtoObj.getFornecedor() + "%");
            } else {
                //Caso estejam todos vazios
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto");
            }
            
            //Executa o comando no SGBD
            resultado = instrucaoSQL.executeQuery();
            
            return resultado; 
        } catch (Exception e){
            return resultado; 
        }
    }
    
    public static boolean editarDB(Produto produtoObj, int codigo){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;
        
        //Tenta fazer a atualização no DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
            
            if (produtoObj.getReservados() == 0){
                instrucaoSQL = conexao.prepareStatement("UPDATE produto SET nome = ?, codigoDeBarras = ?, estoque = ?, valor = ?, fornecedor = ?, cor = ? WHERE codProduto = ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, produtoObj.getNome());
                instrucaoSQL.setDouble(2, produtoObj.getCodigoDeBarras());
                instrucaoSQL.setInt(3, produtoObj.getEstoque());
                instrucaoSQL.setDouble(4, produtoObj.getValor());
                instrucaoSQL.setString(5, produtoObj.getFornecedor());
                instrucaoSQL.setString(6, produtoObj.getCor());
                instrucaoSQL.setString(7, codigo + "");
            } else {
                instrucaoSQL = conexao.prepareStatement("UPDATE produto SET nome = ?, codigoDeBarras = ?, estoque = ?, reservado = ?, valor = ?, fornecedor = ?, cor = ? WHERE codProduto = ?");

                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, produtoObj.getNome());
                instrucaoSQL.setDouble(2, produtoObj.getCodigoDeBarras());
                instrucaoSQL.setInt(3, produtoObj.getEstoque());
                instrucaoSQL.setInt(4, produtoObj.getReservados());
                instrucaoSQL.setDouble(5, produtoObj.getValor());
                instrucaoSQL.setString(6, produtoObj.getFornecedor());
                instrucaoSQL.setString(7, produtoObj.getCor());
                instrucaoSQL.setInt(8, codigo);
            }
            
            //Executa o comando no SGBD
            linhasAfetadas = instrucaoSQL.executeUpdate();
            
            //Caso tenha dado certo o update
            if (linhasAfetadas > 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean excluirDB(Produto produtoObj){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;
        
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("DELETE FROM produto WHERE codProduto = ?");
            
            //Adicionando os parâmetros ao comando SQL
            instrucaoSQL.setInt(1, produtoObj.getCodigo());
            
            //Executa o comando no SGBD
            linhasAfetadas = instrucaoSQL.executeUpdate();
            
            //Caso tenha dado certo o delete
            if (linhasAfetadas > 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
}
