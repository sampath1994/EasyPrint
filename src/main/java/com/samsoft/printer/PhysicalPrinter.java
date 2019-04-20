package com.samsoft.printer;

public class PhysicalPrinter {

	private String printerName;
	private Boolean colored;
	private String printerType;
	private Boolean online;

	
	public Boolean getOnline() {
		return online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	public String getPrinterName() {
		return printerName;
	}
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}
	public Boolean getColored() {
		return colored;
	}
	public void setColored(Boolean colored) {
		this.colored = colored;
	}
	public String getPrinterType() {
		return printerType;
	}
	public void setPrinterType(String printerType) {
		this.printerType = printerType;
	}
}
