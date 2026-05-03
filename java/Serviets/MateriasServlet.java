package Serviets;

import Controller.ConsumirApiPHP;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MateriasServlet", urlPatterns = {"/materias"})
public class MateriasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener estudiantes para el combo box
        String jsonEstudiantes = ConsumirApiPHP.obtenerEstudiantes();
        JsonArray estudiantes = JsonParser.parseString(jsonEstudiantes).getAsJsonArray();
        
        // Obtener materias de la API PHP
        String jsonMaterias = ConsumirApiPHP.obtenerMaterias();
        JsonArray materias = JsonParser.parseString(jsonMaterias).getAsJsonArray();
        
        request.setAttribute("estudiantes", estudiantes);
        request.setAttribute("materias", materias);
        request.getRequestDispatcher("/materias.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String cedulaEstudiante = request.getParameter("cedulaEstudiante");
        
        ConsumirApiPHP.insertarMateria(id, nombre, cedulaEstudiante);
        
        response.sendRedirect(request.getContextPath() + "/materias");
    }
}
