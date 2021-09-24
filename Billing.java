package application;
import application.store;
import application.currentUser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.*;

public  class Billing {

	
	String prodname;
	float price1;
	int productid;
	int cid;
	int tempcid;
	
	public void push(int pid,int quantity1)
	{

		try
		{
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			final String user="root";
			final String pass="1947";
			final String db_url="jdbc:mysql://localhost/sportsStore";
			Connection con=DriverManager.getConnection(db_url,user,pass);
			Statement smt= con.createStatement();
			
			ResultSet rs=smt.executeQuery("SELECT *FROM Products");
			
			while(rs.next())
			{
				 productid=rs.getInt("prod_id");
				if(pid==productid)
				{	
					break;
				}
			}
			
					PreparedStatement psmt=con.prepareStatement("Insert into billing_info(prod_name,prod_id,price,quantity,date) values(?,?,?,?,?)");
					 prodname=rs.getString("prod_name");
					price1=rs.getFloat("price");
					
					
					psmt.setString(1,prodname);
					psmt.setInt(2,productid);
					psmt.setFloat(3,price1);
					psmt.setInt(4,quantity1);
					psmt.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now()));
					int status = psmt.executeUpdate();
		            if(status>0)
		            {
		                System.out.println("Inserted vaklues");
		            }
		            else
		            {
		            	System.out.println("Error");
		            }
		            
					
				System.out.println("Prod id "+rs.getInt("prod_id"));
				System.out.println("Prod name "+rs.getString("prod_name"));
				System.out.println("Prod price "+rs.getInt("price"));
				
				
			
		/*	currentUser obj=new currentUser();
			String username=obj.getUser();
			System.out.println("username is "+username);
			int status1=0;
			Statement smt1= con.createStatement();
			ResultSet rs1=smt1.executeQuery("SELECT *FROM Customer");
			while(rs1.next())
			{
				
				
				
			
			
				PreparedStatement psmt1=con.prepareStatement("Insert into previous_orders(cid,prod_id,prod_name,price,quantity,date) values(?,?,?,?,?,?)");
				
				String user1=rs1.getString("email");
				tempcid=rs1.getInt("cid");
				System.out.println(user1);
				System.out.println(tempcid);
				if(username.equals(user1));
				{
					cid=tempcid;
					 
				
				psmt1.setInt(1,cid);
				psmt1.setInt(2,productid);
				psmt1.setString(3,prodname);
				
				psmt1.setFloat(4,price1);
				psmt1.setInt(5,quantity1);
				psmt1.setDate(6,java.sql.Date.valueOf(java.time.LocalDate.now()));
				 status1 = psmt1.executeUpdate();
				break;
				}
			}
	            if(status1>0)
	            {
	                System.out.println("Inserted vaklues");
	            }
	            else
	            {
	            	System.out.println("Error");
	            }*/
			
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
	}
	
	

}
