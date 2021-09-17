
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import modelo.*;
import vista.*;

public class ControladorBotonEjecuta  implements ActionListener{
     
    Interfas_AplicacionMVC marco;
    
    String seccion;
    String pais;
    
    ResultSet rs;
    
    EjecutaConsulta obj = new EjecutaConsulta();
    
    
    public ControladorBotonEjecuta(JFrame marco) {
        
        this.marco =  (Interfas_AplicacionMVC) marco;
        
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try {
            seccion = (String)marco.seccion.getSelectedItem();
            pais = (String)marco.pais.getSelectedItem();
            
            rs = obj.FiltraBDD(seccion, pais);
            
            marco.resultado.setText("");
            while(rs.next()){
                
                marco.resultado.append(rs.getString(1));
                marco.resultado.append(rs.getString(2));
                marco.resultado.append(rs.getString(3));
                marco.resultado.append(rs.getString(4));
                
                marco.resultado.append("\n");
            }
            
            
        } catch (SQLException ex) {
            
            System.out.println("error al imprimir datos del productos");
        }
    }
    
}
