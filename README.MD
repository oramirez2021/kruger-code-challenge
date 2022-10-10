<p align="center">
CODING CHALLENGE VACCINATION
</p>

**Descripción:**<br>
Este coding challenge consiste en exponer una serie de endpoints para controlar la vacunación del personal de una determinada empresa en este caso Kruger.;br:
El lenguaje usado es Java 17 usando Spring boot. En este caso he usado Linux Ubuntu.

1.- **Crear el ambiente Postgresql:**

    1.1. Se debe instalar Postgresql.

    1.2. Ingresar a Postgresql:

          sudo -u postgres psql

    1.3. Crear un usuario admin en Postgresql:

          CREATE USER omar;
 
     1.4. Dar Rol super usuario al nuevo usuario creado:

          ALTER USER omar SUPERUSER CREATEDB;

      1.5. Crear un password para el usuario creado:

          ALTER USER omar WITH PASSWORD 'Gencooil$2022';

    1.6. Crear una base de datos:

          CREATE DATABASE vacc_inventory;

**2. Configurar la aplicación mediante el archivo application.properties del proyecto Maven para que pueda conectarse a la base de datos vacc_inventory por el puerto 5432**
    
    spring.datasource.url=jdbc:postgresql://localhost:5432/vacc_inventory
    spring.datasource.username=omar
    spring.datasource.password=Gencooil$2022
    
 **3. Compilar la aplicación. En este caso compilar utilizando el IDE IntelliJ IDEA.**
 
 **4. Ejecutar la aplicación asegurandose que Postgresql esté escuchando en su puerto configurado:
      Parar ejecutar el jar, hay que ubicarse en la ruta donde se encuentre el artefacto y ejecutar el siguiente comandoÑ
      
      java -jar vaccination-0.0.1-SNAPSHOT.jar

**5. En el caso de querer distribuir la aplicación usando Docker. Lo haremos mediante Dockerfile:**<br>

DOCKER. ARCHIVOS NECESARIOS PARA DESPLEGAR LA APLICACION EN UN AMBIENTE NUEVO:

Para que la aplicacion se disponibilice correctamente, se requiere levantar un contenedor para la base de datos y otro para la aplicacion en si:

Pasos:
      5.1. Crear un bridge para que sirva de puente entre el contenedor de la base de datos y el contenedor de la aplicacion:

	        docker network create kruger_challenge_bridge

	        5.1.1. Si desea ver el bridge ejecutar:
		      docker network ls

      5.2. Dockerizar la instancia de la base de datos Postgresql.

      5.3. Levantar la instancia de la aplicacion:
	        5.3.1. Moverse a la ubicacion de la raiz del proyecto vaccination (Proyecto con los microservicios) y ejecutar el siguiente comando para ejecutar el contenido del Dockerfile:

	               docker build -t mi_kruger_challenge .

	    5.4. Ejecutar el contenedor creado por el comando anterior en el bridge creado en el punto 1:

	        docker run -p 8080:8080 mi_kruger_challenge



