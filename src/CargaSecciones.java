import java.sql.*;
import modelo.Conexion;


public class CargaSecciones {
    
    Conexion miConeccion;
    
    public ResultSet rs;
    
    public CargaSecciones(){
    
        miConeccion = new Conexion();
        
    }
    //devuelve las seciones de la bdd
    public ResultSet DameSecciones(){
    
        
        Connection accesoBDD = miConeccion.DameConeccion();
        
        try{
            
            Statement secciones = accesoBDD.createStatement();
            
            rs = secciones.executeQuery("Select secciones from productos");
            
            rs.close();
        }catch(Exception e){
            
            System.out.println("Erro al cargar secciones" + e.getMessage());
        }
        
        return rs;
    }    
    
}
