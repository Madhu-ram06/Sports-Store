package application;


import javafx.application.*;
import application.Billing;
import application.Login;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.*;

public class Cricket  {
	Scene CricketScene,DepartmentScene;
	String username;
	
	public void start(Stage myStage) {
		 GridPane grid2=new GridPane();
		Scene CricketScene=new Scene(grid2,600,500);
		myStage.setScene(CricketScene);
		grid2.setPadding(new Insets(10,100,10,40));
		Text a =new Text("<<<--CRICKET-->>>");
		a.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 26));
		 grid2.setAlignment(Pos.BASELINE_CENTER);
	        grid2.add(a,1,1);
	        myStage.setTitle("CRICKET PRODUCTS");
	        grid2.setVgap(10);
	        Text b =new Text("PRICE");
			b.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 22));
			  grid2.add(b,7,3);
		
		Font fontBold=Font.font("Verdana",FontWeight.SEMI_BOLD,FontPosture.REGULAR,18);
	
		CheckBox option1=new CheckBox("Pro Guard Shoes");
		option1.setFont(fontBold);
		option1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				dropDrown obj=new dropDrown();
				obj.menu(10);
				
			}
		});
		Text a1=new Text("Rs.2000");
		a1.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,FontPosture.REGULAR,15));
		Separator sep1 = new Separator();
		sep1.setMaxWidth(300);
		sep1.setHalignment(HPos.CENTER);
		Separator sep2 = new Separator();
		sep2.setMaxWidth(300);
		sep2.setHalignment(HPos.CENTER);
		Separator sep3 = new Separator();
		sep3.setMaxWidth(300);
		sep3.setHalignment(HPos.CENTER);
		Separator sep4 = new Separator();
		sep4.setMaxWidth(300);
		sep4.setHalignment(HPos.CENTER);
		
		CheckBox option2=new CheckBox("Cricket Bat");
		option2.setFont(fontBold);
		option2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				dropDrown obj=new dropDrown();
				obj.menu(22);
				
				
			}
		});
		Text a2=new Text("Rs.2000");
		a2.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,FontPosture.REGULAR,15));
		
		
		CheckBox option3=new CheckBox("Leather Cricket Ball");
		option3.setFont(fontBold);
		option3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				dropDrown obj=new dropDrown();
				obj.menu(11);
				
			}
		});
		Text a3=new Text("Rs.200");
		a3.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,FontPosture.REGULAR,15));
		
		
		CheckBox option4=new CheckBox("Stump Set-Pure Plastic");
		option4.setFont(fontBold);
		option4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				dropDrown obj=new dropDrown();
				obj.menu(55);
				
			}
		});
		Text a4=new Text("Rs.500");
		a4.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,FontPosture.REGULAR,15));
		 
		
		CheckBox option5=new CheckBox("Cricket Kit Bag");
		option5.setFont(fontBold);
		option5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				dropDrown obj=new dropDrown();
				obj.menu(77);
				
			}
		});
		Text a5=new Text("Rs.2400");
		a5.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,FontPosture.REGULAR,15));
		Button prevpage=new Button("<--CHECK OUR OTHER SPORTS PRODUCTS");
		prevpage.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				Login object=new Login();
				object.DepartmentScene(myStage);
			}
		});
		
		 grid2.add(option1,1,4);
		 grid2.add(a1, 2,4);
	        //grid2.addRow(5,sep1);
	      //  GridPane.setHalignment(option1,HPos.CENTER);
	        grid2.add(option2,1,6);
	        grid2.add(a2,2,6);
	       // grid2.addRow(7,sep2);
	        //GridPane.setHalignment(option2,HPos.CENTER);
	        grid2.add(option3,1,8);
	        grid2.add(a3,2,8);
	       // grid2.addRow(9,sep3);
	       // GridPane.setHalignment(option3,HPos.CENTER);
	        grid2.add(option4,1,10);
	        grid2.add(a4,2,10);
	        //grid2.addRow(11,sep4);
	        //GridPane.setHalignment(option4,HPos.CENTER);
	        grid2.add(option5,1,12);	
	        grid2.add(a5,2,12);
	        grid2.add(prevpage,1,16);	
		//grid2.getChildren().addAll(option1,option2,option3,option3,option5);
		
	       
	}

}
