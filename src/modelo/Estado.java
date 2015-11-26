
package modelo;
    
import DAO.CompetenciaDaoJDBC;

public class Estado {
        private String nombre;

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
