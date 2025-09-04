package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
     JMenuItem employee;
    Dashboard(){
    setBounds(0,0,1550,1000);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
    Image i2=i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,1550,1000);
    add(image);
    
    JLabel text=new JLabel("THE TAJ GROUP WELCOME YOU");
    text.setBounds(400, 80, 1000, 50);
    text.setFont(new Font("Tahoma",Font.PLAIN,46));
    text.setForeground(Color.WHITE);
    image.add(text);
    
    JMenuBar mb=new JMenuBar();
    mb.setBounds(0, 0, 1550, 30);
    image.add(mb);
    
    JMenu hotal=new JMenu("Hotal Management ");
    hotal.setForeground(Color.red);
    mb.add(hotal);
    
    JMenuItem reception=new JMenuItem("Reception");
    reception.addActionListener(this);
    hotal.add(reception);
    
    JMenu admin=new JMenu("Admin");
    admin.setForeground(Color.blue);
    mb.add(admin);
    
    employee=new JMenuItem("Add Employee");
    employee.addActionListener(this);
    admin.add(employee);
    
    JMenuItem room=new JMenuItem("Add Room");
    room.addActionListener(this);
    admin.add(room);
    
    JMenuItem driver=new JMenuItem("Add Driver");
    driver.addActionListener(this);
    admin.add(driver);
    
    setVisible(true);
    }
    
public void actionPerformed(ActionEvent ae){
if(ae.getActionCommand().equals("Add Employee")){
  new AddEmployee();
}
else if(ae.getActionCommand().equals("Add Room")){
  new AddRooms();
}else if(ae.getActionCommand().equals("Add Driver")){
new AddDriver();
}else if(ae.getActionCommand().equals("Reception")){
new Reception();
}
}
public static void main(String [] args){
new Dashboard();
}
}
