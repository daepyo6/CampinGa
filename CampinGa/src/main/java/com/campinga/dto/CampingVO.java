package com.campinga.dto;

import java.sql.Timestamp;

public class CampingVO {
	private Integer cseq;
	private Integer bseq;
	private String cname;
	private String facilities;
	private String image;
	private String content;
	private String category;
	private String c_class;
	private String res_sta;
	private Integer price;
	private Integer min_people;
	private Integer max_people;
	private Timestamp c_indate;
	private String caddress1;
	private String caddress2;
	private String caddress3;
	private String phone;
	
	public String getCaddress1() {
		return caddress1;
	}
	public void setCaddress1(String caddress1) {
		this.caddress1 = caddress1;
	}
	public String getCaddress2() {
		return caddress2;
	}
	public void setCaddress2(String caddress2) {
		this.caddress2 = caddress2;
	}
	public String getCaddress3() {
		return caddress3;
	}
	public void setCaddress3(String caddress3) {
		this.caddress3 = caddress3;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getCseq() {
		return cseq;
	}
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}
	public Integer getBseq() {
		return bseq;
	}
	public void setBseq(Integer bseq) {
		this.bseq = bseq;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getMin_people() {
		return min_people;
	}
	public void setMin_people(Integer min_people) {
		this.min_people = min_people;
	}
	public Integer getMax_people() {
		return max_people;
	}
	public void setMax_people(Integer max_people) {
		this.max_people = max_people;
	}
	public Timestamp getC_indate() {
		return c_indate;
	}
	public void setC_indate(Timestamp c_indate) {
		this.c_indate = c_indate;
	}
	
	
}
