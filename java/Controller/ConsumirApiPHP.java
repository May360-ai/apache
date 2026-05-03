package Controller;

import Modelo.Estudiante;
import java.net.URI;
import static java.net.URLEncoder.encode;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirApiPHP {

    private static final String API_URL = "http://localhost/SOA/api.php";
    private static final HttpClient cliente = HttpClient.newHttpClient();

    // ESTUDIANTES
    public static String obtenerEstudiantes() {
        return obtenerEstudiantes(null);
    }

    public static String obtenerEstudiantes(String busqueda) {
        String params = "?table=estudiante";
        if (busqueda != null && !busqueda.isEmpty()) {
            params += "&search=" + encode(busqueda, StandardCharsets.UTF_8);
        }
        return peticionGET(params);
    }

    public static String insertar(Estudiante e) {
        String body = "txtCedula=" + encode(e.getCedula(), StandardCharsets.UTF_8)
                + "&txtNombre=" + encode(e.getNombre(), StandardCharsets.UTF_8)
                + "&txtApellido=" + encode(e.getApellido(), StandardCharsets.UTF_8)
                + "&txtTelefono=" + encode(e.getTelefono(), StandardCharsets.UTF_8)
                + "&txtDireccion=" + encode(e.getDireccion(), StandardCharsets.UTF_8);
        return peticionPOST("?table=estudiante", body);
    }

    public static String eliminar(String cedula) {
        return peticionDELETE("?table=estudiante&txtCedula=" + encode(cedula, StandardCharsets.UTF_8));
    }

    public static String actualizar(Estudiante e) {
        String params = "?table=estudiante&txtCedula=" + encode(e.getCedula(), StandardCharsets.UTF_8)
                + "&txtNombre=" + encode(e.getNombre(), StandardCharsets.UTF_8)
                + "&txtApellido=" + encode(e.getApellido(), StandardCharsets.UTF_8)
                + "&txtTelefono=" + encode(e.getTelefono(), StandardCharsets.UTF_8)
                + "&txtDireccion=" + encode(e.getDireccion(), StandardCharsets.UTF_8);
        return peticionPUT(params);
    }

    // MATERIAS
    public static String obtenerMaterias() {
        return peticionGET("?table=materia");
    }

    public static String insertarMateria(String id, String nombre, String cedulaEstudiante) {
        String body = "txtIdMateria=" + encode(id, StandardCharsets.UTF_8)
                + "&txtNombreMateria=" + encode(nombre, StandardCharsets.UTF_8)
                + "&txtCedulaEstudiante=" + encode(cedulaEstudiante, StandardCharsets.UTF_8);
        return peticionPOST("?table=materia", body);
    }

    // MÉTODOS GENÉRICOS
    private static String peticionGET(String params) {
        try {
            HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(API_URL + params)).GET().build();
            return cliente.send(peticion, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception ex) {
            return "[]";
        }
    }

    private static String peticionPOST(String params, String body) {
        try {
            HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(API_URL + params))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(body)).build();
            return cliente.send(peticion, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception ex) {
            return "error";
        }
    }

    private static String peticionPUT(String params) {
        try {
            HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(API_URL + params))
                    .PUT(HttpRequest.BodyPublishers.noBody()).build();
            return cliente.send(peticion, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception ex) {
            return "error";
        }
    }

    private static String peticionDELETE(String params) {
        try {
            HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(API_URL + params)).DELETE().build();
            return cliente.send(peticion, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception ex) {
            return "error";
        }
    }
}
