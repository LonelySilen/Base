package com.silen.entity.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int id;
	private String usn;
	private String pwd;
	private String name;
	private String gender;
	private String cover;
	private String mobile;
	private String postCart;
	private String address;
	private double blance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPostCart() {
		return postCart;
	}

	public void setPostCart(String postCart) {
		this.postCart = postCart;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBlance() {
		return blance;
	}

	public void setBlance(double blance) {
		this.blance = blance;
	}

	public User(int id, String usn, String pwd, String name, String gender, String cover, String mobile,
			String postCart, String address, double blance) {
		super();
		this.id = id;
		this.usn = usn;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.cover = cover;
		this.mobile = mobile;
		this.postCart = postCart;
		this.address = address;
		this.blance = blance;
	}

	public User(String usn, String pwd, String name, String gender, String cover, String mobile, String postCart,
			String address, double blance) {
		super();
		this.usn = usn;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.cover = cover;
		this.mobile = mobile;
		this.postCart = postCart;
		this.address = address;
		this.blance = blance;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
