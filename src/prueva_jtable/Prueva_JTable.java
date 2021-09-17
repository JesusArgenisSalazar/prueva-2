package prueva_jtable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Prueva_JTable {

    public static void main(String[] args) {

        Lamina_Tabla lamina = new Lamina_Tabla();
        lamina.setSize(500, 500);
        lamina.setResizable(true);
        lamina.setLocationRelativeTo(null);
        lamina.setVisible(true);

    }
}

class Lamina_Tabla extends JFrame {
    
    DatabaseMetaData meta;
    Connection cn ;
    ResultSet rs = null;
    
    Lamina_Tabla() {

        setLayout(new BorderLayout());
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel LaminaTabla = new JPanel();
        
        //El ComboBox -----------------------------------------------

        JPanel LaminaCombo = new JPanel();

        JComboBox Combo = new JComboBox();
        
        try{
          
            cn = DriverManager.getConnection("jdbc:mysql://localhost/productos","root","");
            
            meta = cn.getMetaData();
            
            ResultSet rsMeTa = meta.getTables(null,null,null,null);
            
            while(rsMeTa.next()){
                
                Combo.addItem(rsMeTa.getString("TABLE_NAME"));
            }
                    
        }catch(SQLException e){
            
            e.printStackTrace();
        }
        
        Combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String table_name = Combo.getSelectedItem().toString();
                
                Statement st = null;
                
                try{
                
                    String sql = "SElECT * FROM " + table_name;
                    
                    st = cn.createStatement();
                    
                    rs = st.executeQuery(sql);
                    
                    
                    TableModel modelo = new ModeloTabla(rs);
                    
                    JTable tabla = new JTable(modelo);
                    
                    LaminaTabla.add(new JScrollPane(), BorderLayout.SOUTH);
                    
                    LaminaTabla.validate();
                   
                    
                }catch(Exception e){
                
                    e.printStackTrace();
                    
                }
            }
        });
        
      //Add Componentes ------------------------
        LaminaCombo.add(Combo);
        
         //LaminaTabla.add(new JScrollPane(tabla), BorderLayout.CENTER);

        add(LaminaCombo, BorderLayout.NORTH);
        
        
        add(LaminaTabla, BorderLayout.CENTER);
       
        
    }

}

class ModeloTabla extends AbstractTableModel {
    
    ResultSetMetaData meta;
    ResultSet rs;
    
    public ModeloTabla(ResultSet rs){
         
        this.rs = rs;
        try {
            
            meta = rs.getMetaData();
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    @Override
    public int getRowCount() {

        try {
            
            rs.last();
            
            return rs.getRow();
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getColumnCount() {

        try {
            return meta.getColumnCount();
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Object getValueAt(int i, int j) {

        try {
            rs.absolute(i+1);
            
            return  rs.getObject(j+1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
