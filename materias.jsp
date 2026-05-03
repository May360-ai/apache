<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Gestión de Materias</h1>
        <a href="estudiantes">Ver Estudiantes</a>
        
        <form action="materias" method="POST">
            ID Materia: <input type="text" name="id"><br>
            Nombre Materia: <input type="text" name="nombre"><br>
            Estudiante:
            <select name="cedulaEstudiante">
                <% 
                    JsonArray estudiantes = (JsonArray) request.getAttribute("estudiantes");
                    if (estudiantes != null) {
                        for (int i = 0; i < estudiantes.size(); i++) {
                            JsonObject e = estudiantes.get(i).getAsJsonObject();
                            String cedula = e.get("cedula").getAsString();
                            String nombre = e.get("nombre").getAsString();
                %>
                    <option value="<%=cedula%>"><%=nombre%> (<%=cedula%>)</option>
                <% 
                        }
                    }
                %>
            </select>
            <input type="submit" value="Guardar">
        </form>

        <h2>Lista de Materias</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Estudiante (Cédula)</th>
            </tr>
            <% 
                JsonArray materias = (JsonArray) request.getAttribute("materias");
                if (materias != null) {
                    for (int i = 0; i < materias.size(); i++) {
                        JsonObject m = materias.get(i).getAsJsonObject();
            %>
                <tr>
                    <td><%= m.get("id").getAsString() %></td>
                    <td><%= m.get("nombre").getAsString() %></td>
                    <td><%= m.get("estudiante").getAsString() %></td>
                </tr>
            <% 
                    }
                }
            %>
        </table>
    </body>
</html>
