CREATE TABLE Veiculo (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    ano INT,
    modelo VARCHAR(255),
    cor VARCHAR(50),
    placa VARCHAR(10) UNIQUE NOT NULL,
    unico_dono BOOLEAN,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id)
);

CREATE TABLE Categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    rg VARCHAR(20) UNIQUE,
    telefone VARCHAR(20),
    referencia_comercial VARCHAR(255),
    data_nascimento DATE
);

CREATE TABLE Vendedor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    salario VARCHAR(255),
    telefone VARCHAR(20)
);

CREATE TABLE VendaVeiculo (
    id SERIAL PRIMARY KEY,
    data_cadastro DATE NOT NULL DEFAULT CURRENT_DATE,
    data_venda DATE NOT NULL,
    valor_desconto DOUBLE PRECISION,
    valor_final DOUBLE PRECISION NOT NULL,
    id_vendedor INT NOT NULL,
    id_cliente INT NOT NULL,
    id_veiculo INT NOT NULL,
    FOREIGN KEY (id_vendedor) REFERENCES Vendedor(id),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id),
    FOREIGN KEY (id_veiculo) REFERENCES Veiculo(id)
);