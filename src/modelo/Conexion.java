
package modelo;

import controlador.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    Connection miconeccion = null;
    
    public Conexion(){
    
    }
    public Connection DameConeccion(){
      
        try {
            
           miconeccion = DriverManager.getConnection("jdbc:mysql://localhost/productos","root","");
        
        } catch (SQLException ex) {
            
            System.out.println("Error en conexion a bdd");
        }
        
        return miconeccion;
    }
}
