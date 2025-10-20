
## Tabla de contenidos
1. [Informacion General](#general-info)
2. [Tegnologias](#technologies)
3. [Instalacion](#installation)
### Informacion General
***
Microservio encargado de la busqueda y creacion de nuevos productos ademas se tiene la la docuemntacion
## Tegnologias
***
Lista de tegnologia utilzada para crear el microservicio
* [Java](https://example.com): Version 17
* [Spring Boot](https://example.com): Version 3.5.6

## Test Aplicados a Invetario 
La pruebas realizadas a microservicio de invetario abarcaron un % 96 del total de codigo. El test que hicieron contiene lo siguiente
* Creación de productos.
* Manejo de errores (producto no encontrado, inventario insuficiente).
* Prueba de integración del microservicio.

<img width="1289" height="297" alt="image" src="https://github.com/user-attachments/assets/07854e8c-c801-4d4e-ba9a-88ff67b5d8f5" />


## Verificar health checks.
Se agrego un health checks y se verifica mediante la URL donde se envia un JSON con el estado de funcionamento
http://localhost:8081/actuator/health 
<img width="1425" height="419" alt="image" src="https://github.com/user-attachments/assets/9a2e0bed-c6a7-4e71-9593-dfc90785ccb6" />


## Swager
Utilize Swager para hacer la documentacion de los enpoint de los microservicios

<img width="1802" height="773" alt="image" src="https://github.com/user-attachments/assets/3bdb0c72-7b81-4af5-a24f-6f201e4651d6" />


