package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Random;

import java.sql.*;



public class store extends Application {
    /*public static void main(String[] args)
    {
        launch(args);
    }*/
    Scene signInScene;

    @Override
    public void start(Stage myStage) throws Exception{
        SignInForm signin=new SignInForm();
        signin.showSignIn(myStage);


    }

    class SignInForm{
        Label l1= new Label("First Name:");
        TextField t1 = new TextField();
        Label l2 = new Label("Last Name:");
        TextField t2 = new TextField();
        Label l3 = new Label("Phone Number:");
        TextField t3 = new TextField();
        Label l4 = new Label("Address:");
        TextField t4 = new TextField();
        Label l5 = new Label("Email:");
        TextField t5 = new TextField();
        Label l6 = new Label("Password:");
        PasswordField t6 = new PasswordField();
        Button submit = new Button("SUBMIT");
        Label error = new Label();

        public void showSignIn(Stage myStage) {

            GridPane rootNode = new GridPane();                 //rootNode
            rootNode.setPadding(new Insets(25,10,10,50));  //top,  ,  , left
            rootNode.setVgap(10);
            rootNode.setHgap(10);
            rootNode.setAlignment(Pos.TOP_LEFT);
            Button goback=new Button("<--Prev Page");
            goback.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent ae)
                {
                    Login object=new Login();
                    try {
                        object.start(myStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    myStage.setScene(object.scene1);
                }
            });

            rootNode.add(l1,0,1);
            rootNode.add(t1,1,1);
            rootNode.add(l2,0,2);
            rootNode.add(t2,1,2);
            rootNode.add(l3,0,3);
            rootNode.add(t3,1,3);
            rootNode.add(l4,0,4);
            rootNode.add(t4,1,4);
            rootNode.add(l5,0,5);
            rootNode.add(t5,1,5);
            rootNode.add(l6,0,6);
            rootNode.add(t6,1,6);
            rootNode.add(submit,1,9);
            rootNode.add(error,1,11);
            rootNode.add(goback,1,13);

            submit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {  //19.49

                    System.out.println("Submitted");
                    boolean check =checkAllFields();
                    if(check)
                    {   //calling constructor
                        Customer customer= new Customer(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText());
                        System.out.println("Values passed");

                        //inserting values
                        boolean status=customer.insertSignInDetails();
                        if(status) {
                            error.setText("Recorded Successfully");
                            System.out.println("Going to Deptartments");
                            Login object=new Login();
                            object.DepartmentScene(myStage);
                            myStage.setScene(object.DepartmentScene);
                        }
                        else
                            error.setText("Record Failed");
                    }
                    //if the SignIn form is not valid or failed
                    else
                        error.setTextFill(Color.RED);   //ADD ALERT!
                }
            });




            signInScene=new Scene(rootNode,500,500);




        }
        public boolean checkAllFields(){
            boolean entered=true;

            //check if firstname is entered
            if((t1.getText().isEmpty() && entered) == true)
            {
                error.setText("Enter your first name");
                entered=false;
            }
            if((t2.getText().isEmpty() && entered) == true)
            {
                error.setText("Enter your last name");
                entered=false;
            }
            if((t3.getText().isEmpty() && entered) == true)
            {
                error.setText("Enter your Phone Number");
                entered=false;
            }
            if((t4.getText().isEmpty() && entered) == true)
            {
                error.setText("Enter your Address");
                entered=false;
            }
            if((t5.getText().isEmpty() && entered) == true)
            {
                error.setText("Enter your email");
                entered=false;
            }
            if((t6.getText().isEmpty() && entered) == true)
            {
                error.setText("Enter your password");
                entered=false;
            }
            return entered;
        }
    }

}

class Customer{
    private int cid;
    private String phno;
    private String Fname,Lname;
    private String address;
    private String emailID;
    private String password;

    public int generateCID()
    {
        int[] arr=new int[1000];
        Random rand=new Random();
        int cid= rand.nextInt(((999-100)+1)+100);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==cid)
                cid=generateCID();
        }
        return cid;
    }

    //constructor
    public Customer(String fname, String lname,String phno, String address, String emailID, String password) {

        this.cid = generateCID();
        this.phno = phno;
        Fname = fname;
        Lname = lname;
        this.address = address;
        this.emailID = emailID;
        this.password = password;
    }

    //insert into database
    public boolean insertSignInDetails(){
        try {
            dbmsconnection connect = new dbmsconnection("jdbc:mysql://localhost:3306/sportsStore", "root", "1947");
            Connection con1= connect.getConnection();
            String entry="insert into Customer values(?,?,?,?,?,?,?);";
            PreparedStatement details= con1.prepareStatement(entry);
            details.setInt(1,cid);
            details.setString(2,Fname);
            details.setString(3,Lname);
            details.setString(4,phno);
            details.setString(5,address);
            details.setString(6,emailID);
            details.setString(7,password);
            int status = details.executeUpdate();
            if(status>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

}

//connection to database
class dbmsconnection{
    String url;
    String username;
    String password;
    public dbmsconnection(String url,String username,String password)
    {
        this.url=url;
        this.username=username;
        this.password=password;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established");
        return con;
    }

    public void closeConnection(Connection con,Statement smt) throws SQLException {
        smt.close();
        con.close();;
        System.out.println("Connection Disconnected");

    }
}