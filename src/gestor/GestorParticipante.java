/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import DAO.CompetenciaDaoJDBC;
import DAO.ParticipanteDao;
import static gestor.GestorCD.obtenerIdCD;
import java.io.FileInputStream;
import java.util.ArrayList;
import modelo.CompetenciaAux;
import modelo.Participante;
import modelo.ParticipanteAux;

/**
 *
 * @author Martin
 */
public class GestorParticipante {
    
    public static boolean verificarNombre (int id, String nombre) {
        boolean retorno =ParticipanteDao.nombreUsado(id, nombre);
        return retorno;
    }
    
    public static boolean verificarCorreo (int id, String correo) {
        boolean retorno= ParticipanteDao.correoUsado(id, correo);
        return retorno;
    }
    
    
    public static void altaParticipante(int idCD, String nombre, String correo, FileInputStream fis){
        // Nuevo participante
        Participante participante= new Participante(nombre, correo);
        
        // Persistir participante
        ParticipanteDao.persistirParticipante(idCD, participante);
    }
    
    public static ArrayList<ParticipanteAux> listarParticipantes (int idCD) {
        
        // Se obtienen los participantes de la BD
        ArrayList<Participante> participantes;
        participantes = ParticipanteDao.getParticipantes(idCD);
        
        
        ArrayList<ParticipanteAux> participantesAux= new ArrayList <ParticipanteAux> ();
        ParticipanteAux aux;
        
        for(int i=0; i < participantes.size(); i++){
            
            aux= new ParticipanteAux(participantes.get(i).getNombre(),
                    participantes.get(i).getCorreo());
            participantesAux.add(aux);
            
        }
        
        return participantesAux;
    }
    
}
