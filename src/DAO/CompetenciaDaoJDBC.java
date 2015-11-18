package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public static ArrayList<String> getNombresCD () {
        String _SQL_FIND_NOMBRES_LUGARES = "SELECT nombre FROM lugar";
        Connection conn = null;
        ArrayList<String> listaNombresCD = new ArrayList();
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(_SQL_FIND_NOMBRES_LUGARES);
            while (rs.next()) {
                listaNombresCD.add(rs.getString("nombre")); }
            rs.close();
            return listaNombresCD; }
        catch (SQLException ex) {
            /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ }
        finally {
            if (conn!=null) try {
                conn.close(); }
            catch (SQLException ex) {
                /* Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); */ } } 
        return listaNombresCD; }
    
    // Completar
    public static ArrayList<Competencia> getCompetencias (String nombreCD, String nombreDeporte, String nombreModalidad, String nombreEstado) {
        String _SQL_FIND_COMPETENCIAS = "SELECT * FROM competencia WHERE ";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs;
            if (nombreCD != null) {
                _SQL_FIND_COMPETENCIAS = _SQL_FIND_COMPETENCIAS + "nombre LIKE '%" + nombreCD + "%'"; }
            if (nombreDeporte != null) {
                String _SQL_FIND_ID_DEPORTE = "SELECT id_deporte FROM deporte WHERE nombre ='" + nombreDeporte + "'";
                rs = statement.executeQuery(_SQL_FIND_ID_DEPORTE);
                int IDDeporte = rs.getInt("id_deporte");
                _SQL_FIND_COMPETENCIAS =_SQL_FIND_COMPETENCIAS + "id_deporte = " + IDDeporte + ", "; }
            if (nombreModalidad != null) {
                String _SQL_FIND_ID_MODALIDAD = "SELECT id_modalidad FROM modalidad WHERE nombre ='" + nombreModalidad + "'";
                rs = statement.executeQuery(_SQL_FIND_ID_MODALIDAD);
                int IDModalidad = rs.getInt("id_modalidad");
                _SQL_FIND_COMPETENCIAS =_SQL_FIND_COMPETENCIAS + "id_modalidad = " + IDModalidad + ", "; }
            if (nombreEstado != null) {
                String _SQL_FIND_ID_ESTADO = "SELECT id_estado FROM estado WHERE nombre LIKE '%" + nombreEstado + "%'";
                rs = statement.executeQuery(_SQL_FIND_ID_ESTADO);
                int IDEstado = rs.getInt("id_estado");
                _SQL_FIND_COMPETENCIAS =_SQL_FIND_COMPETENCIAS + "id_estado = " + IDEstado; }
            rs = statement.executeQuery(_SQL_FIND_COMPETENCIAS);
            while (rs.next()) {
                     
              Competencia comp= null;
              Estado estado = null;
              Modalidad modalidad=null;
              Deporte deporte=null;
                
              String SQL_NOMBRECD = rs.getString("nombre");
              String SQL_FIND_ESTADO = "SELECT nombre FROM estado WHERE id_estado="+ rs.getInt("id_estado");
              String SQL_FIND_MODALIDAD = "SELECT nombre FROM modalidad WHERE id_estado="+ rs.getInt("id_modalidad");
              String SQL_FIND_DEPORTE = "SELECT nombre FROM deporte WHERE id_estado="+ rs.getInt("id_deporte");     
                     
              estado.setNombre(SQL_FIND_ESTADO);
              modalidad.setNombre(SQL_FIND_MODALIDAD);
              deporte.setNombre(SQL_FIND_DEPORTE);
              
                     //id.estado --> nombreEstado
                     //id.modalidad --> nombreModalidad
                     //id.deporte --> nombreDeporte
                        
                    //arreglo1(nombre,nombreEstado,nombreEstado,nombreDeporte)
                     
                    //arreglo2 add(arreglo1);
                     
                     
                   /* comp.setNombre(rs.getString("nombre"));
                    comp.setReglamento(rs.getString("reglamento"));
                    comp.setModalidad(rs.getInt("id_modalidad"));
                    comp.setEstado(rs.getInt("id_estado"));
                    comp.setFormaPuntuacion("formaPuntuacion");
                    comp.setCantidadMaximaDeSets(rs.getInt("cantidadMaximaDeSets"));
                    comp.setTantosPorAusenciaDeRival(rs.getInt("tantosPorAusenciaDeRival"));
        comp.setPuntosPorPresentacion(rs.getInt("puntosPorPresentacion"));
        comp.setPuntosPorVictoria(rs.getInt("puntosPorVictoria"));
        comp.setEmpatePermitido(rs.getInt("empatePermitido"));
        comp.setPuntosPorEmpate(rs.getInt"puntosPorEmpate");
        comp.setDeporte(rs.getInt("id_deporte"));
        comp.setListaDisponibilidades(rs.getInt("listaDisponibilidades"));*/
                  
                    
                    //...
                    
                    //arregloCD add(comp);
                    
                    //for(int i i<arregloCD.long, i++)
                        // arregloCD[i].setIdEstado
                        //buscamos el el nombre Estado por medio del IdEstado
                    
                    // addTabla(nombre,estado,modalidad,deporte)
        
                    //arreglo();
                    
                    //for(int i, i<arregloCD.long,i++)
                        //setNombre(arregloCD[i].nombre) 
                        //setEstado(arregloCD[i].estado)
                        //setModalidad(arregloCD[i].modalidad)
                        //setDeporte(arregloCD[i].deporte)
                        //--> o un Arreglo nuevo que tenga 4 espacios
                        //uno para Nombre, uno para Estado otro para modalidad, otro para deporte 
                        // lo buscamos con los arregloCD[i].IdEstado por ejemplo
            }
            rs.close();  }
        catch (SQLException ex) {
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); }
        finally {
            if (conn!=null) try {
                conn.close(); }
            catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); } } 
        return null;
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
        
        int id_estado= rs.getInt("id_estado");
        String nomb=rs.getString("nombre");
        
        unEstado = new Estado(id_estado, nomb);
        
        
   
        }catch (SQLException ex) {
            
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
            
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
            
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
            
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public static void persistirDisponibilidad(Disponibilidad unaDisponibilidad, int IDCD){
        int cantidad = unaDisponibilidad.getCantidad();
        LugarRealizacion lugar = unaDisponibilidad.getLg();
   
        String insertarDisponibilidad = "INSERT INTO disponibilidad VALUES (default, " + IDCD + ", " + lugar.getId() + ", " + cantidad + ")";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            statement.executeUpdate(insertarDisponibilidad); }
        catch (SQLException ex) {
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); }
        finally {
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close(); }
            catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); } } }
    
    public static void persistirCD(Competencia unaCompetencia){
        Estado estado = unaCompetencia.getEstado();
        FormaPuntuacion formaPuntuacion = unaCompetencia.getFormaPuntuacion();
        Modalidad modalidad = unaCompetencia.getModalidad();
        Deporte deporte = unaCompetencia.getDeporte();
        Fixture fixture = unaCompetencia.getFixture();
        ArrayList<Disponibilidad> listaDisponibilidades = unaCompetencia.getListaDisponibilidades();
     
        String unNombreCompetencia = unaCompetencia.getNombre();
        String unReglamento=unaCompetencia.getReglamento();
        int unaCantidadMaximaDeSets=unaCompetencia.getCantidadMaximaDeSets();
        int unTantosPorAusenciaDeRival=unaCompetencia.getTantosPorAusenciaDeRival();
        int unPuntosPorPresentacion=unaCompetencia.getPuntosPorPresentacion();
        int unPuntosPorVictoria=unaCompetencia.getPuntosPorVictoria();
        boolean unEmpatePermitido=unaCompetencia.getEmpatePermitido();
        int unPuntosPorEmpate=unaCompetencia.getPuntosPorEmpate();
               
        String insertarCD = "INSERT INTO " + "competencia VALUES (default, 1, " +
                estado.getID() + ", " + formaPuntuacion.getId() +
                ", " + modalidad.getId() + ", " + deporte.getId() + ", '" + unNombreCompetencia +
                "', '" + unReglamento + "' , " + unaCantidadMaximaDeSets + 
                ", " + unTantosPorAusenciaDeRival + ", " + unPuntosPorPresentacion +
                ", " + unPuntosPorVictoria + ", " + unEmpatePermitido +
                ", " + unPuntosPorEmpate + ")";
        
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement(); 
            statement.executeUpdate(insertarCD);
            // Insercion disponibilidades
            String _SQL_FIND_IDCOMPETENCIA = "SELECT id_competencia FROM competencia WHERE nombre = '"+ unNombreCompetencia + "'";
            ResultSet rs = statement.executeQuery(_SQL_FIND_IDCOMPETENCIA);
            int IDCD = 0;
            while (rs.next()) {
                IDCD = rs.getInt("id_competencia"); }
            for (int i=0; i<listaDisponibilidades.size(); i++) {
                persistirDisponibilidad(listaDisponibilidades.get(i), IDCD); }
            rs.close(); }
        catch (SQLException ex) {
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); }
        finally {
            if(conn!=null)try {
                conn.close(); }
            catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex); } } }
    
    public String estadoC(String e){
    
        return "SELECT id_estado FROM" + "estado" + "WHERE" + "nombre ="+ e ; 
    }
    
     public String formaPuntuacionC(String fp){
    
        return "SELECT id_forma_puntuacion FROM" + "forma_puntuacion" + "WHERE" + "nombre ="+ fp ; 
    }
    
    public String modalidadC(String m){
    
        return "SELECT id_modalidad FROM" + "deporte" + "WHERE" + "nombre ="+ m ; 
    }
        
    public String disponibilidadC(String dis){
    
        return "SELECT id_diponibilidad FROM" + "deporte" + "WHERE" + "nombre ="+ dis ; 
    }
    
     public String usuarioC(String u){
    
        return "SELECT id_usuario FROM" + "usuario" + "WHERE" + "nombre ="+ u ; 
    }
    
     public String deporteC(String d) {

     return "SELECT id_deporte FROM" + "deporte" + "WHERE" + "nombre ="+ d ;   
    }
    
     public String fixtureC(String f ) {

     return "SELECT id_fixture FROM" + "fixture" + "WHERE" + "nombre ="+ f ;   
    }
     
    public void insertarCompetencia(){
    
    
    
    }
     
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
            
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    
     public void consultaD(){
         
        Connection conn = null; 
         
        try{
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            //PreparedStatement: Ejecuta sentencias SQL con parámetros de entrada.
            //PreparedStatement ps = conn.prepareStatement(_SQL_FIND_ALL_DEPORTE); 
            
            System.out.println(_SQL_FIND_ALL_DEPORTE);
            
            ResultSet rs = statement.executeQuery(_SQL_FIND_ALL_DEPORTE);
            
            while (rs.next()) {

				String id = rs.getString("id_deporte");
				String nombre = rs.getString("nombre");

				System.out.println("id : " + id);
				System.out.println("name : " + nombre);

			}

            //ps.setInt(1,d.getId());
            
            /*ps.setInt(2,c.getEstado());
            ps.setInt(4,c.getModalidad());
            ps.setInt(5,c.getDeporte());*/
           // ps.setString(10, c.getNombre());
            
            
            rs.close();
            
            
        
        
        
            
        }catch (SQLException ex) {
            
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    public void crear(Competencia c) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            
            //PreparedStatement: Ejecuta sentencias SQL con parámetros de entrada.
            PreparedStatement ps = conn.prepareStatement(_SQL_INSERT_COMPETENCIA); 
           /* ps.setInt(2,c.getEstado());
            ps.setInt(3,c.getFormaPuntuacion());
            ps.setInt(4,c.getModalidad());
            ps.setInt(5,c.getDeporte());
            ps.setInt(6,c.getDisponibilidad());
            ps.setInt(7,c.getUsuario());
            ps.setInt(8,c.getTablaPosicionesParticipante);
            ps.setInt(9,c.getFixture());*/
            ps.setString(10, c.getNombre());
            ps.setString(11, c.getReglamento());
            ps.setInt(12, c.getCantidadMaximaDeSets());
            ps.setInt(13,c.getTantosPorAusenciaDeRival());
            ps.setInt(14,c.getPuntosPorPresentacion());
            ps.setInt(15,c.getPuntosPorVictoria());
            ps.setBoolean(16,c.getEmpatePermitido());
            ps.setInt(17,c.getPuntosPorEmpate());
           
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //no olvidar nunca cerrar todo!!!
            if(conn!=null)try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(participanteDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
       
}