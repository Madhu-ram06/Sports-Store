package application;
import application.store;
import application.Cricket;
import application.Swimming;
import application.Mountaineering;
import application.Indoor;
import application.currentUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.*;
//import javafx.scene.image.*;
import javafx.scene.text.*;

//import javafx.scene.control.Separator;



public class Login extends Application {
	String username;
	public static void main(String[] args) {
		launch(args);

	}
	Scene scene1,LoginScene,DepartmentScene,CricketScene;


	public void start(Stage myStage)
	{
		

		VBox grid=new VBox();
		grid.setSpacing(50);
		grid.setPadding(new Insets(10));


		scene1=new Scene(grid,500,600);
		
		myStage.setScene(scene1);
		myStage.setTitle("SPORTS STORE !!");
		//LOGIN PAGE
		Text a =new Text("<<<<<-WELCOME TO THRIFT SPORTS->>>>> ");
		a.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 26));
		grid.setAlignment(Pos.BASELINE_CENTER);

		Text a1 =new Text("LOGIN/SIGNUP TO CONTINUE..");
		a1.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 22));


		Text b =new Text("Have an existing account?");
		b.setFont(Font.font("Arial", FontWeight.LIGHT, 18));



		Button login=new Button("LOGIN");
		
				
			
				

		login.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				myStage.setScene(LoginScene);


			}
		});
		Separator sep = new Separator();
		sep.setMaxWidth(300);
		sep.setHalignment(HPos.CENTER);

		Text c =new Text("Create a new account");
		c.setFont(Font.font("Arial", FontWeight.LIGHT, 18));
		Button signup=new Button("SIGNUP");


		signup.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				store object=new store();
				try {
					object.start(myStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

				myStage.setScene(object.signInScene);

			}

		});




		grid.getChildren().addAll(a,a1,b,login,sep,c,signup);
		LoginScene(myStage);
		//DepartmentScene(myStage);
		
		





		myStage.show();




	}
	
	
	public void DepartmentScene(Stage myStage)
	{
		VBox grid2=new VBox();
		DepartmentScene=new Scene(grid2,600,500);
		myStage.setTitle("OUR DEPARTMENTS");
		
		
	
		Text a =new Text("<<<<<-THRIFT SPORTS->>>>> ");
		a.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 26));
		grid2.setAlignment(Pos.BASELINE_CENTER);
		grid2.getChildren().add(a);
		Text b=new Text("CHOOSE FROM OUR WIDE RANGE OF SPORTS PRODUCTS!!");
		b.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 22));
		grid2.setAlignment(Pos.BASELINE_CENTER);
		
		Button Account=new Button("MY ACCOUNT");
		Account.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			Account object=new Account();
			try {
				object.start(myStage);
			} catch (Exception e) {
				e.printStackTrace();
			}}

	});
		 Image i=new Image("https://1.imimg.com/data/2/A/MY-50793/cricket_250x250.jpg");
		    ImageView view=new ImageView(i);
		    view.setFitHeight(80);
		      view.setPreserveRatio(true);
		    Button Cricket=new Button();
		    Cricket.setGraphic(view);
		    Cricket.setPrefSize(20, 20);
		   
		    Cricket.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			Cricket object=new Cricket();
			try {
				object.start(myStage);
			} catch (Exception e) {
				e.printStackTrace();
			}}

	});

			 Image j=new Image("https://media-exp3.licdn.com/dms/image/C561BAQHl6w8EStcTxA/company-background_10000/0/1556893789193?e=2159024400&v=beta&t=7BBwKVJHwzAyrWzmKsb_MuWm7J_BK3DVDiTJH1TGzqM");
			    ImageView view1=new ImageView(j);
			    view1.setFitHeight(80);
			      view1.setPreserveRatio(true);
			    Button Swimming=new Button();
			    Swimming.setGraphic(view);
			    Swimming.setPrefSize(20, 20);
			   
			    Swimming.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					Swimming object=new Swimming();
				try {
					object.start(myStage);
				} catch (Exception e) {
					e.printStackTrace();
				}}

		});
			    Image k=new Image("https://cdn.discordapp.com/attachments/843824081841291314/864868370767806464/depositphotos_213393552-stock-illustration-mountain-background-vector.png");
			    ImageView view2=new ImageView(k);
			    view2.setFitHeight(80);
			      view2.setPreserveRatio(true);
			    Button Mountaineering=new Button();
			    Mountaineering.setGraphic(view);
			    Mountaineering.setPrefSize(20, 20);
			   
			    Mountaineering.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					Mountaineering object=new Mountaineering();
				try {
					object.start(myStage);
				} catch (Exception e) {
					e.printStackTrace();
				}}

		});
			    Image l=new Image("https://cdn.discordapp.com/attachments/843824081841291314/864868370767806464/depositphotos_213393552-stock-illustration-mountain-background-vector.png");
			    ImageView view3=new ImageView(l);
			    view3.setFitHeight(80);
			      view3.setPreserveRatio(true);
			    Button Indoor=new Button();
			    Indoor.setGraphic(view);
			    Indoor.setPrefSize(20, 20);
			   
			    Indoor.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					Indoor object=new Indoor();
				try {
					object.start(myStage);
				} catch (Exception e) {
					e.printStackTrace();
				}}

		});
		
		
		Button Orders=new Button("VIEW PREVIOUS ORDERS");
		Orders.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			Cricket object=new Cricket();
			try {
				object.start(myStage);
			} catch (Exception e) {
				e.printStackTrace();
			}}

	});
		myStage.setScene(DepartmentScene);
		grid2.getChildren().addAll(b,Account,Cricket,Swimming,Mountaineering,Indoor,Orders);
		}
	public void LoginScene(Stage myStage)
	{
		
		GridPane grid2=new GridPane();
		LoginScene=new Scene(grid2,500,500);
		grid2.setPadding(new Insets(50,10,10,50));
		grid2.setVgap(10);
		grid2.setHgap(10);
		//grid2.setGridLinesVisible(true);
		
		myStage.setTitle("LOGIN PAGE");
		Text t=new Text("Enter Email and Password :");
		t.setFont(Font.font("Arial", FontWeight.LIGHT, 18));
		grid2.setAlignment(Pos.BASELINE_CENTER);

		
		Label usrname=new Label("EMAIL ID:");
		TextField u=new TextField();
		Label psswrd=new Label("PASSWORD:");
		PasswordField p = new PasswordField();
		
		
		Button Submit=new Button("SUBMIT");
		Submit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				 username=u.getText();
				String password=p.getText();
				
				
				
				try
				{
					
					DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
					final String user="root";
					final String pass="1947";
					final String db_url="jdbc:mysql://localhost/sportsStore";
					Connection con=DriverManager.getConnection(db_url,user,pass);
					Statement smt= con.createStatement();
					
					ResultSet rs=smt.executeQuery("SELECT *FROM Customer ");
					int ustatus=0,pstatus=0,emptystatus=0;
					while(rs.next())
					{
						String str=rs.getString("EMAIL");
						String strpass=rs.getString("PASSWORD");
						if(username.isEmpty() || password.isEmpty())
						{
							emptystatus=1;
						}
						
						else if(username.equals(str))
						{
							 ustatus=1;

							if(password.equals(strpass))
							{
								 pstatus=1;
								 break;
							}
							
						}
					}
						
						
						
						if(emptystatus==1)
						{
							Alert alert=new Alert(AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("Please fill all the fields");
							alert.showAndWait();
						}
						else if(ustatus==1 && pstatus==1)
						{
							Alert alert=new Alert(AlertType.INFORMATION);
							alert.setHeaderText(null);
							alert.setContentText("LOGIN SUCCESSFUL");
							alert.showAndWait();
							currentUser obj=new currentUser();
							//System.out.println("This is in ogin "+username);
							obj.setUser(username);
							Login object=new Login();
							object.DepartmentScene(myStage);
						
						
						}
						else if(ustatus==1 && pstatus==0)
						{
							Alert alert=new Alert(AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("PASSWORD ENTERED IS INCORRECT!");
							alert.showAndWait();
							
							p.setText("");
							
							
						}
						else if(ustatus==0)
						{
							Alert alert=new Alert(AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("EMAIL ID ENTERED IS INCORRECT!");
							alert.showAndWait();
							u.setText("");
							p.setText("");
						}
						
					}
					
					
				
			catch(Exception e)
				{
				System.out.println(e.getMessage());
				}
				
				
			}
			
	});
		
		
		Button goback=new Button("<--Prev Page");
		goback.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				myStage.setScene(scene1);
				
			}
	});
		

		grid2.add(t,1,0);
		grid2.add(usrname,0,4);
		grid2.add(u,1,4);

		grid2.add(psswrd,0,6);
		grid2.add(p,1,6);

		grid2.add(Submit,1,9);
		GridPane.setHalignment(Submit,HPos.CENTER);

		grid2.add(goback,2,18);





	}



}
