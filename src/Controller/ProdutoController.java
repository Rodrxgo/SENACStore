package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import java.sql.ResultSet;

public class ProdutoController {
    
    public static boolean cadastrarDB(String nome, Double codigoDeBarras, int estoque, int reservados, Double valor, String fornecedor, String cor){
        //Cria instancia da classe Produto
        Produto produtoObj = new Produto();
        
        //Seta os atributos
        produtoObj.setNome(nome);
        produtoObj.setCodigoDeBarras(codigoDeBarras);
        produtoObj.setEstoque(estoque);
        produtoObj.setReservados(reservados);
        produtoObj.setValor(valor);
        produtoObj.setFornecedor(fornecedor);
        produtoObj.setCor(cor);
        
        //Salva no DB e retorna objeto
        boolean resultado = ProdutoDAO.cadastrarDB(produtoObj);
        
        //Confirmação p/ usuário
        if (resultado == true){
            return true;
        } else {
            return false;
        }
    }
    
    public static ResultSet consultarDB(int codigo, String fornecedor, String nome, String cor){
        //Cria instancia da classe Produto
        Produto produtoObj = new Produto();

        //Seta os atributos
        produtoObj.setCodigo(codigo);
        produtoObj.setNome(nome);
        produtoObj.setCor(cor);
        //Caso tenha selecionado todas as marcas
        if (fornecedor == "Todas"){
            produtoObj.setFornecedor("");
        } else {
            produtoObj.setFornecedor(fornecedor);
        }
        
        //Salva no DB e retorna objeto
        ResultSet resultado = ProdutoDAO.consultarDB(produtoObj);
        
        //Confirmação p/ usuário
        return resultado;
    }
    
    public static boolean editarDB(int codigoProduto, String nomeProduto, Double codigoDeBarrasProduto, int estoqueProduto, int reservadosProduto, Double valorProduto, String fornecedor, String cor){
        //Cria instancia da classe Produto
        Produto produtoObj = new Produto();

        //Seta os atributos
        produtoObj.setCodigo(codigoProduto);
        produtoObj.setNome(nomeProduto);
        produtoObj.setCodigoDeBarras(codigoDeBarrasProduto);
        produtoObj.setEstoque(estoqueProduto);
        produtoObj.setReservados(reservadosProduto);
        produtoObj.setValor(valorProduto);
        produtoObj.setFornecedor(fornecedor);
        produtoObj.setCor(cor);

        //Atualiza no DB e retorna objeto
        boolean resultado = ProdutoDAO.editarDB(produtoObj, codigoProduto);

        //Confirmação p/ usuário
        return resultado;
    }
    
    public static boolean excluirDB(int codigoProduto){
        //Cria instancia da classe Produto
        Produto produtoObj = new Produto();
        
        //Seta os atributos
        produtoObj.setCodigo(codigoProduto);
        
        //Atualiza no DB e retorna objeto
        boolean resultado = ProdutoDAO.excluirDB(produtoObj);
        
        //Confirmação p/ usuário
        return resultado;
    }
}
