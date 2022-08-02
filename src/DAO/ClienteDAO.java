package DAO;

import Model.Cliente;
import Model.Endereco;
import Utils.GerenciadorConexao;
import java.sql.*;

public class ClienteDAO {
    
    public static int cadastrarDBCliente(Cliente clienteObj){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;
        int codCliente = 0;
        
        //Tenta fazer a inserção no DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
            
            if (clienteObj.getCpfNaoFormatado().isEmpty()){
                //Caso seja CNPJ
                //Executa o comando no SGBD
                instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome, telefone, email, cnpj) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, clienteObj.getNome());
                instrucaoSQL.setString(2, clienteObj.getTelefone());
                instrucaoSQL.setString(3, clienteObj.getEmail());
                instrucaoSQL.setString(4, clienteObj.getCnpj());
            } else {
                //Caso seja CPF
                //Executa o comando no SGBD
                instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome, telefone, email, sexo, estadocivil, nascimento, cpf) values (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, clienteObj.getNome());
                instrucaoSQL.setString(2, clienteObj.getTelefone());
                instrucaoSQL.setString(3, clienteObj.getEmail());
                instrucaoSQL.setString(4, clienteObj.getSexo());
                instrucaoSQL.setString(5, clienteObj.getEstadoCivil());
                instrucaoSQL.setString(6, clienteObj.getNascimento());
                instrucaoSQL.setString(7, clienteObj.getCpf());
            }
            
            //Executa o comando no SGBD
            linhasAfetadas = instrucaoSQL.executeUpdate();
            
            //Pega o codigo do cliente que foi gerado
            ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupera o Cod da venda
            if (generatedKeys.next()) {
                codCliente = generatedKeys.getInt(1);
            }
            
            return codCliente;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return codCliente;
        }
    }
    
    public static boolean cadastrarDBEndereco(Endereco enderecoObj){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;
        
        //Tenta fazer a inserção no DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
            
            if (enderecoObj.getComplemento().isEmpty()){
                //Caso nao tenha complemento
                //Executa o comando no SGBD
                instrucaoSQL = conexao.prepareStatement("INSERT INTO endereco (codCliente, endereco, numero, "
                                            + "cep, cidade, uf, bairro) VALUES (?, ?, ?, ?, ?, ?, ?)");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setInt(1, enderecoObj.getCodCliente());
                instrucaoSQL.setString(2, enderecoObj.getEndereco());
                instrucaoSQL.setInt(3, enderecoObj.getNumero());
                instrucaoSQL.setString(4, enderecoObj.getCep());
                instrucaoSQL.setString(5, enderecoObj.getCidade());
                instrucaoSQL.setString(6, enderecoObj.getUf());
                instrucaoSQL.setString(7, enderecoObj.getBairro());
            } else {
                //Caso tenha complemento
                //Executa o comando no SGBD
                instrucaoSQL = conexao.prepareStatement("INSERT INTO endereco (codCliente, endereco, numero, complemento,"
                                            + "cep, cidade, uf, bairro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setInt(1, enderecoObj.getCodCliente());
                instrucaoSQL.setString(2, enderecoObj.getEndereco());
                instrucaoSQL.setInt(3, enderecoObj.getNumero());
                instrucaoSQL.setString(4, enderecoObj.getComplemento());
                instrucaoSQL.setString(5, enderecoObj.getCep());
                instrucaoSQL.setString(6, enderecoObj.getCidade());
                instrucaoSQL.setString(7, enderecoObj.getUf());
                instrucaoSQL.setString(8, enderecoObj.getBairro());
            }
            
            //Executa o comando no SGBD
            linhasAfetadas = instrucaoSQL.executeUpdate();
            
            //Caso tenha dado certo o insert
            if (linhasAfetadas >= 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
    
    public static ResultSet consultarDBCliente(Cliente clienteObj){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet resultado = null;
        
        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
            
            //Verifica qual dos 3 campos o usuário preencheu (e se nao preencheu nenhum)
            if (clienteObj.getCodigo() != 0){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE codCliente = ?");

                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setInt(1, clienteObj.getCodigo());
            } else if (clienteObj.getCodigo() == 0 && !clienteObj.getNome().isEmpty() && clienteObj.getCpfNaoFormatado().isEmpty() && clienteObj.getCnpjNaoFormatado().isEmpty()){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE nome like ?");
                
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, clienteObj.getNome() + "%");
            } else if (clienteObj.getCodigo() == 0 && clienteObj.getNome().isEmpty() && !clienteObj.getCpfNaoFormatado().isEmpty()){
               instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf like ?");
               
               //Adicionando os parâmetros ao comando SQL
               instrucaoSQL.setString(1, clienteObj.getCpf() + "%");
            } else if (clienteObj.getCodigo() == 0 && clienteObj.getNome().isEmpty() && !clienteObj.getCnpjNaoFormatado().isEmpty()){
               instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cnpj like ?");
               
               //Adicionando os parâmetros ao comando SQL
               instrucaoSQL.setString(1, clienteObj.getCnpj() + "%");
            } else {
                //Caso estejam todos vazios
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente");
            }
            
            //Executa o comando no SGBD
            resultado = instrucaoSQL.executeQuery();
            
            return resultado;
        } catch (Exception e){
            return resultado;
        }
    }
    
    public static ResultSet consultarDBEndereco(Endereco enderecoObj){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet resultado = null;
        
        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM endereco WHERE codCliente = ?");

            //Adicionando os parâmetros ao comando SQL
            instrucaoSQL.setInt(1, enderecoObj.getCodCliente());
            
            //Executa o comando no SGBD
            resultado = instrucaoSQL.executeQuery();
            
            return resultado;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return resultado;
        }
    }
    
    public static boolean editarDBCliente(Cliente clienteObj, int codigoCliente){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;

        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
            if (!clienteObj.getCnpjNaoFormatado().isEmpty()){
               //Caso seja CNPJ
               instrucaoSQL = conexao.prepareStatement("UPDATE cliente SET nome = ?, telefone = ?, email = ?, cnpj = ? WHERE codCliente = ?");
            
               //Adicionando os parâmetros ao comando SQL
               instrucaoSQL.setString(1, clienteObj.getNome());
               instrucaoSQL.setString(2, clienteObj.getTelefone());
               instrucaoSQL.setString(3, clienteObj.getEmail());
               instrucaoSQL.setString(4, clienteObj.getCnpj());
               instrucaoSQL.setInt(5, codigoCliente);
            } else {
                //Caso seja CPF
                instrucaoSQL = conexao.prepareStatement("UPDATE cliente SET nome = ?, telefone = ?, email = ?, sexo = ?, estadoCivil = ?, nascimento = ?, cpf = ? WHERE codCliente = ?");
            
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, clienteObj.getNome());
                instrucaoSQL.setString(2, clienteObj.getTelefone());
                instrucaoSQL.setString(3, clienteObj.getEmail());
                instrucaoSQL.setString(4, clienteObj.getSexo());
                instrucaoSQL.setString(5, clienteObj.getEstadoCivil());
                instrucaoSQL.setString(6, clienteObj.getNascimento());
                instrucaoSQL.setString(7, clienteObj.getCpf());
                instrucaoSQL.setInt(8, codigoCliente);
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
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean editarDBEndereco(Endereco enderecoObj){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;

        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();

            if (enderecoObj.getComplemento().isEmpty()){
                //Caso não tenha complemento
                instrucaoSQL = conexao.prepareStatement("UPDATE endereco SET endereco = ?, numero = ?, cep = ?, cidade = ?, uf = ?, bairro = ? WHERE codCliente = ?");
            
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, enderecoObj.getEndereco());
                instrucaoSQL.setInt(2, enderecoObj.getNumero());
                instrucaoSQL.setString(3, enderecoObj.getCep());
                instrucaoSQL.setString(4, enderecoObj.getCidade());
                instrucaoSQL.setString(5, enderecoObj.getUf());
                instrucaoSQL.setString(6, enderecoObj.getBairro());
                instrucaoSQL.setInt(7, enderecoObj.getCodCliente());
            } else {
                //Caso tenha complemento
                instrucaoSQL = conexao.prepareStatement("UPDATE endereco SET endereco = ?, numero = ?, complemento = ?, cep = ?, cidade = ?, uf = ?, bairro = ? WHERE codCliente = ?");
            
                //Adicionando os parâmetros ao comando SQL
                instrucaoSQL.setString(1, enderecoObj.getEndereco());
                instrucaoSQL.setInt(2, enderecoObj.getNumero());
                instrucaoSQL.setString(3, enderecoObj.getComplemento());
                instrucaoSQL.setString(4, enderecoObj.getCep());
                instrucaoSQL.setString(5, enderecoObj.getCidade());
                instrucaoSQL.setString(6, enderecoObj.getUf());
                instrucaoSQL.setString(7, enderecoObj.getBairro());
                instrucaoSQL.setInt(8, enderecoObj.getCodCliente());
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
    
    public static boolean excluirDBCliente(Cliente clienteObj){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;
        
        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
        
            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE codCliente = ?");
            
            //Adicionando os parâmetros ao comando SQL
            instrucaoSQL.setInt(1, clienteObj.getCodigo());
            
            //Executa o comando no SGBD
            linhasAfetadas = instrucaoSQL.executeUpdate();
            
            //Caso tenha dado certo o delete
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
    
    public static boolean excluirDBEndereco(Endereco enderecoObj){
        //Infos DB
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int linhasAfetadas;
        
        //Tenta se conectar ao DB
        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = GerenciadorConexao.abrirConexao();
        
            instrucaoSQL = conexao.prepareStatement("DELETE FROM endereco WHERE codCliente = ?");
            
            //Adicionando os parâmetros ao comando SQL
            instrucaoSQL.setInt(1, enderecoObj.getCodCliente());
            
            //Executa o comando no SGBD
            linhasAfetadas = instrucaoSQL.executeUpdate();
            
            //Caso tenha dado certo o delete
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
}
