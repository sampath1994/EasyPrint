package com.samsoft;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class MainWindowController implements Initializable {
	
	@FXML
	AnchorPane descriptionPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	public void currentPrint(){
		
		AnchorPane pane = null;
		try {
			pane = FXMLLoader.load(getClass()
			        .getResource("MyScene.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		descriptionPane.getChildren().setAll(pane);
	}
	
}
