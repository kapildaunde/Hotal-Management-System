package hotalmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfadhaar;
    JRadioButton male,female;
    JButton submit;
    JComboBox cbjob;
     AddEmployee(){
         setLayout(null);
         
         JLabel name=new JLabel("NAME");
         name.setBounds(60, 30, 120, 30);
         name.setFont(new Font("Tahoma",Font.PLAIN,18));
         add(name);
         
         tfname=new JTextField();
         tfname.setBounds(200, 30, 150, 30);
         add(tfname); 
         
         JLabel age=new JLabel("AGE");
         age.setBounds(60, 80, 120, 30);
         age.setFont(new Font("Tahoma",Font.PLAIN,18));
         add(age);
        
         tfage=new JTextField();
         tfage.setBounds(200, 80, 150, 30);
         add(tfage);
         
         JLabel gender=new JLabel("Gender");
         gender.setBounds(60, 130, 120, 30);
         gender.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(gender);
         
         male=new JRadioButton("Male");
         male.setBounds(200, 130, 70, 30);
         male.setFont(new Font("Tahoma",Font.PLAIN,14));
         male.setBackground(Color.white);
         add(male);
         
         female=new JRadioButton("Female");
         female.setBounds(280, 130, 70, 30);
         female.setFont(new Font("Tahoma",Font.PLAIN,14));
         female.setBackground(Color.white);
         add(female);
         
         ButtonGroup bg=new ButtonGroup();
         bg.add(male);
         bg.add(female);

         JLabel job=new JLabel("Jobs");
         job.setBounds(60, 180, 120, 30);
         job.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(job);
         
         String [] str={"Front Desk Clerk","Porters","HouseKeeping","Kitchen Staff","Room Service","chefs","Manager"};
         cbjob=new JComboBox(str);
         cbjob.setBounds(200, 180, 150, 30);
         cbjob.setBackground(Color.WHITE);
         add(cbjob);
         
         JLabel salary=new JLabel("SALARY");
         salary.setBounds(60, 230,120, 30);
         salary.setFont(new Font("Tahoma",Font.PLAIN,18));
         add(salary);
         
         tfsalary=new JTextField();
         tfsalary.setBounds(200, 230, 150, 30);
         add(tfsalary);
         
         JLabel phone=new JLabel("PHONE");
         phone.setBounds(60, 280, 120, 30);
         phone.setFont(new Font("Tahoma",Font.PLAIN,18));
         add(phone);
         
         JLabel email=new JLabel("EMAIL");
         email.setBounds(60, 330, 120, 30);
         email.setFont(new Font("Tahoma",Font.PLAIN,18));
         add(email);
         
         tfemail=new JTextField();
         tfemail.setBounds(200, 330, 150, 30);
         add(tfemail);  
         
         tfphone=new JTextField();
         tfphone.setBounds(200, 280, 150, 30);
         add(tfphone); 
         
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
         JLabel adhaar=new JLabel("Adhaar no.");
         adhaar.setBounds(60, 380, 120, 30);
         adhaar.setFont(new Font("Tahoma",Font.PLAIN,18));
         add(adhaar);
        
         tfadhaar=new JTextField();
         tfadhaar.setBounds(200, 380, 150, 30);
         add(tfadhaar);
         
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i1=i.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        image.setBounds(380, 60, 450, 370);
        add(image);
         
         getContentPane().setBackground(Color.WHITE);
         setBounds(350,200,850,540);
         setVisible(true);
     }
      public void actionPerformed(ActionEvent ae){
          String name=tfname.getText();
          String age=tfage.getText();
          String salary = tfsalary.getText();
          String phone=tfphone.getText();
          String email=tfemail.getText();
          String adhar=tfadhaar.getText();
          String gender=null;
          if(male.isSelected()){
          gender="Male";
          }
          else if(female.isSelected()){
          gender="Female";
          }
          String job=(String)cbjob.getSelectedItem();
          try{
          Conn c=new Conn();
          String query = "INSERT INTO Employee VALUES('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + email + "', '" + adhar + "')";
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Employee Added Successfully");
          
          setVisible(false);
          }
          catch(Exception e){
          e.printStackTrace();
          }
}
     public static void main(String [] args){
     new AddEmployee(); 
     }
}
