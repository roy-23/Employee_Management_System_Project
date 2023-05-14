
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice empId;
    JButton search, back, update, print;
    
    ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by employee ID");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);
        
        empId = new Choice();
        empId.setBounds(180,20,160,20);
        add(empId);
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                empId.add(rs.getNString("empid"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,500);
        add(jsp);
        
        

        
        
        setSize(900,500);
        setLocation(240,70);
        setVisible(true);
        
        //Buttons
        
        search = new JButton("Search");
        search.setBounds(30,50,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120,50,80,20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(210,50,80,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(300,50,80,20);       
        back.addActionListener(this);
        add(back);

             
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from employee where empid = '"+empId.getSelectedItem()+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == print){
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new UpdateEmployee(empId.getSelectedItem());
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new ViewEmployee();
    }
    
}
