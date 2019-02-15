package com.so.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@Column(length = 64)
	private String oid; // 订单编号
	@Column(name = "total")
	private double total; // 总计
	@Column(name = "states", length = 11)
	private int states; // 状态
	@Column(name = "address", length = 20)
	private String address; // 收货人地址
	@Column(name = "name", length = 30)
	private String name; // 收货人姓名
	@Column(name = "telephone", length = 20)
	private String telephone; // 收货人电话
	@Temporal(TemporalType.DATE)
	@Column(name = "ordertime")
	private Date ordertime; // 下单时间
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "uid")
	private User user;
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "oid")
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", total=" + total + ", states=" + states + ", address=" + address + ", name="
				+ name + ", telephone=" + telephone + ", ordertime=" + ordertime + ", user=" + user + ", orderItems="
				+ orderItems + "]";
	}

}