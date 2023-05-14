
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cempid;
    
    JButton delete, back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempid = new JLabel("Employee ID");
        labelempid.setBounds(100,50,100,20);
        add(labelempid);
        
        cempid = new Choice();
        cempid.setBounds(200,50,120,20);
        add(cempid);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        //Name
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(100,80,100,20);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,80,100,20);
        add(lblname);
        
        //Designation
        JLabel labeldesig = new JLabel("Designation");
        labeldesig.setBounds(100,110,100,20);
        add(labeldesig);
        
        JLabel lbldesig = new JLabel();
        lbldesig.setBounds(200,110,100,20);
        add(lbldesig);
        
        
        
        //ccode
//        JLabel labelccode = new JLabel("Name");
//        labelname.setBounds(100,80,100,20);
//        add(labelname);
        
        JLabel lblccode = new JLabel();
        lblccode.setBounds(200,140,100,20);
        add(lblccode);
        
        //Phone Number
        JLabel labelphn = new JLabel("Phone");
        labelphn.setBounds(100,140,100,20);
        add(labelphn);
        
        JLabel lblphn = new JLabel();
        lblphn.setBounds(230,140,100,20);
        add(lblphn);
        
        //Email
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(100,170,100,20);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,170,190,20);
        add(lblemail);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empid = '"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lbldesig.setText(rs.getString("designation"));
                lblccode.setText(rs.getString("ccode"));
                lblphn.setText(rs.getString("phone"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from employee where empid = '"+cempid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        lblname.setText(rs.getString("name"));
                        lbldesig.setText(rs.getString("designation"));
                        lblccode.setText(rs.getString("ccode"));
                        lblphn.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                     }
                    }
                 catch(Exception e){
                      e.printStackTrace();
                    }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(240,240,120,30);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(420,240,120,30);
        back.addActionListener(this);
        add(back);
        
        
        //Image
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2= i1.getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460,15,400,200);
        add(image);
        
        
        setSize(900,400);
        setLocation(230,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try{
                Conn c= new Conn();
                String query = "delete from employee where empid = '"+cempid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Details deleted successfully");
                setVisible(false);
                new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
            
        }
    }
    
    public static void main(String[] args){
        new RemoveEmployee();
    }
}
