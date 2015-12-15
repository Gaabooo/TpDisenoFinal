package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

public class CompetenciaDaoJDBC {
    private static final String _SQL_INSERT_COMPETENCIA = "INSERT INTO "+ "competencia" +" "
            + "(id_competencia,id_estado,id_forma_Puntuacion,id_modalidad,id_deporte,id_disponibiliad,"
            + "id_usuario, id_tablaPosicionesParticipante,id_fixture,nombre,reglamento,"
            + "cantidad_maxima_de_sets,tanto_por_ausencia_rival,puntos_por_presentacion,puntos_por_victoria,"
            + "empate_permitido,puntos_por_empate) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  
    private static final String _SQL_FIND_ALL_ESTADO="SELECT * FROM"+ "estado";
    private static final String _SQL_FIND_ALL_FORMA_PUNTUACION="SELECT * FROM"+ "forma_puntuacion";
    private static final String _SQL_FIND_ALL_MODALIDAD="SELECT * FROM"+ "modalidad";
    private static final String _SQL_INSERT_DISPONIBILIADAD="SELECT * FROM"+ "disponibilidad";
    private static final String _SQL_FIND_ALL_USUARIO="SELECT * FROM"+ "usuario";
    private static final String _SQL_FIND_ALL_TABLA_POSICIONES_PARTICIPANTE="SELECT * FROM"+ "tabla_posiciones";
    private static final String _SQL_FIND_ALL_DEPORTE = "SELECT * FROM " + "deporte";
    private static final String _SQL_FIND_ALL_FIXTURE="SELECT * FROM"+ "fixture";
    
    
    public static ArrayList<PosicionAux> getPosicionesAux(int unIDCD) {
        ArrayList<PosicionAux> listaPosiciones = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getPosiciones = "SELECT * FROM posicion WHERE id_competencia = " + unIDCD;
            ResultSet rs = statement.executeQuery(getPosiciones);
            // NOTA: El ResultSet tiene un solo resultado
            while (rs.next()) {
                int IDPosicion = rs.getInt("id_posicion");
                int IDParticipante = rs.getInt("id_participante");
                Participante unParticipante = GestionarFixtureDAO.getParticipante(IDParticipante);
                String nombreParticipante = unParticipante.getNombre();
                int puntos = rs.getInt("puntaje");
                int partidosGanados = rs.getInt("partidos_ganados");
                int partidosPerdidos = rs.getInt("partidos_perdidos");
                int partidosEmpatados = rs.getInt("partidos_empatados");
                int tantosAFavor = rs.getInt("tantos_a_favor");
                int tantosEnContra = rs.getInt("tantos_en_contra");
                PosicionAux unaPosicion = new PosicionAux(nombreParticipante, puntos, partidosGanados, partidosPerdidos, partidosEmpatados, tantosAFavor, tantosEnContra);
                listaPosiciones.add(unaPosicion); }
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return listaPosiciones; }
    
