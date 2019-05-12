package com.samsoft.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import com.samsoft.http.HttpPrintService;
import com.samsoft.printer.ExePrint;
import com.samsoft.printer.PrinterSelector;

public class PrintingService {

	private static boolean started = false;
	private static Thread t = null;
	private static volatile boolean stopCalled = false;

	public static void initiatePrinting() {

		stopCalled = false;

		if(!started) {

			t = new Thread(()->
			{	
				HttpPrintService httpService = new HttpPrintService();
				boolean pollFlag = true;
				int failedPollCount = 0;
				while(pollFlag) {
					//Get DocList relevant for current poll
					List<DocSettings> documents = null;
					try {
						documents = httpService.getDocSettings("username");// username should be extracted from property file
						failedPollCount = 0;
					} catch (IOException e1) {
						// Poll failed
						e1.printStackTrace();
						failedPollCount++;
						if(failedPollCount>10) {
							//Show print shop client is failing http poll
						}
					}  	
					if(documents!=null) {
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
								pollFlag = false;
								break;
							}



							String url = doc.getFileLink();

							//save pdfs in .temp folder according to user and time
							String username = doc.getOwner();
							String time = doc.getTime();
							String docID = Integer.toString(doc.getId());   
							//Download the Document
							String docFilePath = null;
							try {
								docFilePath = httpService.downloadFile(url, username+"_"+docID);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//Now we have the File and path, let's start printing current doc

							PrinterSelector printersltr = new PrinterSelector();

							List<String> possiblePrinterNames = printersltr.selectPrinter(doc.getColored(), doc.getPrinterType());

							for(String s : possiblePrinterNames) {
								int status = ExePrint.print(docFilePath, username, docID, s, doc.getOrientation(), doc.getSingleSided(), doc.getCopyCount());
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
					}				
					//sleep poll for 30 seconds 
					try {
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
