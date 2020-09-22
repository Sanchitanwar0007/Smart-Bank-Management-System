/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Signup2 extends JFrame implements ActionListener{
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
   JTextField t1,t2,t3,t4;
   JRadioButton rb1,rb2,rb3,rb4;
    JComboBox religionCb,categoryCb,incomeCb,eduDetailCb;
   JButton next,back;
    Color blue = new Color(70, 215, 255);
 
       String form="";
       
    Signup2(String str)  {
        
         setFont(new Font("System",Font.BOLD,22));
        Font f=getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Singn Up Process Page 2");
        int y=fm.stringWidth(" ");
        int z=getWidth()-x;
        int wid=z/y-30;
        String padding=" ";
        padding=String.format("%"+wid+"s",padding);
        setTitle(padding+"Sign Up Process Page 2");
        
        
       l1=new JLabel("Page 2: Additional Details");
       l1.setFont(new Font("Raleway",Font.BOLD,22));
        
       l2=new JLabel("Religion:-");
       l2.setFont(new Font("Raleway",Font.BOLD,18));
       
       l3=new JLabel("Category:-");
       l3.setFont(new Font("Raleway",Font.BOLD,18));
       
       l4=new JLabel("Income:-");
       l4.setFont(new Font("Raleway",Font.BOLD,18));
       
       l5=new JLabel("Educational");
       l5.setFont(new Font("Raleway",Font.BOLD,18));
       
       l11=new JLabel("Qualification:-");
       l11.setFont(new Font("Raleway",Font.BOLD,18));
       
               
       l6=new JLabel("PAN No.:-");
       l6.setFont(new Font("Raleway",Font.BOLD,18));
       
       l7=new JLabel("Aadhar No.:-");
       l7.setFont(new Font("Raleway",Font.BOLD,18));
       
       l8=new JLabel("Existing Acount:");
       l8.setFont(new Font("Raleway",Font.BOLD,16));
       
       l9=new JLabel("Form No.:");
       l9.setFont(new Font("Raleway",Font.BOLD,14));
       
       l10=new JLabel("Select Only one");
       l10.setFont(new Font("Raleway",Font.ITALIC,14));
       l10.setForeground(Color.red);
       l10.setVisible(false);
        next=new JButton("Submit");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        
        back= new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        
        t1=new JTextField(); 
        t1.setFont(new Font("Raleway",Font.BOLD,14));
        
       
        
        t2=new JTextField(); //PAn Number
        t2.setFont(new Font("Raleway",Font.BOLD,14));
        
        t3=new JTextField();   //form no.
        t3.setFont(new Font("Raleway",Font.BOLD,14));
        t3.setText(str);
        t4=new JTextField();
        t4.setFont(new Font("Raleway",Font.BOLD,14));
           
        rb1=new JRadioButton("Yes");
        rb1.setFont(new Font("Raleway",Font.BOLD,14));
        rb1.setBackground(Color.WHITE);
        
       rb2=new JRadioButton("No");
       rb2.setFont(new Font("Raleway",Font.BOLD,14));
       rb2.setBackground(Color.WHITE);
       
       rb3=new JRadioButton("Yes");
       rb3.setFont(new Font("Raleway",Font.BOLD,14));
       rb3.setBackground(Color.WHITE);
       
       rb4=new JRadioButton("No");
       rb4.setFont(new Font("Raleway",Font.BOLD,14));
       rb4.setBackground(Color.WHITE);
       
       String religion[]={"","Hindu","Muslim","Sikh","Christian","Other"};
        religionCb=new JComboBox(religion);
        religionCb.setBackground(Color.WHITE);
        religionCb.setFont(new Font("Raleway",Font.BOLD,14));
        
        String category[]={"","General","OBC","SC","ST","Other"};
         categoryCb=new JComboBox(category);
         categoryCb.setBackground(Color.WHITE);
         categoryCb.setFont(new Font("Raleway",Font.BOLD,14));
         
         String income[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
         incomeCb=new JComboBox(income);
         incomeCb.setBackground(Color.WHITE);
         incomeCb.setFont(new Font("Raleway",Font.BOLD,14));
         
         String education[]= {"","10TH","12TH","Graduate","Post-Graduate","Doctrate","Other"};
         eduDetailCb = new JComboBox(education);
         eduDetailCb.setBackground(Color.WHITE);
         eduDetailCb.setFont(new Font("Raleway",Font.BOLD,14));
         
         setLayout(null);
         l9.setBounds(680,10,68,30);
         add(l9);
         t3.setBounds(760,10,60,30);
         add(t3);
         
         l1.setBounds(280,30,600,40);
         add(l1);
         l2.setBounds(100,120,100,30);
         add(l2);
         religionCb.setBounds(300,120,320,30);
         add(religionCb);
         
         l3.setBounds(100,170,100,30);
         add(l3);
         categoryCb.setBounds(300,170,320,30);
         add(categoryCb);
         
         l4.setBounds(100,220,100,30);
         add(l4);
         incomeCb.setBounds(300,220,320,30);
         add(incomeCb);
         
         l5.setBounds(100,270,140,30);
         add(l5);
         l11.setBounds(98,290,140,30);
         add(l11);
         eduDetailCb.setBounds(300,280,320,30);
         add(eduDetailCb);
         
         l6.setBounds(100,330,140,30);
         add(l6);
         t1.setBounds(300,330,320,30);
         add(t1);
         
         l7.setBounds(100,380,140,30);
         add(l7);
         t2.setBounds(300,380,320,30);
         add(t2);
         l8.setBounds(100,430,140,30);
         add(l8);
         rb1.setBounds(300,430,80,30);
         add(rb1);
         rb2.setBounds(470,430,80,30);
         add(rb2);
         l10.setBounds(300,460,320,30);
         add(l10);
         next.setBounds(560,500,100,30);
         add(next);
         back.setBounds(260,500,80,30);
         add(back);
         next.addActionListener(this);
         back.addActionListener(this);
         
         getContentPane().setBackground(blue);
                setSize(850,850);
                setLocation(500,90);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==back){
        new Signup("").setVisible(true);
        setVisible(false);
   }
         String religionString=(String)religionCb.getSelectedItem();
         String categoryString=(String)categoryCb.getSelectedItem();
         String incomeString=(String)incomeCb.getSelectedItem();
         String educationString=(String)eduDetailCb.getSelectedItem();
         
         String panString=t1.getText();
         String adharString=t2.getText();
         String formString=t3.getText();
         System.out.println(formString);
         String existingAcconuString="";
         if(rb1.isSelected() && rb2.isSelected()){
             rb1.setSelected(false);
             rb2.setSelected(false);
            l10.setVisible(true);
         }
        else if(rb1.isSelected()){
             existingAcconuString=rb1.getText();
              l10.setVisible(false);
             
         }else if(rb2.isSelected()){
           existingAcconuString=rb2.getText();
            l10.setVisible(false);
         }
         
        try{
  if(ae.getSource()==next){
      if(religionString.equals("") || categoryString.equals("")|| educationString.equals("")||panString.equals("")||adharString.equals("")||existingAcconuString.equals("")){
          JOptionPane.showMessageDialog(null,"Fill all the details");
      }else {
          connection con= new connection();
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
              LocalDateTime now = LocalDateTime.now();  
              String nowd=dtf.format(now);
          String query="insert into signup2 values('"+religionString+"','"+categoryString+"','"+educationString+"','"+panString+"','"+adharString+"','"+existingAcconuString+"','"+formString+"','"+nowd+"','"+incomeString+"')";
          con.s.executeUpdate(query);
          
          JOptionPane.showMessageDialog(null,"Hi,Your Account opened Succesfully");
          
          new Login().setVisible(true);
          
          setVisible(false);
      }
  }
            
   }catch(Exception e){
       e.printStackTrace();
          // System.out.println();
          
          JOptionPane.showMessageDialog(null,"Form no. are necessory");
          
         }
}
public static void main(String[] args){
    new Signup2("");
}
}
