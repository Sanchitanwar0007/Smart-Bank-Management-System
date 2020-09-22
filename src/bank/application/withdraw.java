/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank.application;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javafx.scene.AccessibleAttribute;
public class withdraw extends JFrame implements ActionListener {
   JLabel l, l1,l2,l3;
   JTextField t1,t2;
   JPasswordField t3;
   JButton deposit,back,exit;
    Color blue = new Color(70, 215, 255);
   String send="";
   
   public withdraw(String str){
        send=str;
          setFont(new Font("System",Font.BOLD,26));
        Font f=getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Withdraw Amount");
        int y=fm.stringWidth(" ");
        int z=getWidth()-x;
        int wid=z/y-1;
        String padding=" ";
        padding=String.format("%"+wid+"s",padding);
        setTitle(padding+"Withdraw Amount");
        
        l=new JLabel("Withdraw Window");
        l.setFont(new Font("Raleway",Font.BOLD,20));
        
        
        l1=new JLabel("Rs.:");
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        
        l2=new JLabel("Username:");
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        
        l3=new JLabel("Password:");
        l3.setFont(new Font("Raleway",Font.BOLD,16));
        
        t1=new JTextField();
        t2=new  JTextField();
        t3=new JPasswordField();
       
         
       deposit=new JButton("Withdraw");
       deposit.setFont(new Font("Raleway",Font.BOLD,16));
          deposit.setBackground(Color.BLACK);
          deposit.setForeground(Color.WHITE);
          
          back=new JButton("Back");
          back.setFont(new Font("Raleway",Font.BOLD,16));
          back.setBackground(Color.BLACK);
          back.setForeground(Color.white);
          
//          exit=new JButton("Exit");
//          exit.setFont(new Font("Raleway",Font.BOLD,16));
//          exit.setBackground(Color.black);
//          exit.setForeground(Color.WHITE);
          
          setLayout(null);
          l.setBounds(120,25,700,40);
          add(l);

          l1.setBounds(50,100,200,30);
          add(l1);
          t1.setBounds(140,100,200,30);
          add(t1);
      
          l3.setBounds(50,150,200,30);
          add(l3);
          
          t3.setBounds(140,150,200,30);
          add(t3);
          deposit.setBounds(80,270,120,30);
          add(deposit);
          
          back.setBounds(285,270,120,30);
          add(back);
          
//          exit.setBounds(183,340,100,30);
//          add(exit);
          
          deposit.addActionListener(this);
          back.addActionListener(this);
         // exit.addActionListener(this);
           getContentPane().setBackground(blue);
                setSize(500,500);
                setLocation(500,90);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }
     public void actionPerformed(ActionEvent ae){
           String rupees=t1.getText();
               String user=t2.getText();
                String pass=new String(t3.getPassword());
            if(ae.getSource()==back){
               new Transaction(send).setVisible(true);
               setVisible(false);
           }else if(ae.getSource()==deposit){
               
              
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
              LocalDateTime now = LocalDateTime.now();  
              String nowd=dtf.format(now);
             // System.out.println(nowd);
                if(rupees.equals("")||  pass.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill require field");
                   // JOptionPane.setBounds(225,225,400,80);
                }else {
               try{
                   connection con=new connection();
                   ResultSet rs=con.s.executeQuery("Select * from bank where username='"+send+"' and password='"+pass+"'");
                   double balance=0;
                   if(rs.next()){
                       balance=rs.getDouble("balance");
                       double d=Double.parseDouble(rupees);
                       if(balance<d){
                           JOptionPane.showMessageDialog(null, "Insuffcient balance");
                       }else{
                       balance-=d;
                       String query="update bank set balance='"+balance+"' where username='"+send+"' and password='"+pass+"'";
                      //  String query1="update bank set Deposit='"+balance+"' where username='"+user+"' and password='"+pass+"'";
                        String query3="update bank set date='"+nowd+"' where username='"+send+"' and password='"+pass+"'";
                       con.s.executeUpdate(query);
                     //  con.s.executeUpdate(query1);
                       con.s.executeUpdate(query3);
                       JOptionPane.showMessageDialog(null, "Withdrawal Successful");
                        new Transaction(send).setVisible(true);
               setVisible(false);
                      // System.out.println(balance);
                   }
                   }
                   else{
                       JOptionPane.showMessageDialog(null, "Sorry ! No user found");
                   }
               }
               catch(Exception  e){
                   e.printStackTrace();
               }
           }
          
           }
}
      public static void main(String[] args){
        new withdraw("");
    }
}
  

