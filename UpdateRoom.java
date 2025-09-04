package hotalmanagement.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener{
    Choice customer;
    JTextField tfstatus,tfavailability,tfroom;
    JButton back,update,check;
    UpdateRoom(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
        
    JLabel text=new JLabel("Update Room");
    text.setFont(new Font("Tahoma",Font.BOLD,25));
    text.setBounds(30, 20, 250, 30);
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
    room.setBounds(30, 130, 100, 20);
    add(room);
    
    tfroom=new JTextField();
    tfroom.setBounds(200, 130, 150, 25);
    add(tfroom);
    
    JLabel availability=new JLabel("Availability");
    availability.setBounds(30, 180, 100, 20);
    add(availability);
    
    tfavailability=new JTextField();
    tfavailability.setBounds(200, 180, 150, 25);
    add(tfavailability);
    
    JLabel checkin=new JLabel("Cleaning Status");
    checkin.setBounds(30, 230, 100, 20);
    add(checkin);
    
    tfstatus=new JTextField();
    tfstatus.setBounds(200, 230, 150, 25);
    add(tfstatus);
  
    
    check=new JButton("CHECK");
    check.setBackground(Color.BLACK);
    check.setForeground(Color.WHITE);
    check.setBounds(30, 300, 100, 30);
    check.addActionListener(this);
    add(check);
    
    update=new JButton("UPDATE");
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.setBounds(150, 300, 100, 30);
    update.addActionListener(this);
    add(update);
    
    back=new JButton("BACK");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(270, 300, 100, 30);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
    Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(400, 50, 500,300);
    add(image);
     
    setBounds(300,200,980,450); 
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
   
    }
    ResultSet rs2=c.s.executeQuery("select * from  room where roomnumber='"+tfroom.getText()+"'");
    while(rs2.next()){
    tfavailability.setText(rs2.getString("availability"));
    tfstatus.setText(rs2.getString("cleaning_status"));
    }
    }
    catch(Exception e){
    e.printStackTrace();
    }
    }else if(ae.getSource()==update){
    String number=customer.getSelectedItem();
    String room=tfroom.getText();
    String available=tfavailability.getText();
    String status=tfstatus.getText();
    
    try{
    Conn c=new Conn();
    c.s.executeUpdate("update room set availability='"+available+"' , cleaning_status='"+status+"'where roomnumber='"+room+"'");
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
    new UpdateRoom();

    }
}

