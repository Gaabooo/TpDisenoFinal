
package modelo;

import java.util.*;

public class Fixture {
    private int id;
    ArrayList<Ronda> rondas;

    public Fixture(int id, ArrayList<Ronda> ronda) {
        this.id = id;
        this.rondas = ronda;
    }
    public Fixture(ArrayList<Ronda> rondas) {
        this.rondas = rondas;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }
    public ArrayList<Ronda> getListaRondas() {
        return rondas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRonda(ArrayList<Ronda> ronda) {
        this.rondas = ronda;
    }
    
    
}
