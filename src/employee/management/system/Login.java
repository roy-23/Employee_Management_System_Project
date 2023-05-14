package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

//import java.awt.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername,tfpwd;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //to add Username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(70,40,200,80);
        lblusername.setFont(new Font("serif", Font.ROMAN_BASELINE ,20));
        add(lblusername);
        
        //to add box beside username
        tfusername=new JTextField();
        tfusername.setBounds(230,63,300,33);
        add(tfusername);
        
        //to add password
        JLabel lblpwd = new JLabel("Password");
        lblpwd.setBounds(70,110,200,80);
        lblpwd.setFont(new Font("serif", Font.ROMAN_BASELINE ,20));
        add(lblpwd);
        
        //to add box beside Password
        tfpwd=new JTextField();
        tfpwd.setBounds(230,133,300,33);
        add(tfpwd);
        
        //to add button
        JButton btn=new JButton("LOGIN");
        btn.setBounds(230,230,120,30);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        add(btn);
        
        
        //add Image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2= i1.getImage().getScaledInstance(90,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,0,500,50);
        add(image);
        
        setSize(600,400);
        setLocation(400,160);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tfusername.getText();
            String password = tfpwd.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                //next class
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null,"invalid Username or Password");
                setVisible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
    
}
