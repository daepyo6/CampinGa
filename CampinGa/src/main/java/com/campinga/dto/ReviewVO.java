package com.campinga.dto;

import java.sql.Timestamp;

public class ReviewVO {
	private Integer rseq;
	private Integer mseq;
	private Integer bseq;
	private String content;
	private	Timestamp indate;
	
	public Integer getRseq() {
		return rseq;
	}
	public void setRseq(Integer rseq) {
		this.rseq = rseq;
	}
	public Integer getMseq() {
		return mseq;
	}
	public void setMseq(Integer mseq) {
		this.mseq = mseq;
	}
	public Integer getBseq() {
		return bseq;
	}
	public void setBseq(Integer bseq) {
		this.bseq = bseq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
}
