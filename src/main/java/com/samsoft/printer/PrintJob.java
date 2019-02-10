package com.samsoft.printer;

public class PrintJob {

	private String documentName;
	private String jobOwnerName;
	private int totalPages;
	private int pagesPrinted;
	private boolean opened;
	
	PrintJob(){	
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getJobOwnerName() {
		return jobOwnerName;
	}

	public void setJobOwnerName(String jobOwnerName) {
		this.jobOwnerName = jobOwnerName;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPagesPrinted() {
		return pagesPrinted;
	}

	public void setPagesPrinted(int pagesPrinted) {
		this.pagesPrinted = pagesPrinted;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

}
