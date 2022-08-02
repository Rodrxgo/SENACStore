package Controller;

import DAO.VendaDAO;
import Model.Venda;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VendaController {
    
    public static int cadastrarDB(int codigoCliente, Double valorVenda, int itensVenda, ArrayList<ArrayList> pedido){
        //Cria instancia da classe Venda
        Venda vendaObj = new Venda();
        
        //Seta os atributos venda
        vendaObj.setCodCliente(codigoCliente);
        vendaObj.setValorVenda(valorVenda);
        vendaObj.setItensVenda(itensVenda);
        //Seta os atributos detalhesVenda
        
        //Insere no DB
        int codVenda = VendaDAO.cadastrarDBVenda(vendaObj, pedido);
        
        //Confirmação p/ usuário
        if (codVenda != 0){
            //Caso tenha conseguido inserir na tabela venda, inserir o resto na tabela detalhesVenda
            
            //Insere no DB e retorna objeto
            boolean resultado = VendaDAO.cadastrarDBDetalhesVenda(codVenda, pedido);
            
            if (resultado == true){
                return codVenda;
            } else {
                return 0;
            }
        } else {
            return codVenda;
        }
    }
    
    public static ResultSet consultaEstoqueDB(int codigoProduto){
        //Pesquisa no DB se o produto possui estoque ou nao
        ResultSet resultado = VendaDAO.consultaEstoqueDBProduto(codigoProduto);
        
        //Confirmação p/ usuário
        return resultado;
    }
}
