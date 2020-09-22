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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
        JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
        JRadioButton rb1,rb2,rb3,rb4;
        JButton submit,cancel;
        JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
        JTextField t1;
        Color blue = new Color(70, 215, 255);
    public Signup3() {
        setFont(new Font("System",Font.BOLD,22));
        Font f=getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Singn Up Process Page 2");
        int y=fm.stringWidth(" ");
        int z=getWidth()-x;
        int wid=z/y-38;
        String padding=" ";
        padding=String.format("%"+wid+"s",padding);
        setTitle(padding+"Sign Up Process Page 2");
        
        l1=new JLabel("Page 3: Account Detail"); 
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l2=new JLabel("Account Type :");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        l3= new JLabel("Card Number:");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l4=new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l5= new JLabel("Your 16-digit Card Number");
        l5.setFont(new Font("Raleway",Font.BOLD,12));
        l6=new JLabel("It would appear on ATM Card");
        l6.setFont(new Font("Raleway",Font.BOLD,12));
        l7=new JLabel("PIN:");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l8=new JLabel("XXXX");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l9=new JLabel("4-digit Password");
        l9.setFont(new Font("Raleway",Font.BOLD,12));
        l10=new JLabel("Service Required");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l11=new JLabel("Form No.:");
        l11.setFont(new Font("Raleway",Font.BOLD,14));
        
         submit=new JButton("Submit");
         submit.setFont(new Font("Raleway",Font.BOLD,14));
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);

         cancel=new JButton("Cancel");
         cancel.setFont(new Font("Raleway",Font.BOLD,14));
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
        
        cb1=new JCheckBox("ATM CARD");
        cb1.setBackground(Color.WHITE);
        cb1.setFont(new Font("Raleway",Font.BOLD,16));
        
        cb2=new JCheckBox("Internet Banking");
        cb2.setBackground(Color.WHITE);
        cb2.setFont(new Font("Raleway",Font.BOLD,16));
        
        cb3=new JCheckBox("Mobile Banking");
        cb3.setBackground(Color.WHITE);
        cb3.setFont(new Font("Raleway",Font.BOLD,16));
        
        cb4=new JCheckBox("Email Alerts");
            cb4.setBackground(Color.WHITE);
        cb4.setFont(new Font("Raleway",Font.BOLD,16));
        
        cb5=new JCheckBox("Cheque Book");
         cb5.setBackground(Color.WHITE);
        cb5.setFont(new Font("Raleway",Font.BOLD,16));
        
        cb6=new JCheckBox("E-Statement");
         cb6.setBackground(Color.WHITE);
        cb6.setFont(new Font("Raleway",Font.BOLD,16));
        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,16));
        rb1=new JRadioButton("Saving Account");
        rb1.setBackground(Color.WHITE);
        rb1.setFont(new Font("Raleway",Font.BOLD,12));
        
        rb2=new JRadioButton("Fixed Deposit Account");
        rb2.setBackground(Color.WHITE);
        rb2.setFont(new Font("Raleway",Font.BOLD,12));
        
        rb3=new JRadioButton("Current Account");
           rb3.setBackground(Color.WHITE);
        rb3.setFont(new Font("Raleway",Font.BOLD,12));
        
        rb4=new JRadioButton("Recurring Deposit Account");
           rb4.setBackground(Color.WHITE);
        rb4.setFont(new Font("Raleway",Font.BOLD,12));
        setLayout(null);
        
        l11.setBounds(700,10,70,30);
        add(l11);
        
        t1.setBounds(770,10,60,30);
        add(t1);
        
        l1.setBounds(280,50,400,40);
        add(l1);
        
        l2.setBounds(100,140,200,30);
        add(l2);
        
        rb1.setBounds(100,180,150,30);
        add(rb1);
        
        rb2.setBounds(350,180,300,30);
        add(rb2);
        
        rb3.setBounds(100,220,200,30);
        add(rb3);
        
        rb4.setBounds(350,220,300,30);
        add(rb4);
        
        l3.setBounds(100,300,200,30);
        add(l3);
        l4.setBounds(330,300,250,30);
        add(l4);
        
        l5.setBounds(100,330,200,20);
        add(l5);
        
        l6.setBounds(330,330,500,20);
        add(l6);
        
        l7.setBounds(100,370,200,30);
        add(l7);
        
        l8.setBounds(330,370,200,20);
        add(l8);
        l9.setBounds(100,400,200,20);
        add(l9);
        
        l10.setBounds(100,450,200,30);
        add(l10);
        
        cb1.setBounds(100,500,200,30);
        add(cb1);
        
         cb2.setBounds(350,500,200,30);
         add(cb2);
         
         cb3.setBounds(100,550,200,30);
         add(cb3);
         
         cb4.setBounds(350,550,200,30);
         add(cb4);
         
         cb5.setBounds(100,600,200,30);
         add(cb5);
         
         cb6.setBounds(350,600,200,30);
         add(cb6);
        
         cancel.setBounds(300,720,100,30);
         add(cancel);
         
         submit.setBounds(420,720,100,30);
         add(submit);
         
         
         cancel.addActionListener(this);
         submit.addActionListener(this);
         
         
        getContentPane().setBackground(blue);
                setSize(850,850);
                setLocation(500,90);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }
      int i=0;
    
     public void actionPerformed(ActionEvent ae){
        String sa=null;
          if(rb1.isSelected()){
            sa=rb1.getText();
            i=0;
        }else if(rb2.isSelected()){
            sa=rb1.getText();
            i=0;
        }else if(rb3.isSelected()){
            sa=rb3.getText();
            i=0;
        }else if(rb4.isSelected()){
            sa=rb4.getText();
            i=0;
         
        }
        if(rb1.isSelected() && rb2.isSelected() && rb3.isSelected() && rb4.isSelected()){
            JOptionPane.showMessageDialog(null,"Please select Account Type");
            rb1.setSelected(false);
             rb2.setSelected(false);
            rb3.setSelected(false);
            rb4.setSelected(false);
           i=1;
        }
         if( rb2.isSelected() && rb3.isSelected() && rb4.isSelected()){
            JOptionPane.showMessageDialog(null,"Please select Account Type");
            //rb1.setSelected(false);
             rb2.setSelected(false);
            rb3.setSelected(false);
            rb4.setSelected(false);
           i=1;
        }
          if(rb1.isSelected() && rb2.isSelected() && rb4.isSelected()){
            JOptionPane.showMessageDialog(null,"Please select Account Type");
            rb1.setSelected(false);
             rb2.setSelected(false);
            //rb3.setSelected(false);
            rb4.setSelected(false);
           i=1;
        }
           if(rb1.isSelected()  && rb3.isSelected() && rb4.isSelected()){
            JOptionPane.showMessageDialog(null,"Please select Account Type");
            rb1.setSelected(false);
            // rb2.setSelected(false);
            rb3.setSelected(false);
            rb4.setSelected(false);
           i=1;
        }
            if( rb2.isSelected() && rb3.isSelected() ){
            JOptionPane.showMessageDialog(null,"Please select Account Type");
          //  rb1.setSelected(false);
             rb2.setSelected(false);
            rb3.setSelected(false);
           // rb4.setSelected(false);
           i=1;
        }
         if(rb1.isSelected() && rb2.isSelected() && rb3.isSelected() ){
            JOptionPane.showMessageDialog(null,"Please select Account Type");
            rb1.setSelected(false);
             rb2.setSelected(false);
            rb3.setSelected(false);
           i=1;
           
        }
         if(rb1.isSelected() && rb2.isSelected() ){
            JOptionPane.showMessageDialog(null,"Please select Account Type");
            rb1.setSelected(false);
             rb2.setSelected(false);
     i=1;
        }
      
        Random ran=new Random();
        long first7=(ran.nextLong()%90000000L)+5040936000000000L;
        long first8=Math.abs(first7);
        
        long first3=(ran.nextLong()%9000L)+1000L;
        long first4=Math.abs(first3);
        
        String sr="";
        if(cb1.isSelected()){
            sr=sr+" "+cb1.getText();
        }
        if(cb2.isSelected()){
            sr=sr+" "+cb2.getText();
        }
        if(cb3.isSelected()){
            sr=sr+" "+cb3.getText();
        }
        if(cb4.isSelected()){
            sr=sr+" "+cb4.getText();
        }
        if(cb5.isSelected()){
            sr=sr+" "+cb5.getText();
        }
        if(cb6.isSelected()){
            sr=sr+" "+cb6.getText();
        }
        String formno=t1.getText();
        try{
            if(ae.getSource()==submit)
            {
               if(submit.equals("") && i==0){
                   JOptionPane.showMessageDialog(null, "Fill all the required fields");
               }else {
                   connection con=new connection();
                    
                   String query1= "insert into signup3 values('"+formno+"','"+sa+"','"+first8+"','"+first4+"','"+sr+"')";
                   String query2= "insert into login values('"+first8+"','"+first4+"')";
                   con.s.executeUpdate(query1);
                   con.s.executeUpdate(query2);
                   JOptionPane.showMessageDialog(null,"Card Number :-"+first8+ "\n Pin aa:-"+first4);
                   
                   //new Deposit().setVisible(true);
                   setVisible(false);
               } 
            }else if(ae.getSource()==cancel){
                System.exit(0);
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
     public static void main (String args[]){
         new Signup3();
     }
    
}
 