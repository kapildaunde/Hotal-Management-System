package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JTextField jfname,jfmodel,jfage,jfcompany,jflocation;
    JButton add,cancel;
    JComboBox availablecombo,gendercombo,bedcombo;
    AddDriver(){
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel heading =new JLabel("ADD Drivers");
     heading.setFont(new Font("Tahoma",Font.BOLD,20));
     heading.setBounds(150, 10, 200, 20);
     add(heading);
     
     JLabel room=new JLabel("Name");
     room.setFont(new Font("Tahoma",Font.PLAIN,17));
     room.setBounds(60, 70, 120, 20);
     add(room);
     
     jfname=new JTextField();
     jfname.setBounds(200, 70, 150 , 30);
     add(jfname);
     
     JLabel age=new JLabel("Age");
     age.setFont(new Font("Tahoma",Font.PLAIN,17));
     age.setBounds(60, 110, 120, 30);
     add(age);
     
     jfage=new JTextField();
     jfage.setBounds(200, 110, 150 , 30);
     add(jfage);
     
     
     JLabel clean=new JLabel("Gender");
     clean.setFont(new Font("Tahoma",Font.PLAIN,17));
     clean.setBounds(60, 150, 120, 30);
     add(clean);
     
     String cleanroom[]={"Male", "Female"};
     gendercombo=new JComboBox(cleanroom);
     gendercombo.setBounds(200, 150, 150, 30);
     gendercombo.setBackground(Color.WHITE);
     add(gendercombo);
     
     JLabel price=new JLabel("Car Company");
     price.setFont(new Font("Tahoma",Font.PLAIN,17));
     price.setBounds(60, 190, 120, 20);
     add(price);
     
     jfcompany=new JTextField();
     jfcompany.setBounds(200, 190, 150 , 30);
     add(jfcompany);
     
     JLabel bed=new JLabel("Car Model");
     bed.setFont(new Font("Tahoma",Font.PLAIN,17));
     bed.setBounds(60, 230, 120, 30);
     add(bed);
     
     jfmodel=new JTextField();
     jfmodel.setBounds(200, 230, 150 , 30);
     add(jfmodel);
     
     JLabel available=new JLabel("Available");
     available.setFont(new Font("Tahoma",Font.PLAIN,17));
     available.setBounds(60, 270, 120, 30);
     add(available);
     
     String DriverOption[]={"Available", "Busy"};
     availablecombo=new JComboBox(DriverOption);
     availablecombo.setBounds(200, 270, 150, 30);
     availablecombo.setBackground(Color.WHITE);
     add(availablecombo);
     
     JLabel location=new JLabel("Location");
     location.setFont(new Font("Tahoma",Font.PLAIN,17));
     location.setBounds(60, 310, 120, 30);
     add(location);
     
     jflocation=new JTextField();
     jflocation.setBounds(200, 310, 150 , 30);
     add(jflocation);
     
     add=new JButton("ADD Driver");
     add.setBackground(Color.black);
     add.setForeground(Color.white);
     add.setBounds(60, 370, 130, 30);
     add.addActionListener(this);
     add(add);

    cancel=new JButton("Cancel");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setBounds(230, 370, 130, 30);
    cancel.addActionListener(this);
    add(cancel);

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
    Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(400,30,500,300);
    add(image);
    
     setBounds(300,200,980,470);
     setVisible(true);
     }
     
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==add){
     String name=jfname.getText();
     String age=jfage.getText();
     String gender=(String)gendercombo.getSelectedItem();
     String company=jfcompany.getText();
     String model=jfmodel.getText();
     String available=(String)availablecombo.getSelectedItem();
     String location=jflocation.getText();
    try{
      Conn c=new Conn();
      String query ="insert into Driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
      c.s.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
      setVisible(false);
     }
    catch(Exception e){
    e.printStackTrace();
    }
    }else {
    setVisible(false);
    }
    }
     public static void main(String [] args){
     new AddDriver();
     }
}
