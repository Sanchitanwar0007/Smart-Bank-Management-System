
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


public class user extends JFrame implements ActionListener{

    JLabel welcome, username,password,confirmPass,securityque,answer,passlength;
    JTextField tf1,tf2,tf3;
   JPasswordField pf1;
    JComboBox jcb1;
    JButton next,cancel;
    
    Color blue = new Color(70, 215, 255);
   public user()  {
        setFont(new Font("System",Font.BOLD,22));
        Font f=getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("New User Registration");
        int y=fm.stringWidth(" ");
        int z=getWidth()-x;
        int wid=z/y-38;
        String padding=" ";
        padding=String.format("%"+wid+"s",padding);
        setTitle(padding+"New User Registration");
       welcome =new JLabel("Register new User");
       welcome.setFont(new Font("Raleway",Font.BOLD,25));
      username = new JLabel("Username:");
      username.setFont(new Font("Raleway",Font.BOLD,18));
      password=new JLabel("Password:");
      password.setFont(new Font("Raleway",Font.BOLD,18));
      confirmPass=new JLabel("Confirm Password:");
      confirmPass.setFont(new Font("Raleway",Font.BOLD,18));
      securityque=new JLabel("Security Question:");
      securityque.setFont(new Font("Raleway",Font.BOLD,18));
      answer=new JLabel("Answer:");
      answer.setFont(new Font("Raleway",Font.BOLD,18));
      passlength=new JLabel("Password must contain atleast 8 characters");
      passlength.setFont(new Font("Raleway",Font.ITALIC,12));
      passlength.setForeground(Color.RED);
      tf1=new JTextField();
      tf1.setFont(new Font("Raleway",Font.BOLD,18));
      tf2=new JTextField();
      tf2.setFont(new Font("Raleway",Font.BOLD,18));
      tf3=new JTextField();
      tf3.setFont(new Font("Raleway",Font.BOLD,18));
      pf1=new JPasswordField();
      pf1.setFont(new Font("Raleway",Font.BOLD,18));
      String[] sq={"What is childhood name ?","What is your pet animal name?","What is your favourite subject?","In which city you born?","What is your 1st school?","What is your favourite sport?","Who is your favourite actor?","What is your father's village name?"};
      
      jcb1=new JComboBox(sq);
      jcb1.setFont(new Font("Raleway",Font.BOLD,18));
      next=new JButton("Next");
      next.setFont(new Font("Raleway",Font.BOLD,18));
      cancel=new JButton("Back");
      cancel.setFont(new Font("Raleway",Font.BOLD,18));
      
       setLayout(null);
       welcome.setBounds(280,50,400,40);
       add(welcome);
       username.setBounds(150,140,200,30);
       add(username);
       tf1.setBounds(330,140,200,30);
       add(tf1);
       password.setBounds(150,200,200,30);
       add(password);
       passlength.setBounds(330,289,400,20);
       add(passlength);
       passlength.setVisible(false);
     
      
       tf2.setBounds(330,200,200,30);
       add(tf2);
       confirmPass.setBounds(150,260,200,30);
       add(confirmPass);
       pf1.setBounds(330,260,200,30);
       add(pf1);
       securityque.setBounds(150,320,200,30);
       add(securityque);
       jcb1.setBounds(330,320,310,30);
       add(jcb1);
       answer.setBounds(150,380,200,30);
       add(answer);
       tf3.setBounds(330,380,200,30);
       add(tf3);
       next.setBounds(460,520,100,30);
       add(next);
       next.setForeground(Color.WHITE);
       next.setBackground(Color.black);
       cancel.setBounds(180,520,100,30);
       add(cancel);
       cancel.setForeground(Color.WHITE);
       cancel.setBackground(Color.BLACK);
        
       next.addActionListener(this);
       cancel.addActionListener(this);
       
      getContentPane().setBackground(blue);
                setSize(850,850);
                setLocation(500,90);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }
     public void actionPerformed(ActionEvent ae){
         String user=tf1.getText();
         String pass=tf2.getText();
         String answerString=tf3.getText();
         String combo=(String)jcb1.getSelectedItem();
        
         String confirmpass=new String(pf1.getPassword());
        // System.out.println(confirmpass);
        
         boolean passVisible=true;
        int userLength=user.length();
         if(pass.length()<8){
             passlength.setVisible(true);
             passVisible=true;
             tf2.setText("");
             pf1.setText("");
         }else if(pass.length()>=8){
             passlength.setVisible(false);
             passVisible=false;
         }
         if((!pass.equals(confirmpass))){
            pf1.setText("");
         }
         try{
          
         if(ae.getSource()==next){
         if(userLength<4||passVisible ||(!pass.equals(confirmpass))||  user.equals("")||answerString.equals("")||pass.equals("") ){
            
         
             JOptionPane.showMessageDialog(null,"Fill proper fields");
              
         }else {
             connection con=new connection();
              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
              LocalDateTime now = LocalDateTime.now();  
              String nowd=dtf.format(now);
             String query="insert into user values('"+user+"','"+pass+"','"+combo+"','"+answerString+"','"+nowd+"')";
             String query2="insert into login values('"+user+"','"+pass+"','"+nowd+"')";
             String query3="insert into bank values('"+user+"','"+pass+"',null,null)";
             
             con.s.executeUpdate(query);
             con.s.executeUpdate(query2);
             con.s.executeUpdate(query3);
              new Signup(user).setVisible(true);
             setVisible(false);
             
         }
         }
         else if(ae.getSource()==cancel){
             new Login();
             setVisible(false);
         }
         
     }catch(Exception e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null, "Username already exist");
     }
     }
     public static void main(String[] args){ 
         new user();
     }
  
}
 
