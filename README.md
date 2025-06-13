# Sistema de Reserva de Espacios

## Funciones Principales

- Registro de Usuarios
- Registro de Espacios
- Reserva de Espacios
- Creacion de Reserva por Dia y Hora
- Cancelacion de Reserva

## Arquitectura Aplicada

La arquitectura que se siguio para la implementacion de este proyecto es la arquitectura Hexagonal donde se separo de la siguiente forma

- **Dominio**: Logica del Negocio
- **Aplicacion**: Casos de Uso
- **Infraestructura**: Acceso a datos, y adaptadores JPA para Persistencia de Datos
- **WEB**: Controladores REST y DTOs

## Tecnologias Utilizadas

- Java 17
- SpringBoot 3.4.4
- Spring Data JPA
- Swagger
- Lombok
- JUnit 5
- MYSQL

## Requisitos Previos

- Instalar Gradle para la administracion de dependencias
- Instalar MYSQL para la base de datos
- Crear una base de datos en MYSQL (Ej. softwarearchitecture_db)
- Modificar el Archivo aplication.properties siguiendo las siguientes instrucciones:
  - spring.datasource.url=jdbc:mysql://localhost:3306/{Nombre Base de Datos}?useSSL=false
  - spring.datasource.username= Usuario configurado para MYSQL (o usar el root)
  - spring.datasource.password= Contraseña de usuario en MYSQL

## Pasos para ejecutar el proyecto

### Clonar el Repositorio
- git clone https://github.com/sergioale1990/softwarearchitecture.git

### Compilar y correr

- Ejecutar en la consola el comando ./gradlew bootRun
- Ejecutar el comando ./gradlew test para ejecutar 

### Ingreso para probar API

- Ingresar a la URL http://localhost:8080/swagger-ui.html
- O usar POSTMAN para prueba de EndPoints