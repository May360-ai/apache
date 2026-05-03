package Modelo;

public class Materia {
    private int id;
    private String nombre;
    private String estudianteCedula;

    public Materia(int id, String nombre, String estudianteCedula) {
        this.id = id;
        this.nombre = nombre;
        this.estudianteCedula = estudianteCedula;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEstudianteCedula() { return estudianteCedula; }
    public void setEstudianteCedula(String estudianteCedula) { this.estudianteCedula = estudianteCedula; }
}
