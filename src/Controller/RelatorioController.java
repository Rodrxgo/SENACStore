package Controller;

import DAO.RelatorioDAO;
import Model.Relatorio;
import java.sql.ResultSet;

public class RelatorioController {
    
    public static ResultSet consultarDBVenda(String dataInicio, String dataFim, Double valorInicio, Double valorFim, int codVenda, int codCliente){
        //Cria instancia da classe Produto
        Relatorio relatorioObj = new Relatorio();
        
        //Seta os atributos
        relatorioObj.setDataInicio(dataInicio);
        relatorioObj.setDataFim(dataFim);
        relatorioObj.setValorInicio(valorInicio);
        relatorioObj.setValorFim(valorFim);
        relatorioObj.setCodVenda(codVenda);
        relatorioObj.setCodCliente(codCliente);
        
        //Salva no DB e retorna objeto
        ResultSet resultado = RelatorioDAO.consultarDBVenda(relatorioObj);
        
        //Confirmação p/ usuário
        return resultado;
    }
    
    public static ResultSet consultarDBDetalhesVenda(int codVenda){
        //Cria instancia da classe Produto
        Relatorio relatorioObj = new Relatorio();
        
        //Seta os atributos
        relatorioObj.setCodVenda(codVenda);
        
        //Salva no DB e retorna objeto
        ResultSet resultado = RelatorioDAO.consultarDBDetalhesVenda(relatorioObj);
        
        //Confirmação p/ usuário
        return resultado;
    }
}
