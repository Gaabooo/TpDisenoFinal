
package modelo;

import java.util.*;

public class Ronda {
    private int numeroRonda;
    private Boolean rondaPerdedores; 
    private String fecha;
    ArrayList<Partido> listaPartidos;  

    public void setNumeroRonda(int unNumeroRonda) {
        this.numeroRonda = unNumeroRonda; }
    
    public void setRondaPerdedores(Boolean unBooleano) {
        this.rondaPerdedores = unBooleano; }

    public void setFecha(String fecha) {
        this.fecha = fecha; }

    public void setPartido(ArrayList<Partido> unaListaPartidos) {
        this.listaPartidos = unaListaPartidos; }

    public int getNumeroRonda() {
        return numeroRonda; }    
    
    public Boolean getRondaPerdedores() {
        return rondaPerdedores; }

    public String getFecha() {
        return fecha; }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos; }

    public Ronda(int unNumeroRonda, Boolean rondaPerdedores, String fecha, ArrayList<Partido> unaListaPartidos) {
        this.numeroRonda = unNumeroRonda;
        this.rondaPerdedores = rondaPerdedores;
        this.fecha = fecha;
        this.listaPartidos = unaListaPartidos; } }