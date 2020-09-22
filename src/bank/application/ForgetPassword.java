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

public class ForgetPassword extends JFrame implements ActionListener {

    JLabel fp,un,sq,sq2,ans;
    JTextField user,answer;
    JButton ok,ok2,close;
    Color blue = new Color(70, 215, 255); 
    String sd="";
    ForgetPassword()  {
     setFont(new Font("System",Font.BOLD,22));
        Font f=getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Forget Password");
        int y=fm.stringWidth(" ");
        int z=getWidth()-x;
        int wid=z/y-38;
        String padding=" ";
        padding=String.format("%"+wid+"s",padding);
        setTitle(padding+"Forget Password");
        
        fp=new JLabel("Forget Password");
        fp.setFont(new Font("Raleway",Font.BOLD,25));
        un=new JLabel("Username:");
        un.setFont(new Font("Raleway",Font.BOLD,18));
        sq=new JLabel("Security Question:");
        sq.setFont(new Font("Raleway",Font.BOLD,18));
        sq2=new JLabel(sd);
        sq2.setFont(new Font("Raleway",Font.BOLD,18));
        ans=new JLabel("Answer:");
        ans.setFont(new Font("Raleway",Font.BOLD,18));
        ans.setVisible(false);
        user=new JTextField();
        user.setFont(new Font("Raleway",Font.BOLD,18));
        answer=new JTextField();
        answer.setFont(new Font("Raleway",Font.BOLD,18));
       answer.setVisible(false);
        ok=new JButton("OK");
        ok.setFont(new Font("Raleway",Font.BOLD,18));
        ok2=new JButton("OK");
        ok2.setFont(new Font("Raleway",Font.BOLD,18));
        
         close=new JButton("Close");
        close.setFont(new Font("Raleway",Font.BOLD,18));
        
        setLayout(null);
      fp.setBounds(280,50,400,40);
       add(fp);
       un.setBounds(150,140,200,30);
       add(un);
       user.setBounds(330,140,200,30);
       add(user);
       sq.setBounds(150,200,200,30);
       add(sq);
       sq.setVisible(false);
      sq2.setBounds(330,200,300,30);
        add(sq2);
        sq2.setVisible(false);
        //ans=new JLabel("Answer");
        ans.setBounds(150,260,200,30);
       add(ans);
       answer.setBounds(330,260,200,30);
       add(answer);
       
       ok.setBounds(550,140,80,30);
       add(ok);
      close.setBounds(375,420,100,30);
       add(close);
      ok2.setBounds(550,260,80,30);
       add(ok2);
       close.setForeground(Color.WHITE);
       close.setBackground(Color.black);
       ok.setForeground(Color.WHITE);
       ok.setBackground(Color.black);
        ok2.setForeground(Color.WHITE);
       ok2.setBackground(Color.black);
       ok2.setVisible(false);
        ok2.addActionListener(this);
        ok.addActionListener(this);
        close.addActionListener(this);
       getContentPane().setBackground(blue);
                setSize(850,850);
                setLocation(500,90);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }


    
 public void actionPerformed(ActionEvent ae){
 String userN=user.getText();
 String ans1=answer.getText();
      
       //System.out.println(sd);
 
    try{
        connection con= new connection();
        if(ae.getSource()==ok){
           
            
          String query=("(Select SecurityQuestion from user where UserName='"+userN+"')");
          ResultSet rs=con.s.executeQuery(query);
          if(rs.next()){
              sd=rs.getString(1);
            System.out.println(sd);
             ans.setVisible(true);
           answer.setVisible(true);
           ok2.setVisible(true);
           sq.setVisible(true);
           sq2.setText(sd);
         sq2.setVisible(true);
          }else{
              JOptionPane.showMessageDialog(null,"No user found");
               ans.setVisible(false);
           answer.setVisible(false);
           ok2.setVisible(false);
           sq.setVisible(false);
           sq2.setVisible(false);
          }
          
           
           //add(sq2);
      }else if(ae.getSource()==ok2){
          String query2=("(Select Password from user where UserName='"+userN+"' and Answer='"+ans1+
                   "')");
           ResultSet rs2=con.s.executeQuery(query2);
           if(rs2.next()){
               String pass=rs2.getString(1);
              // System.out.println(rs2.getString(1));
              int result=JOptionPane.showConfirmDialog(null, "Do you want to change your password ?",null,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
              if(result==JOptionPane.YES_OPTION){
                  
                  new changepin(userN).setVisible(true);
                  setVisible(false);
                   JOptionPane.showMessageDialog(null,"Your old Password is:- "+pass);
              }else if(result==JOptionPane.NO_OPTION){
               JOptionPane.showMessageDialog(null,"Hi,Your Password is:- "+pass);
           }else{
            JOptionPane.showMessageDialog(null,"No Record found");
           }
      }
      }
    }
      catch(Exception e){
          e.printStackTrace();
          
      }
  if(ae.getSource()==close){
      new Login().setVisible(true);
      setVisible(false);
  }
  }

 public static void main(String[] args)
 {
     new ForgetPassword();
 }
}
