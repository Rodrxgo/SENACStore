package Model;

public class Relatorio {
    //Atributos venda
    private String dataInicio;
    private String dataFim;
    private Double valorInicio;
    private Double valorFim;
    private int codVenda;
    private int codCliente;

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Double getValorInicio() {
        return valorInicio;
    }

    public void setValorInicio(Double valorInicio) {
        this.valorInicio = valorInicio;
    }

    public Double getValorFim() {
        return valorFim;
    }

    public void setValorFim(Double valorFim) {
        this.valorFim = valorFim;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    
}
