
package modelo;

import java.sql.Time;
import java.util.Date;

public class HistorialParticipante {
    private int id;
    private String nombre;
    private String correo_electronico;
    // private String imagen;
    private Date fecha;
    private Time hora;

    public void setCorreo(String correo) {
        this.correo_electronico = correo; }

    public void setNombre(String nombre) {
        this.nombre = nombre; }

    /* public void setImagen(String imagen) {
        this.imagen = imagen; } */

    public void setFecha(Date fecha) {
        this.fecha = fecha; }

    public void setHora(Time hora) {
        this.hora = hora; }

    public String getCorreo() {
        return correo_electronico; }

    public String getNombre() {
        return nombre; }

    /* public String getImagen() {
        return imagen; } */

    public Date getFecha() {
        return fecha; }

    public Time getHora() {
        return hora; }

    /* public HistorialParticipante(int id, String correoElectronico, String nombre, String imagen, Date fecha, Time hora) {
        this.id = id;
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.imagen = imagen;
        this.fecha = fecha;
        this.hora = hora; } */

    public HistorialParticipante(String nombre, String correo, Date fecha, Time hora) {
        this.nombre = nombre;
        this.correo_electronico = correo;
        this.fecha = fecha;
        this.hora = hora; } }
