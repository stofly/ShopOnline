package com.so.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	@Column(name = "username", length = 20)
	private String username;
	@Column(name = "password", length = 20)
	private String password;
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "email", length = 30)
	private String email;
	@Column(name = "telephone", length = 20)
	private String telephone;
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "sex", length = 10)
	private String sex;
	@Column(name = "state")
	private Integer state; // #状态：0=未激活，1=已激活
	@Column(name = "code", length = 64)
	private String code; // #激活码

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", telephone=" + telephone + ", birthday=" + birthday + ", sex=" + sex + ", state=" + state
				+ ", code=" + code + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getName()=" + getName() + ", getEmail()=" + getEmail() + ", getTelephone()=" + getTelephone()
				+ ", getBirthday()=" + getBirthday() + ", getSex()=" + getSex() + ", getState()=" + getState()
				+ ", getCode()=" + getCode() + ", getUid()=" + getUid() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}