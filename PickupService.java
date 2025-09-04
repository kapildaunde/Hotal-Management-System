package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickupService extends JFrame implements ActionListener{
    JButton back,submit;
    JTable table;
    JComboBox bedtype;
    Choice typeofcar;
    PickupService(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
 
   JLabel text=new JLabel("Pickup Service");
   text.setFont(new Font("Tahoma",Font.BOLD,20));
   text.setBounds(400, 30, 200, 30);
   add(text);
    
   JLabel bed=new JLabel("Type Of Car");
   bed.setBounds(50, 100, 100, 20);
   add(bed);
   
   typeofcar= new Choice();
   typeofcar.setBounds(150, 100, 200, 25);
   add(typeofcar);
   
   try{
   Conn c=new Conn();
   ResultSet rs=c.s.executeQuery("select * from driver ");
   while(rs.next()){
   typeofcar.add(rs.getString("model"));
   }
   }
   catch(Exception e){
   e.printStackTrace();
   }
   
 
   
    JLabel I1=new JLabel("Name");
    I1.setBounds(30, 160, 100, 20);
    add(I1);
    
    JLabel I2=new JLabel("Age");
    I2.setBounds(200, 160, 100, 20);
    add(I2);
    
    JLabel I3=new JLabel("Gender");
    I3.setBounds(330, 160, 100, 20);
    add(I3);
    
    JLabel I4=new JLabel("Company");
    I4.setBounds(460, 160, 100, 20);
    add(I4);
    
    JLabel I5=new JLabel("Modal");
    I5.setBounds(630, 160, 100, 20);
    add(I5);
    
    JLabel I6=new JLabel("Availability");
    I6.setBounds(740, 160, 100, 20);
    add(I6);
    
    JLabel I7=new JLabel("Location");
    I7.setBounds(890, 160, 100, 20);
    add(I7);
    
    table=new JTable();
    table.setBounds(0, 200, 1000, 300);
    add(table);
    
    try{
    Conn c=new Conn();
    ResultSet rs=c.s.executeQuery("select * from driver");
    table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
    e.printStackTrace();
    }
    
    submit=new JButton("Submit");
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.addActionListener(this);
    submit.setBounds(300, 520, 120, 30);
    add(submit);
    
    back=new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    back.setBounds(500, 520, 120, 30);
    add(back);
    
    setBounds(300,200,1050,600);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==submit){
     try{
     String query="select * from room where modal='"+typeofcar.getSelectedItem()+"'";
    
     Conn c=new Conn();
     ResultSet rs;
  
     rs=c.s.executeQuery(query);
     
     table.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
     e.printStackTrace();
     }
     }else{
        setVisible(false);
      new Reception();
    }
    }
    public static void  main(String [] args){
    new PickupService();
    }
}
