package hotalmanagement.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
    Choice customer;
    JTextField tfpending,tfcheckin,tfname,tfroom,tfpaid;
    JButton back,update,check;
    UpdateCheck(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
        
    JLabel text=new JLabel("Update Status");
    text.setFont(new Font("Tahoma",Font.BOLD,20));
    text.setBounds(90, 20, 200, 30);
    add(text);
    
    JLabel id=new JLabel("Customer Id");
    id.setBounds(30, 80, 100, 20);
    add(id);
    
    customer=new Choice();
    customer.setBounds(200, 80, 150, 25);
    add(customer);
    
    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from customer");
        while(rs.next()){
        
        customer.add(rs.getString("number"));
        }
    }
    catch(Exception e){
    e.printStackTrace();
    }    
    
    JLabel room=new JLabel("Room Number");
    room.setBounds(30, 120, 100, 20);
    add(room);
    
    tfroom=new JTextField();
    tfroom.setBounds(200, 120, 150, 25);
    add(tfroom);
    
    JLabel name=new JLabel("Name");
    name.setBounds(30, 160, 100, 20);
    add(name);
    
    tfname=new JTextField();
    tfname.setBounds(200, 160, 150, 25);
    add(tfname);
    
    JLabel checkin=new JLabel("Checkin  Time");
    checkin.setBounds(30, 200, 100, 20);
    add(checkin);
    
    tfcheckin=new JTextField();
    tfcheckin.setBounds(200, 200, 150, 25);
    add(tfcheckin);
    
    JLabel paid=new JLabel("Amount Paid");
    paid.setBounds(30, 240, 100, 20);
    add(paid);
    
    tfpaid=new JTextField();
    tfpaid.setBounds(200, 240, 150, 25);
    add(tfpaid);
    
    JLabel pending=new JLabel("Pending Amount");
    pending.setBounds(30, 280, 100, 20);
    add(pending);
    
    tfpending=new JTextField();
    tfpending.setBounds(200, 280, 150, 25);
    add(tfpending);
    
    check=new JButton("CHECK");
    check.setBackground(Color.BLACK);
    check.setForeground(Color.WHITE);
    check.setBounds(30, 340, 100, 30);
    check.addActionListener(this);
    add(check);
    
    update=new JButton("UPDATE");
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.setBounds(150, 340, 100, 30);
    update.addActionListener(this);
    add(update);
    
    back=new JButton("BACK");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(270, 340, 100, 30);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
    JLabel image=new JLabel(i1);
    image.setBounds(400, 50, 500,300);
    add(image);
     
    setBounds(300,200,980,500); 
    setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==check){
    String id=customer.getSelectedItem();
    String query="select * from customer where number='"+id+"'";
    try{
    Conn c=new Conn();
    ResultSet rs=c.s.executeQuery(query);
    while(rs.next()){
    tfroom.setText(rs.getString("room"));
    tfname.setText(rs.getString("name"));
    tfcheckin.setText(rs.getString("checkintime"));
    tfpaid.setText(rs.getString("deposit"));
    }
    }
    catch(Exception e){
    e.printStackTrace();
    }
    }else if(ae.getSource()==update){
    String number=customer.getSelectedItem();
    String room=tfroom.getText();
    String name=tfname.getText();
    String checkin=tfcheckin.getText();
    String deposite=tfpaid.getText();
    
    try{
    Conn c=new Conn();
    c.s.executeUpdate("update customer set room='"+room+"' , name='"+name+"',checkintime='"+checkin+"', deposit='"+deposite+"' where number='"+number+"'");
    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
    setVisible(false);
    new Reception();
    }
    catch(Exception e){
    e.printStackTrace();
    }
    }else{
    setVisible(false);
    new Reception();
    }
    }
    public static  void main(String [] args){
    new UpdateCheck();

    }
}
