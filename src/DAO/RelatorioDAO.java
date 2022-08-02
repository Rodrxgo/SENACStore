package DAO;

import Model.Relatorio;
import Utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RelatorioDAO {
    
    public static ResultSet consultarDBVenda(Relatorio relatorioObj){
        //Infos DB
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
        
            //Verifica qual dos campos o usuário preencheu, e monta a query baseado nisso
            if (relatorioObj.getCodVenda() != 0){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE codVenda = ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setInt(1, relatorioObj.getCodVenda());
            } else if (relatorioObj.getCodCliente() != 0){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE codCliente = ?");
                 
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setInt(1, relatorioObj.getCodCliente());
            } else if (!relatorioObj.getDataInicio().isEmpty() && !relatorioObj.getDataFim().isEmpty()){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE dataVenda >= ? AND dataVenda <= ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, relatorioObj.getDataInicio());
                instrucaoSQL.setString(2, relatorioObj.getDataFim());
            } else if (!relatorioObj.getDataInicio().isEmpty() && !relatorioObj.getDataFim().isEmpty() && relatorioObj.getValorInicio() != 0D && relatorioObj.getValorFim() != 0D){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE dataVenda >= ? AND dataVenda <= ? AND valorVenda >= ? AND valorVenda <= ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, relatorioObj.getDataInicio());
                instrucaoSQL.setString(2, relatorioObj.getDataFim());
                instrucaoSQL.setDouble(3, relatorioObj.getValorInicio());
                instrucaoSQL.setDouble(4, relatorioObj.getValorFim());
            } else if (!relatorioObj.getDataInicio().isEmpty() && relatorioObj.getDataFim().isEmpty() && relatorioObj.getValorInicio() != 0D && relatorioObj.getValorFim() != 0D){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE dataVenda >= ? AND valorVenda >= ? AND valorVenda <= ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, relatorioObj.getDataInicio());
                instrucaoSQL.setDouble(2, relatorioObj.getValorInicio()); 
                instrucaoSQL.setDouble(3, relatorioObj.getValorFim());
            } else if (relatorioObj.getDataInicio().isEmpty() && !relatorioObj.getDataFim().isEmpty() && relatorioObj.getValorInicio() != 0D && relatorioObj.getValorFim() != 0D){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE dataVenda <= ? AND valorVenda >= ? AND valorVenda <= ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, relatorioObj.getDataFim());
                instrucaoSQL.setDouble(2, relatorioObj.getValorInicio()); 
                instrucaoSQL.setDouble(3, relatorioObj.getValorFim());
            } else if (relatorioObj.getDataInicio().isEmpty() && relatorioObj.getDataFim().isEmpty() && relatorioObj.getValorInicio() != 0D && relatorioObj.getValorFim() != 0D){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE valorVenda >= ? AND valorVenda <= ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setDouble(1, relatorioObj.getValorInicio()); 
                instrucaoSQL.setDouble(2, relatorioObj.getValorFim());
            } else if (relatorioObj.getDataInicio().isEmpty() && relatorioObj.getDataFim().isEmpty() && relatorioObj.getValorInicio() == 0D && relatorioObj.getValorFim() != 0D){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE valorVenda <= ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setDouble(1, relatorioObj.getValorFim());
            } else if (relatorioObj.getDataInicio().isEmpty() && relatorioObj.getDataFim().isEmpty() && relatorioObj.getValorInicio() != 0D && relatorioObj.getValorFim() == 0D){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE valorVenda >= ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setDouble(1, relatorioObj.getValorInicio());
            } else if (!relatorioObj.getDataInicio().isEmpty() && relatorioObj.getDataFim().isEmpty()){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE dataVenda >= ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, relatorioObj.getDataInicio());
            } else if (relatorioObj.getDataInicio().isEmpty() && !relatorioObj.getDataFim().isEmpty()){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE dataVenda <= ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, relatorioObj.getDataFim());
            } else {
                //Caso estejam todos vazios
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda");
            }
            
            //Executa o comando no SGBD
            resultado = instrucaoSQL.executeQuery();
            
            return resultado; 
        } catch (Exception e){
            return resultado; 
        }
    }
    
    public static ResultSet consultarDBDetalhesVenda(Relatorio relatorioObj){
        //Infos DB
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM detalhesVenda WHERE codVenda = ?");

            //Adicionando os parâmetros ao comando SQL
            instrucaoSQL.setInt(1, relatorioObj.getCodVenda());
            
            //Executa o comando no SGBD
            resultado = instrucaoSQL.executeQuery();
            
            return resultado; 
        } catch (Exception e){
            return resultado; 
        }
    }
}
