package transacciones;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruevaTransacciones {

    public static void main(String args[]) {
        
         
        Connection cn = null;
        try {
            
            
            cn = DriverManager.getConnection("jdbc:mysql://localhost/productos", "root", "");
           
            Statement sentencia = cn.createStatement();
            
            cn.setAutoCommit(false);
            
            String sentencia1 = "DELETE FROM PRODUCTOS WHERE PAISORIGEN = 'USA'";
            String sentencia2 = "DELETE FROM PRODUCTOS WHERE PRECI > 3000";
            String sentencia3  = "UPDATE PRODUCTOS SET PRECIO = PRECIO*1.5 ";
            
            if(ValidaEjecucion()){
                
            sentencia.executeUpdate(sentencia1);
            sentencia.executeUpdate(sentencia2);
            sentencia.executeUpdate(sentencia3);
            }else{
                System.out.println("no se realizaron cambios ");
            }
            
            cn.commit();
        } catch (Exception e) {
            
            try {
                
                cn.rollback();
                System.out.println("algo salio mal no se ejecuto  la consulta");
            } catch (SQLException ex) {
            }
        }
    }

    public static boolean ValidaEjecucion() {

        String ejecuta = JOptionPane.showInputDialog("Esta seguro de  ejecutar la consulta SI/NO");

        if (ejecuta.equalsIgnoreCase("si")) {
            return true;
        } else {
            return false;
        }

    }
}
