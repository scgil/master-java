# API REST Agencia de Viajes

Este repositorio contiene tres microservicios (Hoteles, Vuelos y Reservas) desarrollados en Spring Boot para gestionar una agencia de viajes. La aplicación utiliza bases de datos independientes para cada servicio y expone sus funcionalidades a través de una API REST.

## Características Principales

- Arquitectura basada en microservicios.
- Uso de 3 bases de datos H2 (el repositorio incluye scripts para realizar inserts en Hoteles y Vuelos).
- Relaciona los microservicios **Hoteles** y **Vuelos** con el microservicio **Reservas**.
- Exposición de endpoints para interactuar con todas las entidades.

## Tecnologías Utilizadas

- **Spring Boot**: Infraestructura para microservicios eficiente.
- **H2**: Base de datos en memoria.
- **Swagger**: Documentación y visualización de API RESTful.
- **JUnit**: Marco para pruebas unitarias en Java.

## Inicio Rápido

1. Clonar el repositorio: git clone https://github.com/scgil/Microservicios-AgenciaViajes.git

2. Acceder al directorio del proyecto.

## Entidades

- **Hotel**: Representa un hotel con las propiedades `idHotel`, `nombre`, `categoria`, `precio` y `disponible`.
- **Vuelo**: Representa un vuelo con las propiedades `idVuelo`, `compañia`, `fechaVuelo`, `precio` y `plazasDisponibles`.
- **Reserva**: Representa una reserva con las propiedades `idReserva`, `nombreCliente`, `dni`, `idHotel` e `idVuelo`.

## Servicios

### Servicio de Hoteles

Este microservicio proporciona funcionalidades para la gestión de hoteles.

#### Funcionalidades

1. Listar todos los hoteles.
2. Listar todos los hoteles disponibles.
3. Obtener los datos de un hotel a partir de su nombre.

#### Endpoints

Puerto: **8080**

- **Listar todos los hoteles**  
  - URL: `api/hoteles`  
  - Método: `GET`

- **Listar todos los hoteles disponibles**  
  - URL: `api/hoteles/disponibles`  
  - Método: `GET`

- **Obtener los datos de un hotel a partir de su nombre**  
  - URL: `api/hoteles/{nombre}`  
  - Método: `GET`

### Servicio de Vuelos

Este microservicio proporciona funcionalidades para la gestión de vuelos.

#### Funcionalidades

1. Listar todos los vuelos.
2. Listar todos los vuelos con plazas suficientes.
3. Actualizar las plazas disponibles de un vuelo.

#### Endpoints

Puerto: **9000**

- **Listar todos los vuelos**  
  - URL: `api/vuelos`  
  - Método: `GET`

- **Listar todos los vuelos con plazas suficientes**  
  - URL: `api/vuelos/{plazas}`  
  - Método: `GET`

- **Actualizar las plazas disponibles de un vuelo**  
  - URL: `api/vuelos/{id}/{plazasReserva}`  
  - Método: `PATCH`

### Servicio de Reservas

Este microservicio interactúa con los servicios **Hoteles** y **Vuelos** para gestionar las reservas. Cuando se realiza una reserva, se verifica la disponibilidad del hotel y del vuelo, y se actualizan las plazas restantes del vuelo.

#### Funcionalidades

1. Registrar una nueva reserva.
2. Listar todas las reservas para un hotel específico.

#### Endpoints

Puerto: **9090**

- **Registrar una nueva reserva**  
  - URL: `api/reservas`  
  - Método: `POST`

- **Listar todas las reservas para un hotel específico**  
  - URL: `api/reservas/{nombreHotel}`  
  - Método: `GET`
