
package modelo;

 import java.util.*;

public class Participante {
    private String nombre;
    private String correo_electronico;
    // private String imagen;
    private ArrayList<HistorialParticipante> historial;

    public Participante(String nombre, String correo_electronico/*,String imagen, ArrayList<HistorialParticipante> HistP*/) {
        this.correo_electronico = correo_electronico;
        this.nombre = nombre;
        /*this.imagen = imagen;
        this.HistP = HistP;*/
    }

    // Constructor auxiliar, NO ES FINAL
    public Participante(String nombre, String correo, /* FKIN IMAGEN */ ArrayList<HistorialParticipante> historial) {
        this.nombre = nombre;
        this.correo_electronico = correo;
        this.historial = historial; }

    public void setCorreo(String correo) {
        this.correo_electronico = correo; }

    public void setNombre(String nombre) {
        this.nombre = nombre; }

    /* public void setImagen(String imagen) {
        this.imagen = imagen; } */

    public void setHistP(ArrayList<HistorialParticipante> HistP) {
        this.HistP = HistP; }
 
    ArrayList<HistorialParticipante> HistP;

    public String getCorreo() {
        return correo_electronico; }

    public String getNombre() {
        return nombre; }

    /* public String getImagen() {
        return imagen;
    } */

    public ArrayList<HistorialParticipante> getHistP() {
        return HistP;
    } }
