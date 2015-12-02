package gestor;

import DAO.CompetenciaDaoJDBC;
import java.util.ArrayList;
import modelo.*;

public class gestorCD {
    
    

    /**
     *
     * @param id_competencia
     * @param id_CompetenciaDeportiva
     * @param nombre
     * @param deporte
     * @param modalidad
     * @param estado
     * @return 
     */

    public static ArrayList<TablaPosicionesParticipante> listarTpp(int id_competencia){
        return CompetenciaDaoJDBC.getTablaPosiciones(id_competencia);
    }
    
    public static Competencia obtenerCD(int id_CompetenciaDeportiva){
        return CompetenciaDaoJDBC.getCompetenciasS(id_CompetenciaDeportiva);
    }
    
    public static int obtenerIdCD(String nombre){
            return CompetenciaDaoJDBC.getIdCompetencia(nombre);
    }
    public static ArrayList<CompetenciaAux> listarCD (String nombreCD, String nombreDeporte, String nombreModalidad, String nombreEstado) {
        
        // Se recuperan las competencias que coincidan con los filtros
        ArrayList<Competencia> competencias = CompetenciaDaoJDBC.getCompetencias(nombreCD,
                nombreDeporte, nombreModalidad, nombreEstado);
        
        
        // Se pasan los datos de las competencias a la estructura auxiliar para la interfaz
        
        // Nueva lista para devolver
        ArrayList<CompetenciaAux> listaAux= new ArrayList<> ();
        
        // Iteracion de la lista de competencias
        for(int i=0; i<competencias.size(); i++){
            
            Competencia compI= competencias.get(i);
            
            // Se crea una nueva Competencia auxiliar y se la agega a la lista
            CompetenciaAux compAux= new CompetenciaAux(compI.getEstado().getNombre(), 
                compI.getDeporte().getNombre(), compI.getModalidad().getNombre(), compI.getNombre());
            listaAux.add(compAux);
            
            }
        
        return listaAux;
    }    

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