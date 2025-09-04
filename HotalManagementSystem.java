package hotalmanagement.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotalManagementSystem extends JFrame implements ActionListener{
    HotalManagementSystem(){
    setBounds(100,100,1366,565);
    setLayout(null);
    
    ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
    JLabel image1=new JLabel(i);
    image1.setBounds(0, 0, 1366, 565);
  
    add(image1);
    
    
    JLabel text=new JLabel("HOTAL MANAGEMENT SYSTEM");
    text.setBounds(20,430,1000,90);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif",Font.PLAIN,60));
    image1.add(text);
    JButton next=new JButton("Next");
    next.setBounds(1150, 450, 150, 50);
    next.setBackground(Color.WHITE);
    next.setForeground(Color.MAGENTA);
    next.addActionListener(this);
    next.setFont(new Font("serif",Font.PLAIN,20));
    image1.add(next);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
     setVisible(false);
     new login();
    
    }
    public static void main(String[] args) {
    new HotalManagementSystem();
    }
    
}
