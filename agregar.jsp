<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Registrar Estudiante</h1>
        <form action="estudiantes" method="POST">
            Cédula: <input type="text" name="cedula"><br>
            Nombre: <input type="text" name="nombre"><br>
            Apellido: <input type="text" name="apellido"><br>
            Teléfono: <input type="text" name="telefono"><br>
            Dirección: <input type="text" name="direccion"><br>
            <input type="submit" value="Guardar">
        </form>
        <a href="estudiantes">Volver</a>
    </body>
</html>
