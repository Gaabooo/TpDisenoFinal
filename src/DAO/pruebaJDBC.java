
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class pruebaJDBC {
  
    public static int buscarEstado(String name){
       
    String _SQL_FK_ESTADO ="SELECT id_estado FROM estado WHERE nombre ="+ name ;
    
    Connection conn;
 
    try{
        conn = DBConnection.get();
        
        Statement stmt = conn.createStatement();
            
            ResultSet rs;
            
            rs=stmt.executeQuery(_SQL_FK_ESTADO);
                    
    }
    catch(Exception e){
           System.out.println("Error de "+ e.getMessage());
       }  
    
    return Integer.parseInt(_SQL_FK_ESTADO);
    }
    
    public static int buscarModalidad(String name){
    
        String _SQL_FK_MODALIDAD ="SELECT id_modalidad FROM modalidad WHERE nombre ="+ name ;
        
        Connection conn;
 
    try{
        conn = DBConnection.get();
        
        Statement stmt = conn.createStatement();
            
            ResultSet rs;
            
            rs=stmt.executeQuery(_SQL_FK_MODALIDAD);
                    
    }
    catch(Exception e){
        System.out.println("Error de "+ e.getMessage());
    }
        
      return Integer.parseInt(_SQL_FK_MODALIDAD);  
    }
    
    public static int buscarFormaPuntuacion(String name){
    

        String _SQL_FK_FORMAPUNTUACION ="SELECT id_forma_puntuacion FROM forma_puntuacion WHERE nombre ="+ name ;
        
        Connection conn;
       
        try{
        conn = DBConnection.get();
        
        Statement stmt = conn.createStatement();
            
            ResultSet rs;
            
            rs=stmt.executeQuery(_SQL_FK_FORMAPUNTUACION);
                    
    }
    catch(Exception e){
        System.out.println("Error de "+ e.getMessage());
    }
        
    return Integer.parseInt(_SQL_FK_FORMAPUNTUACION); 
        
    }
    
    public static int buscarDeporte(String name){
     
    String _SQL_FK_DEPORTE ="SELECT id_deporte FROM deporte WHERE nombre ="+ name ;
        
    Connection conn;    
    
     try{
        conn = DBConnection.get();
        
        Statement stmt = conn.createStatement();
            
            ResultSet rs;
            
            rs=stmt.executeQuery(_SQL_FK_DEPORTE);
                    
    }
    catch(Exception e){
        System.out.println("Error de "+ e.getMessage());
    }  
      return Integer.parseInt(_SQL_FK_DEPORTE);
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
    
         String _SQL_NAME_ALL_PAIS ="SELECT nombre FROM pais";
    
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
    
    int estadoFK= buscarEstado(nombreEstado);
    int modalidadFK = buscarModalidad(nombreModalidad);
    int formaPuntuacionFK = buscarFormaPuntuacion(nombreFormaPuntuacion);
    int deporteFK = buscarDeporte(nombreDeporte);
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
