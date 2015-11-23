
package modelo;

import java.util.*;

public class Disponibilidad {
   private int cantidad;
   private LugarRealizacion lg;

    public void setCantidad(int unaCantidad) {
        this.cantidad = unaCantidad;
    }

    public void setLg(LugarRealizacion lg) {
        this.lg = lg;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LugarRealizacion getLg() {
        return lg;
    }

    public Disponibilidad(int unaCantidad, LugarRealizacion lg) {
        this.cantidad = unaCantidad;
        this.lg = lg;
    }
}