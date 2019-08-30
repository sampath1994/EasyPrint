package com.samsoft.service;

public class DocSettings {

	private int id;
	private String owner;
	private String time;
	private String fileLink;
	private boolean colored;
	private int copyCount;
	private boolean singleSided;
	private String orientation;
	private String printerType;
	
	
	
	
	public DocSettings(int id, String owner, String time, String fileLink, boolean colored, int copyCount,
			boolean singleSided, String orientation, String printerType) {
		super();
		this.id = id;
		this.owner = owner;
		this.time = time;
		this.fileLink = fileLink;
		this.colored = colored;
		this.copyCount = copyCount;
		this.singleSided = singleSided;
		this.orientation = orientation;
		this.printerType = printerType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getFileLink() {
		return fileLink;
	}
	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}
	public boolean getColored() {
		return colored;
	}
	public void setColored(boolean colored) {
		this.colored = colored;
	}
	public int getCopyCount() {
		return copyCount;
	}
	public void setCopyCount(int copyCount) {
		this.copyCount = copyCount;
	}
	public boolean getSingleSided() {
		return singleSided;
	}
	public void setSingleSided(boolean singleSided) {
		this.singleSided = singleSided;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getPrinterType() {
		return printerType;
	}
	public void setPrinterType(String printerType) {
		this.printerType = printerType;
	}
}
