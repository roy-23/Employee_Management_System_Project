
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random rn = new Random();
    int num = rn.nextInt(999999);
    
    
    JTextField tfName,tffName,tfdesig,tfsal,tfadd,tfemail,tfccode,tfphn;
    JButton btnadd,btnback;
    JDateChooser dcdob;
    JComboBox cbedu;
    JLabel lblempid;
    
    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(310,20,400,34);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,21));
        add(heading);
        
        //Name
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,95,90,20);
        labelname.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labelname);
        
        tfName= new JTextField();
        tfName.setBounds(240,90,150,35);
        add(tfName);
        
        //Father's Guardian's name
        
        JLabel labelfname=new JLabel("Father's/Guardian's Name");
        labelfname.setBounds(440,95,190,20);
        labelfname.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labelfname);
        
        tffName= new JTextField();
        tffName.setBounds(640,90,150,35);
        add(tffName);
        
        //DOB
        
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50,145,190,20);
        labeldob.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(240,140,150,35);
        add(dcdob);
//        
        //Designation
        
        JLabel labeldesig=new JLabel("Designation");
        labeldesig.setBounds(440,145,190,26);
        labeldesig.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labeldesig);
        
        tfdesig= new JTextField();
        tfdesig.setBounds(640,140,150,35);
        add(tfdesig);
        
        //Salary
        
        JLabel labelsal=new JLabel("Salary");
        labelsal.setBounds(50,195,90,24);
        labelsal.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labelsal);
        
        tfsal= new JTextField();
        tfsal.setBounds(240,190,150,35);
        add(tfsal);
        
        //Address
        
        JLabel labeladd=new JLabel("Address");
        labeladd.setBounds(440,195,190,26);
        labeladd.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labeladd);
        
        tfadd= new JTextField();
        tfadd.setBounds(640,190,150,35);
        add(tfadd);
        
        //email
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,245,90,24);
        labelemail.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labelemail);
        
        tfemail= new JTextField();
        tfemail.setBounds(240,240,150,35);
        add(tfemail);
        
        //Phone
        
        JLabel labelphn=new JLabel("Phone");
        labelphn.setBounds(440,245,190,26);
        labelphn.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labelphn);
        
        tfccode=new JTextField();
        tfccode.setBounds(640,240,30,35);
        add(tfccode); 
        
        tfphn= new JTextField();
        tfphn.setBounds(675,240,115,35);
        add(tfphn);
        
        //education
        
        JLabel labeledu=new JLabel("Highest Education");
        labeledu.setBounds(50,295,140,24);
        labeledu.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labeledu);
        
        String courses[]={" ","B Tech","B.E","BBA","B.Sc","B.Com","B.A","M Tech","MBA","M.Sc","M.Com","M.A"};
        cbedu= new JComboBox(courses);
        cbedu.setBackground(Color.WHITE);
        cbedu.setBounds(240,290,150,35);
        add(cbedu);
        
        //Employee ID
        
        JLabel labelempid=new JLabel("Employee ID");
        labelempid.setBounds(50,345,140,24);
        labelempid.setFont(new Font("SERIF",Font.PLAIN,18));
        add(labelempid);
        
        lblempid=new JLabel(""+num);
        lblempid.setBounds(240,345,140,24);
        lblempid.setForeground(Color.RED);
        lblempid.setFont(new Font("SERIF",Font.PLAIN,18));
        add(lblempid);
        
        //Buttons
        
        btnadd = new JButton("Confirm");
        btnadd.setBounds(265,390,150,28);
        btnadd.setBackground(Color.BLACK);
        btnadd.setForeground(Color.WHITE);
        btnadd.addActionListener(this);
        add(btnadd);
        
        btnback = new JButton("Back");
        btnback.setBounds(480,390,150,28);
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.WHITE);
        btnback.addActionListener(this);
        add(btnback);
        
        
        //Image
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/print.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,520,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,500);
        add(image);
        
        
        //Frame size
        
        setSize(920,540);
        setLocation(240,70);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnadd){
            String name = tfName.getText();
            String fname = tffName.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String designation = tfdesig.getText();
            String salary = tfsal.getText();
            String address = tfadd.getText();
            String email = tfemail.getText();
            String ccode = tfccode.getText();
            String phone = tfphn.getText();
            String education = (String)cbedu.getSelectedItem();
            String empid = lblempid.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into employee values ('"+name+"','"+fname+"','"+dob+"','"+designation+"','"+salary+"','"+address+"','"+email+"','"+ccode+"','"+phone+"','"+education+"','"+empid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
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
        new AddEmployee();
    }
}
