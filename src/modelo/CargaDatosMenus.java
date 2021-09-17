
package modelo;

import java.sql.*;


public class CargaDatosMenus {
    
    Conexion miConeccion;
    public ResultSet rs;
    public ResultSet rs2;
    public CargaDatosMenus(){
    
        miConeccion = new Conexion();
        
    }
    //devuelve las seciones de la bdd
    public void ejecutaConsulta(){
    
        
        Connection accesoBDD = miConeccion.DameConeccion();
        
        try{
            
            Statement secciones = accesoBDD.createStatement();
            Statement paiseOrigen = accesoBDD.createStatement();
            
            rs = secciones.executeQuery("Select secciones from productos");
            rs2 = paiseOrigen.executeQuery("SELECT PaisOrigen FROM PRODUCTOS");
            
            
        }catch(SQLException e){
            
            System.out.println("Erro al ejecutar consulta" + e.getMessage());
        }
        
       
        
    }    
    
}
