
package procedimientos_almacenados;

import java.sql.*;
import modelo.Conexion;

public class Procedimientos_Almacenados {
    
   
    
    public static void main(String args[]){
        
        try {
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/productos", "root", "");
            
            CallableStatement sentencia = cn.prepareCall("{call ConsultaClientes}");
       
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()){
                
                System.out.println(rs.getString(1) + " " +  rs.getString(2) + " " + rs.getString(3) + "" + rs.getString(5));
                System.out.println("");
            }
        } catch (SQLException ex) {       
        
            System.out.println("Error en tu procedimiento almacenado");
        }
        
    }
    
}
