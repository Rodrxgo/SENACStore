package DAO;

import Model.Venda;
import Utils.GerenciadorConexao;
import java.sql.*;
import java.util.ArrayList;

public class VendaDAO {
    
    public static int cadastrarDBVenda(Venda vendaObj, ArrayList<ArrayList> pedido){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;
        int codVenda = 0;
        
        //Tenta fazer a inserção no DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            //Caso tenha reservados
            //Executa o comando no SGBD, inserindo na tabela venda
            instrucaoSQL = conexao.prepareStatement("INSERT INTO venda (codCliente, valorVenda, itensVenda) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
             
            //Adicionando os parâmetros ao comando SQL
            instrucaoSQL.setInt(1, vendaObj.getCodCliente());
            instrucaoSQL.setDouble(2, vendaObj.getValorVenda());
            instrucaoSQL.setInt(3, vendaObj.getItensVenda());
             
            //Executa o comando no SGBD
            linhasAfetadas = instrucaoSQL.executeUpdate();
            
            ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupera o Cod da venda
            if (generatedKeys.next()) {
                codVenda = generatedKeys.getInt(1);
            }else {
                throw new SQLException("Falha ao obter o Cod da venda!.");
            }
                    
            return codVenda;
        } catch (Exception e){
            return codVenda;
        }
    }
    
    public static boolean cadastrarDBDetalhesVenda(int codVenda, ArrayList<ArrayList> pedido){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;
        
        //Tenta fazer a inserção no DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            //Pegando todo os itens do pedido
            for (int i = 0; i < pedido.size(); i++){
                //Criando um array com todas as colunas do item
                ArrayList<String> itemCarrinho = new ArrayList();

                for (int j = 0; j < pedido.get(i).size(); j++){
                    //Pega a coluna do item atual
                    String colunaItemAtual = (String) pedido.get(i).get(j);
                    
                    //Adiciona a coluna atual ao array do item
                    itemCarrinho.add(colunaItemAtual);
                }
                
                //Insere no DB o item atual do carrinho
                instrucaoSQL = conexao.prepareStatement("INSERT INTO detalhesVenda (codVenda, codProduto, nomeProduto, valorProduto) values (?,?,?,?)");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setInt(1, codVenda);
                instrucaoSQL.setInt(2, Integer.parseInt(itemCarrinho.get(0)));
                instrucaoSQL.setString(3, itemCarrinho.get(1));
                instrucaoSQL.setString(4, itemCarrinho.get(4));
                
                //Executa o comando no SGBD
                linhasAfetadas = instrucaoSQL.executeUpdate();
            }   
            
            return true;
        } catch (Exception e){
            return false;
        }
    }
    
    public static ResultSet consultaEstoqueDBProduto(int codigoProduto){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet resultado = null;
        
        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT verifica_estoque_produto(?) as 'estoque' FROM produto LIMIT 1");

            //Adicionando os parâmetros ao comando SQL
            instrucaoSQL.setInt(1, codigoProduto);
            
            //Executa o comando no SGBD
            resultado = instrucaoSQL.executeQuery();
            
            return resultado;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return resultado;
        }
    }
}
