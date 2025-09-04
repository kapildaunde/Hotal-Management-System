package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    JButton back,submit;
    JTable table;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
 
   JLabel text=new JLabel("Search For Room");
   text.setFont(new Font("Tahoma",Font.BOLD,20));
   text.setBounds(400, 30, 200, 30);
   add(text);
    
   JLabel bed=new JLabel("Bed Type");
   bed.setBounds(50, 100, 100, 20);
   add(bed);
   
   bedtype=new JComboBox(new String[]{"Single Bed","Double Bed"});
   bedtype.setBounds(150, 100, 150, 25);
   bedtype.setBackground(Color.WHITE);
   add(bedtype);
   
   available=new JCheckBox("Only Display Available");
   available.setBounds(650, 100, 150, 25);
   available.setBackground(Color.WHITE);
   add(available);
   
    JLabel I1=new JLabel("Room Number");
    I1.setBounds(50, 160, 100, 20);
    add(I1);
    
    JLabel I2=new JLabel("Availibility");
    I2.setBounds(270, 160, 100, 20);
    add(I2);
    
    JLabel I3=new JLabel("Cleaning Status");
    I3.setBounds(450, 160, 100, 20);
    add(I3);
    
    JLabel I4=new JLabel("Price");
    I4.setBounds(670, 160, 100, 20);
    add(I4);
    
    JLabel I5=new JLabel("Bed Type");
    I5.setBounds(870, 160, 100, 20);
    add(I5);
    
    table=new JTable();
    table.setBounds(0, 200, 1000, 300);
    add(table);
    
    try{
    Conn c=new Conn();
    ResultSet rs=c.s.executeQuery("select * from room");
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
     String query="select * from room where bed_type='"+bedtype.getSelectedItem()+"'";
     String query1="select * from room where availbility ='Available' AND bed_type='"+bedtype.getSelectedItem()+"'";
     
     Conn c=new Conn();
     ResultSet rs;
     if(available.isSelected()){
     rs=c.s.executeQuery(query1);
     }else{
     rs=c.s.executeQuery(query);
     }
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
    new SearchRoom();
    }
}
