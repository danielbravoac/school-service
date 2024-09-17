
---

# School Service - REST API

Este proyecto es una API REST desarrollada con **Spring Boot** que gestiona el registro de estudiantes, cursos y matrículas en una academia.

## Características

- CRUD de estudiantes
- CRUD de cursos
- Registro de matrículas
- Listado de estudiantes ordenados por edad
- Relación de cursos con los estudiantes matriculados

## Tecnologías utilizadas

- **Java 21**
- **Spring Boot**
- **Maven**
- **H2 Database** (por defecto)
- **Swagger** (para documentación interactiva de la API)
- **Postman** (para probar los endpoints)

## Pre-requisitos

Antes de iniciar el proyecto, asegúrate de tener lo siguiente instalado:

- **Java 21**
- **Maven** 3.6 o superior
- **Git** (opcional, para clonar el repositorio)

## Instrucciones para ejecutar el proyecto

### Clonar el repositorio

```bash
git clone https://github.com/danielbravoac/school-service.git
cd school-service
```

### Configuración de la base de datos

El proyecto está configurado para utilizar la base de datos **H2** por defecto, lo que significa que no necesitas realizar configuraciones adicionales para comenzar a trabajar con él.

Si en el futuro decides utilizar otra base de datos, como **PostgreSQL**, puedes modificar la configuración en el archivo `src/main/resources/application.properties`.

### Ejecutar el proyecto

Puedes ejecutar el proyecto utilizando **Maven** con el siguiente comando:

```bash
mvn spring-boot:run
```

O empaquetarlo y ejecutarlo como un **.jar**:

```bash
mvn clean package
java -jar target/school-service-0.0.1-SNAPSHOT.jar
```

El proyecto se ejecutará en `http://localhost:8080`.

### Importar la colección de Postman

Una vez que el proyecto esté en ejecución, puedes importar la colección de Postman para probar los diferentes endpoints:

1. Descarga la colección de Postman desde el repositorio (`postman/school-service-collection.json`).
2. Abre Postman.
3. Haz clic en **Importar**.
4. Selecciona el archivo JSON descargado.
5. Ahora puedes utilizar los endpoints disponibles en la colección para interactuar con la API.

### Acceder a la documentación Swagger

El proyecto cuenta con **Swagger** para la documentación interactiva de la API. Puedes acceder a la interfaz de Swagger en la siguiente URL, una vez que el servidor esté corriendo:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger te permitirá probar los diferentes endpoints de forma interactiva.

## Endpoints principales

Aquí tienes algunos de los principales endpoints del sistema:

### Estudiantes

- **GET** `/students` - Listar todos los estudiantes
- **GET** `/students/orderByAge` - Listar todos los estudiantes ordenados por edad de manera descendente
- **POST** `/students` - Crear un nuevo estudiante
- **PUT** `/students/{id}` - Actualizar un estudiante existente
- **DELETE** `/students/{id}` - Eliminar un estudiante

### Cursos

- **GET** `/courses` - Listar todos los cursos
- **POST** `/courses` - Crear un nuevo curso
- **PUT** `/courses/{id}` - Actualizar un curso existente
- **DELETE** `/courses/{id}` - Eliminar un curso

### Matrículas

- **GET** `/enrollments` - Listar todas las matrículas
- **GET** `/enrollments/groupByCourseReport` - Listar los alumnos agrupados por cursos
- **POST** `/enrollments` - Registrar una nueva matrícula

## Stack Tecnológico

**Client:** HTML, TailwindCSS, TailwindCSS Animated, Vanilla JS, Vite
