
package principal2;

import javax.swing.JFrame;
import vista.*;

public class Run {
    
    public static void main(String args[]){
        
        Interfas_AplicacionMVC aplicaion = new Interfas_AplicacionMVC();
        
        aplicaion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        aplicaion.setVisible(true);
        
       
    }
}
