package com.mana.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Htdaililog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "htdaililog", catalog = "mana")
public class Htdaililog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bianhao;
	private String shiduan;
	private String guige;
	private Integer kanlijia;
	private String zhekou;
	private Float jingjia;
	private Integer tianshu;
	private Float zongjingjia;
	private String zriqi;

	// Constructors

	/** default constructor */
	public Htdaililog() {
	}

	/** full constructor */
	public Htdaililog(String bianhao, String shiduan, String guige,
			Integer kanlijia, String zhekou, Float jingjia, Integer tianshu,
			Float zongjingjia, String zriqi) {
		this.bianhao = bianhao;
		this.shiduan = shiduan;
		this.guige = guige;
		this.kanlijia = kanlijia;
		this.zhekou = zhekou;
		this.jingjia = jingjia;
		this.tianshu = tianshu;
		this.zongjingjia = zongjingjia;
		this.zriqi = zriqi;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "bianhao")
	public String getBianhao() {
		return this.bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	@Column(name = "shiduan")
	public String getShiduan() {
		return this.shiduan;
	}

	public void setShiduan(String shiduan) {
		this.shiduan = shiduan;
	}

	@Column(name = "guige")
	public String getGuige() {
		return this.guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	@Column(name = "kanlijia")
	public Integer getKanlijia() {
		return this.kanlijia;
	}

	public void setKanlijia(Integer kanlijia) {
		this.kanlijia = kanlijia;
	}

	@Column(name = "zhekou", length = 11)
	public String getZhekou() {
		return this.zhekou;
	}

	public void setZhekou(String zhekou) {
		this.zhekou = zhekou;
	}

	@Column(name = "jingjia", precision = 11, scale = 0)
	public Float getJingjia() {
		return this.jingjia;
	}

	public void setJingjia(Float jingjia) {
		this.jingjia = jingjia;
	}

	@Column(name = "tianshu")
	public Integer getTianshu() {
		return this.tianshu;
	}

	public void setTianshu(Integer tianshu) {
		this.tianshu = tianshu;
	}

	@Column(name = "zongjingjia", precision = 11, scale = 0)
	public Float getZongjingjia() {
		return this.zongjingjia;
	}

	public void setZongjingjia(Float zongjingjia) {
		this.zongjingjia = zongjingjia;
	}

	@Column(name = "zriqi")
	public String getZriqi() {
		return this.zriqi;
	}

	public void setZriqi(String zriqi) {
		this.zriqi = zriqi;
	}

}