
package vista;

import controlador.ControladorEventos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import controlador.*;
import java.awt.Color;

public class Interfas_AplicacionMVC extends JFrame{
    
    public JComboBox seccion;
    public JComboBox pais;
    public JTextArea resultado;
    
    public Interfas_AplicacionMVC(){
    
        setLayout(new BorderLayout());
        
        setBounds(0,0,300,300);
        
        JPanel PaneNort = new JPanel();
        
        PaneNort.setLayout(new FlowLayout());
        
        PaneNort.setBackground(Color.orange);
        add(PaneNort, BorderLayout.NORTH);
        
        seccion = new JComboBox();
        
        seccion.addItem("Todos");
        
        PaneNort.add(seccion);
       
        pais = new JComboBox();
        
        pais.addItem("Todos");
        
        PaneNort.add(pais);
        
        resultado = new JTextArea();
        
        resultado.setEditable(false);
        
        add(resultado, BorderLayout.CENTER);
        
        JButton boton = new JButton("Enviar");
        
        add(boton,BorderLayout.SOUTH);
        
        addWindowListener(new ControladorEventos(this));
    
        boton.addActionListener(new ControladorBotonEjecuta(this));
        
        
    }
   
    
}
