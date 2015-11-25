/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import modelo.*;
import DAO.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueMasTeGuste {
    
    public static boolean nombreUsado (String nombreCD) {
        ArrayList<String> listaNombres = CompetenciaDaoJDBC.getNombresCD();
        for (int i=0; i<listaNombres.size(); i++) {
           if (listaNombres.get(i).equals(nombreCD)){
               return true;
           } 
        }
        return false;
    }    
    
    public static String[] getListaDeportes () {
        ArrayList<String> deportes = CompetenciaDaoJDBC.getListaDeportes();
        
        String[] vectorNombreDeportes = new String[deportes.size()];
        vectorNombreDeportes = deportes.toArray(vectorNombreDeportes);
        
        return vectorNombreDeportes;
    }
    
        public static String[] getListaLugares () {
        ArrayList<String> lugares = CompetenciaDaoJDBC.getListaLugares();
        
        String[] vectorNombreLugares = new String[lugares.size()];
        vectorNombreLugares = lugares.toArray(vectorNombreLugares);
        
        return vectorNombreLugares;
    }
    
        public static String[] getListaModalidades () {
        ArrayList<String> modalidades = CompetenciaDaoJDBC.getListaModalidades();
        
        String[] vectorNombreModalidades = new String[modalidades.size()];
        vectorNombreModalidades = modalidades.toArray(vectorNombreModalidades);
        
        return vectorNombreModalidades;
    }
        
        public static String[] getListaPuntuaciones () {
        ArrayList<String> puntuaciones = CompetenciaDaoJDBC.getListaPuntuaciones();
        
        String[] vectorNombrePuntuaciones = new String[puntuaciones.size()];
        vectorNombrePuntuaciones = puntuaciones.toArray(vectorNombrePuntuaciones);
        
        return vectorNombrePuntuaciones;
    }
    
    public static void darDeAltaCD(String nombre, String reglamento, String nombreDeporte, String nombreModalidad,
                         String matrizLugares[][], String nombreFormaPuntuacion, int cantMaximaDeSets,
                         int tantosPorAusenciaDeRival, int puntosPorPresentacion,
                         int puntosPorVictoria, boolean empatePermitido, int puntosPorEmpate){
        
        Estado e = pruebaJDBC.getEstado("Creada");
        Modalidad m = pruebaJDBC.getModalidad(nombreModalidad);
        FormaPuntuacion fp = pruebaJDBC.getFormaPuntuacion(nombreFormaPuntuacion);
        Deporte d = pruebaJDBC.getDeporte(nombreDeporte);
        
        
        // Disponibilidades
        ArrayList<Disponibilidad> listaDisponibilidades = new ArrayList();
        for (int i=0; i<matrizLugares.length; i++) {
            String unNombreLR = matrizLugares[i][0];
            //System.out.println(unNombreLR);
            LugarRealizacion unLR = CompetenciaDaoJDBC.buscarLRPorNombre(unNombreLR);
            Disponibilidad unaDisponibilidad = new Disponibilidad(Integer.parseInt(matrizLugares[i][1]), unLR);
            listaDisponibilidades.add(unaDisponibilidad); }
        /*
        for (int i=0; i<listaDisponibilidades.size(); i++) {
            Disponibilidad unaDisponibilidad = listaDisponibilidades.get(i);
            System.out.println(unaDisponibilidad.getCantidad());
            System.out.println((unaDisponibilidad.getLg()).getNombre()); }*/
        
        Competencia nuevaCD = new Competencia(nombre, reglamento, d, m, e, listaDisponibilidades, fp, cantMaximaDeSets, 
                tantosPorAusenciaDeRival, puntosPorPresentacion, puntosPorVictoria, empatePermitido, puntosPorEmpate);
        CompetenciaDaoJDBC.persistirCD(nuevaCD);
        
    }
}

