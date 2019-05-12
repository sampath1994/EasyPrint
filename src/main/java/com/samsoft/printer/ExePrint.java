package com.samsoft.printer;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.Sides;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.printing.PDFPageable;

public class ExePrint {

	/**
	 * Make the doc name in print pool
	   set other attributes
	   do the print
	   state check-------> return passed or failed
	   
	   return 
	    0 = printing/success
	   -1 = print paused or printer not connected
	   -2 = status code not recognized yet
	   -3 = pdf password protected
	   -4 = Can't Retrieve file from temp folder
	   -5 = Exception occurred while starting printing
	   -6 = Document couldn't find from print pool
	   
	 */
	public static int print(String dirPath,String owner,String docID,String printerName,String orientation,Boolean singleSided,Integer copyCount) {
		
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(null, null);
		PrintService selectedPrintService = null;
		for(PrintService p :printService) {
			if(printerName.equals(p.getName())) {
				selectedPrintService = p;
			}
		}
		
		PDDocument document=null;
		
		try {
			document = PDDocument.load(new File(dirPath));
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			return -3;
		} catch (IOException e) {
			e.printStackTrace();
			return -4;
		}
		
		
		PrinterJob job = PrinterJob.getPrinterJob();
        job.setPageable(new PDFPageable(document));
        
        
        try {
        	job.setPrintService(selectedPrintService);


        	PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        	JobName jobName = new JobName(owner+"_"+docID, null);
        	attributeSet.add(jobName);

        	
        	Copies p = new Copies(copyCount);
        	attributeSet.add(p);

        	if(singleSided) {
        		attributeSet.add(Sides.ONE_SIDED);
        	}else {
        	    attributeSet.add(Sides.DUPLEX);	
        	}
        	if(orientation.equalsIgnoreCase("landscape")) {
        	    attributeSet.add(OrientationRequested.LANDSCAPE);
        	}else {
        		attributeSet.add(OrientationRequested.PORTRAIT);
        	}

        	job.print(attributeSet);
		} catch (PrinterException e) {
			e.printStackTrace();
			return -5;
		}
		
        // check the print pool for submitted print
        
        Printer pr = new Printer();
        List<PrintJob> pj = pr.getJobsof(printerName);
        for(PrintJob p : pj) {
        	if(p.getDocumentName().equals(owner+"_"+docID)) {
        		if(p.getStatusInt()==0) {
        			//print paused or printer not connected
        			return -1;
        		}else if(p.getStatusInt()==8208){
        			//printing
        			return 0;
        		}else {
        			//status code not recognized yet
        			return -2;
        		}
        	}
        }
        return -6;
	}
}
