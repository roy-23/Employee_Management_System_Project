
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton add,view,update,delete;
    
    Home(){
        setLayout(null);
        
        //Paste images
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2= i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(630,20,400,40);
        heading.setFont(new Font("Fahoma", Font.BOLD,25));
        image.add(heading);
        
        add=new JButton("Add Employee");
        add.setBounds(650, 80,150,40);
        add.addActionListener(this);
        image.add(add);
        
        view=new JButton("View Employee");
        view.setBounds(840, 80,150,40);
        view.addActionListener(this);
        image.add(view);
        
        update=new JButton("Update Employee");
        update.setBounds(650, 160,150,40);
        update.addActionListener(this);
        image.add(update);
        
        delete=new JButton("Delete Employee");
        delete.setBounds(840, 160,150,40);
        delete.addActionListener(this);
        image.add(delete);
        
        setSize(1120,630);
        setLocation(150, 70);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource() == view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new ViewEmployee();
        }
        else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String[] args){
        new Home();
    }
}
