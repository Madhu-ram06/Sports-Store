package application;
import application.store;
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
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.*;

public class Account {

	public void start(Stage myStage) {
		VBox grid2=new VBox();
		
		
		Text a =new Text("accnt PAGE");
		a.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 26));
		grid2.setAlignment(Pos.BASELINE_CENTER);
		grid2.getChildren().add(a);
		myStage.setTitle("MY ACCOUNT");
		Scene CricketScene=new Scene(grid2,600,500);
		myStage.setScene(CricketScene);

	}

}
