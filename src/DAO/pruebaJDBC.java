
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.*;


public class pruebaJDBC {
  
    //CU - listar CD
    
    public static Competencia filtroCD(Competencia unaCompretencia,Modalidad unaModaliadad,Estado unEstado){
    
    Competencia unaCompetencia= null;
        
    
        return unaCompetencia;
    }
    
    //CU - alta CD
    public static Estado getEstado(String name){
       
    String _SQL_FK_ESTADO ="SELECT id_estado FROM estado WHERE nombre = '" + name + "' ";
    
        Connection conn;
        Estado unEstado=null;
        int id=0;
        String nomb=null;
    try{
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_ESTADO);
        
        rs.next();
        
        nomb=name;
        id= rs.getInt("id_estado");
        
        
        //unEstado = new Estado(id, nomb);
                
    }
    catch(Exception e){
           System.out.println("Error de "+ e.getMessage());
       }  
    /*Integer.parseInt*/
      return unEstado; 
    }
    
    public static Modalidad getModalidad(String name){
    
        String _SQL_FK_MODALIDAD ="SELECT id_modalidad FROM modalidad WHERE nombre = '" + name + "' ";
        
        
        Connection conn;
        Modalidad unaModalidad=null;
        int id=0;
        String nomb=null;
        
 
    try{
        
        conn = DBConnection.get();
        
        ResultSet rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_MODALIDAD);
        
        rs.next();
        
        nomb=name;
        int id_modalidad= rs.getInt("id_modalidad");
        
        unaModalidad = new Modalidad(id_modalidad, nomb);
               
    }
    catch(Exception e){
        System.out.println("Error de "+ e.getMessage());
    }
        
      return unaModalidad;  
    }
    
    public static FormaPuntuacion getFormaPuntuacion(String name){
    

        String _SQL_FK_FORMAPUNTUACION ="SELECT id_forma_puntuacion FROM forma_puntuacion WHERE nombre = '" + name + "' ";
        
        FormaPuntuacion unaFormaPuntuacion = null;
        Connection conn;
       
        int id=0;
        String nomb=null;
          
        try{
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_FORMAPUNTUACION);
        
        rs.next();
        
        int id_forma_puntuacion= rs.getInt("id_forma_puntuacion");
        nomb=name;
        
        /*unaFormaPuntuacion = new FormaPuntuacion(id_forma_puntuacion, nomb);*/
                    
    }
    catch(Exception e){
        System.out.println("Error de "+ e.getMessage());
    }
        
    return unaFormaPuntuacion; 
        
    }
    
    public static Deporte getDeporte(String name){
     
    String _SQL_FK_DEPORTE ="SELECT id_deporte FROM deporte D WHERE D.nombre = '" + name + "' ";
      
    Deporte unDeporte = null;
    Connection conn; 
    
    int id=0;
        String nomb=null;
    
     try{
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_DEPORTE);
        
        rs.next();
        
        int id_deporte= rs.getInt("id_deporte");
        nomb=name;
        
        unDeporte = new Deporte(id_deporte, nomb);
                    
    }
    catch(Exception e){
        System.out.println("Error de "+ e.getMessage());
    }  
      return unDeporte;
    }
    
    public static LugarRealizacion getLugarRealizacion(int idLugar){
       
    String _SQL_FK_LUGAR ="SELECT nombre FROM lugar WHERE id_lugar = '" + idLugar + "' ";
    
        Connection conn;
        LugarRealizacion unLugar=null;
        int id=0;
        String nomb=null;
    try{
        conn = DBConnection.get();
        
        ResultSet  rs;
        
        Statement stmt = conn.createStatement();
         
        rs=stmt.executeQuery(_SQL_FK_LUGAR);
        
        rs.next();
        
        id=idLugar;
        nomb= rs.getString("nombre");
        
        
        unLugar = new LugarRealizacion(id, nomb,"A",null);
                
    }
    catch(Exception e){
           System.out.println("Error de "+ e.getMessage());
       }  
    
      return unLugar; 
    }
    
    
    public static int buscarUsuario(String name){
     
    String _SQL_FK_USUARIO ="SELECT id_usuario FROM usuario WHERE nombre ="+ name ;
        
    Connection conn;    
    
     try{
        conn = DBConnection.get();
        
        Statement stmt = conn.createStatement();
            
            ResultSet rs;
            
            rs=stmt.executeQuery(_SQL_FK_USUARIO);
                    
    }
    catch(Exception e){
        System.out.println("Error de "+ e.getMessage());
    }  
      return Integer.parseInt(_SQL_FK_USUARIO);  
    }

    public static int buscarLugar(int idUsuario){
     
    String _SQL_FK_LUGAR ="SELECT id_lugar FROM lugar WHERE id_usuario ="+ idUsuario ;
        
    Connection conn;    
    
     try{
        conn = DBConnection.get();
        
        Statement stmt = conn.createStatement();
            
            ResultSet rs;
            
            rs=stmt.executeQuery(_SQL_FK_LUGAR);
                    
    }
    catch(Exception e){
        System.out.println("Error de "+ e.getMessage());
    }  
      return Integer.parseInt(_SQL_FK_LUGAR);  
    }
   
    public static Competencia insertCompetencia(Estado unEstado, 
            FormaPuntuacion unaFormaPuntuacion, Modalidad unaModalidad,Deporte unDeporte,
            int id,String nombre, String reglamento,ArrayList<Disponibilidad> listaDisponibilidades,
            int cantMaxDeSet,int tantoPorAusencia,int puntoPorPresencia,
            int puntosPorVictoria,boolean empatePermitido,int puntosPorEmpate,int puntosPorPermitido){
    
        Competencia unaCompetencia= null;
        
        Fixture unFixture=null;
        
        unaCompetencia.setNombre(nombre);
        unaCompetencia.setReglamento(reglamento);
        
        unaCompetencia.setCantidadMaximaDeSets(cantMaxDeSet);
        unaCompetencia.setTantosPorAusenciaDeRival(tantoPorAusencia);
        unaCompetencia.setPuntosPorPresentacion(puntoPorPresencia);
        unaCompetencia.setPuntosPorVictoria(puntosPorEmpate);
        unaCompetencia.setEmpatePermitido(empatePermitido);
        unaCompetencia.setPuntosPorEmpate(puntosPorEmpate);
        unaCompetencia.setEmpatePermitido(true);
        unaCompetencia.setPuntosPorEmpate(1);
        
        unaCompetencia.setEstado(unEstado);
        unaCompetencia.setFormaPuntuacion(unaFormaPuntuacion);
        unaCompetencia.setModalidad(unaModalidad);
        unaCompetencia.setFixture(unFixture);
        unaCompetencia.setDeporte(unDeporte);
        unaCompetencia.setListaDisponibilidades(null);
        unaCompetencia.addTablaPosicionesParticipante(null);
        
        return unaCompetencia;
    }
    
    
    public static void insertarPais(int id, String name){
      
        String insertPais = "INSERT INTO pais"
				+ "(id_pais, nombre ) " + "VALUES"
				+ "("+ id +",'"+ name +"')";
          
        Connection conn;   
        
        try{
            conn = DBConnection.get();
        
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insertPais);
        }
       catch(Exception e){
           System.out.println("Error de "+ e.getMessage());
       }          
    }
    
    public static boolean buscarPais(String name){
    
         String _SQL_NAME_ALL_PAIS ="SELECT nombre FROM pais WHERE nombre="+name;
    
         Connection conn;
         boolean valor=false;
         
         try{
            conn = DBConnection.get();
              
            Statement stmt = conn.createStatement();
            
            ResultSet rs;
            
            rs=stmt.executeQuery(_SQL_NAME_ALL_PAIS);
            
            while(rs.next()){
                
                if(name.equals(rs.getString("nombre"))){ 
                    valor=true;  
                }               
            }
          }
           catch(Exception e){
           System.out.println("Error de "+ e.getMessage());
       } 
        
      return valor;   
    }
    
    public static void addCompetencia(String nombreDeporte,String nombreEstado,
            String nombreModalidad,String nombreFormaPuntuacion, String nombreUsuario ){
    
    /*int estadoFK= buscarEstado(nombreEstado);*/
    /*int modalidadFK = buscarModalidad(nombreModalidad);
    int formaPuntuacionFK = buscarFormaPuntuacion(nombreFormaPuntuacion);
    int deporteFK = buscarDeporte(nombreDeporte);*/
    int usuarioFK = buscarUsuario(nombreUsuario);
     
    }
     
    public static void muestraPais(){
    
         String _SQL_FIND_ALL_PAIS ="SELECT * FROM pais";
         
        Connection conn; 
            
        try{
            conn = DBConnection.get();
              
            Statement stmt = conn.createStatement();
            /*las instancias de esta clase se obtiene invocando al metodo apropiado 
            de un objeto del tipo conexion */ 
           
            ResultSet rs;
            /*JDBC devuelve resultados de una consulta SQL (SELECT) en un
            objeto ResultSet*/
            
            /*ResultSet mantiene un cursor apuntado a las filas actual de 
            datos*/
            
            rs=stmt.executeQuery(_SQL_FIND_ALL_PAIS);
           /*retorna un objeto ResultSet para el procesasamiento de las filas*/
           
           /*executeQuery para sentencias SELECT*/ 
            
            while(rs.next()){
            /*next() mueve el cursos a la siguiente fila y hace que esa fila 
                (llamada fila actual) sea aquella con la que podemos operar*/
                
             System.out.println(rs.getString("nombre"));    
            }           
       }
       catch(Exception e){
           System.out.println("Error de "+ e.getMessage());
       }
           
    }
   
}
