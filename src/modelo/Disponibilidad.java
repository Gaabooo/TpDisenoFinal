package modelo;

import java.util.*;

public class Disponibilidad {
   private int cantidad;
   private LugarRealizacion LR;

    public void setCantidad(int unaCantidad) {
        this.cantidad = unaCantidad; }

    public void setLR(LugarRealizacion LR) {
        this.LR = LR; }

    public int getCantidad() {
        return cantidad; }

    public LugarRealizacion getLR() {
        return LR; }

    public Disponibilidad(int unaCantidad, LugarRealizacion LR) {
        this.cantidad = unaCantidad;
        this.LR = LR; } }
