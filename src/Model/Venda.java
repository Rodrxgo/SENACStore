package Model;

public class Venda {
    //Atributos venda
    private int codVenda;
    private int codCliente;
    private Double valorVenda;
    private int itensVenda;
    private String dataVenda;

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
    
    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(int itensVenda) {
        this.itensVenda = itensVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
}
