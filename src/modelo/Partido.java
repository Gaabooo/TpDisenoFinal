package modelo;

import java.util.*;

public class Partido {
    private Participante P0;
    private Participante P1;
    private LugarRealizacion lugarRealizacion;
    private ArrayList<Resultado> res;
    private Boolean empatePermitido;
    // Solo para modalidad de eliminacion
    private String anterior1;
    private String anterior2;
    // Solo para eliminacionDoble
    private Boolean rondaPerdedores;
    
    public Participante getP0() {
        return P0; }
    
    public Participante getP1() {
        return P1; }
    
    public LugarRealizacion getLR() {
        return lugarRealizacion; }
    
    public ArrayList<Resultado> getResultados() {
        return res; }
    
    public Boolean getEmpatePermitido() {
        return empatePermitido; }
    
    public Boolean getRondaPerdedores() {
        return rondaPerdedores; }   
    
    public Partido(Participante P0, Participante P1, LugarRealizacion LR, Boolean rondaPerdedores, Boolean empatePermitido) {
        this.P0 = P0;
        this.P1 = P1; 
        this.lugarRealizacion = LR;
        this.rondaPerdedores = rondaPerdedores;
        this.empatePermitido = empatePermitido; } }
