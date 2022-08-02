package Controller;

import DAO.ClienteDAO;
import Model.Cliente;
import Model.Endereco;
import java.sql.ResultSet;

public class ClienteController {
    
    public static int cadastrarDB(String nome, String telefone, String email, String sexo, String estadoCivil, String nascimento, String cpf, String cnpj, String cpfNaoFormatado, String cnpjNaoFormatadoString, String endereco, int numero, String complemento, String cep, String cidade, String uf, String bairro){
        //Cria instancia da classe Cliente
        Cliente clienteObj = new Cliente();
        
        //Seta os atributos
        clienteObj.setNome(nome);
        clienteObj.setTelefone(telefone);
        clienteObj.setEmail(email);
        clienteObj.setSexo(sexo);
        clienteObj.setEstadoCivil(estadoCivil);
        clienteObj.setNascimento(nascimento);
        clienteObj.setCpf(cpf);
        clienteObj.setCnpj(cnpj);
        clienteObj.setCpfNaoFormatado(cpfNaoFormatado);
        clienteObj.setCnpjNaoFormatado(cnpjNaoFormatadoString);
        
        //Salva no DB e retorna codigo do cliente
        int codCliente = ClienteDAO.cadastrarDBCliente(clienteObj);
        
        //Confirmação p/ usuário
        if (codCliente != 0){
            //Caso tenha conseguido inserir na tabela cliente, inserir o endereco na tabela endereco
            
            //Cria instancia da classe endereco
            Endereco enderecoObj = new Endereco();
            
            //Seta os atributos
            enderecoObj.setCodCliente(codCliente);
            enderecoObj.setEndereco(endereco);
            enderecoObj.setNumero(numero);
            enderecoObj.setComplemento(complemento);
            enderecoObj.setCep(cep);
            enderecoObj.setCidade(cidade);
            enderecoObj.setUf(uf);
            enderecoObj.setBairro(bairro);
            
            //Insere no DB e retorna objeto
            boolean resultado = ClienteDAO.cadastrarDBEndereco(enderecoObj);
            
            if (resultado == true){
                return codCliente;
            } else {
                return 0;
            }
        } else {
            return codCliente;
        }
    }
    
    public static ResultSet consultarDBCliente(int codigo, String cpf, String cnpj, String cpfNaoFormatado, String cnpjNaoFormatadoString, String nome){
        //Cria instancia da classe Produto
        Cliente clienteObj = new Cliente();
        
        //Seta os atributos
        //Caso seja CPF
        clienteObj.setCpf(cpf);
        clienteObj.setCnpj(cnpj);
        clienteObj.setCpfNaoFormatado(cpfNaoFormatado);
        clienteObj.setCnpjNaoFormatado(cnpjNaoFormatadoString);
        clienteObj.setCodigo(codigo);
        clienteObj.setNome(nome);
        
        //Salva no DB e retorna objeto
        ResultSet resultado = ClienteDAO.consultarDBCliente(clienteObj);
        
        //Confirmação p/ usuário
        return resultado;
    }
    
    public static ResultSet consultarDBEndereco(int codigoCliente){
        //Cria instancia da classe Produto
        Endereco enderecoObj = new Endereco();
        
        //Seta os atributos
        enderecoObj.setCodCliente(codigoCliente);
        
        //Consulta o DB e retorna objeto
        ResultSet resultado = ClienteDAO.consultarDBEndereco(enderecoObj);
        
        //Confirmação p/ usuário
        return resultado;
    }
    
    public static boolean editarDBCliente(int codigoCliente, String nome, String telefone, String email, String nascimento, String cpf, String cnpj, String cnpfUnformatted, String cpfUnformatted, String sexo, String estadoCivil){
        //Cria instancia da classe Cliente
        Cliente clienteObj = new Cliente();
        
        //Seta os atributos
        clienteObj.setCodigo(codigoCliente);
        clienteObj.setNome(nome);
        clienteObj.setTelefone(telefone);
        clienteObj.setEmail(email);
        clienteObj.setNascimento(nascimento);
        clienteObj.setCpf(cpf);
        clienteObj.setCnpj(cnpj);
        clienteObj.setCpfNaoFormatado(cpfUnformatted);
        clienteObj.setCnpjNaoFormatado(cnpfUnformatted);
        clienteObj.setSexo(sexo);
        clienteObj.setEstadoCivil(estadoCivil);
        
        //Atualiza no DB e retorna objetoW
        boolean resultado = ClienteDAO.editarDBCliente(clienteObj, codigoCliente);
        
        if (resultado == true){
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean editarDBEndereco(int codigoCliente, String endereco, int numero, String complemento, String cep, String cidade, String uf, String bairro){
        //Cria instancia da classe Produto
        Endereco enderecoObj = new Endereco();
        
        //Seta os atributos
        enderecoObj.setCodCliente(codigoCliente);
        enderecoObj.setEndereco(endereco);
        enderecoObj.setNumero(numero);
        enderecoObj.setComplemento(complemento);
        enderecoObj.setCep(cep);
        enderecoObj.setCidade(cidade);
        enderecoObj.setUf(uf);
        enderecoObj.setBairro(bairro);
        
        //Atualiza no DB e retorna objetoW
        boolean resultado = ClienteDAO.editarDBEndereco(enderecoObj);
        
        if (resultado == true){
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean excluirDB(int codigoCliente){
        //Cria instancia da classe Endereco
        Endereco enderecoObj = new Endereco();
        
        //Seta os atributos
        enderecoObj.setCodCliente(codigoCliente);
        
        //Exclui os dados no DB de endereco e retorna objeto
        boolean resultado = ClienteDAO.excluirDBEndereco(enderecoObj);
        
        //Caso tenha conseguido realizar a exclusao do endereco do cliente, realizar a exclusao do cliente
        if (resultado == true){
            //Cria instancia da classe Endereco
            Cliente clienteObj = new Cliente();
            
            //Seta os atributos
            clienteObj.setCodigo(codigoCliente);
            
            boolean resultado2 = ClienteDAO.excluirDBCliente(clienteObj);
            
            if (resultado2 == true){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
