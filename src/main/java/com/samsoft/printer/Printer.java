package com.samsoft.printer;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.Winspool;
import com.sun.jna.platform.win32.WinspoolUtil;

public class Printer {

	private List<String> activePrinters;
	private List<String> allPrinters;
	private List<PrintJob> printJobs;


	Printer(){
		allPrinters = new ArrayList<>();
		Winspool.PRINTER_INFO_4[] printers = WinspoolUtil.getPrinterInfo4();
		for (Winspool.PRINTER_INFO_4 printer : printers) {  
			allPrinters.add(printer.pPrinterName);
		}

	}

	public List<String> getAllPrinters(){
		return allPrinters;
	}
	
	public List<PrintJob> getJobsof(String printerName) {
		WinNT.HANDLEByReference phPrinter2 = new WinNT.HANDLEByReference();
		boolean opened2 = Winspool.INSTANCE.OpenPrinter(
			printerName,
		    phPrinter2,
		    null
		);
		
		if (!opened2) {
		    return null;
		}
		
		printJobs = new ArrayList<PrintJob>();
		
		Winspool.JOB_INFO_1[] jobs2 = WinspoolUtil.getJobInfo1(phPrinter2);
		for (Winspool.JOB_INFO_1 job : jobs2) {
			
			PrintJob pj = new PrintJob();
			pj.setDocumentName(job.pDocument);
			pj.setJobOwnerName(job.pUserName);
			pj.setPagesPrinted(job.PagesPrinted);
			pj.setTotalPages(job.TotalPages);
			
			printJobs.add(pj);

		}
		return printJobs;
	}
}
