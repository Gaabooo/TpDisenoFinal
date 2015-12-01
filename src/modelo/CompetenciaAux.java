package modelo;

public class CompetenciaAux {
   
    public String estado;
    public String deporte;
    public String modalidad;
    String nombre;
    

    public CompetenciaAux(String estado, String deporte, String modalidad, String nombre) {
        this.estado=estado;
        this.deporte=deporte;
        this.modalidad=modalidad;
        this.nombre=nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getEstado() {
        return estado;
    }
    public String getModalidad() {
        return modalidad;
    }
    public String getDeporte() {
        return deporte;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
