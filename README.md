# Microservicio_java_spring

# Microservicio_java_spring

## Descripción

Este proyecto implementa dos microservicios en Java utilizando Spring Boot para la gestión de Clientes, Cuentas y Movimientos. Los microservicios están diseñados siguiendo las mejores prácticas de programación, patrones de diseño, y se despliegan utilizando Docker. Se incluye también un esquema de base de datos SQL y un conjunto de pruebas unitarias e integradas.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Arquitectura](#arquitectura)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Instrucciones de Despliegue](#instrucciones-de-despliegue)
- [Pruebas](#pruebas)
- [API Endpoints](#api-endpoints)
- [Base de Datos](#base-de-datos)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Arquitectura

El proyecto se divide en dos microservicios:

1. **Microservicio 1: Gestión de Clientes y Personas**
2. **Microservicio 2: Gestión de Cuentas y Movimientos**

Estos microservicios se comunican de manera asincrónica y están diseñados para ser escalables y resilientes.

## Tecnologías Utilizadas

- **Java 11**
- **Spring Boot 2.5.4**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **Docker**
- **JUnit 5**
- **Mockito**
- **H2 Database (para pruebas)**
- **PostgreSQL/MySQL (para producción)**

## Estructura del Proyecto

```plaintext
microservicios
│
├── microservicio1
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   ├── com
│   │   │   │   │   └── ejemplo
│   │   │   │   │       └── microservicio1
│   │   │   │   │           ├── Microservicio1Application.java
│   │   │   │   │           ├── controller
│   │   │   │   │           │   └── ClienteController.java
│   │   │   │   │           ├── entity
│   │   │   │   │           │   ├── Cliente.java
│   │   │   │   │           │   ├── Persona.java
│   │   │   │   │           ├── exception
│   │   │   │   │           │   ├── ResourceNotFoundException.java
│   │   │   │   │           ├── repository
│   │   │   │   │           │   ├── ClienteRepository.java
│   │   │   │   │           ├── service
│   │   │   │   │           │   ├── ClienteService.java
│   │   │   │   │           ├── config
│   │   │   │   │           │   ├── GlobalExceptionHandler.java
│   │   │   │   │           ├── util
│   │   │   │   │           │   ├── ErrorDetails.java
│   │   │   │   │           ├── test
│   │   │   │   │           │   ├── ClienteServiceTests.java
│   │   │   │   │           │   ├── ClienteControllerIntegrationTests.java
│   │   │   ├── resources
│   │   │       ├── application.properties
│   │   │       ├── data.sql
│   ├── Dockerfile
│
├── microservicio2
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   ├── com
│   │   │   │   │   └── ejemplo
│   │   │   │   │       └── microservicio2
│   │   │   │   │           ├── Microservicio2Application.java
│   │   │   │   │           ├── controller
│   │   │   │   │           │   ├── CuentaController.java
│   │   │   │   │           │   ├── MovimientoController.java
│   │   │   │   │           ├── entity
│   │   │   │   │           │   ├── Cuenta.java
│   │   │   │   │           │   ├── Movimiento.java
│   │   │   │   │           ├── exception
│   │   │   │   │           │   ├── ResourceNotFoundException.java
│   │   │   │   │           │   ├── InsufficientFundsException.java
│   │   │   │   │           ├── repository
│   │   │   │   │           │   ├── CuentaRepository.java
│   │   │   │   │           │   ├── MovimientoRepository.java
│   │   │   │   │           ├── service
│   │   │   │   │           │   ├── CuentaService.java
│   │   │   │   │           │   ├── MovimientoService.java
│   │   │   │   │           ├── config
│   │   │   │   │           │   ├── GlobalExceptionHandler.java
│   │   │   │   │           ├── util
│   │   │   │   │           │   ├── ErrorDetails.java
│   │   │   │   │           ├── test
│   │   │   │   │           │   ├── CuentaServiceTests.java
│   │   │   │   │           │   ├── MovimientoServiceTests.java
│   │   │   ├── resources
│   │   │       ├── application.properties
│   │   │       ├── data.sql
│   ├── Dockerfile
│
├── docker-compose.yml
├── BaseDatos.sql
├── Collection.json
├── README.md
```

## Instrucciones de Despliegue
Requisitos
Docker: Asegúrate de tener Docker instalado. Puedes descargarlo desde aquí.
Docker Compose: Viene incluido con Docker Desktop.
Pasos para Desplegar
Clonar el repositorio desde GitHub:

### bash
Copiar código
git clone https://github.com/MattiasAlvaradoo1997/Microservicio_java_spring.git
cd Microservicio_java_spring
Navegar a cada directorio de microservicio y construir el proyecto con Maven:

### bash
Copiar código
cd microservicio1
./mvnw clean package
cd ../microservicio2
./mvnw clean package
Levantar los servicios con Docker Compose:

### bash
Copiar código
docker-compose up --build
Acceder a los endpoints:

Microservicio 1 (Clientes): http://localhost:8081/api/clientes
Microservicio 2 (Cuentas y Movimientos): http://localhost:8082/api/cuentas


## Pruebas
Pruebas Unitarias
Las pruebas unitarias están ubicadas en los respectivos directorios src/test/java/com/ejemplo/microservicio1/test y src/test/java/com/ejemplo/microservicio2/test.

Para ejecutar las pruebas unitarias, navega a cada microservicio y ejecuta:

### bash
Copiar código
./mvnw test
Pruebas de Integración
Las pruebas de integración también están ubicadas en los directorios de pruebas mencionados anteriormente. Estas pruebas aseguran que los componentes del sistema funcionan correctamente cuando se integran.

## API Endpoints
Microservicio 1: Gestión de Clientes
GET /api/clientes: Obtiene todos los clientes.
GET /api/clientes/{id}: Obtiene un cliente por ID.
POST /api/clientes: Crea un nuevo cliente.
PUT /api/clientes/{id}: Actualiza un cliente existente.
DELETE /api/clientes/{id}: Elimina un cliente por ID.
Microservicio 2: Gestión de Cuentas y Movimientos
GET /api/cuentas: Obtiene todas las cuentas.
GET /api/cuentas/{id}: Obtiene una cuenta por ID.
POST /api/cuentas: Crea una nueva cuenta.
PUT /api/cuentas/{id}: Actualiza una cuenta existente.
DELETE /api/cuentas/{id}: Elimina una cuenta por ID.
GET /api/movimientos: Obtiene todos los movimientos.
GET /api/movimientos/{id}: Obtiene un movimiento por ID.
POST /api/movimientos: Crea un nuevo movimiento.
## Base de Datos
El script SQL para crear la base de datos se encuentra en el archivo BaseDatos.sql.

### Estructura de la Base de Datos
####Persona

Id (Primary Key)
Nombre
Genero
Edad
Identificacion
Direccion
Telefono


#### Cliente

ClienteId (Primary Key)
Contrasena
Estado
Id (Foreign Key de Persona)

####Cuenta

Id (Primary Key)
NumeroCuenta
TipoCuenta
SaldoInicial
Estado
ClienteId (Foreign Key de Cliente)

#### Movimiento

Id (Primary Key)
Fecha
TipoMovimiento
Valor
Saldo
CuentaId (Foreign Key de Cuenta)
