package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class dropDrown
{	int quantity=0;
	String s="";
	public void menu(int pid)
	{
		VBox grid3=new VBox();
		 Scene menuScene=new Scene(grid3,400,350);
		Stage newWindow=new Stage();
		newWindow.setTitle("QUANTITY");
		newWindow.setScene(menuScene);
		newWindow.show();
		
		ObservableList<String> values=FXCollections.observableArrayList("1","2","3");
		ComboBox<String> qn=new ComboBox<String>(values);
		qn.setValue("Select quantity");
		qn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{	 
				 s=qn.getValue();
				  quantity=Integer.parseInt(s);
			}
		});
		Button Submit=new Button("SUBMIT");
		Submit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae)
			{
				if(s=="")
				{
					Alert alert=new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("QUANTITY NOT CHOSEN !!");
					alert.showAndWait();
					
				}
				else
				{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("ITEM ADDED TO CART !!");
				alert.showAndWait();
				
				newWindow.close();
				Billing obj=new Billing();
				obj.push(pid,quantity);
				}
	}
		});
	grid3.getChildren().addAll(qn,Submit);
}
}
