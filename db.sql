CREATE DATABASE pi;
USE pi;

CREATE TABLE cliente (
	codCliente smallint NOT NULL primary key auto_increment,
	nome varchar(255) NOT NULL,
	telefone varchar(15) NOT NULL,
	email varchar(255) NOT NULL,
	sexo varchar(20) NULL,
	estadoCivil varchar(255) NULL,
	nascimento varchar(10) NULL,
	cpf varchar(14) NULL,
	cnpj varchar(18) NULL,
	dataCadastro DATETIME DEFAULT now() NOT NULL,
	ultimaAtualizacao DATETIME ON UPDATE now() NULL
);

CREATE TABLE backup_cliente (
	codCliente smallint NOT NULL primary key,
	nome varchar(255) NOT NULL,
	telefone varchar(15) NOT NULL,
	email varchar(255) NOT NULL,
	sexo varchar(20) NULL,
	estadoCivil varchar(255) NULL,
	nascimento varchar(10) NULL,
	cpf varchar(14) NULL,
	cnpj varchar(18) NULL,
	dataCadastro DATETIME DEFAULT now() NOT NULL,
	ultimaAtualizacao DATETIME ON UPDATE now() NULL
);

CREATE TABLE endereco (
	codEndereco smallint NOT NULL primary key auto_increment,
    codCliente smallint NOT NULL,
	endereco varchar(255) NOT NULL,
	numero int(11) NOT NULL,
	complemento varchar(255) NULL,
	cep varchar(255) NOT NULL,
	cidade varchar(255) NOT NULL,
	uf varchar(2) NOT NULL,
	bairro varchar(255) NOT NULL,
    FOREIGN KEY (codCliente)
        REFERENCES cliente(codCliente)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE produto (
	codProduto smallint NOT NULL primary key auto_increment,
	nome varchar(255) NOT NULL,
	codigoDeBarras bigint(25) NOT NULL,
	estoque int(11) NOT NULL,
	reservado int(11) NULL,
	alocados int(11) NULL,
	liquido int(11) NULL,
	valor decimal(10,2) NOT NULL,
	fornecedor varchar(255) NOT NULL,
	cor varchar(30) NOT NULL,
	dataCadastro DATETIME DEFAULT now() NOT NULL,
	ultimaAtualizacao DATETIME ON UPDATE now() NULL
);

CREATE TABLE venda (
    codVenda SMALLINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    codCliente SMALLINT NOT NULL,
    valorVenda decimal(10,2) NOT NULL,
    itensVenda smallint NOT NULL,
    dataVenda DATETIME DEFAULT NOW() NOT NULL,
    ultimaAtualizacao DATETIME ON UPDATE NOW() NULL,
    FOREIGN KEY (codCliente)
        REFERENCES cliente(codCliente)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE detalhesVenda (
	codVenda smallint NOT null,
	codDetalhes smallint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    codProduto smallint not null,
    nomeProduto varchar(255) not null,
    valorProduto decimal(10,2) NOT null,
    FOREIGN KEY (codVenda)
        REFERENCES venda(codVenda)
        ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY (codProduto)
        REFERENCES produto(codProduto)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

#Cria função responsável por verificar se existe estoque disponível para o produto desejado (retorna 1 caso sim, 0 caso nao)
delimiter $$	
CREATE FUNCTION verifica_estoque_produto (codigoProduto smallint)
returns smallint
BEGIN
	DECLARE foo smallint;

	SELECT estoque INTO foo FROM produto WHERE codProduto = codigoProduto;
    
    RETURN foo;
END $$	

#Cria a trigger responsável por atualizar o estoque dos produtos, assim que uma venda for realizada
delimiter $$
CREATE TRIGGER atualiza_estoque_produto AFTER INSERT ON detalhesVenda FOR EACH ROW
BEGIN
	UPDATE produto set estoque = estoque - 1 WHERE codProduto = new.codProduto;
END $$

#Cria trigger que faz backup do cadastro dos clientes
delimiter $$
CREATE TRIGGER backup_dados_clientes BEFORE UPDATE ON cliente FOR EACH ROW
BEGIN
	#Primeiro deleta caso já existia alguma inserção mais antiga desse cliente
    DELETE FROM backup_cliente WHERE codCliente = old.codCliente;
    #Atualiza com o backup mais recente
	INSERT INTO backup_cliente (codCliente, nome, telefone, email, sexo, estadoCivil, nascimento, cpf, cnpj, dataCadastro, ultimaAtualizacao) VALUES (old.codCliente, old.nome, old.telefone, old.email, old.sexo, old.estadoCivil, old.nascimento, old.cpf, old.cnpj, old.dataCadastro, old.ultimaAtualizacao);
END $$