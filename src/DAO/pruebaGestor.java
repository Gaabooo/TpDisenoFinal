
package DAO;

public class pruebaGestor {
   
   public static void addPais(int n,String p){
        
       pruebaJDBC.insertarPais(n,p);
       
   }   
  public static void searchPais(String p){
  
      pruebaJDBC.buscarPais(p);
  } 
   
}
