package Model;

public class Produto {
    
    //Atributos Produto
    private int codigo;
    private String nome;
    private Double codigoDeBarras;
    private int estoque;
    private int reservados;
    private int alocados;
    private int liquido;
    private Double valor;
    private String fornecedor;
    private String cor;
            
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(Double codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getReservados() {
        return reservados;
    }

    public void setReservados(int reservados) {
        this.reservados = reservados;
    }

    public int getAlocados() {
        return alocados;
    }

    public void setAlocados(int alocados) {
        this.alocados = alocados;
    }

    public int getLiquido() {
        return liquido;
    }

    public void setLiquido(int liquido) {
        this.liquido = liquido;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
