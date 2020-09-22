

package bank.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
JLabel l1,l2,l3,l4,l5,fp;
JTextField tf1;
JPasswordField pf1;
JButton login,clear,signup;
     boolean isNumbercf=true;
     boolean isNumberpin=true;
    Login(){
        setFont(new Font("System",Font.BOLD,22));
        Font f=getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Bank Application");
        int y=fm.stringWidth(" ");
        int z=getWidth()-x;
        int wid=z/y-40;
        String padding=" ";
        padding=String.format("%"+wid+"s",padding);
        setTitle(padding+"Bank Application");
      //Label Text View Code  
        l1=new JLabel("Welcome  To Bank");
        l1.setFont(new Font("Osward",Font.BOLD,38));
        l2=new JLabel("Username:");
        l2.setFont(new Font("Raleway",Font.BOLD,25));
        l3=new JLabel("Password:");
        l3.setFont(new Font("Raleway",Font.BOLD,25));
         l4= new JLabel("Invalid Pin Code");
         l4.setFont(new Font("Raleway",Font.ITALIC,15));
         l5=new JLabel("Invalid card detail");
         l5.setFont(new Font("Raleway",Font.ITALIC,15));
         fp=new JLabel("Forget Password");
         fp.setFont(new Font("Raleway",Font.ITALIC,15));
        //Text fiels Code
        tf1=new JTextField(15);
        pf1=new JPasswordField(15);
        
        //button code
        login=new JButton("Login");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        
        signup=new JButton("SignUp");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        
        clear= new JButton("Clear");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
         
        setLayout(null);
        l1.setBounds(175,52,450,200);
        add(l1);
        
        l2.setBounds(125,150,375,200);
        add(l2);
        
        l3.setBounds(125,225,375,200);
        add(l3);
        l5.setBounds(300,260,230,45);
        l5.setForeground(Color.RED);
        add(l5);
         l5.setVisible(false);
        l4.setBounds(300,330,230,45);
        l4.setForeground(Color.RED);
        add(l4);
        l4.setVisible(false);
        tf1.setFont(new Font("Arial",Font.BOLD,15));
        tf1.setBounds(300,235,230,30);
        add(tf1);
       
     
//        tf1.addKeyListener(new KeyAdapter() {
//            @Override
//         public void keyPressed(KeyEvent ke) {
//           try{
//               
//               int i=Integer.parseInt(tf1.getText());
//               l5.setVisible(false);
//               isNumbercf=true;
//           
//           }catch(NumberFormatException n){
//               isNumbercf=false;
//             l5.setVisible(true);
//              if(tf1.getText().equals("")){
//              l5.setVisible(false);
//        }
//       
//           }
//         }
//      });
        
        pf1.setFont(new Font("Arial",Font.BOLD,15));
        pf1.setBounds(300,310,230,30);
        add(pf1);
//        pf1.addKeyListener(new KeyAdapter() {
//            @Override
//         public void keyPressed(KeyEvent ke) {
//           try{
//              
//               String s=new String(pf1.getPassword());
//               int i=Integer.parseInt(s);
//               l4.setVisible(false);
//                isNumberpin=true;
//           }catch(NumberFormatException n){
//               isNumberpin=false;
//             l4.setVisible(true);
//             String pin1=new String(pf1.getPassword());
//        if(pin1.equals("")){
//            l4.setVisible(false);
//        }
//           }
//         }
//      })
        fp.setBounds(416,339,200,30);
        add(fp);
        fp.setForeground(Color.BLUE);
         fp.addMouseListener(new MouseAdapter() {
       
       public void mouseClicked(MouseEvent e){
           new ForgetPassword().setVisible(true);
           setVisible(false);
       }
         
         });
        login.setFont(new Font("Arial",Font.BOLD,15));
        login.setBounds(300,400,100,30);
        add(login);
        
        signup.setFont(new Font("Arial",Font.BOLD,15));
        signup.setBounds(430,400,100,30);
        add(signup);
        
        clear.setFont(new Font("Arial",Font.BOLD,15));
        clear.setBounds(300,450,230,30);
        add(clear);
        
        login.addActionListener(this);
        signup.addActionListener(this);
        clear.addActionListener(this);
         Color blue = new Color(70, 215, 255);
        getContentPane().setBackground(blue);
        
        setSize(750,750);
        setLocation(500,200);
        setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

     
    
  public void actionPerformed(ActionEvent ae){
      try{
          connection c1= new connection();
        String user=tf1.getText();
        String pin=new String(pf1.getPassword());
//         System.out.println(a);
//        System.out.println(b);
        String query="select * from login where UserName= '"+user+"'and Password='"+pin+"'";
         ResultSet rs=c1.s.executeQuery(query);
         if(ae.getSource()==login && isNumbercf && isNumberpin){
            
             if(rs.next()){
                 
             new Transaction(user).setVisible(true);
             // System.out.println("Login Succesful");
             setVisible(false);
         }else{
             JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
         }
      }else if(ae.getSource()==signup ){
         new user().setVisible(true);
             setVisible(false);
      }else if(ae.getSource()==clear){
         tf1.setText("");
         pf1.setText("");
      } 
      
      }
      catch(Exception e){
          e.printStackTrace();
        
      }
  }
          
    
}
