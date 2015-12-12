package gestor;

import DAO.*;
import modelo.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GestorGestionarFixture {
    public static int randomInt(int min, int max) {
        int rand = ThreadLocalRandom.current().nextInt(min, max+1);
        return rand; 
    }
    
    public static ArrayList<ArrayList<Participante>> crearLLPA(ArrayList<Participante> unaLP) {
        // Lista auxiliar de listas de participantes
        ArrayList<ArrayList<Participante>> LLPA = new ArrayList();
        for (int i=0; i<unaLP.size(); i++) {
            for (int j=i+1; j<unaLP.size(); j++) {
                // Lista auxiliar de participantes
                ArrayList<Participante> LPA = new ArrayList();
                LPA.add(unaLP.get(i));
                LPA.add(unaLP.get(j));
                LLPA.add(LPA); 
            } 
        }
        return LLPA; 
    }
    
    // Solo modalidad LIGA
    public static void generarFixture(CompetenciaAux compAux) {
        String nombreCD = compAux.getNombre();
        // Objetos existentes
        Competencia unaCompetencia = GestionarFixtureDAO.getCompetencia(nombreCD);
        ArrayList<Participante> listaParticipantes = unaCompetencia.getListaParticipantes();
        ArrayList<Disponibilidad> listaDisponibilidades = unaCompetencia.getListaDisponibilidades();
        // Nuevos objetos
        ArrayList<Ronda> listaRondas = new ArrayList();
        ArrayList<ArrayList<Participante>> LLPA = crearLLPA(listaParticipantes);
        Estado unEstado = unaCompetencia.getEstado();
        if ("Creada".equals(unEstado.getNombre()) || "Planificada".equals(unEstado.getNombre())) {
            for (int i=0; i<listaParticipantes.size()-1; i++) {
                ArrayList<Partido> listaPartidos = new ArrayList();
                for (int j=0; j<listaParticipantes.size()/2; j++) {
                    // Participantes
                    int PIndex = randomInt(0, LLPA.size()-1);
                    ArrayList<Participante> LPA = LLPA.get(PIndex);
                    int LPAIndex = randomInt(0, LPA.size()-1);
                    Participante P0 = LPA.get(LPAIndex);
                    Participante P1;
                    if (LPAIndex == 0) {
                        P1 = LPA.get(1); 
                    }
                    else {
                        P1 = LPA.get(0); 
                    }
                    LLPA.remove(PIndex);
                    // Lugar de realizacion
                    int LRIndex = randomInt(0, listaDisponibilidades.size()-1);
                    LugarRealizacion unLugar = listaDisponibilidades.get(LRIndex).getLR();
                    // Tipo de ronda
                    Boolean rondaPerdedores = false;
                    // Creacion del partido
                    Partido unPartido = new Partido(P0, P1, unLugar, rondaPerdedores, unaCompetencia.getEmpatePermitido());
                    listaPartidos.add(unPartido); 
                }
                // Creacion de la ronda
                Ronda unaRonda = new Ronda(i, false, null, listaPartidos);
                listaRondas.add(unaRonda); 
            }
            // Creacion del fixture
            Fixture unFixture = new Fixture(listaRondas);
            unaCompetencia.setFixture(unFixture);
            // Persistencia
            if ("Creada".equals(unEstado.getNombre())) {
                System.out.println("Se pasa Creada a Planificada");
                Estado nuevoEstado = GestionarFixtureDAO.getEstado("Planificada");
                unaCompetencia.setEstado(nuevoEstado);
                GestionarFixtureDAO.setEstado(unaCompetencia, nuevoEstado); 
            }
            else {
                GestionarFixtureDAO.deleteFixture(unaCompetencia); 
            }
            System.out.println("Se crea el Fixture");
            unaCompetencia.setFixture(unFixture);
            GestionarFixtureDAO.persistirFixture(unFixture, nombreCD); 
        } 
    }
}
