package com.samsoft.service;

import java.util.ArrayList;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import com.samsoft.printer.ExePrint;
import com.samsoft.printer.PrinterSelector;

public class PrintingService {
	
	private static boolean started = false;
	private static Thread t = null;
	private static volatile boolean stopCalled = false;
	
	public static void initiatePrinting(List<DocSettings> documents) {
		
		stopCalled = false;
		
		if(!started) {
				
		t = new Thread(()->
		{	
		// Download all the documents using urls
		for(DocSettings doc : documents)
		{
			if(stopCalled) {
				List<DocSettings> notFinishedJobs = new ArrayList<>();
				while(documents.iterator().hasNext()) {
					notFinishedJobs.add(documents.iterator().next());
				}
				//send not finished jobs to server --- later poll will schedule those jobs back 
				//show not finished jobs to print shop client
				//get out from loop
				setStarted(false);
				break;
			}
			
			String url = doc.getFileLink();
	        
			//save pdfs in .temp folder according to user and time
	        String username = doc.getOwner();
	        String time = doc.getTime();
	        
	        //Now we have the File and path, let's start printing current doc
	        
	        PrinterSelector printersltr = new PrinterSelector();
	        
	        List<String> possiblePrinterNames = printersltr.selectPrinter(doc.getColored(), doc.getPrinterType());
	        
	        for(String s : possiblePrinterNames) {
	        	int status = ExePrint.print(dirPath, username, s, doc.getOrientation(), doc.getSingleSided(), doc.getCopyCount());
	        	if(status == 0)
	        	{
	        		break;
	        	}else if((status==-1)||(status==-5)||(status==-6) ){
	        		continue;
	        	}else {
	        		//send error via http and make it visible to print shop client
	        		break;
	        	}
	        }
		}   
		});
		t.start();
		setStarted(true);
		}else {
			System.out.println("service already started!!");
		}
	}
	
	
	public static void terminatePrinting() {
		stopCalled = true;
	}

	private static synchronized void setStarted(boolean var) {
		started = var;
	}
}
