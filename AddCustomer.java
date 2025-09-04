package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JRadioButton male,female;
    JComboBox combid;
    JButton add,back;
    JTextField tfnumber,tfname,tfcountry,tfdeposit; 
    Choice croom;
    JLabel checkintime;
    
    AddCustomer(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel text=new JLabel("New Customer Form");
    text.setBounds(100, 20, 300, 30);
    text.setFont(new Font("Raleway",Font.BOLD,20));
    add(text);
    
    JLabel id=new JLabel("ID");
    id.setBounds(35, 80, 100, 20);
    id.setFont(new Font("Raleway",Font.PLAIN,20));
    add(id);
    
    String options[]={"Aadhar Card","Pan Card","Driving Licence","Voter Card"};
    combid=new JComboBox(options);
    combid.setBounds(200, 80, 150, 25);
    combid.setBackground(Color.WHITE);
    add(combid);
    
    JLabel numbers=new JLabel("Number");
    numbers.setBounds(35, 120, 100, 20);
    numbers.setFont(new Font("Raleway",Font.PLAIN,20));
    add(numbers);
    
    tfnumber =new JTextField();
    tfnumber.setBounds(200, 120, 150, 25);
    add(tfnumber);
   
    JLabel name=new JLabel("Name");
    name.setBounds(35, 160, 100, 20);
    name.setFont(new Font("Raleway",Font.PLAIN,20));
    add(name);
    
    tfname =new JTextField();
    tfname.setBounds(200, 160, 150, 25);
    add(tfname);
    
    JLabel gender=new JLabel("Gender");
    gender.setBounds(35, 200, 100, 20);
    gender.setFont(new Font("Raleway",Font.PLAIN,20));
    add(gender);
    
    male=new JRadioButton("Male");
    male.setBackground(Color.WHITE);
    male.setBounds(200, 200, 60, 25);
    add(male);
    
    female=new JRadioButton("Female");
    female.setBackground(Color.WHITE);
    female.setBounds(270, 200, 90, 25);
    add(female);
    
    JLabel country=new JLabel("Country");
    country.setBounds(35, 240, 100, 25);
    country.setFont(new Font("Raleway",Font.PLAIN,20));
    add(country);    
    
    tfcountry=new JTextField();
    tfcountry.setBounds(200, 240, 150, 25);
    add(tfcountry);
    
    JLabel room=new JLabel("Room Number");
    room.setBounds(35, 280, 150, 20);
    room.setFont(new Font("Raleway",Font.PLAIN,20));
    add(room);   
    
    croom =new Choice();
    
    try{
    Conn c=new Conn();
    String query="select * from room where available='Available'";
    ResultSet rs=c.s.executeQuery(query);
    while(rs.next()){
    croom.add(rs.getString("roomnumber"));
    }
    }
    catch(Exception e){
    e.printStackTrace();
    }
    croom.setBounds(200, 280,150, 25);
    add(croom);
    
    
    JLabel time=new JLabel("Checkin time");
    time.setBounds(35, 320, 150, 20);
    time.setFont(new Font("Raleway",Font.PLAIN,20));
    add(time); 
    
    Date date=new Date();
    
    checkintime=new JLabel(""+date);
    checkintime.setBounds(200, 320, 150, 25 );
    checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
    add(checkintime); 
 
    
    JLabel deposit=new JLabel("Deposite");
    deposit.setBounds(35, 360, 100, 25);
    deposit.setFont(new Font("Raleway",Font.PLAIN,20));
    add(deposit);
    
    tfdeposit =new JTextField();
    tfdeposit.setBounds(200, 360, 150, 25);
    add(tfdeposit);
    
    add=new JButton("ADD");
    add.setBackground(Color.BLACK);
    add.setForeground(Color.WHITE);
    add.setBounds(50, 410, 120, 30);
    add.addActionListener(this);
    add(add);
    
    back=new JButton("Back");
    back.setForeground(Color.WHITE);
    back.setBackground(Color.BLACK);
    back.setBounds(200, 410, 120, 30);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
    Image i2=i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(400, 50, 300, 400);
    add(image);
    
    setBounds(350,200,800,550);
    setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==add){
    String id=(String)combid.getSelectedItem();
    String number=tfnumber.getText();
    String name=tfname.getText();
    String gender=null;
    if(male.isSelected()){
    gender="male";
    }else{
    gender="female";
    }
    String country=tfcountry.getText();
    String room=croom.getSelectedItem();
    String time=checkintime.getText();
    String deposite=tfdeposit.getText();
    
    try{
    String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposite+"',)";
    String query1="update room set availability='occupied' where roomnumber='"+room+"'";
    Conn c=new Conn();
    c.s.executeUpdate(query);
    c.s.executeUpdate(query1);
    
    JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
    setVisible(false);
    new Reception();    
    }
    catch(Exception e){
    e.printStackTrace();
    }
    }else if(ae.getSource()==back){
    setVisible(false);
    new Reception();
    }
    }
    
    public static void main(String [] args){
    new AddCustomer();
    }
}
