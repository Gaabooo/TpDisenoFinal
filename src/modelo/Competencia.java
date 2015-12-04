package modelo;

import java.util.*;

public class Competencia {
    private int id;
    private int IDUsuario;
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
    
    private ArrayList<Participante> listaParticipantes;
    private ArrayList<Disponibilidad> listaDisponibilidades;
    private ArrayList<TablaPosicionesParticipante> listaTablasPosiciones;

    public void setNombre(String nombre) {
        this.nombre = nombre; }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento; }

    public void setCantidadMaximaDeSets(int cantidadMaximaDeSets) {
        this.cantidadMaximaDeSets = cantidadMaximaDeSets; }

    public void setTantosPorAusenciaDeRival(int tantosPorAusenciaDeRival) {
        this.tantosPorAusenciaDeRival = tantosPorAusenciaDeRival; }

    public void setPuntosPorPresentacion(int puntosPorPresentacion) {
        this.puntosPorPresentacion = puntosPorPresentacion; }

    public void setPuntosPorVictoria(int puntosPorVictoria) {
        this.puntosPorVictoria = puntosPorVictoria; }
    
    public void setPuntosPorEmpate(int puntosPorEmpate) {
        this.puntosPorEmpate = puntosPorEmpate; }
    
    public void setEmpatePermitido(boolean empatePermitido) {
        this.empatePermitido = empatePermitido; }

    public void setEstado(Estado estado) {
        this.estado = estado; }
    
    public void setFormaPuntuacion(FormaPuntuacion formaPuntuacion) {
        this.formaPuntuacion = formaPuntuacion; }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad; }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture; }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte; }

    public void setListaDisponibilidades(ArrayList<Disponibilidad> listaDisponibilidades) {
        this.listaDisponibilidades = listaDisponibilidades; } 
    
    public void addTablaPosicionesParticipante(TablaPosicionesParticipante unaTabla) {
        listaTablasPosiciones.add(unaTabla); }    

    public String getNombre() {
        return nombre; }

    public String getReglamento() {
        return reglamento; }

    public int getCantidadMaximaDeSets() {
        return cantidadMaximaDeSets; }

    public int getTantosPorAusenciaDeRival() {
        return tantosPorAusenciaDeRival; }

    public int getPuntosPorPresentacion() {
        return puntosPorPresentacion; }

    public int getPuntosPorVictoria() {
        return puntosPorVictoria; }

    public boolean getEmpatePermitido() {
        return empatePermitido; }
    
    public int getPuntosPorEmpate() {
        return puntosPorEmpate; }

    public Estado getEstado() {
        return estado; }

    public FormaPuntuacion getFormaPuntuacion() {
        return formaPuntuacion; }

    public Modalidad getModalidad() {
        return modalidad; }

    public Fixture getFixture() {
        return fixture; }

    public Deporte getDeporte() {
        return deporte; }
    
    public ArrayList<Participante> getListaParticipantes() {
        return listaParticipantes; } 
    
    public ArrayList<Disponibilidad> getListaDisponibilidades() {
        return listaDisponibilidades; } 
    
    public ArrayList<TablaPosicionesParticipante> getTablaPosicionesParticipante() {
        return listaTablasPosiciones; }    
    
    public Competencia(String nombre, String reglamento, Deporte deporte, Modalidad modalidad, Estado estado,
                       ArrayList<Disponibilidad> listaDisponibilidades, FormaPuntuacion formaPuntuacion, int cantidadMaximaDeSets,
                       int tantosPorAusenciaDeRival, int puntosPorPresentacion, int puntosPorVictoria,
                       boolean empatePermitido, int puntosPorEmpate) {
        
        this.nombre=nombre;
        this.reglamento=reglamento;
        this.deporte=deporte;
        this.modalidad=modalidad;
        this.estado=estado;
        this.listaDisponibilidades = listaDisponibilidades;
        this.formaPuntuacion=formaPuntuacion;
        this.cantidadMaximaDeSets=cantidadMaximaDeSets;
        this.tantosPorAusenciaDeRival= tantosPorAusenciaDeRival;
        this.puntosPorPresentacion=puntosPorPresentacion;
        this.puntosPorVictoria=puntosPorVictoria;
        this.empatePermitido=empatePermitido;
        this.puntosPorEmpate=puntosPorEmpate;
        this.listaTablasPosiciones = new ArrayList<>(); }
    
    // Constructor auxiliar
    public Competencia(int IDUsuario, String nombre, String reglamento, Deporte deporte, Modalidad modalidad, Estado estado, FormaPuntuacion formaPuntuacion,
                       ArrayList<Disponibilidad> listaDisponibilidades, ArrayList<Participante> listaParticipantes, ArrayList<TablaPosicionesParticipante> listaTablasPosiciones,
                       int cantidadMaximaDeSets, int tantosPorAusenciaDeRival, int puntosPorPresentacion,
                       int puntosPorVictoria, boolean empatePermitido, int puntosPorEmpate) {
        this.IDUsuario = IDUsuario;
        this.nombre = nombre;
        this.reglamento = reglamento;
        this.deporte = deporte;
        this.modalidad = modalidad;
        this.estado = estado;
        this.listaDisponibilidades = listaDisponibilidades;
        this.listaParticipantes = listaParticipantes;
        this.listaTablasPosiciones = listaTablasPosiciones;
        this.formaPuntuacion = formaPuntuacion;
        this.cantidadMaximaDeSets = cantidadMaximaDeSets;
        this.tantosPorAusenciaDeRival = tantosPorAusenciaDeRival;
        this.puntosPorPresentacion = puntosPorPresentacion;
        this.puntosPorVictoria = puntosPorVictoria;
        this.empatePermitido = empatePermitido;
        this.puntosPorEmpate = puntosPorEmpate; }
    
    public Competencia(int id, String nombre, Deporte deporte, Modalidad modalidad,
            Estado estado, FormaPuntuacion formaPuntuacion) {
        
        this.id=id;
        this.nombre=nombre;
        this.deporte=deporte;
        this.modalidad=modalidad;
        this.estado=estado;
        this.formaPuntuacion=formaPuntuacion;
    }
    
}
