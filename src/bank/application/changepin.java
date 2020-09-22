/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class changepin extends JFrame implements ActionListener{
 JLabel l, l1,l2,l3;
   JTextField t1,t2;
   JPasswordField t3;
   JButton ok,back,exit;
    Color blue = new Color(70, 215, 255);
   String user="";
    changepin(String str) {
        user=str;
          setFont(new Font("System",Font.BOLD,26));
        Font f=getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Change Password");
        int y=fm.stringWidth(" ");
        int z=getWidth()-x;
        int wid=z/y+10;
        String padding=" ";
        padding=String.format("%"+wid+"s",padding);
        setTitle(padding+"Change Password");
        
        l=new JLabel("Change password");
        l.setFont(new Font("Raleway",Font.BOLD,20));
        
        
        l1=new JLabel("Old Password:");
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        
        l2=new JLabel("New Password:");
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        
        l3=new JLabel("Confirm Password:");
        l3.setFont(new Font("Raleway",Font.BOLD,16));
        
        t1=new JTextField();
        t2=new  JTextField();
        t3=new JPasswordField();
       
         
       ok=new JButton("Ok");
       ok.setFont(new Font("Raleway",Font.BOLD,16));
          ok.setBackground(Color.BLACK);
          ok.setForeground(Color.WHITE);
          
          back=new JButton("Back");
          back.setFont(new Font("Raleway",Font.BOLD,16));
          back.setBackground(Color.BLACK);
          back.setForeground(Color.white);
          
          exit=new JButton("Exit");
          exit.setFont(new Font("Raleway",Font.BOLD,16));
          exit.setBackground(Color.black);
          exit.setForeground(Color.WHITE);
          
          setLayout(null);
          l.setBounds(120,25,700,40);
          add(l);

          l1.setBounds(50,100,200,30);
          add(l1);
          t1.setBounds(200,100,200,30);
          add(t1);
          l2.setBounds(50,150,200,30);
          add(l2);
          
          t2.setBounds(200,150,200,30);
          add(t2);
          
          l3.setBounds(50,200,200,30);
          add(l3);
          
          t3.setBounds(200,200,200,30);
          add(t3);
          
          ok.setBounds(80,270,100,30);
          add(ok);
          
          back.setBounds(285,270,100,30);
          add(back);
          
          exit.setBounds(183,340,100,30);
         // add(exit);
          
          ok.addActionListener(this);
          back.addActionListener(this);
          exit.addActionListener(this);
           getContentPane().setBackground(blue);
                setSize(450,450);
                setLocation(500,90);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }
     public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==exit){
             //  System.exit(0);
           }else if(ae.getSource()==back){
               new Transaction(user).setVisible(true);
               setVisible(false);
           }else if(ae.getSource()==ok){
               
               String old=t1.getText();
               String newPass=t2.getText();
                String ConfirmPass=new String(t3.getPassword());
                
             
                if(old.equals("")|| newPass.equals("") || ConfirmPass.equals("")){
                    
                    JOptionPane.showMessageDialog(null,"Fill require fields");
                   // JOptionPane.setBounds(225,225,400,80);
                }else if(!(newPass.equals(ConfirmPass))){
                   JOptionPane.showMessageDialog(null,"Password doesn't match");
                }else if(newPass.length()<8 && ConfirmPass.length()<8){
                    JOptionPane.showMessageDialog(null,"Password must contain atleast 8 characters.");
                 }else{
                    try{
                   connection con=new connection();
                   String query="update bank set password='"+ConfirmPass+"' where username='"+user+"' and password='"+old+"'";
                    String query1="update login set password='"+ConfirmPass+"' where username='"+user+"' and password='"+old+"'";
                     String query2="update user set password='"+ConfirmPass+"' where username='"+user+"' and password='"+old+"'";
                     con.s.executeUpdate(query);
                     con.s.executeUpdate(query1);
                     con.s.executeUpdate(query2);
                     JOptionPane.showMessageDialog(null, "Password changed Successfully");
                     new Transaction(user).setVisible(true);
                        setVisible(false);
               }
               catch(Exception  e){
                   e.printStackTrace();
               }
           }
          
           }
}
      public static void main(String[] args){
        new changepin("");
    }
}
