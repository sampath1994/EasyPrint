package com.samsoft.printer;

import java.io.Serializable;

public class PhysicalPrinter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String printerName;
	private Boolean colored;
	private String printerType;
	private Boolean online;

	
	
	public PhysicalPrinter(String printerName, Boolean colored, String printerType) {
		super();
		this.printerName = printerName;
		this.colored = colored;
		this.printerType = printerType;
	}
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
	
	@Override
	public String toString() {
		return "PhysicalPrinter [printerName=" + printerName + ", colored=" + colored + ", printerType=" + printerType +"]";
	}
}
