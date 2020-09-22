

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
         
public class Transaction extends JFrame implements ActionListener{
         JLabel l1;
         JButton deposit,cash_withdrawl,mini_statement,pinchange,balance_enq,exit,logout;
          Color blue = new Color(70, 215, 255);
          String userString="";
     String send="";
  
          
   Transaction(String str){
       send=str;
       System.out.println(send);
       try{
           
           connection con= new connection();
            String query="select * from signup where Username= '"+str+"'";
            ResultSet rs= con.s.executeQuery(query);
            if(rs.next()){
                System.out.println(rs.getString("name"));
                userString =rs.getString("name");
                                
            }
       }catch(Exception e){
           e.printStackTrace();
       }
      
        setFont(new Font("System",Font.BOLD,26));
        Font f=getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Singn Up Process Page 2");
        int y=fm.stringWidth(" ");
        int z=getWidth()-x;
        int wid=z/y-25;
        String padding=" ";
        padding=String.format("%"+wid+"s",padding);
        setTitle(padding+"Welcome to Bank Management System");
       
      
       l1=new JLabel("Hi, Welcome "+userString);
                l1.setFont(new Font("Raleway",Font.BOLD,22)); 
       deposit=new JButton("Deposit");
       deposit.setFont(new Font("Raleway",Font.BOLD,16));
       deposit.setBackground(Color.BLACK);
       deposit.setForeground(Color.WHITE);
       
       cash_withdrawl=new JButton("Cash Withdraw");
       cash_withdrawl.setFont(new Font("Raleway",Font.BOLD,16));
       cash_withdrawl.setBackground(Color.BLACK);
       cash_withdrawl.setForeground(Color.white);
       
       mini_statement=new JButton("Mini Statement");
       mini_statement.setFont(new Font("Raleway",Font.BOLD,16));
       mini_statement.setBackground(Color.BLACK);
       mini_statement.setForeground(Color.WHITE);
       
       pinchange=new JButton("Change PIN");
       pinchange.setFont(new Font("Raleway",Font.BOLD,16));
          pinchange.setBackground(Color.BLACK);
          pinchange.setForeground(Color.WHITE);
          
          balance_enq=new JButton("Balance Enquiry");
          balance_enq.setFont(new Font("Raleway",Font.BOLD,16));
          balance_enq.setBackground(Color.BLACK);
          balance_enq.setForeground(Color.white);
          
          exit=new JButton("Exit");
          exit.setFont(new Font("Raleway",Font.BOLD,16));
          exit.setBackground(Color.black);
          exit.setForeground(Color.WHITE);
          
          
          logout=new JButton("Logout");
          logout.setFont(new Font("Raleway",Font.BOLD,16));
          logout.setBackground(Color.black);
          logout.setForeground(Color.WHITE);
          
          setLayout(null);
          l1.setBounds(300,100,700,40);
          add(l1);
          
          deposit.setBounds(40,250,300,60);
          add(deposit);
          
         cash_withdrawl.setBounds(440,250,300,60);
         add(cash_withdrawl);
         
         mini_statement.setBounds(40,360,300,60);
         add(mini_statement);
         
         pinchange.setBounds(440,360,300,60);
         add(pinchange);
         
         balance_enq.setBounds(40,470,300,60);
         add(balance_enq);
         
         exit.setBounds(240,600,300,60);
         add(exit);
       
         logout.setBounds(440,470,300,60);
         add(logout);
       
       deposit.addActionListener(this);
       cash_withdrawl.addActionListener(this);
       mini_statement.addActionListener(this);
       pinchange.addActionListener(this);
       balance_enq.addActionListener(this);
       exit.addActionListener(this);
        logout.addActionListener(this);
       
        getContentPane().setBackground(blue);
                setSize(850,850);
                setLocation(500,90);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
   } 
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==exit){
        System.exit(0);
    }else if(ae.getSource()==deposit){
        new deposit(send).setVisible(true);
        setVisible(false);
    }else if(ae.getSource()==cash_withdrawl){
       new withdraw(send).setVisible(true);
        setVisible(false);
    }else if(ae.getSource()==mini_statement){
        JOptionPane.showMessageDialog(null,"Coming soon !");
    }else if(ae.getSource()==logout){
      int result=  JOptionPane.showConfirmDialog(null, "Do you want to logout ?","Log out",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result==JOptionPane.YES_OPTION){
             new Login().setVisible(true);
        setVisible(false);
        
        JOptionPane.showMessageDialog(null,userString+",Logged out successfully!");
        }else {
            
        }
       
    }
    else if(ae.getSource()==pinchange){
       new changepin(send).setVisible(true);
        setVisible(false);
        
    }else if(ae.getSource()==balance_enq){

        connection con=new connection();
        try{
              JPanel p = new JPanel(new BorderLayout(5,5));

        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
       // labels.add(new JLabel("User Name", SwingConstants.TRAILING));
        labels.add(new JLabel("Password", SwingConstants.TRAILING));
        p.add(labels, BorderLayout.LINE_START);

        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
//        JTextField username = new JTextField();
//        controls.add(username);
        JPasswordField password = new JPasswordField();
     //   password.addAncestorListener(new RequestFocusListener(false));
        controls.add(password);
        p.add(controls, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(
            null, p, "Check Balance", JOptionPane.QUESTION_MESSAGE);
//        System.out.println("User Name: " + username.getText());
//        System.out.println("Password: " + new String(password.getPassword()));

             // String user=username.getText();
              String pass=new String(password.getPassword());
               String query="select * from bank where UserName= '"+send+"'and Password='"+pass+"'";
               ResultSet rs= con.s.executeQuery(query);
              if(rs.next()){
                  String balance=rs.getString("balance");
                //  System.out.println(balance);
                  JOptionPane.showMessageDialog(null,"Your account balance is:- Rs. "+balance);
              }else{
                 
              }
    }
        
        catch(Exception e){
            e.printStackTrace();
        } 
    }
        
   
        
        
}
    
    public static void main(String[] args){
        new Transaction("");
    }
}
