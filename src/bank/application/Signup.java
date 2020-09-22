package bank.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Signup extends JFrame implements ActionListener{

    JLabel pincodeLa,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,radiopickwarn,noRadioChoose,maritalRadio,noMaritalRDchose;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton rb1,rb2,rb3,rb4,rb5;
    JButton next,back;
    JComboBox c1,c2,c3; 
    String s="";
  final int digits;
  Color blue = new Color(70, 215, 255);
     Signup(String str)  
          {
              s=str;
         Random ran= new Random();     
             long randigits=(ran.nextLong()%9000L)+1000L;
            digits=(int)Math.abs(randigits);
      setFont(new Font("System",Font.BOLD,22));
        Font f=getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Singn Up Process");
        int y=fm.stringWidth(" ");
        int z=getWidth()-x;
        int wid=z/y-44;
        String padding=" ";
        padding=String.format("%"+wid+"s",padding);
        setTitle(padding+"Sign Up Process");
      
       
        l1= new JLabel("Application Form No. "+ " "+digits);
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l2=new JLabel("1.Personel Details");
        l2.setFont(new Font("Raleway",Font.BOLD,20));
        l3= new JLabel("Name*");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l4=new JLabel("Father's Name");
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        l5= new JLabel("Date of Birth");
        l5.setFont(new Font("Raleway",Font.BOLD,20));
        l6=new JLabel("Gender");
        l6.setFont(new Font("Raleway",Font.BOLD,20));
        l7=new JLabel("Email Address");
        l7.setFont(new Font("Raleway",Font.BOLD,20));
        l8=new JLabel("Marital Status");
        l8.setFont(new Font("Raleway",Font.BOLD,20));
        l9=new JLabel("Address");
        l9.setFont(new Font("Raleway",Font.BOLD,20));
        l10=new JLabel("City");
        l10.setFont(new Font("Raleway",Font.BOLD,20));
        l11=new JLabel("Pin Code");
        l11.setFont(new Font("Raleway",Font.BOLD,20));
        l12=new JLabel("State");
        l12.setFont(new Font("Raleway",Font.BOLD,20));
        l13=new JLabel("Date");
        l13.setFont(new Font("Raleway",Font.BOLD,14));
        l14=new JLabel("Month");
        l14.setFont(new Font("Raleway",Font.BOLD,14));
        l15=new JLabel("Year");
        l15.setFont(new Font("Raleway",Font.BOLD,14));
        radiopickwarn=new JLabel("Please choose only one");
        radiopickwarn.setFont(new Font("Arial",Font.ITALIC,16));
        radiopickwarn.setForeground(Color.red);
        noRadioChoose=new JLabel("Please Choose atleast one option above");
        noRadioChoose.setFont(new Font("Arial",Font.ITALIC,16));
        noRadioChoose.setForeground(Color.red);
        maritalRadio=new JLabel("Please choose only one");
        maritalRadio.setFont(new Font("Arial",Font.ITALIC,16));
        maritalRadio.setForeground(Color.red);
        noMaritalRDchose=new JLabel("Please Choose atleast one option above");
        noMaritalRDchose.setFont(new Font("Arial",Font.ITALIC,16));
        noMaritalRDchose.setForeground(Color.red);
        pincodeLa=new JLabel("Enter only Numbers");
        pincodeLa.setForeground(Color.red);
        pincodeLa.setFont(new Font("Arial",Font.ITALIC,16));
                
        t1=new JTextField();   //name
        t1.setFont(new Font("Raleway",Font.BOLD,14));
        
        t2= new JTextField();  // fname
        t2.setFont(new Font("Raleway",Font.BOLD,14));
        
        t3=new JTextField();  // email
        t3.setFont(new Font("Raleway",Font.BOLD,14));
        
        t4=new JTextField();  //Address
        t4.setFont(new Font("Raleway",Font.BOLD,14));
        
        t5=new JTextField(); //city
        t5.setFont(new Font("Raleway",Font.BOLD,14));
        
        t6=new JTextField();   // PinCode
        t6.setFont(new Font("Raleway",Font.BOLD,14));
        
        t7=new JTextField();  //State
        t7.setFont(new Font("Raleway",Font.BOLD,14));
        
        next=new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        back= new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        
       
        rb1= new JRadioButton("Male");
        rb1.setFont(new Font("Raleway",Font.BOLD,14));
        rb1.setBackground(Color.WHITE);
        
        rb2= new JRadioButton("Female");
        rb2.setFont(new Font("Raleway",Font.BOLD,14));
        rb2.setBackground(Color.WHITE);
        
        rb5= new JRadioButton("Other");
        rb5.setFont(new Font("Raleway",Font.BOLD,14));
        rb5.setBackground(Color.WHITE);
       
        
        rb3= new JRadioButton("Married");
        rb3.setFont(new Font("Raleway",Font.BOLD,14));
        rb3.setBackground(Color.WHITE);
        
        rb4=new JRadioButton("Unmarried");
        rb4.setFont(new Font("Raleway",Font.BOLD,14));
        rb4.setBackground(Color.WHITE);

        String date[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",};
        c1=new JComboBox(date);
        c1.setBackground(Color.WHITE);
        
        String month[]= {"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
        c2=new JComboBox(month);
        c2.setBackground(Color.WHITE);
        
        String year[]=new String[70];
        int j=1960;
         for(int k=0;k<70;k++){
             year[k]=Integer.toString(j);
             j++;
         }
//        for(int k=0;k<70;k++){
//        System.out.println(year[k]);
//        }
        c3= new JComboBox(year);
        c3.setBackground(Color.WHITE);
          
              setLayout(null);
              l1.setBounds(250,20,750,40);  // Application form No.
              add(l1);
              
              l2.setBounds(300,70,600,30);  // Personal Detail
              add(l2);
              l3.setBounds(100,140,100,30);    //Name
              add(l3);
              
              t1.setBounds(300,140,400,30);   //Name TextField
              add(t1);
              
              l4.setBounds(100,190,200,30);   //Fathers Name
              add(l4);
              
              t2.setBounds(300,190,400,30);    // Fname Textfield
              add(t2);
              
              l5.setBounds(100,240,200,30);  // Date of Birth
              add(l5);
              
              l13.setBounds(300,240,40,30);  //Date
              add(l13);
              
              c1.setBounds(340,240,60,30);   // Combo Box Date
              add(c1);
              
              l14.setBounds(410,240,50,30); //Month
               add(l14);
              
              c2.setBounds(460,240,100,30); //Month Combo Box
              add(c2);
              
              l15.setBounds(570,240,40,30); //year
              add(l15);
              
              c3.setBounds(610,240,90,30);  // year Combo Box
              add(c3);
              
              l6.setBounds(100,290,200,30);  // Gender
              add(l6);
              
              rb1.setBounds(300,290,60,30); // RadiO Button 1st for Male
              add(rb1);
                    
              rb2.setBounds(450,290,90,30); // Radio Button Female;
              add(rb2);
              
              
             radiopickwarn.setBounds(300,300,600,60);
             add(radiopickwarn);
             radiopickwarn.setVisible(false);
             noRadioChoose.setBounds(300,300,600,60);
             add(noRadioChoose);
             noRadioChoose.setVisible(false);
             
             maritalRadio.setBounds(300,400,600,60); 
              add(maritalRadio);
              maritalRadio.setVisible(false);
              noMaritalRDchose.setBounds(300,400,600,60); 
              add(noMaritalRDchose);
              noMaritalRDchose.setVisible(false);
             rb5.setBounds(600,290,120,30);
              add(rb5);
              
              l7.setBounds(100,340,200,30); // Email Address
              add(l7);
               
              t3.setBounds(300,340,400,30); // Email Text Field
              add(t3);
              
              l8.setBounds(100,390,200,30); // Martial Status
              add(l8);
              
              rb3.setBounds(300,390,100,30);
              add(rb3);
              
              rb4.setBounds(450,390,100,30);
              add(rb4);
              
             l9.setBounds(100,440,200,30); // Address
              add(l9);
              
              t4.setBounds(300,440,400,30);
              add(t4);
              
              l10.setBounds(100,490,200,30); // City
              add(l10);
              
              t5.setBounds(300,490,400,30); // city TextField
              add(t5);
              
              l11.setBounds(100,540,200,30); // Pincode
              add(l11);
              
              pincodeLa.setBounds(300,565,400,30);
              add(pincodeLa);
              pincodeLa.setVisible(false);
              t6.setBounds(300,540,400,30); //Pincode text Field
              add(t6);
              
        t6.addKeyListener(new KeyAdapter() {
            @Override
         public void keyPressed(KeyEvent ke) {
           try{
               
               int i=Integer.parseInt(t6.getText());
               pincodeLa.setVisible(false);
           
           }catch(NumberFormatException n){
       
             pincodeLa.setVisible(true);
             if(t6.getText().equals("")){
                 pincodeLa.setVisible(false); 
             }
           }
         }
      });
              
              l12.setBounds(100,590,400,30);
              add(l12);
              
              t7.setBounds(300,590,400,30);
              add(t7);
              
              next.setBounds(620,660,80,30);
              add(next);
              back.setBounds(300,660,80,30);
             // add(back);
              next.addActionListener(this);
              back.addActionListener(this);
             
              getContentPane().setBackground(blue);
              
                setSize(850,850);
                setLocation(500,90);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               }
   public void actionPerformed(ActionEvent ae){
     
       
       String name=t1.getText();
       String fName=t2.getText();
       String dateCombo=(String) c1.getSelectedItem();
       String monthCombo=(String) c2.getSelectedItem();
       String yearCombo=(String) c3.getSelectedItem();
       
        String radioPick="";
        if((rb1.isSelected() && rb2.isSelected() && rb5.isSelected()) || (rb1.isSelected()&& rb2.isSelected()) || (rb2.isSelected() && rb5.isSelected())|| (rb5.isSelected() && rb1.isSelected()))
        {
           // System.out.println("Selecte only One");
     rb1.setSelected(false);
     rb2.setSelected(false);
     rb5.setSelected(false);
           radiopickwarn.setVisible(true);
           noRadioChoose.setVisible(false);
        } else if(!rb1.isSelected() && !rb2.isSelected() && !rb5.isSelected()){
            
          noRadioChoose.setVisible(true);
          radiopickwarn.setVisible(false);
        }else if(rb1.isSelected()){
            
            radioPick=rb1.getText();
            noRadioChoose.setVisible(false);
            radiopickwarn.setVisible(false);
             
           
            //System.out.println(radioPick+"is selected");
        }else if(rb2.isSelected()){
                radioPick=rb2.getText();
                 noRadioChoose.setVisible(false);
                radiopickwarn.setVisible(false);
               
              //  System.out.println(radioPick+"is selected");
            }else if(rb5.isSelected()){
                radioPick=rb5.getText();
                noRadioChoose.setVisible(false);
                radiopickwarn.setVisible(false);
                
              //  System.out.println(radioPick+"is selected");
        }
        String emailText=t3.getText();
        
        String maritalStatus="";
        if(rb3.isSelected() && rb4.isSelected()){
            rb3.setSelected(false);
            rb4.setSelected(false);
            maritalRadio.setVisible(true);
            noMaritalRDchose.setVisible(false);
        }else if(!rb3.isSelected() && !rb4.isSelected()){
            noMaritalRDchose.setVisible(true);
             maritalRadio.setVisible(false);
        }
        else if(rb3.isSelected()){
            maritalStatus=rb3.getText();
              noMaritalRDchose.setVisible(false);
              maritalRadio.setVisible(false);
        }else if(rb4.isSelected()){
            maritalStatus=rb4.getText();
             noMaritalRDchose.setVisible(false);
             maritalRadio.setVisible(false);
        }
        
        String addressText=t4.getText();
        String cityText=t5.getText();
        String pincodeText= t6.getText();
        String stateText= t7.getText();
        if(ae.getSource()==back){
                new user().setVisible(true);
                setVisible(false);
            }
        try{  
            if(ae.getSource()==next){       
           if(name.equals("") || fName.equals("") || radioPick=="" || emailText.equals("") || maritalStatus=="" || addressText.equals("") || cityText.equals("")|| pincodeText.equals("") || stateText.equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter proper Detail");
            // System.out.println("Calling");
//            }else if((rb1.isSelected() && rb2.isSelected() && rb5.isSelected()) || (rb1.isSelected()&& rb2.isSelected()) || (rb2.isSelected() && rb5.isSelected())|| (rb5.isSelected() && rb1.isSelected())|| (rb3.isSelected() && rb4.isSelected())){
               
//           
               }    else if(ae.getSource()==next){
             //  System.out.println(pincodeText+" "+ stateText);
                connection con= new connection();
              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
              LocalDateTime now = LocalDateTime.now();  
              String nowd=dtf.format(now);
                String query1="insert into signup values('"+name+"','"+fName+"','"+dateCombo+"','"+monthCombo+"','"+yearCombo+"','"+radioPick+"','"+emailText+"','"+maritalStatus+"','"+addressText+"','"+cityText+"','"+pincodeText+"','"+stateText+"','"+digits+"','"+nowd+"','"+s+"')";
                con.s.executeUpdate(query1);
                String str=Integer.toString(digits);
                new Signup2(str).setVisible(true);
               setVisible(false);
                 //JOptionPane.showMessageDialog(null, "Form No."+digits);
               
               setDefaultCloseOperation(EXIT_ON_CLOSE);
            } 
           
        }
              
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Your data is already submitted with Application Form :"+digits);
            //System.out.println(e);
        }
        
        
        
   }
    public static void main(String[] args){ 
         new Signup("");
     }
        
   }
