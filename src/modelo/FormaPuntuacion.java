
package modelo;

public class FormaPuntuacion {

     String nombre;
     int id;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   public void setId(int id) {
        this.id = id;
    } 
    
     public int getId() {
        
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public FormaPuntuacion(int id,String nombre) {
         this.id=id;
        this.nombre = nombre;
    }
}
