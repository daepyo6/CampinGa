package com.campinga.dto;

import java.sql.Timestamp;

public class NoticeVO {
	private Integer nseq;
	private String aid;
	private String subject;
	private String content;
	private Timestamp indate;
	
	public Integer getNseq() {
		return nseq;
	}
	public void setNseq(Integer nseq) {
		this.nseq = nseq;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
