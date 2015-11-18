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
    
    public boolean nombreUsado (String nombreCD) {
        ArrayList<String> listaNombres = CompetenciaDaoJDBC.getNombresCD();
        for (int i=0; i<listaNombres.size(); i++) {
           if (listaNombres.get(i).equals(nombreCD)){
               return true;
           } 
        }
        return false;
    }    
    /*
        Estado e = pruebaJDBC.getEstado("Finalizada");
        Modalidad m = pruebaJDBC.getModalidad("Liga");
        FormaPuntuacion fp = pruebaJDBC.getFormaPuntuacion("Sets");
        Deporte d = pruebaJDBC.getDeporte("Voley");
        String matrizLugares[][] = new String[2][4];
        
        matrizLugares[0][0] = "lugar1";
        matrizLugares[0][1] = "lugar2";
        matrizLugares[0][2] = "lugar3";
        matrizLugares[0][3] = "lugar4";
        
        matrizLugares[1][0] = "12";
        matrizLugares[1][1] = "44";
        matrizLugares[1][2] = "5";
        matrizLugares[1][3] = "3";
        
        // Disponibilidades
        ArrayList<Disponibilidad> listaDisponibilidades = new ArrayList();
        for (int i=0; i<matrizLugares[0].length; i++) {
            String unNombreLR = (String)matrizLugares[0][i];
            LugarRealizacion unLR = CompetenciaDaoJDBC.buscarLRPorNombre(unNombreLR);
            Disponibilidad unaDisponibilidad = new Disponibilidad(Integer.parseInt(matrizLugares[1][i]), unLR);
            listaDisponibilidades.add(unaDisponibilidad); }
        
        for (int i=0; i<listaDisponibilidades.size(); i++) {
            Disponibilidad unaDisponibilidad = listaDisponibilidades.get(i);
            System.out.println(unaDisponibilidad.getCantidad());
            System.out.println((unaDisponibilidad.getLg()).getNombre()); }
        
        Competencia nuevaCD = new Competencia("A", "B", d, m, e, listaDisponibilidades, fp, 1, 1, 1, 1, false, 1);
        CompetenciaDaoJDBC.persistirCD(nuevaCD);
        
        */
}

