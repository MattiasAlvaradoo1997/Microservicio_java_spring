CREATE TABLE Persona (
    Id BIGINT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Genero VARCHAR(50),
    Edad INT,
    Identificacion VARCHAR(50),
    Direccion VARCHAR(200),
    Telefono VARCHAR(20)
);

CREATE TABLE Cliente (
    ClienteId BIGINT PRIMARY KEY AUTO_INCREMENT,
    Contrasena VARCHAR(100),
    Estado BOOLEAN,
    Id BIGINT,
    FOREIGN KEY (Id) REFERENCES Persona(Id)
);

CREATE TABLE Cuenta (
    Id BIGINT PRIMARY KEY AUTO_INCREMENT,
    NumeroCuenta VARCHAR(20),
    TipoCuenta VARCHAR(50),
    SaldoInicial DECIMAL(18, 2),
    Estado BOOLEAN,
    ClienteId BIGINT,
    FOREIGN KEY (ClienteId) REFERENCES Cliente(ClienteId)
);

CREATE TABLE Movimiento (
    Id BIGINT PRIMARY KEY AUTO_INCREMENT,
    Fecha TIMESTAMP,
    TipoMovimiento VARCHAR(50),
    Valor DECIMAL(18, 2),
    Saldo DECIMAL(18, 2),
    CuentaId BIGINT,
    FOREIGN KEY (CuentaId) REFERENCES Cuenta(Id)
);
