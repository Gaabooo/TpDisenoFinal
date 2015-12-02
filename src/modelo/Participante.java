
package modelo;

 import java.util.*;

public class Participante {
    private String nombre;
    private String correo;
    // private String imagen;
    private ArrayList<HistorialParticipante> historial;

    /*public Participante(int id, String correo, String nombre, String imagen, ArrayList<HistorialParticipante> HistP) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.HistP = HistP;
    }*/

    // Constructor auxiliar, NO ES FINAL
    public Participante(String nombre, String correo, /* FKIN IMAGEN */ ArrayList<HistorialParticipante> historial) {
        this.nombre = nombre;
        this.correo = correo;
        this.historial = historial; }

    public void setCorreo(String correo) {
        this.correo = correo; }

    public void setNombre(String nombre) {
        this.nombre = nombre; }

    /* public void setImagen(String imagen) {
        this.imagen = imagen; } */

    public void setHistP(ArrayList<HistorialParticipante> HistP) {
        this.HistP = HistP; }
 
    ArrayList<HistorialParticipante> HistP;

    public String getCorreo() {
        return correo; }

    public String getNombre() {
        return nombre; }

    /* public String getImagen() {
        return imagen;
    } */

    public ArrayList<HistorialParticipante> getHistP() {
        return HistP;
    } }