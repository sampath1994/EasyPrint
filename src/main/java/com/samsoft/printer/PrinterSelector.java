package com.samsoft.printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.samsoft.persistence.PrinterManager;

// This is used choose relevant printer according to color,Laser or Inkjet  
public class PrinterSelector {

	List<PhysicalPrinter> pp = null;
	PrinterManager pm = null;
	
	//Initialize physicalPrinters from properties file
	
	public PrinterSelector(){
		pm = new PrinterManager();
		pp = pm.getPrinters();
	}
	
	public List<String> selectPrinter(Boolean colored, String type) {

		List<PhysicalPrinter> choosenList = new ArrayList<>();
		
		for(PhysicalPrinter p : pp) {
			if(p.getColored()&&colored)
			{
				if(p.getPrinterType().equalsIgnoreCase(type)) {
					choosenList.add(p);
				}
			}
		}
		
		if(choosenList.size()>1) {
			Map<String,Integer> jobCount = new HashMap<String,Integer>();
			
			for(PhysicalPrinter pr : choosenList) {
				Printer detailedPrinter  = new Printer();
				int jCount = detailedPrinter.getJobsof(pr.getPrinterName()).size();				
				jobCount.put(pr.getPrinterName(), jCount);
			}
			
			
			Map<String, Integer> sorted = jobCount
			        .entrySet()
			        .stream()
			        .sorted(Map.Entry.comparingByValue())
			        .collect(
			            Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
			                LinkedHashMap::new));
			
			List<String> keys = new LinkedList<String>(sorted.keySet());
			return keys;
			
		}
		
		return choosenList.stream().map(e->e.getPrinterName()).collect(Collectors.toList());
	} 
}