package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener{
    JLabel roomnumber,checkintime,checkouttime;
    Choice customer;
    JButton checkoutb,back;
    
    Checkout(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel text=new JLabel("CheckOut");
    text.setBounds(100, 20, 100, 30);
    text.setForeground(Color.BLACK);
    text.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(text);
    
    JLabel id=new JLabel("Customer ID");
    id.setBounds(30, 80, 100, 30);
    add(id);
    
    customer=new Choice();
    customer.setBounds(150, 80, 150, 25);
    add(customer);
    
  
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
    Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(310, 80, 20, 20);
    add(image);
     
    JLabel room=new JLabel("Room Number");
    room.setBounds(30, 130, 100, 30);
    add(room);
    
    roomnumber=new JLabel();
    roomnumber.setBounds(150, 130, 100, 30);
    add(roomnumber);
    
    JLabel checkin=new JLabel("Checkin Time");
    checkin.setBounds(30, 180, 100, 30);
    add(checkin);
    
    checkintime=new JLabel();
    checkintime.setBounds(150, 180, 100, 30);
    add(checkintime);
    
    JLabel checkout=new JLabel("CheckOut Time");
    checkout.setBounds(30, 230, 100, 30);
    add(checkout);
    
    Date date=new Date();
    checkouttime=new JLabel(""+date);
    checkouttime.setBounds(150, 230, 150, 30);
    add(checkouttime);
    
    checkoutb=new JButton("Check Out");
    checkoutb.setBounds(30, 280, 120, 30);
    checkoutb.setBackground(Color.BLACK);
    checkoutb.setForeground(Color.WHITE);
    checkoutb.addActionListener(this);
    add(checkoutb);
    
    back=new JButton("Back");
    back.setBounds(170,280, 120, 30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.white);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
    Image i5=i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
    ImageIcon i6=new ImageIcon(i5);
    JLabel image1=new JLabel(i6);
    image1.setBounds(350, 50, 400, 250);
    add(image1);
    
       try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from customer");
        while(rs.next()){
        roomnumber.setText(rs.getString("room"));
        checkintime.setText(rs.getString("checkintime"));
        customer.add(rs.getString("number"));
        }
    }
    catch(Exception e){
    e.printStackTrace();
    }   
    
    setBounds(300,200,800,400);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==checkoutb){
    String query="delect from customer where ='"+customer.getSelectedItem()+"'";
    String query1="update romm set availability='Available' where roomnumber='"+roomnumber+"'";
    try{
    Conn c=new Conn();
    c.s.executeQuery(query);
    c.s.executeQuery(query1);
      
       JOptionPane.showMessageDialog(null, "Check Out Done");
    }
    catch(Exception e){
    e.printStackTrace();
    }
    }
    else{
            setVisible(false);
            new Reception();
            }
    }
    public static void main(String []args){
    new Checkout();
    }
}
