
package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import vista.*;
import modelo.*;


public class ControladorEventos extends WindowAdapter{
    
    Interfas_AplicacionMVC marco;
    CargaDatosMenus obj = new CargaDatosMenus();
    
    public  ControladorEventos(Interfas_AplicacionMVC Marco){
        
        marco = Marco;
       
       
    }

    @Override
    public void windowOpened(WindowEvent we) {
        
        obj.ejecutaConsulta();
        
        try {
            
            while(obj.rs.next()){
                
               marco.seccion.addItem(obj.rs.getString(1));
               
                
            }
            
            while(obj.rs2.next()){
                
                marco.pais.addItem(obj.rs2.getString(1));
                
            }
            obj.rs.close();
            obj.rs2.close();
            
            
        } catch (SQLException ex) {
            
            System.out.println("error al cargar secciones");
        }
    }
    
    
    
    
    
}
