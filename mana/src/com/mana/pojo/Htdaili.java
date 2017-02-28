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
	private Float price;
	private String hangye;
	private String meiti;
	private String isshenpi;
	private String isshenhe;
	private String iszuofei;
	private String ci;
	private String username;
	private String kfuser;
	private String shenpiuser;
	private Date sdate;
	private Date edate;
	private String shenpiremark;
	private String shenheremark;
	private Float jianmian;

	// Constructors

	/** default constructor */
	public Htdaili() {
	}

	/** full constructor */
	public Htdaili(String bianhao, Date cdate, String daili, String kehuname,
			Float price, String hangye, String meiti, String isshenpi,
			String isshenhe, String iszuofei, String ci, String username,
			String kfuser, String shenpiuser, Date sdate, Date edate,
			String shenpiremark, String shenheremark, Float jianmian) {
		this.bianhao = bianhao;
		this.cdate = cdate;
		this.daili = daili;
		this.kehuname = kehuname;
		this.price = price;
		this.hangye = hangye;
		this.meiti = meiti;
		this.isshenpi = isshenpi;
		this.isshenhe = isshenhe;
		this.iszuofei = iszuofei;
		this.ci = ci;
		this.username = username;
		this.kfuser = kfuser;
		this.shenpiuser = shenpiuser;
		this.sdate = sdate;
		this.edate = edate;
		this.shenpiremark = shenpiremark;
		this.shenheremark = shenheremark;
		this.jianmian = jianmian;
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

	@Column(name = "price", precision = 11)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
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

	@Column(name = "iszuofei")
	public String getIszuofei() {
		return this.iszuofei;
	}

	public void setIszuofei(String iszuofei) {
		this.iszuofei = iszuofei;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "sdate", length = 10)
	public Date getSdate() {
		return this.sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "edate", length = 10)
	public Date getEdate() {
		return this.edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	@Column(name = "shenpiremark")
	public String getShenpiremark() {
		return this.shenpiremark;
	}

	public void setShenpiremark(String shenpiremark) {
		this.shenpiremark = shenpiremark;
	}

	@Column(name = "shenheremark")
	public String getShenheremark() {
		return this.shenheremark;
	}

	public void setShenheremark(String shenheremark) {
		this.shenheremark = shenheremark;
	}

	@Column(name = "jianmian", precision = 12, scale = 0)
	public Float getJianmian() {
		return this.jianmian;
	}

	public void setJianmian(Float jianmian) {
		this.jianmian = jianmian;
	}

}