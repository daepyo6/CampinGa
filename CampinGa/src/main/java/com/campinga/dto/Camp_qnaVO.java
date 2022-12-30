package com.campinga.dto;

import java.sql.Timestamp;

public class Camp_qnaVO {
	private Integer qseq;
	private String mid;
	private Integer bseq;
	private String content;
	private Timestamp indate;
	private String reply;
	private String repyn;
	
	public Integer getQseq() {
		return qseq;
	}
	public void setQseq(Integer qseq) {
		this.qseq = qseq;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRepyn() {
		return repyn;
	}
	public void setRepyn(String repyn) {
		this.repyn = repyn;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	
	
}
