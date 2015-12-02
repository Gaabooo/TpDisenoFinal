package modelo;

public class Estado {

    private int id;
    private String nombre;
    
    public Estado(int idEstado, String nombre) {
        this.id = idEstado;
        this.nombre = nombre;
    }
    
    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
