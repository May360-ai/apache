# Prompt de Generación de Sistema Integral SOA (PHP/Java/MySQL)

Actúa como un Arquitecto de Software y Desarrollador Senior Full Stack. Tu objetivo es generar el código completo para un sistema basado en una arquitectura SOA, donde una aplicación Java consume servicios de una API en PHP.

**[INSTRUCCIÓN DE TEMA]:** El sistema debe tratar sobre **{DESCRIPCIÓN DEL TEMA O ENTIDAD}**. Si no se especifica un tema, propón uno profesional (ej. Gestión de Inventarios, Sistema de Reservas, Control de Biblioteca, etc.).

## 1. Definición de Entidades y Datos
- Define la entidad principal y al menos 5 atributos relevantes (incluyendo una Clave Primaria única).
- Genera el script **MySQL (.sql)** para crear la base de datos y la tabla correspondiente.

## 2. Tecnologías y Requerimientos Técnicos:
- **API (Backend de Datos):** PHP 8.x con PDO, utilizando una arquitectura de clase para la conexión y los CRUDS. Debe retornar JSON.
- **App (Cliente de Servicios):** Java 11+ con **Jakarta EE 10**.
- **Librerías Obligatorias:** `java.net.http.HttpClient` para peticiones y `Gson` para el mapeo de objetos.
- **Arquitectura Java:** Patrón MVC (Model, Controller para API, Servlets, JSPs).
- **Comunicación:** El cliente Java debe enviar datos en formato `application/x-www-form-urlencoded`.

## 3. Entregables de Código:

### A. Capa de Datos (PHP)
- `conexion.php`: Manejo de conexión mediante PDO.
- `cruds.php`: Clase con métodos estáticos para Listar, Insertar, Actualizar y Eliminar.
- `api.php`: Switch principal que gestione los métodos HTTP (GET, POST, PUT, DELETE).

### B. Capa de Aplicación (Java)
- **Modelo:** Clase POJO que represente la entidad con sus atributos, constructor, getters y setters.
- **Consumidor de API:** Clase controladora que encapsule el uso de `HttpClient` para comunicarse con el `api.php` mediante los 4 verbos HTTP.
- **Servlets:** Gestión de la lógica de navegación y procesamiento de formularios.
- **Vistas (JSP):** 
    - Pantalla principal con tabla de datos (Listar y botón Eliminar).
    - Formulario de creación.
    - Formulario de edición (con carga de datos previa).

## 4. Estándares de Calidad:
- Código limpio (Clean Code) y modular.
- Manejo de excepciones tanto en PHP como en Java.
- Comentarios explicativos en las secciones críticas.
- Uso de JSTL en los JSPs para evitar scriptlets.
- La API debe ser independiente: debe funcionar probándola solo con herramientas como Postman.

---
**Resultado esperado:** Genera todos los archivos mencionados listos para ser implementados.
