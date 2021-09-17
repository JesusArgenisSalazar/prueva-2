package modelo;

import java.sql.*;

public class EjecutaConsulta {
    
    Conexion miconexion = new Conexion();
    
    PreparedStatement consulta;
    
    String sentencia_seccion = "SELECT * FROM PRODUCTOS WHERE SECCIONES=?";
    String sentencia_pais = "SELECT * FROM PRODUCTOS WHERE PAISORIGEN=?";
    String sentencia_todos = "SElECT * FROM PRODUCTOS";
    String sentencia_pais_seccion =  "SELECT * FROM PRODUCTOS WHERE SECCIONES=? AND PAISORIGEN=?";
    
    ResultSet rs;
    
    public ResultSet FiltraBDD(String seccion, String pais){
        
        Connection cn = miconexion.DameConeccion();
        
        try{
        if(seccion.equals("Todos") && pais.equals("Todos")){
            
            consulta = cn.prepareStatement(sentencia_todos);
            
            rs = consulta.executeQuery();
            
        }else if(!seccion.equals("Todos") && !pais.equals("Todos")){
        
           consulta = cn.prepareStatement(sentencia_pais_seccion);
            
           consulta.setString(1, seccion);
           
           consulta.setString(2, pais);
            
           rs = consulta.executeQuery();
            
        }else if(!seccion.equals("Todos") && pais.equals("Todos")){
           
            consulta = cn.prepareStatement(sentencia_seccion);
            
            consulta.setString(1, seccion);
            
            rs = consulta.executeQuery();
            
        }else if(seccion.equals("Todos") && !pais.equals("Todos")){
           
           consulta = cn.prepareStatement(sentencia_pais);
            
           consulta.setString(1, pais);
            
           rs = consulta.executeQuery();
        }
        }catch(SQLException e){
        
            System.out.println("Error al ejecutar consuta de productos");
        }
        
        return rs;
    }
}
