<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Lista Estudiantes</h1>
        <a href="estudiantes?accion=irAgregar">Agregar Estudiante</a> | 
        <a href="materias">Gestionar Materias</a>

        <br><br>
        <form action="estudiantes" method="GET">
            Buscar: <input type="text" name="txtBusqueda" placeholder="Cédula, nombre o apellido...">
            <input type="submit" value="Buscar">
            <a href="estudiantes">Limpiar</a>
        </form>
        <br>

        <table border="1">
            <tr>
                <th>Cedula</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Acciones</th>
            </tr>
            <%
                JsonArray estudiantes = (JsonArray) request.getAttribute("estudiantes");
                if (estudiantes != null) {
                    for (int i = 0; i < estudiantes.size(); i++) {
                        JsonObject e = estudiantes.get(i).getAsJsonObject();
                        String cedula = e.get("cedula").getAsString();
            %>
            <tr>            
                <td><%=cedula%></td>
                <td><%=e.get("nombre").getAsString()%></td>
                <td><%=e.get("apellido").getAsString()%></td>
                <td>
                    <a href="estudiantes?accion=editar&cedula=<%=cedula%>&nombre=<%=e.get("nombre").getAsString()%>&apellido=<%=e.get("apellido").getAsString()%>&telefono=<%=e.get("telefono").getAsString()%>&direccion=<%=e.get("direccion").getAsString()%>">Editar</a>
                    <button onclick="confirmarEliminar('<%=cedula%>')">Eliminar</button>
                </td>
            </tr>
            <%      }
                }
            %>
        </table>

        <script>
            function confirmarEliminar(cedula) {
                if (confirm("¿Eliminar " + cedula + "?")) {
                    fetch('estudiantes?cedula=' + cedula, { method: 'DELETE' })
                    .then(() => location.reload());
                }
            }
        </script>
    </body>
</html>
