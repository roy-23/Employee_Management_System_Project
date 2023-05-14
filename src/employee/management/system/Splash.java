
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  //for ActionListener event

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
        
        //To get access of the frame
        getContentPane().setBackground(Color.WHITE);
        //To not use layouts from swing
        setLayout(null);
               
        //Write something inside frame
        JLabel heading= new JLabel("Employee Management System");
        //make custom layouts
        heading.setBounds(180, 30, 1200, 75);
        heading.setFont(new Font("serif", Font.ROMAN_BASELINE ,60));
        heading.setForeground(Color.LIGHT_GRAY);
        //To see the components inside frame
        add(heading);
        
        JLabel subhead= new JLabel("WELCOME");
        subhead.setBounds(480,110,1000,80);
        subhead.setFont(new Font("serif", Font.ROMAN_BASELINE ,40));
        subhead.setForeground(Color.white);
        add(subhead);
        
        
        //Paste images
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2= i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,120,1050,400);
        add(image);
        
        //Add Button
        JButton click = new JButton("Continue");
        click.setBounds(380,320,300,60);
        click.setBackground(Color.LIGHT_GRAY);
        click.setFont(new Font("serif",Font.ROMAN_BASELINE,24));
        
        click.addActionListener(this);
        
//        click.setForeground(Color.white);
        image.add(click);
        
        
        
        
        //set size of the frame
        setSize(1150,650);
        setLocation(120,50);
        //To display the frame
        setVisible(true);
        
        
        while(true){
            subhead.setVisible(false);
            
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                
            }
            
            subhead.setVisible(true);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String []args){
        new Splash();
    }
}


