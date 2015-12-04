
package modelo;

import java.util.*;

public class LugarRealizacion {
    
    private int id;
    private String nombre;
    private String descripción;
    
    ArrayList<Deporte> deportes;

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public void addDeporte(Deporte unDeporte) {
        deportes.add(unDeporte);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public ArrayList<Deporte> getDeportes() {
        return deportes;
    }

    public LugarRealizacion(int id, String nombre, String descripcion, ArrayList<Deporte> deportes) {
        this(id, nombre, descripcion);
        this.deportes = deportes;
    }
    public LugarRealizacion(int id, String nombre, String descripción) {
        this.id = id;
        this.nombre = nombre;
        this.descripción = descripción;
    }
}
