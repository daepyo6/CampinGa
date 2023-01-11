package com.campinga.dto;

public class BusinessmanVO {
	private Integer bseq;
	private String bid;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String cname;
	private String caddress1;	// 전체, 특별시, 도
	private String caddress2;	// 시, 군
	private String caddress3;	// 세부주소
	private String facilities;
	private String image;
	private String content;
	private String category;
	
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
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
	
	
	
}
