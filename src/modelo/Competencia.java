
package modelo;

import java.util.*;

public class Competencia {
    private String nombre;
    private String reglamento;
   
    private int cantidadMaximaDeSets;
    private int tantosPorAusenciaDeRival;
    private int puntosPorPresentacion;
    private int puntosPorVictoria;
    private boolean empatePermitido;
    private int puntosPorEmpate;
    
    private Estado estado;
    private FormaPuntuacion formaPuntuacion;
    private Modalidad modalidad;
    private Fixture fixture;
    private Deporte deporte;
    
    /*private ArrayList<Participante> listaParticipantes;*/
    private ArrayList<Disponibilidad> disponibilidad;
    private ArrayList<TablaPosicionesParticipante> tablaPosicionesParticipante;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
    }

    public void setCantidadMaximaDeSets(int cantidadMaximaDeSets) {
        this.cantidadMaximaDeSets = cantidadMaximaDeSets;
    }

    public void setTantosPorAusenciaDeRival(int tantosPorAusenciaDeRival) {
        this.tantosPorAusenciaDeRival = tantosPorAusenciaDeRival;
    }

    public void setPuntosPorPresentacion(int puntosPorPresentacion) {
        this.puntosPorPresentacion = puntosPorPresentacion;
    }

    public void setPuntosPorVictoria(int puntosPorVictoria) {
        this.puntosPorVictoria = puntosPorVictoria;
    }
    
    public void setPuntosPorEmpate(int puntosPorEmpate) {
        this.puntosPorEmpate = puntosPorEmpate;
    }
    
    public void setEmpatePermitido(boolean empatePermitido) {
        this.empatePermitido = empatePermitido;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public void setFormaPuntuacion(FormaPuntuacion formaPuntuacion) {
        this.formaPuntuacion = formaPuntuacion;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public void setListaDisponibilidades(ArrayList<Disponibilidad> listaDisponibilidades) {
        this.disponibilidad = listaDisponibilidades;
    } 
    
    public void addTablaPosicionesParticipante(TablaPosicionesParticipante unaTabla) {
        tablaPosicionesParticipante.add(unaTabla);
    }    

    public String getNombre() {
        return nombre;
    }

    public String getReglamento() {
        return reglamento;
    }

    public int getCantidadMaximaDeSets() {
        return cantidadMaximaDeSets;
    }

    public int getTantosPorAusenciaDeRival() {
        return tantosPorAusenciaDeRival;
    }

    public int getPuntosPorPresentacion() {
        return puntosPorPresentacion;
    }

    public int getPuntosPorVictoria() {
        return puntosPorVictoria;
    }

    public boolean getEmpatePermitido() {
        return empatePermitido;
    }
    
    public int getPuntosPorEmpate() {
        return puntosPorEmpate;
    }

    public Estado getEstado() {
        return estado;
    }

    public FormaPuntuacion getFormaPuntuacion() {
        return formaPuntuacion;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public Deporte getDeporte() {
        return deporte;
    }
    
    public ArrayList<Disponibilidad> getListaDisponibilidades() {
        return disponibilidad;
    } 
    
    public ArrayList<TablaPosicionesParticipante> getTablaPosicionesParticipante() {
        return tablaPosicionesParticipante;
    }     
    public Competencia(String nombre, String reglamento, Deporte deporte, Modalidad modalidad, Estado estado,
                       ArrayList<Disponibilidad> listaDisponibilidades, FormaPuntuacion formaPuntuacion, int cantidadMaximaDeSets,
                       int tantosPorAusenciaDeRival, int puntosPorPresentacion, int puntosPorVictoria,
                       boolean empatePermitido, int puntosPorEmpate) {
        
        setNombre(nombre);
        setReglamento(reglamento);
        setCantidadMaximaDeSets(cantidadMaximaDeSets);
        setTantosPorAusenciaDeRival(tantosPorAusenciaDeRival);
        setPuntosPorPresentacion(puntosPorPresentacion);
        setPuntosPorVictoria(puntosPorVictoria);
        setEmpatePermitido(empatePermitido);
        setPuntosPorEmpate(puntosPorEmpate);
 
        setEstado(estado);
        setFormaPuntuacion(formaPuntuacion);
        setModalidad(modalidad);
        setDeporte(deporte);
        setListaDisponibilidades(listaDisponibilidades);
        
       
        this.disponibilidad = listaDisponibilidades;
        
        this.tablaPosicionesParticipante = new ArrayList<>();
    }

    
    
}