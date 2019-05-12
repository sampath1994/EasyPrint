package com.samsoft.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.samsoft.printer.PhysicalPrinter;

public class PrinterManager {

	public PrinterManager() {

	}

	/**
	 * @param printerList - list of printers need to persist as a file 
	 * @return - true if method success
	 * printer categories of shop will be stored in home directory .easyPrint folder 
	 */
	public boolean savePrinters(List<PhysicalPrinter> printerList){
		try {
			File tempDir = new File(System.getProperty("user.home")+File.separator+".easyPrint");
			if(!tempDir.exists()) {
			tempDir.mkdir();
			}
			FileOutputStream f = new FileOutputStream(new File(System.getProperty("user.home")+File.separator+".easyPrint"+File.separator+"printer_config.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(printerList);
			o.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@SuppressWarnings("unchecked")
	public List<PhysicalPrinter> getPrinters(){
		FileInputStream f;
		try {
			f = new FileInputStream(new File(System.getProperty("user.home")+File.separator+".easyPrint"+File.separator+"printer_config.txt"));
			ObjectInputStream o = new ObjectInputStream(f);
			return (List<PhysicalPrinter>) o.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
