package Model;

public class Cliente {

    //Atributos cliente
    private int codigo;
    private String nome;
    private String telefone;
    private String email;
    private String sexo;
    private String estadoCivil;
    private String nascimento;
    private String cpf;
    private String cnpj;
    private String cpfNaoFormatado;
    private String cnpjNaoFormatado;
    
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getCpfNaoFormatado() {
        return cpfNaoFormatado;
    }

    public void setCpfNaoFormatado(String CpfNaoFormatado) {
        this.cpfNaoFormatado = CpfNaoFormatado;
    }
    
    public String getCnpjNaoFormatado() {
        return cnpjNaoFormatado;
    }

    public void setCnpjNaoFormatado(String cnpjNaoFormatado) {
        this.cnpjNaoFormatado = cnpjNaoFormatado;
    }
}
