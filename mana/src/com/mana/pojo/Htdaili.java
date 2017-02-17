package com.mana.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Htdaili entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "htdaili", catalog = "mana")
public class Htdaili implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bianhao;
	private Date cdate;
	private String daili;
	private String kehuname;
	private Integer price;
	private String hangye;
	private String meiti;
	private String isshenpi;
	private String isshenhe;
	private String ci;
	private String username;
	private String kfuser;
	private String shenpiuser;

	// Constructors

	/** default constructor */
	public Htdaili() {
	}

	/** full constructor */
	public Htdaili(String bianhao, Date cdate, String daili, String kehuname,
			Integer price, String hangye, String meiti, String isshenpi,
			String isshenhe, String ci, String username, String kfuser,
			String shenpiuser) {
		this.bianhao = bianhao;
		this.cdate = cdate;
		this.daili = daili;
		this.kehuname = kehuname;
		this.price = price;
		this.hangye = hangye;
		this.meiti = meiti;
		this.isshenpi = isshenpi;
		this.isshenhe = isshenhe;
		this.ci = ci;
		this.username = username;
		this.kfuser = kfuser;
		this.shenpiuser = shenpiuser;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "cdate", length = 10)
	public Date getCdate() {
		return this.cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	@Column(name = "daili")
	public String getDaili() {
		return this.daili;
	}

	public void setDaili(String daili) {
		this.daili = daili;
	}

	@Column(name = "kehuname")
	public String getKehuname() {
		return this.kehuname;
	}

	public void setKehuname(String kehuname) {
		this.kehuname = kehuname;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "hangye")
	public String getHangye() {
		return this.hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
	}

	@Column(name = "meiti")
	public String getMeiti() {
		return this.meiti;
	}

	public void setMeiti(String meiti) {
		this.meiti = meiti;
	}

	@Column(name = "isshenpi")
	public String getIsshenpi() {
		return this.isshenpi;
	}

	public void setIsshenpi(String isshenpi) {
		this.isshenpi = isshenpi;
	}

	@Column(name = "isshenhe")
	public String getIsshenhe() {
		return this.isshenhe;
	}

	public void setIsshenhe(String isshenhe) {
		this.isshenhe = isshenhe;
	}

	@Column(name = "ci")
	public String getCi() {
		return this.ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "kfuser")
	public String getKfuser() {
		return this.kfuser;
	}

	public void setKfuser(String kfuser) {
		this.kfuser = kfuser;
	}

	@Column(name = "shenpiuser")
	public String getShenpiuser() {
		return this.shenpiuser;
	}

	public void setShenpiuser(String shenpiuser) {
		this.shenpiuser = shenpiuser;
	}

}