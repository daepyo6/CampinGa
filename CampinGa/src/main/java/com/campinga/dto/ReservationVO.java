package com.campinga.dto;

import java.sql.Timestamp;

public class ReservationVO {
	private Integer reseq;
	private Integer bseq;
	private Integer cseq;
	private String mid;
	private Timestamp res_date;
	private Integer price;
	private Integer people;
	private String chk_in;
	private String chk_out;
	private String cname;
	private String c_class;
	private String res_sta;
	private String bid;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getC_class() {
		return c_class;
	}
	public void setC_class(String c_class) {
		this.c_class = c_class;
	}
	public String getRes_sta() {
		return res_sta;
	}
	public void setRes_sta(String res_sta) {
		this.res_sta = res_sta;
	}
	public Integer getReseq() {
		return reseq;
	}
	public void setReseq(Integer reseq) {
		this.reseq = reseq;
	}
	public Integer getCseq() {
		return cseq;
	}
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}
	public Timestamp getRes_date() {
		return res_date;
	}
	public void setRes_date(Timestamp res_date) {
		this.res_date = res_date;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPeople() {
		return people;
	}
	public void setPeople(Integer people) {
		this.people = people;
	}
	public String getChk_in() {
		return chk_in;
	}
	public void setChk_in(String chk_in) {
		this.chk_in = chk_in;
	}
	public String getChk_out() {
		return chk_out;
	}
	public void setChk_out(String chk_out) {
		this.chk_out = chk_out;
	}
	public Integer getBseq() {
		return bseq;
	}
	public void setBseq(Integer bseq) {
		this.bseq = bseq;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	
}
