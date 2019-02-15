package com.so.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid; // 商品编号
	@Column(name = "pname", length = 50)
	private String pname; // 商品名称
	@Column(name = "marketprice")
	private double marketprice;// 商品市场价格
	@Column(name = "shopprice")
	private double shopprice;// 商品商场价格
	@Column(name = "pimage", length = 200)
	private String pimage;// 商品图片路径
	@Column(name = "pdate")
	@Temporal(TemporalType.DATE)
	private Date pdate;// 商品上架日期
	@Column(name = "ishot")
	private int ishot;// 商品是否热门
	@Column(name = "pdesc", length = 255)
	private String pdesc;// 商品描述
	@Column(name = "pflag")
	private int pflag;// 商品是否在货架 上 0:在货架上 1:下架
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid")
	private Category category;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(double marketprice) {
		this.marketprice = marketprice;
	}

	public double getShopprice() {
		return shopprice;
	}

	public void setShopprice(double shopprice) {
		this.shopprice = shopprice;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public int getIshot() {
		return ishot;
	}

	public void setIshot(int ishot) {
		this.ishot = ishot;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public int getPflag() {
		return pflag;
	}

	public void setPflag(int pflag) {
		this.pflag = pflag;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", marketprice=" + marketprice + ", shopprice=" + shopprice
				+ ", pimage=" + pimage + ", pdate=" + pdate + ", ishot=" + ishot + ", pdesc=" + pdesc + ", pflag="
				+ pflag + ", category=" + category + "]";
	}

}
