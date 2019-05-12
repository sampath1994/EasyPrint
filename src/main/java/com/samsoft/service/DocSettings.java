package com.samsoft.service;

public class DocSettings {

	private int id;
	private String owner;
	private String time;
	private String fileLink;
	private Boolean colored;
	private Integer copyCount;
	private Boolean singleSided;
	private String orientation;
	private String printerType;
	
	
	
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
	public Boolean getColored() {
		return colored;
	}
	public void setColored(Boolean colored) {
		this.colored = colored;
	}
	public Integer getCopyCount() {
		return copyCount;
	}
	public void setCopyCount(Integer copyCount) {
		this.copyCount = copyCount;
	}
	public Boolean getSingleSided() {
		return singleSided;
	}
	public void setSingleSided(Boolean singleSided) {
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
