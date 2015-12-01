package gestor;

import DAO.CompetenciaDaoJDBC;
import java.util.ArrayList;
import modelo.*;

public class gestorCD {
    
    

    /**
     *
     * @param nombre
     * @param deporte
     * @param modalidad
     * @param estado
     * @return 
     */

    public static int obtenerIdCD(String nombre, String deporte, String modalidad, String estado){
            return CompetenciaDaoJDBC.getIdCompetencia(nombre,deporte,modalidad,estado);
    }
    public static ArrayList<CompetenciaAux> listarCD (String nombreCD, String nombreDeporte, String nombreModalidad, String nombreEstado) {
        return CompetenciaDaoJDBC.getCompetencias(nombreCD, nombreDeporte, nombreModalidad, nombreEstado); }    

    public static boolean verificarNombre (String nombreCD) {
        boolean nombreUsado = CompetenciaDaoJDBC.nombreUsado(nombreCD);
        return nombreUsado; }    
    
    public static String[] getListaDeportes () {
        ArrayList<String> deportes = CompetenciaDaoJDBC.getListaDeportes();
        String[] vectorNombreDeportes = new String[deportes.size()];
        vectorNombreDeportes = deportes.toArray(vectorNombreDeportes);
        return vectorNombreDeportes; }
    
    public static String[] getListaLugares () {
        ArrayList<String> lugares = CompetenciaDaoJDBC.getListaLugares();
        String[] vectorNombreLugares = new String[lugares.size()];
        vectorNombreLugares = lugares.toArray(vectorNombreLugares);
        return vectorNombreLugares; }
    
    public static String[] getListaModalidades () {
        ArrayList<String> modalidades = CompetenciaDaoJDBC.getListaModalidades();
        String[] vectorNombreModalidades = new String[modalidades.size()];
        vectorNombreModalidades = modalidades.toArray(vectorNombreModalidades);
        return vectorNombreModalidades; }
        
    public static String[] getListaPuntuaciones () {
        ArrayList<String> puntuaciones = CompetenciaDaoJDBC.getListaPuntuaciones();
        String[] vectorNombrePuntuaciones = new String[puntuaciones.size()];
        vectorNombrePuntuaciones = puntuaciones.toArray(vectorNombrePuntuaciones);
        return vectorNombrePuntuaciones; }
    
    public static void darDeAltaCD(String nombre, String reglamento, String nombreDeporte, String nombreModalidad,
        String matrizLugares[][], String nombreFormaPuntuacion, int tantosPorAusenciaDeRival, int cantMaximaDeSets,
        int puntosPorVictoria, int puntosPorPresentacion, boolean empatePermitido, int puntosPorEmpate) {
        
        Estado unEstado = CompetenciaDaoJDBC.getEstado("Creada");
        Modalidad unaModalidad = CompetenciaDaoJDBC.getModalidad(nombreModalidad);
        FormaPuntuacion unaFormaPuntuacion = CompetenciaDaoJDBC.getFormaPuntuacion(nombreFormaPuntuacion);
        Deporte unDeporte = CompetenciaDaoJDBC.getDeporte(nombreDeporte);
        
        // Disponibilidades
        ArrayList<Disponibilidad> listaDisponibilidades = new ArrayList();
        for (int i=0; i<matrizLugares[0].length; i++) {
            String unNombreLR = (String)matrizLugares[0][i];
            LugarRealizacion unLR = CompetenciaDaoJDBC.buscarLRPorNombre(unNombreLR);
            Disponibilidad unaDisponibilidad = new Disponibilidad(Integer.parseInt(matrizLugares[1][i]), unLR);
            listaDisponibilidades.add(unaDisponibilidad); }
        
        // CD
        Competencia nuevaCD = null;
        if ("Puntuacion".equals(nombreModalidad)) {
            if ("Liga".equals(nombreFormaPuntuacion)) {
                nuevaCD = new Competencia(nombre, reglamento, unDeporte, unaModalidad, unEstado, listaDisponibilidades,
                    unaFormaPuntuacion, 0, tantosPorAusenciaDeRival, puntosPorPresentacion,
                    puntosPorVictoria, empatePermitido, puntosPorEmpate); }
            else if ("Eliminacion simple".equals(nombreFormaPuntuacion) || "Eliminacion doble".equals(nombreFormaPuntuacion)) {
                nuevaCD = new Competencia(nombre, reglamento, unDeporte, unaModalidad, unEstado, listaDisponibilidades,
                    unaFormaPuntuacion, 0, tantosPorAusenciaDeRival, 0, 0, false, 0); } }
        if ("Sets".equals(nombreModalidad)) {
            if ("Liga".equals(nombreFormaPuntuacion)) {
                nuevaCD = new Competencia(nombre, reglamento, unDeporte, unaModalidad, unEstado, listaDisponibilidades,
                    unaFormaPuntuacion, cantMaximaDeSets, 0, puntosPorPresentacion,
                    puntosPorVictoria, empatePermitido, puntosPorEmpate); }
            else if ("Eliminacion simple".equals(nombreFormaPuntuacion) || "Eliminacion doble".equals(nombreFormaPuntuacion)) {
                nuevaCD = new Competencia(nombre, reglamento, unDeporte, unaModalidad, unEstado, listaDisponibilidades,
                    unaFormaPuntuacion, cantMaximaDeSets, 0, 0, 0, false, 0); } }
        if ("Resultado final".equals(nombreModalidad)) {
            if ("Liga".equals(nombreFormaPuntuacion)) {
                nuevaCD = new Competencia(nombre, reglamento, unDeporte, unaModalidad, unEstado, listaDisponibilidades,
                    unaFormaPuntuacion, 0, 0, puntosPorPresentacion,
                    puntosPorVictoria, empatePermitido, puntosPorEmpate); }
            else if ("Eliminacion simple".equals(nombreFormaPuntuacion) || "Eliminacion doble".equals(nombreFormaPuntuacion)) {
                nuevaCD = new Competencia(nombre, reglamento, unDeporte, unaModalidad, unEstado, listaDisponibilidades,
                    unaFormaPuntuacion, 0, 0, 0, 0, false, 0); } }
        
        // Persistencia
        CompetenciaDaoJDBC.persistirCD(nuevaCD); } }