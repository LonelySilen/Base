package com.silen.entity.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Admin implements Serializable {
	private Integer id;
	private String usn;
	private String pwd;
	private String name;
	private String mobile;
	private String cover;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer id, String usn, String pwd, String name, String mobile, String cover) {
		super();
		this.id = id;
		this.usn = usn;
		this.pwd = pwd;
		this.name = name;
		this.mobile = mobile;
		this.cover = cover;
	}

	public Admin(String usn, String pwd, String name, String mobile, String cover) {
		super();
		this.usn = usn;
		this.pwd = pwd;
		this.name = name;
		this.mobile = mobile;
		this.cover = cover;
	}
}
