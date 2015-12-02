package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
  public static Competencia getCompetenciasS(int id_competencia){
    
     Competencia c=null;
    Connection conn = null;
    
    String Nombre, reglamento;
    int IdDeporte,IdModalidad,IdEstado,IdFormaPuntuacion, cantMaxSets,tantoPorAusencia, puntosPresentacion, puntosVictoria, puntosEmpate;
    boolean empatePermitido;
    
    try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            
            String SQL_FIND_COMPETENCIA = "SELECT nombre, id_forma_puntuacion, id_deporte, id_modalidad, id_estado FROM competencia WHERE id_competencia = '" + id_competencia + "'";
            
            ResultSet rs1 = statement.executeQuery(SQL_FIND_COMPETENCIA);
            rs1.next();
            
            Nombre=rs1.getString("nombre");
            
            IdDeporte=rs1.getInt("id_deporte");
            Deporte unDeporte = setDeporteCD(IdDeporte);
         
            IdModalidad=rs1.getInt("id_modalidad");
            Modalidad unaModalidad = setModalidadCD(IdModalidad);
            
            IdEstado=rs1.getInt("id_estado");
            Estado unEstado = setEstadoCD(IdEstado);
            
            IdFormaPuntuacion=rs1.getInt("id_forma_puntuacion");
            FormaPuntuacion unaFormaPuntuacion = setFormaPuntuacionCD(IdFormaPuntuacion);
            
            String SQL_FIND_COMPETENCIA_SETS = "SELECT reglamento, cantidad_maxima_de_sets, tanto_por_ausencia_rival, puntos_por_presentacion, puntos_por_victoria, empate_permitido, puntos_por_empate FROM competencia WHERE id_competencia = '" + id_competencia + "'";
            
            ResultSet rs4 = statement.executeQuery(SQL_FIND_COMPETENCIA_SETS);
            rs4.next();
            cantMaxSets=rs4.getInt("cantidad_maxima_de_sets");
            tantoPorAusencia=rs4.getInt("tanto_por_ausencia_rival");
            puntosPresentacion=rs4.getInt("puntos_por_presentacion");
            puntosVictoria=rs4.getInt("puntos_por_victoria");
            empatePermitido=rs4.getBoolean("empate_permitido");
            puntosEmpate=rs4.getInt("puntos_por_empate");
            reglamento=rs4.getString("reglamento");
            
            c = new Competencia(Nombre,reglamento,unDeporte,unaModalidad,unEstado,null,unaFormaPuntuacion,cantMaxSets,tantoPorAusencia,puntosPresentacion,puntosVictoria,empatePermitido,puntosEmpate);
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

    public static Estado getEstado(String unNombre) {
        Estado unEstado = null;
        int IDEstado = 0;
        String nombreEstado = "";
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDEstado = "SELECT id_estado FROM estado WHERE nombre = '" + unNombre + "'";
            ResultSet rs = statement.executeQuery(getIDEstado);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDEstado = rs.getInt("id_estado"); }
            String getEstado = "SELECT * FROM estado WHERE id_estado = " + IDEstado;
            rs = statement.executeQuery(getEstado);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                nombreEstado = rs.getString("nombre"); }
            unEstado = new Estado(nombreEstado);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unEstado; }
    
    public static Modalidad getModalidad(String unNombre) {
        Modalidad unaModalidad = null;
        int IDModalidad = 0;
        String nombreModalidad = "";
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDModalidad = "SELECT id_modalidad FROM modadlidad WHERE nombre = '" + unNombre + "'";
            ResultSet rs = statement.executeQuery(getIDModalidad);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDModalidad = rs.getInt("id_modalidad"); }
            String getModalidad = "SELECT * FROM modalidad WHERE id_modalidad = " + IDModalidad;
            rs = statement.executeQuery(getModalidad);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                nombreModalidad = rs.getString("nombre"); }
            unaModalidad = new Modalidad(IDModalidad, nombreModalidad);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unaModalidad; }  
    
    public static FormaPuntuacion getFormaPuntuacion(String unNombre) {
        FormaPuntuacion unaFormaPuntuacion = null;
        int IDFormaPuntuacion = 0;
        String nombreFormaPuntuacion = "";
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDFormaPuntuacion = "SELECT id_forma_puntuacion FROM forma_puntuacion WHERE nombre = '" + unNombre + "'";
            ResultSet rs = statement.executeQuery(getIDFormaPuntuacion);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDFormaPuntuacion = rs.getInt("id_forma_puntuacion"); }
            String getFormaPuntuacion = "SELECT * FROM forma_puntuacion WHERE id_forma_puntuacion = " + IDFormaPuntuacion;
            rs = statement.executeQuery(getFormaPuntuacion);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                nombreFormaPuntuacion = rs.getString("nombre"); }
            unaFormaPuntuacion = new FormaPuntuacion(nombreFormaPuntuacion);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unaFormaPuntuacion; }    
    
    public static Deporte getDeporte(String unNombre) {
        Deporte unDeporte = null;
        int IDDeporte = 0;
        String nombreDeporte = "";
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDDeporte = "SELECT id_deporte FROM deporte WHERE nombre = '" + unNombre + "'";
            ResultSet rs = statement.executeQuery(getIDDeporte);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDDeporte = rs.getInt("id_deporte"); }
            String getDeporte = "SELECT * FROM deporte WHERE id_deporte = " + IDDeporte;
            rs = statement.executeQuery(getDeporte);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                nombreDeporte = rs.getString("deporte"); }
            unDeporte = new Deporte(IDDeporte, nombreDeporte);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unDeporte; }
    
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
    
    public static ArrayList<String> getListaLugares() {
        String _SQL_FIND_NOMBRES_LUGARES = "SELECT nombre FROM lugar";   
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
    
    // Completar
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
                 
                Competencia compAux= new Competencia(setEstadoCD(rs.getInt("id_estado")),
                        setDeporteCD(rs.getInt("id_deporte")),setModalidadCD(rs.getInt("id_modalidad")),
                        setNombreCD(rs.getInt("id_competencia")));
                
                ls.add(compAux);     
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
    
    public static ArrayList<TablaPosicionesParticipante> getTablaPosiciones (int id_competencia){
    
    ArrayList<TablaPosicionesParticipante> tps= new ArrayList <> ();
    
    Connection conn = null; 
        
    int puntos,partidosGanados,partidosPerdidos,partidosEmpatados,tantoEnContra,tantoAFavor;
    
       try{   
        
            conn = DBConnection.get();
     
            Statement statement = conn.createStatement();
 
            
         
            String SQL_FIND_TABLAPOSICIONES = "SELECT puntos, partidos_ganados, partidos_perdidos, partidos_empatados, tantos_contra, tantos_a_favor FROM tabla_posiciones WHERE id_competencia ='"+ id_competencia+"'";
            ResultSet rs = statement.executeQuery(SQL_FIND_TABLAPOSICIONES);
            while(rs.next()){
            
                puntos=rs.getInt("puntos");
                partidosGanados=rs.getInt("partidos_ganados");
                partidosPerdidos=rs.getInt("partidos_perdidos");
                partidosEmpatados=rs.getInt("partidos_empatados");
                tantoEnContra=rs.getInt("tantos_contra");
                tantoAFavor=rs.getInt("tantos_a_favor");
                
                TablaPosicionesParticipante pp= new TablaPosicionesParticipante(puntos,partidosGanados,partidosPerdidos,partidosEmpatados,tantoEnContra,tantoAFavor);
                /*TablaPosicionesParticipante( int puntos, int partidosGanados, int partidosPerdidos,
                                       int partidosEmpatados, int tantoEnContra, int tantoAFavor)*/
                tps.add(pp);
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
        
        
    return tps;
    }
    
    
         
    public static String setNombreCD(int id_comp){
        
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
    
    public static Estado setEstadoCD(int idEstado){
        
         
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
        
        unEstado = new Estado(nomb);
        
        
   
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
        
    public static FormaPuntuacion setFormaPuntuacionCD(int idFormaPuntuacion){
        
         
        String _SQL_FK_FORMA_PUNTUACION ="SELECT nombre FROM forma_puntuacion  WHERE id_forma_puntuacion = '" + idFormaPuntuacion + "' ";
        
        Connection conn = null; 
        FormaPuntuacion unaFormaPuntuacion = null;
        
        try{
        
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_FORMA_PUNTUACION );
        
        rs.next();
        String nomb=rs.getString("nombre");
        
        unaFormaPuntuacion = new FormaPuntuacion(nomb);
        
        
   
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
        return unaFormaPuntuacion;
    }
    
    
    
    
    public static Deporte setDeporteCD(int idDeporte){
        
         
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
        
    public static Modalidad setModalidadCD(int idModalidad){
        
         
        String _SQL_FK_MODALIDAD ="SELECT nombre FROM modalidad WHERE id_modalidad = '" + idModalidad + "' ";
        
        Connection conn = null; 
        Modalidad unaModalidad = null;
        
        try{
        
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_MODALIDAD);
        
        rs.next();
        
        int id_modalidad= idModalidad;
        String nomb=rs.getString("nombre");
        
        unaModalidad = new Modalidad(id_modalidad, nomb);
 
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
        
    public static Estado persistirEstado(String name){
        
         //int unIdEstado = unEstado.getID(); 
        //String unNombreEstado = unEstado.getNombre();
        //String insertarEstado="INSERT INTO estado" + "VALUES (" + unNombreEstado + ")";
        String _SQL_FK_ESTADO ="SELECT id_estado FROM estado E WHERE E.nombre = '" + name + "' ";
        
        Connection conn = null; 
        Estado unEstado = null;
        
        try{
        
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_ESTADO);
        
        rs.next();
        String nomb=rs.getString("nombre");
        
        unEstado = new Estado(nomb);
        
        
   
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
    
    public static FormaPuntuacion persistirFormaPuntuacion(FormaPuntuacion unaFormaPuntuacion){
        
        /* int unIdFormaPuntuacion = unaFormaPuntuacion.getId(); */
        String unNombreFormaPuntuacion = unaFormaPuntuacion.getNombre();
        
        
        String insertarPuntuacion="INSERT INTO forma_puntuacion" + "VALUES (" + unNombreFormaPuntuacion + ")";
        
        Connection conn = null; 
        try{
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(insertarPuntuacion);        
            rs.close();
   
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
      return unaFormaPuntuacion;
    }
    
    public static Modalidad persistirModalidad(Modalidad unaModalidad){
        
        /* int unIdModalidad = unaModalidad.getId(); */
        String unNombreModalidad = unaModalidad.getNombre();
        
        
        String insertarModalidad="INSERT INTO modalidad" + "VALUES (" + unNombreModalidad + ")";
        
        Connection conn = null; 
        try{
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(insertarModalidad);        
            rs.close();
   
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
    
    public static void persistirDeporte(Deporte unDeporte){
        
        /* int unIdDeporte = unDeporte.getId(); */
        String unNombreDeporte = unDeporte.getNombre();
        
        
        String insertarDeporte="INSERT INTO deporte" + "VALUES (" + unNombreDeporte + ")";
        
        Connection conn = null; 
        try{
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(insertarDeporte);        
            rs.close();
   
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
    }
    
    public static void persistirDisponibilidad(Disponibilidad unaDisponibilidad, int IDCD) {
        int cantidad = unaDisponibilidad.getCantidad();
        LugarRealizacion lugar = unaDisponibilidad.getLg();
        String insertarDisponibilidad = "INSERT INTO disponibilidad VALUES (default, " + IDCD + ", " + lugar.getId() + ", " + cantidad + ")";
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
        
        // Queries
        String persistirCD = "INSERT INTO competencia VALUES (default, 1, " + getIDEstado(unaCompetencia.getEstado()) + ", "
            + getIDFormaPuntuacion(unaCompetencia.getFormaPuntuacion()) + ", " + getIDModalidad(unaCompetencia.getModalidad()) + ", "
            + getIDDeporte(unaCompetencia.getDeporte()) + ", " + unaCompetencia.getNombre() + ", " + unaCompetencia.getReglamento() + ", "
            + unaCompetencia.getCantidadMaximaDeSets() + ", " + unaCompetencia.getTantosPorAusenciaDeRival() + ", "
            + unaCompetencia.getPuntosPorPresentacion() + ", " + unaCompetencia.getPuntosPorVictoria() + ", "
            + unaCompetencia.getEmpatePermitido() + ", " + unaCompetencia.getPuntosPorEmpate() + ")";
        String getIDCompetencia = "SELECT id_competencia FROM competencia WHERE nombre = '" + unaCompetencia.getNombre() + "'";
        
        // Persistencia
        Connection conn = null; 
        try {
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
            for (Disponibilidad disponibilidad:(unaCompetencia.getListaDisponibilidades())) {
                persistirDisponibilidad(disponibilidad, IDCD); }
            rs.close(); }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } }
    
    public static int getIDEstado(Estado unEstado) {
        int unIDEstado = 0;
        String getIDEstado = "SELECT id_estado FROM estado WHERE nombre = '" + unEstado.getNombre() + "'";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getIDEstado);
            while (rs.next()) {
                unIDEstado = rs.getInt("id_estado"); }
            rs.close();}
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unIDEstado; }
    
    public static int getIDDeporte(Deporte unDeporte) {
        int unIDDeporte = 0;
        String getIDEstado = "SELECT id_deporte FROM deporte WHERE nombre = '" + unDeporte.getNombre() + "'";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getIDEstado);
            while (rs.next()) {
                unIDDeporte = rs.getInt("id_deporte"); }
            rs.close();}
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unIDDeporte; }
    
    public static int getIDModalidad(Modalidad unaModalidad) {
        int unIDModalidad = 0;
        String getIDModalidad = "SELECT id_modalidad FROM modalidad WHERE nombre = '" + unaModalidad.getNombre() + "'";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getIDModalidad);
            while (rs.next()) {
                unIDModalidad = rs.getInt("id_modalidad"); }
            rs.close();}
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unIDModalidad; }
    
    public static int getIDFormaPuntuacion(FormaPuntuacion unaFormaPuntuacion) {
        int unIDFormaPuntuacion = 0;
        String getIDFormaPuntuacion = "SELECT id_forma_puntuacion FROM forma_puntuacion WHERE nombre = '" + unaFormaPuntuacion.getNombre() + "'";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getIDFormaPuntuacion);
            while (rs.next()) {
                unIDFormaPuntuacion = rs.getInt("id_forma_puntuacion"); }
            rs.close();}
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unIDFormaPuntuacion; }    
    
    public static LugarRealizacion buscarLRPorNombre(String nombreLR){
     Connection conn = null;
     String _SQL_FIND_LUGAR_NOMBRE = "SELECT L.id_lugar, L.nombre, L.descripcion FROM lugar L WHERE nombre = '" + nombreLR + "' ";
     /**/
      try{
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(_SQL_FIND_LUGAR_NOMBRE);
            // Se que tengo 1 solo Lugar por nombre
            int unIDLugar = 1;
            String unNombreLugar = null;
            String unaDescripcion = null;
            while(rs.next()) {
                unIDLugar = rs.getInt("id_lugar");
                unNombreLugar = rs.getString("nombre");
                unaDescripcion = rs.getString("descripcion"); }
            
            String _SQL_FIND_DEPORTES_LUGAR = "SELECT id_deporte FROM lugar_realiza_deporte WHERE id_lugar = " + unIDLugar;
            rs = statement.executeQuery(_SQL_FIND_DEPORTES_LUGAR);
            ArrayList<Integer> listaIDDeporte = new ArrayList();
            while (rs.next()) {
                listaIDDeporte.add(rs.getInt("id_deporte")); }
            
            ArrayList<Deporte> listaDeportes = new ArrayList(); 
            for (int i=0; i<listaIDDeporte.size(); i++) {
                String _SQL_FIND_DEPORTE_ID = "SELECT nombre FROM deporte WHERE id_lugar = " + (listaIDDeporte.get(i)).toString();
                rs = statement.executeQuery(_SQL_FIND_DEPORTE_ID);
                // Se que tengo 1 solo Deporte por ID
                String unNombreDeporte = rs.getString("nombre");
                Deporte unDeporte = new Deporte(listaIDDeporte.get(i), unNombreDeporte);
                listaDeportes.add(unDeporte); }
            LugarRealizacion unLR = new LugarRealizacion(unIDLugar, unNombreLugar, unaDescripcion, listaDeportes);
            rs.close();
            return unLR;
   
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
        return null; } }