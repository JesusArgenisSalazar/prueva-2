
package procedimientos_almacenados;

import java.sql.*;
import javax.swing.JOptionPane;


public class ActualizaPro {
    
    public static void main(String args[]){
        
        String precio = JOptionPane.showInputDialog("Introdusca un precio");
        
        String nombre = JOptionPane.showInputDialog("Introduca el nombre del producto");
        try {
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/productos", "root", "");
           
            CallableStatement procedimiento = cn.prepareCall("{call ActualizaProducto(?,?)}");
            
            procedimiento.setString(1, precio);
            
            procedimiento.setString(2, nombre);
            
            procedimiento.execute();
            
            System.out.println("Listo");
            
        } catch (SQLException ex) {
            
            System.out.println("error al conectar a bdd");
        }
    }
    
}
