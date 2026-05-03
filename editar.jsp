<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Editar Estudiante</h1>
        <form id="formEditar">
            Cédula: <input type="text" name="cedula" value="<%=request.getParameter("cedula")%>" readonly><br>
            Nombre: <input type="text" name="nombre" value="<%=request.getParameter("nombre") != null ? request.getParameter("nombre") : ""%>"><br>
            Apellido: <input type="text" name="apellido" value="<%=request.getParameter("apellido") != null ? request.getParameter("apellido") : ""%>"><br>
            Teléfono: <input type="text" name="telefono" value="<%=request.getParameter("telefono") != null ? request.getParameter("telefono") : ""%>"><br>
            Dirección: <input type="text" name="direccion" value="<%=request.getParameter("direccion") != null ? request.getParameter("direccion") : ""%>"><br>
            <button type="button" onclick="actualizar()">Actualizar</button>
        </form>
        <a href="estudiantes">Cancelar</a>

        <script>
            function actualizar(){
                const params = new URLSearchParams(new FormData(document.getElementById('formEditar')));
                fetch('estudiantes?' + params.toString(), { method: 'PUT' })
                .then(() => window.location.href = 'estudiantes');
            }
        </script>
    </body>
</html>
