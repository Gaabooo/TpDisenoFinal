package modelo;

public class CompetenciaAux {
    
    private int id_competencia;
    private String estado;
    private String deporte;
    private String modalidad;
    private String nombre;
    
    public CompetenciaAux(String estado, String deporte, String modalidad, String nombre, int id){
        this.estado=estado;
        this.deporte=deporte;
        this.modalidad=modalidad;
        this.nombre=nombre;
        this.id_competencia=id;
    }
    
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

    public int getId(){ 
       return id_competencia; 
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
    public void setId(int id_competencia) {
        this.id_competencia =id_competencia;
    }
    
}
