package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{
    JButton back;
    JTable table;
    EmployeeInfo(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel I1=new JLabel("Name");
    I1.setBounds(10, 10, 100, 20);
    add(I1);
    
    JLabel I2=new JLabel("Age");
    I2.setBounds(140, 10, 100, 20);
    add(I2);
    
    JLabel I3=new JLabel("Gender");
    I3.setBounds(270, 10, 100, 20);
    add(I3);
    
    JLabel I4=new JLabel("Job");
    I4.setBounds(400, 10, 100, 20);
    add(I4);
    
    JLabel I5=new JLabel("Salary");
    I5.setBounds(510, 10, 100, 20);
    add(I5);
    
    
    JLabel I6=new JLabel("Phone");
    I6.setBounds(650, 10, 100, 20);
    add(I6);
    
    JLabel I7=new JLabel("Email");
    I7.setBounds(780, 10, 120, 20);
    add(I7);
    
    JLabel I8=new JLabel("Aadhar");
    I8.setBounds(910, 10, 100, 20);
    add(I8);
    
    table=new JTable();
    table.setBounds(0, 40, 1000, 400);
    add(table);
    
    try{
    Conn c=new Conn();
    ResultSet rs=c.s.executeQuery("select * from employee");
    table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
    e.printStackTrace();
    }
    
    back=new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    back.setBounds(420, 500, 120, 30);
    add(back);
    
    setBounds(300,200,1000,600);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      setVisible(false);
      new Reception();
    }
    public static void  main(String [] args){
    new EmployeeInfo();
    }
}
