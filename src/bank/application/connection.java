/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank.application;

import java.sql.*;
public class connection {
 
 String driver="com.mysql.jdbc.Driver";
 String url="jdbc:mysql://localhost:3306/bank?autoReconnect=true&useSSL=false";
 String user="root";
 String pswd="7864";
 Connection c;
 Statement s;
 public connection(){
 try{
   Class.forName(driver);
   c=DriverManager.getConnection(url,user,pswd);
   s=c.createStatement();
//    ResultSet rs=s.executeQuery("select * from demo");
//        if(rs.next()){
//      System.out.println(rs.getInt(1)+" "+rs.getString(2));
//        
//        }
     
   
}catch(Exception e){
            System.out.println(e);
}
}
}
