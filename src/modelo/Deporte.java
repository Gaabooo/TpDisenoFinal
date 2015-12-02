
package modelo;

public class Deporte {
    
     String nombre;
     int id;
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        
        return nombre;
    }
    
    public int getId() {
        
        return id;
    }
    

    public Deporte(int id,String nombre) {
        this.id=id;
        this.nombre = nombre;
    }
    
}
