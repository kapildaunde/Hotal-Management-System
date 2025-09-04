package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
   JButton  logout,checkout,pickupservice,Updateroom,searchroom,newcustomer,room,department,allemployee,managerinfo,customerinfo,Update;
    Reception(){
   getContentPane().setBackground(Color.WHITE);
   setLayout(null);
   
   newcustomer=new JButton("New Customer Form");
   newcustomer.setBounds(10, 30, 200, 30);
   newcustomer.setBackground(Color.BLACK);
   newcustomer.setForeground(Color.WHITE);
   newcustomer.addActionListener(this);
   add(newcustomer);
   
   room=new JButton("ROOMS");
   room.setBounds(10, 70, 200, 30);
   room.setBackground(Color.BLACK);
   room.setForeground(Color.WHITE);
   room.addActionListener(this);
   add(room);
   
   department=new JButton("Department");
   department .setBounds(10, 110, 200, 30);
   department.setBackground(Color.BLACK);
   department.setForeground(Color.WHITE);
   department.addActionListener(this);
   add( department);
   
   allemployee=new JButton("All Employee");
   allemployee.setBounds(10, 150, 200, 30);
   allemployee.setBackground(Color.BLACK);
   allemployee.setForeground(Color.WHITE);
   allemployee.addActionListener(this);
   add( allemployee);   
      
   customerinfo=new JButton("Customet Info");
   customerinfo.setBounds(10, 190, 200, 30);
   customerinfo.setBackground(Color.BLACK);
   customerinfo.setForeground(Color.WHITE);
   customerinfo.addActionListener(this);
   add( customerinfo);  
   
   managerinfo=new JButton("Manager Info");
   managerinfo.setBounds(10, 230, 200, 30);
   managerinfo.setBackground(Color.BLACK);
   managerinfo.setForeground(Color.WHITE);
   managerinfo.addActionListener(this);
   add( managerinfo);  
   
   
   checkout=new JButton("Check out");
   checkout.setBounds(10, 270, 200, 30);
   checkout.setBackground(Color.BLACK);
   checkout.setForeground(Color.WHITE);
   checkout.addActionListener(this);
   add( checkout);
   
   Update=new JButton("Update Status");
   Update.setBounds(10, 310, 200, 30);
   Update.setBackground(Color.BLACK);
   Update.setForeground(Color.WHITE);
   Update.addActionListener(this);
   add(Update);
   
    Updateroom=new JButton("Update Rooom Status");
   Updateroom.setBounds(10, 350, 200, 30);
   Updateroom.setBackground(Color.BLACK);
   Updateroom.setForeground(Color.WHITE);
    Updateroom.addActionListener(this);
   add(Updateroom);
   
   pickupservice=new JButton("PickUp Service");
   pickupservice.setBounds(10, 390, 200, 30);
   pickupservice.setBackground(Color.BLACK);
   pickupservice.setForeground(Color.WHITE);
   pickupservice.addActionListener(this);
   add(pickupservice);
   
   searchroom =new JButton("Search Rooom");
   searchroom.setBounds(10, 430, 200, 30);
   searchroom.setBackground(Color.BLACK);
   searchroom.setForeground(Color.WHITE);
   searchroom.addActionListener(this);
   add(searchroom);
   
   logout=new JButton("LogOut");
   logout.setBounds(10, 470, 200, 30);
   logout.setBackground(Color.BLACK);
   logout.setForeground(Color.WHITE);
   logout.addActionListener(this);
   add(logout);
   
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
   JLabel image=new JLabel(i1);
   image.setBounds(250, 30, 500, 470);
   add(image);
   
   setBounds(350,200,800,570);
   setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
   if(ae.getSource()==newcustomer){
   setVisible(false);
   new AddCustomer();
   }else if(ae.getSource()==room){
   setVisible(false);
   new Room();
   }else if(ae.getSource()==department){
   setVisible(false);
   new Department();
   }else if(ae.getSource()==allemployee){
   setVisible(false);
   new EmployeeInfo();
   }else if(ae.getSource()==managerinfo){
   setVisible(false);
   new ManagerInfo();
   }else if(ae.getSource()==customerinfo){
   setVisible(false);
   new CustomerInfo();
   }else if(ae.getSource()==searchroom){
   setVisible(false);
   new SearchRoom();
   }
   else if(ae.getSource()==Update){
   setVisible(false);
   new UpdateCheck();
   }else if(ae.getSource()== Updateroom){
   setVisible(false);
   new UpdateRoom();
   }else if(ae.getSource()==pickupservice){
   setVisible(false);
   new PickupService();
   }else if(ae.getSource()==checkout){
   setVisible(false);
   new Checkout();
   }
   else if(ae.getSource()==logout){
   setVisible(false);
   System.exit(0);
   }
   }
       public static void main(String [] args){
       new Reception();
       }
}