    public static Competencia getCompetenciaPorId(int id_competencia){
        
        Competencia c=null;
        Connection conn = null;
        
        String Nombre;
    int IdDeporte,IdModalidad,IdEstado;
    
    try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            
            String SQL_FIND_COMPETENCIA_NOMBRE = "SELECT nombre FROM competencia WHERE id_competencia = '" + id_competencia + "'";
            
            ResultSet rs = statement.executeQuery(SQL_FIND_COMPETENCIA_NOMBRE);
            rs.next();
            Nombre=rs.getString("nombre");
            
            String SQL_FIND_COMPETENCIA_DEPORTE = "SELECT id_deporte FROM competencia WHERE id_competencia = '" + id_competencia + "'";
            
            ResultSet rs1 = statement.executeQuery(SQL_FIND_COMPETENCIA_DEPORTE);
            rs1.next();
            IdDeporte=rs1.getInt("id_deporte");
            
            Deporte unDeporte = getDeportePorId(IdDeporte);

            String SQL_FIND_COMPETENCIA_MODALIDAD = "SELECT id_modalidad FROM competencia WHERE id_competencia = '" + id_competencia + "'";
            
            ResultSet rs2 = statement.executeQuery(SQL_FIND_COMPETENCIA_MODALIDAD);
            rs2.next();
            IdModalidad=rs2.getInt("id_modalidad");
            
            Modalidad unaModalidad = getModalidadPorId(IdModalidad);
            
            String SQL_FIND_COMPETENCIA_ESTADO = "SELECT id_estado FROM competencia WHERE id_competencia = '" + id_competencia + "'";
            
            ResultSet rs3 = statement.executeQuery(SQL_FIND_COMPETENCIA_ESTADO);
            rs3.next();
            IdEstado=rs3.getInt("id_estado");
            
            Estado unEstado = getEstadoPorId(IdEstado);
            
            c = new Competencia(Nombre,"",unDeporte,unaModalidad,unEstado,null,null,1,1,1,1,true,1);
            /*(String nombre, String reglamento, Deporte deporte, Modalidad modalidad, Estado estado,
                       ArrayList<Disponibilidad> listaDisponibilidades, FormaPuntuacion formaPuntuacion, int cantidadMaximaDeSets,
                       int tantosPorAusenciaDeRival, int puntosPorPresentacion, int puntosPorVictoria,
                       boolean empatePermitido, int puntosPorEmpate)*/
    }
     catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
    
    
    return c;
    }
    
    public static int getIdCompetencia(String nombre){
        
        int IdCompetencia = 0;
        
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            
            /*id_competencia*/
            String SQL_FIND_ID_COMPETENCIA = "SELECT id_competencia FROM competencia WHERE nombre = '"+ nombre +"'";
             
            ResultSet rs = statement.executeQuery(SQL_FIND_ID_COMPETENCIA);
            
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                 
                IdCompetencia = rs.getInt("id_competencia"); }

            rs.close(); 
        }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        
        return IdCompetencia;
    }
    
    
    public static Estado getEstadoPorNombre(String unNombre) {
        Estado unEstado = null;
        int IDEstado = 0;
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getEstado = "SELECT * FROM estado WHERE nombre = '" + unNombre + "'";
            ResultSet rs = statement.executeQuery(getEstado);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDEstado = rs.getInt("id_estado"); }
            unEstado = new Estado(IDEstado, unNombre);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unEstado; }
    
    public static Modalidad getModalidadPorNombre(String unNombre) {
        Modalidad unaModalidad = null;
        int IDModalidad = 0;
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getModalidad = "SELECT * FROM modalidad WHERE nombre = '" + unNombre + "'";
            ResultSet rs = statement.executeQuery(getModalidad);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDModalidad = rs.getInt("id_modalidad"); }
            unaModalidad = new Modalidad(IDModalidad, unNombre);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unaModalidad; }  
    
    public static FormaPuntuacion getFormaPuntuacionPorNombre(String unNombre) {
        FormaPuntuacion unaFormaPuntuacion = null;
        int IDFormaPuntuacion = 0;
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            
            String getFormaPuntuacion = "SELECT * FROM forma_puntuacion WHERE nombre = '" + unNombre + "'";
            ResultSet rs = statement.executeQuery(getFormaPuntuacion);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDFormaPuntuacion = rs.getInt("id_forma_puntuacion"); }
            unaFormaPuntuacion = new FormaPuntuacion(IDFormaPuntuacion, unNombre);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unaFormaPuntuacion; }    
    
    public static Deporte getDeportePorNombre(String unNombre) {
        Deporte unDeporte = null;
        int IDDeporte = 0;
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDDeporte = "SELECT id_deporte FROM deporte WHERE nombre = '" + unNombre + "'";
            ResultSet rs = statement.executeQuery(getIDDeporte);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDDeporte = rs.getInt("id_deporte"); }
            unDeporte = new Deporte(IDDeporte, unNombre);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unDeporte; }
    
    public static String getNombrePorId(int id_comp){
        
            Connection conn = null;
            String SQL_NOMBRE_CD ="SELECT nombre FROM competencia WHERE id_competencia = '" + id_comp + "' ";
            String nomb=null;
            
            try{
        
                conn = DBConnection.get();
                ResultSet  rs;
                Statement stmt = conn.createStatement(); 
                rs=stmt.executeQuery(SQL_NOMBRE_CD);
        
                rs.next();
 
                nomb=rs.getString("nombre");
 

        }catch (SQLException ex) {
            
            Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
     
        return nomb;
        }
    
    public static Estado getEstadoPorId(int idEstado){
        
         
        String _SQL_FK_ESTADO ="SELECT nombre FROM estado  WHERE id_estado = '" + idEstado + "' ";
        
        Connection conn = null; 
        Estado unEstado = null;
        
        try{
        
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_ESTADO);
        
        rs.next();
        String nomb=rs.getString("nombre");
        
        unEstado = new Estado(idEstado, nomb);
        
        
   
        }catch (SQLException ex) {
            
            Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return unEstado;
    }
        
    public static Deporte getDeportePorId(int idDeporte){
        
         
        String _SQL_FK_DEPORTE ="SELECT nombre FROM deporte  WHERE id_deporte = '" + idDeporte + "' ";
        
        Connection conn = null; 
        Deporte unDeporte = null;
        
        try{
        
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_DEPORTE);
        
        rs.next();
        
        int id_deporte= idDeporte;
        String nomb=rs.getString("nombre");
        
        unDeporte = new Deporte(id_deporte, nomb);
        
        }catch (SQLException ex) {
            
            Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return unDeporte;
    }    
        
    public static Modalidad getModalidadPorId(int idModalidad){
        
         
        String _SQL_FK_MODALIDAD ="SELECT nombre FROM modalidad WHERE id_modalidad = '" + idModalidad + "' ";
        
        Connection conn = null; 
        Modalidad unaModalidad = null;
        
        try{
        
        conn = DBConnection.get();
        ResultSet  rs;
        Statement stmt = conn.createStatement();
        rs=stmt.executeQuery(_SQL_FK_MODALIDAD);
        
        rs.next();
        
        String nomb=rs.getString("nombre");
        
        unaModalidad = new Modalidad(idModalidad, nomb);
 
        }catch (SQLException ex) {
            
            Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return unaModalidad;
    }    
    
    public static FormaPuntuacion getFormaPuntuacionPorId(int idFormaP){
        
         
        String _SQL_FK_FORMAP ="SELECT nombre FROM forma_puntuacion WHERE id_forma_puntuacion = '" + idFormaP + "' ";
        
        Connection conn = null; 
        FormaPuntuacion unaFormaP = null;
        
        try{
        
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_FORMAP);
        
        rs.next();
        String nomb=rs.getString("nombre");
        
        unaFormaP = new FormaPuntuacion(idFormaP, nomb);
        
        
   
        }catch (SQLException ex) {
            
            Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return unaFormaP;
    }
    
    
    public static ArrayList<String> getListaDeportes() {
        String _SQL_FIND_NOMBRES_DEPORTES = "SELECT nombre FROM deporte";   
        Connection conn = null;
        ArrayList<String> deportes = new ArrayList();
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(_SQL_FIND_NOMBRES_DEPORTES);
            while (rs.next()) {
                deportes.add(rs.getString("nombre")); }
            rs.close();
            return deportes; }
        catch (SQLException ex) {
            /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ }
        finally {
            if (conn!=null) try {
                conn.close(); }
            catch (SQLException ex) {
                /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ } } 
        return deportes; 
    }
    
    public static ArrayList<String> getListaLugares(String deporte) {
        String _SQL_FIND_NOMBRES_LUGARES = "SELECT l.nombre FROM lugar l "+
                                           "JOIN lugar_realiza_deporte ld ON ld.id_lugar = l.id_lugar "+
                                           "JOIN deporte d ON ld.id_deporte = d.id_deporte "+
                                           "WHERE d.nombre= '"+deporte+"'";
        Connection conn = null;
        ArrayList<String> lugares = new ArrayList();
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(_SQL_FIND_NOMBRES_LUGARES);
            while (rs.next()) {
                lugares.add(rs.getString("nombre")); }
            rs.close();
            return lugares; }
        catch (SQLException ex) {
            /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ }
        finally {
            if (conn!=null) try {
                conn.close(); }
            catch (SQLException ex) {
                /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ } } 
        return lugares; 
    }
        
    public static ArrayList<String> getListaModalidades() {
        String _SQL_FIND_NOMBRES_MODALIDADES = "SELECT nombre FROM modalidad";   
        Connection conn = null;
        ArrayList<String> modalidades = new ArrayList();
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(_SQL_FIND_NOMBRES_MODALIDADES);
            while (rs.next()) {
                modalidades.add(rs.getString("nombre")); }
            rs.close();
            return modalidades; }
        catch (SQLException ex) {
            /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ }
        finally {
            if (conn!=null) try {
                conn.close(); }
            catch (SQLException ex) {
                /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ } } 
        return modalidades; 
    }
    
    public static ArrayList<String> getListaPuntuaciones() {
        String _SQL_FIND_NOMBRES_PUNTUACIONES = "SELECT nombre FROM forma_puntuacion";   
        Connection conn = null;
        ArrayList<String> puntuaciones = new ArrayList();
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(_SQL_FIND_NOMBRES_PUNTUACIONES);
            while (rs.next()) {
                puntuaciones.add(rs.getString("nombre")); }
            rs.close();
            return puntuaciones; }
        catch (SQLException ex) {
            /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ }
        finally {
            if (conn!=null) try {
                conn.close(); }
            catch (SQLException ex) {
                /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ } } 
        return puntuaciones; 
    }
    
    public static Boolean nombreUsado(String nombreCD) {
        String _SQL_FIND_NOMBRE_USADO = "SELECT nombre FROM competencia WHERE nombre = '" + nombreCD + "'";
        Connection conn = null;
        Boolean retorno = true;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(_SQL_FIND_NOMBRE_USADO);
            if (!rs.isBeforeFirst()) { retorno = false; }
            rs.close(); }
        catch (SQLException e) {
            System.out.println(e.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return retorno; }
    
    
    public static ArrayList<Competencia> getCompetencias (String nombreCD, String nombreDeporte, String nombreModalidad, String nombreEstado) {
        
        Connection conn = null; 
        
        String _SQL_FIND_COMPETENCIAS = "SELECT * FROM competencia WHERE ";
        String SQL_LISTA_COMPETENCIAS=null; 
        ArrayList<Competencia> ls= new ArrayList <> ();
  
        try {
            
            conn = DBConnection.get();
     
            Statement statement = conn.createStatement();
 
            ResultSet rs;
            
            SQL_LISTA_COMPETENCIAS = _SQL_FIND_COMPETENCIAS;
            
            if (nombreCD != null) {
                String auxNombre = "nombre LIKE '%" + nombreCD + "%' and "; 
                SQL_LISTA_COMPETENCIAS= SQL_LISTA_COMPETENCIAS + auxNombre;
            }
            if (nombreDeporte != null) {
                String _SQL_FIND_ID_DEPORTE = "SELECT id_deporte FROM deporte WHERE nombre = '" + nombreDeporte + "'";
                rs = statement.executeQuery(_SQL_FIND_ID_DEPORTE);
                while(rs.next()){
                    int IDDeporte = rs.getInt("id_deporte");
                    String auxDeporte = "id_deporte = " + IDDeporte +" and " ; 
                    SQL_LISTA_COMPETENCIAS= SQL_LISTA_COMPETENCIAS + auxDeporte;
                }
            }
            if (nombreModalidad != null) {
                String _SQL_FIND_ID_MODALIDAD = "SELECT id_modalidad FROM modalidad WHERE nombre ='" + nombreModalidad + "'";
                rs = statement.executeQuery(_SQL_FIND_ID_MODALIDAD);
                while(rs.next()){
                    int IDModalidad = rs.getInt("id_modalidad");
                    String auxModalidad= "id_modalidad = " + IDModalidad +" and " ;
                    SQL_LISTA_COMPETENCIAS= SQL_LISTA_COMPETENCIAS + auxModalidad;
                }
            }
            if (nombreEstado != null) {
                String _SQL_FIND_ID_ESTADO = "SELECT id_estado FROM estado WHERE nombre LIKE '%" + nombreEstado + "%'";
                rs = statement.executeQuery(_SQL_FIND_ID_ESTADO);
                while(rs.next()){    
                    int IDEstado = rs.getInt("id_estado");
                    String auxEstado ="id_estado = " + IDEstado +" and " ;
                    SQL_LISTA_COMPETENCIAS= SQL_LISTA_COMPETENCIAS + auxEstado;
                }
            }
            
            SQL_LISTA_COMPETENCIAS= SQL_LISTA_COMPETENCIAS.substring(0, SQL_LISTA_COMPETENCIAS.length()-4);
            
            rs = statement.executeQuery(SQL_LISTA_COMPETENCIAS);
              
            while(rs.next()){
                
                // Obtener los objetos Estado, Modalidad, FormaPunt, Deporte, y asignarlos a la competencia
                
                Competencia comp= new Competencia(rs.getInt("id_competencia"), getNombrePorId(rs.getInt("id_competencia")),
                        getDeportePorId(rs.getInt("id_deporte")), getModalidadPorId(rs.getInt("id_modalidad")),
                        getEstadoPorId(rs.getInt("id_estado")), getFormaPuntuacionPorId(rs.getInt("id_forma_puntuacion")));
                
                ls.add(comp);     
            }
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); 
        }
        finally {
            if (conn!=null) try {
                conn.close(); }
            catch (SQLException ex) {
                Logger.getLogger(CompetenciaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); } 
        } 
        
            return ls;
    }
    
    
    public static void persistirDisponibilidad(Disponibilidad unaDisponibilidad, int IDCD) {
        int cantidad = unaDisponibilidad.getCantidad();
        LugarRealizacion lugar = unaDisponibilidad.getLR();
        String insertarDisponibilidad = "INSERT INTO disponibilidad VALUES (default, " + IDCD + ", " + lugar.getID() + ", " + cantidad + ")";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            statement.executeUpdate(insertarDisponibilidad); }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } }
    
    public static void persistirCD(Competencia unaCompetencia){
        int IDCD = 0;
        
        String reglamento="";
        
        if(unaCompetencia.getReglamento()!=null){
            reglamento="'"+unaCompetencia.getReglamento()+"'";
        }
        else{
            reglamento=null;
        }
        // Queries
        String persistirCD = "INSERT INTO competencia VALUES (default, 1, " + unaCompetencia.getEstado().getID() + ", "
            + unaCompetencia.getFormaPuntuacion().getId() + ", " + unaCompetencia.getModalidad().getID() + ", "
            + unaCompetencia.getDeporte().getId() + ", '" + unaCompetencia.getNombre() + "', " + reglamento + ", "
            + unaCompetencia.getCantidadMaximaDeSets() + ", " + unaCompetencia.getTantosPorAusenciaDeRival() + ", "
            + unaCompetencia.getPuntosPorPresentacion() + ", " + unaCompetencia.getPuntosPorVictoria() + ", "
            + unaCompetencia.getEmpatePermitido() + ", " + unaCompetencia.getPuntosPorEmpate() + ")";
        String getIDCompetencia = "SELECT id_competencia FROM competencia WHERE nombre = '" + unaCompetencia.getNombre() + "'";
        
        // Persistencia
        Connection conn = null; 
        try {
            System.out.println("acaaaa11111");
            // Persistencia CD
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            statement.executeUpdate(persistirCD);
            // Obtengo IDCD para persistir las disponibilidades
            ResultSet rs = statement.executeQuery(getIDCompetencia);
            // NOTA: El ResultSet solo contiene un resultado
            while (rs.next()) {
                IDCD = rs.getInt("id_competencia"); }
            // Persistencia disponibilidades
            for (Iterator<Disponibilidad> it =
                    (unaCompetencia.getListaDisponibilidades()).iterator(); it.hasNext();) {
                Disponibilidad disponibilidad = it.next();
                System.out.println("acaaaa222222");
                persistirDisponibilidad(disponibilidad, IDCD);
            }
            rs.close(); }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } } }