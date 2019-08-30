package com.samsoft.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.samsoft.service.PrintingService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainWindowController implements Initializable {
	
	@FXML
	AnchorPane descriptionPane;
	
	@FXML
	Label statusLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		statusLabel.setText("Stopped");
		System.out.println("Initialize method called!!");
	}

	
	public void currentPrint(){
		
		AnchorPane pane = null;
		try {
			pane = FXMLLoader.load(getClass()
			        .getResource("/MyScene.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		descriptionPane.getChildren().setAll(pane);
	}
	
	public void initService() {
		PrintingService.initiatePrinting();
		statusLabel.setText("Started");
		System.out.println("service started!!");
	}
	
	public void stopService() {
		PrintingService.terminatePrinting();
		statusLabel.setText("Stopped");
		System.out.println("service stoped!");
	}
	
	public void setSettings() {
		AnchorPane pane = null;
		try {
			pane = FXMLLoader.load(getClass()
			        .getResource("/SettingWindow.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		descriptionPane.getChildren().setAll(pane);
	}
}
