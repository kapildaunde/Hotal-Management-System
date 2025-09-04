package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField jfroom,jfprice;
    JButton add,cancel;
    JComboBox availablecombo,cleancombo,bedcombo;
    AddRooms(){
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel heading =new JLabel("ADD ROOMS");
     heading.setFont(new Font("Tahoma",Font.BOLD,20));
     heading.setBounds(150, 20, 200, 20);
     add(heading);
     
     JLabel room=new JLabel("Room Number");
     room.setFont(new Font("Tahoma",Font.PLAIN,17));
     room.setBounds(60, 80, 120, 20);
     add(room);
     
     jfroom=new JTextField();
     jfroom.setBounds(200, 80, 150 , 30);
     add(jfroom);
     
     JLabel available=new JLabel("Available");
     available.setFont(new Font("Tahoma",Font.PLAIN,17));
     available.setBounds(60, 130, 120, 30);
     add(available);
     
     String availableroom[]={"Available", "occupied"};
     availablecombo=new JComboBox(availableroom);
     availablecombo.setBounds(200, 130, 150, 30);
     availablecombo.setBackground(Color.WHITE);
     add(availablecombo);
     
     JLabel clean=new JLabel("Cleaned Status");
     clean.setFont(new Font("Tahoma",Font.PLAIN,17));
     clean.setBounds(60, 180, 120, 30);
     add(clean);
     
     String cleanroom[]={"Clean", "Dirty"};
     cleancombo=new JComboBox(cleanroom);
     cleancombo.setBounds(200, 180, 150, 30);
     cleancombo.setBackground(Color.WHITE);
     add(cleancombo);
     
     JLabel price=new JLabel("Price");
     price.setFont(new Font("Tahoma",Font.PLAIN,17));
     price.setBounds(60, 230, 120, 20);
     add(price);
     
     jfprice=new JTextField();
     jfprice.setBounds(200, 230, 150 , 30);
     add(jfprice);
     
     JLabel bed=new JLabel("BED TYPE");
     bed.setFont(new Font("Tahoma",Font.PLAIN,17));
     bed.setBounds(60, 280, 120, 30);
     add(bed);
     
     String bedroom[]={"Single Bed", "Double Bed"};
     bedcombo=new JComboBox(bedroom);
     bedcombo.setBounds(200, 280, 150, 30);
     bedcombo.setBackground(Color.WHITE);
     add(bedcombo);
     
     add=new JButton("ADD ROOM");
     add.setBackground(Color.black);
     add.setForeground(Color.white);
     add.setBounds(60, 350, 130, 30);
     add.addActionListener(this);
     add(add);

    cancel=new JButton("Cancel");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setBounds(230, 350, 130, 30);
    cancel.addActionListener(this);
    add(cancel);

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
    JLabel image=new JLabel(i1);
    image.setBounds(400,30,500,300);
    add(image);
    
     setBounds(330,200,940,470);
     setVisible(true);
     }
     
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==add){
     String roomno=jfroom.getText();
     String availability=(String)availablecombo.getSelectedItem();
     String clean=(String)cleancombo.getSelectedItem();
     String price=jfprice.getText();
     String bed=(String)bedcombo.getSelectedItem();
     
    try{
      Conn c=new Conn();
      String query ="insert into room values('"+roomno+"','"+availability+"','"+clean+"','"+price+"','"+bed+"')";
      c.s.executeUpdate(query);
      JOptionPane.showMessageDialog(null,"New Room Added Successfully");
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
     new AddRooms();
     }
}
