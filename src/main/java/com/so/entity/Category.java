package com.so.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	// 商品分类名称表主键id
	@Id
	@Column(name = "cid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	// 分类名称
	@Column(name = "cname", length = 20)
	private String cname;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}

}
