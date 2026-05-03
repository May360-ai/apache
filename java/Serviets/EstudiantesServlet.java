package Serviets;

import Controller.ConsumirApiPHP;
import Modelo.Estudiante;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EstudiantesServlet", urlPatterns = {"/estudiantes"})
public class EstudiantesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            String busqueda = request.getParameter("txtBusqueda");
            String json = ConsumirApiPHP.obtenerEstudiantes(busqueda);
            JsonArray lista = JsonParser.parseString(json).getAsJsonArray();
            request.setAttribute("estudiantes", lista);
            request.getRequestDispatcher("/estudiantes.jsp").forward(request, response);
        } else if (accion.equals("irAgregar")) {
            request.getRequestDispatcher("/agregar.jsp").forward(request, response);
        } else if (accion.equals("editar")) {
            request.getRequestDispatcher("/editar.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Estudiante e = new Estudiante(
                request.getParameter("cedula"),
                request.getParameter("nombre"),
                request.getParameter("apellido"),
                request.getParameter("telefono"),
                request.getParameter("direccion")
        );
        
        ConsumirApiPHP.insertar(e);
        response.sendRedirect(request.getContextPath() + "/estudiantes");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Estudiante e = new Estudiante(
                request.getParameter("cedula"),
                request.getParameter("nombre"),
                request.getParameter("apellido"),
                request.getParameter("telefono"),
                request.getParameter("direccion")
        );
        
        String respuesta = ConsumirApiPHP.actualizar(e);
        response.getWriter().write(respuesta);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cedula = request.getParameter("cedula");
        String respuesta = ConsumirApiPHP.eliminar(cedula);
        response.getWriter().write(respuesta);
    }
}
