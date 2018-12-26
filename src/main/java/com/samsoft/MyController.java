package com.samsoft;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class MyController implements Initializable{

	@FXML
    private Button myButton;

	@FXML
	private TextField myTextField;
	


	 @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
	      //shrtcut();
	   }
	
	/* public void shrtcut() {
		Scene sc = myButton.getScene();
		 sc.getAccelerators().put(
				  new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN), 
				  new Runnable() {
				    @Override public void run() {
				      myButton.fire();
				    }
				  }
				);	 
	 }*/
	 
	 public void showDateTime(ActionEvent event) {
		 System.out.println("Button Clicked!");
		/* logger.error("Logger message of button clicked");
		// Date now= new Date();
	      
	       DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	       // Model Data
	    
	      /* String dateTimeString = df.format(now);
	       myTextField.setText(dateTimeString);
	     
			TimeUnit.SECONDS.sleep(1);*/
		/*	Thread thread = new Thread(new Runnable() {

			    @Override
			    public void run() {
			        for(int i=0; i<100000; i++) {
			        	Date now= new Date();
			        	String dateTimeString = df.format(now);
			 	       myTextField.setText(dateTimeString);
			 	     
			 	      try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        }   
			    }
			    
			});

			thread.start();*/
		 
		 
		/* Parent root;
	        try {
	            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("newWindow.fxml"));
	            root = loader.load();
	           // newController nc = (newController)loader.getController();
	           // nc.setTextField("set From main window");
	            Stage stage = new Stage();
	            stage.setTitle("My New Stage Title");
	            stage.setScene(new Scene(root, 450, 450));
	            stage.show();
	            // Hide this current window (if this is what you want)
	            //((Node)(event.getSource())).getScene().getWindow().hide();
	            
	          /*  TreeTableView<String> treeTableView = new TreeTableView<String>();
	            treeTableView.getSelectionModel().;*/
	            
	     /*   }
	        catch (IOException e) {
	            e.printStackTrace();
	        }*/
	       
	 }
}
