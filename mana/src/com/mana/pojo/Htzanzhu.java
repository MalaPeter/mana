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
 * Htzanzhu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "htzanzhu", catalog = "mana")
public class Htzanzhu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bianhao;
	private Date cadate;
	private String kehuname;
	private String meiti;
	private String hangye;
	private String isshenpi;
	private String isshenhe;
	private String iszuofei;
	private String ci;
	private String username;
	private String kfuser;
	private Date sdate;
	private Date edate;
	private String zhekoudaili;
	private String zhekou;
	private String shour;
	private String sminute;
	private String ehour;
	private String eminute;
	private String jiemu0;
	private String jiemu6;
	private String jiemu7;
	private String zhuprice;
	private String ziprice;
	private String price;

	// Constructors

	/** default constructor */
	public Htzanzhu() {
	}

	/** full constructor */
	public Htzanzhu(String bianhao, Date cadate, String kehuname, String meiti,
			String hangye, String isshenpi, String isshenhe, String iszuofei,
			String ci, String username, String kfuser, Date sdate, Date edate,
			String zhekoudaili, String zhekou, String shour, String sminute,
			String ehour, String eminute, String jiemu0, String jiemu6,
			String jiemu7, String zhuprice, String ziprice, String price) {
		this.bianhao = bianhao;
		this.cadate = cadate;
		this.kehuname = kehuname;
		this.meiti = meiti;
		this.hangye = hangye;
		this.isshenpi = isshenpi;
		this.isshenhe = isshenhe;
		this.iszuofei = iszuofei;
		this.ci = ci;
		this.username = username;
		this.kfuser = kfuser;
		this.sdate = sdate;
		this.edate = edate;
		this.zhekoudaili = zhekoudaili;
		this.zhekou = zhekou;
		this.shour = shour;
		this.sminute = sminute;
		this.ehour = ehour;
		this.eminute = eminute;
		this.jiemu0 = jiemu0;
		this.jiemu6 = jiemu6;
		this.jiemu7 = jiemu7;
		this.zhuprice = zhuprice;
		this.ziprice = ziprice;
		this.price = price;
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
	@Column(name = "cadate", length = 10)
	public Date getCadate() {
		return this.cadate;
	}

	public void setCadate(Date cadate) {
		this.cadate = cadate;
	}

	@Column(name = "kehuname")
	public String getKehuname() {
		return this.kehuname;
	}

	public void setKehuname(String kehuname) {
		this.kehuname = kehuname;
	}

	@Column(name = "meiti")
	public String getMeiti() {
		return this.meiti;
	}

	public void setMeiti(String meiti) {
		this.meiti = meiti;
	}

	@Column(name = "hangye")
	public String getHangye() {
		return this.hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
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

	@Column(name = "zhekoudaili")
	public String getZhekoudaili() {
		return this.zhekoudaili;
	}

	public void setZhekoudaili(String zhekoudaili) {
		this.zhekoudaili = zhekoudaili;
	}

	@Column(name = "zhekou")
	public String getZhekou() {
		return this.zhekou;
	}

	public void setZhekou(String zhekou) {
		this.zhekou = zhekou;
	}

	@Column(name = "shour")
	public String getShour() {
		return this.shour;
	}

	public void setShour(String shour) {
		this.shour = shour;
	}

	@Column(name = "sminute")
	public String getSminute() {
		return this.sminute;
	}

	public void setSminute(String sminute) {
		this.sminute = sminute;
	}

	@Column(name = "ehour")
	public String getEhour() {
		return this.ehour;
	}

	public void setEhour(String ehour) {
		this.ehour = ehour;
	}

	@Column(name = "eminute")
	public String getEminute() {
		return this.eminute;
	}

	public void setEminute(String eminute) {
		this.eminute = eminute;
	}

	@Column(name = "jiemu0")
	public String getJiemu0() {
		return this.jiemu0;
	}

	public void setJiemu0(String jiemu0) {
		this.jiemu0 = jiemu0;
	}

	@Column(name = "jiemu6")
	public String getJiemu6() {
		return this.jiemu6;
	}

	public void setJiemu6(String jiemu6) {
		this.jiemu6 = jiemu6;
	}

	@Column(name = "jiemu7")
	public String getJiemu7() {
		return this.jiemu7;
	}

	public void setJiemu7(String jiemu7) {
		this.jiemu7 = jiemu7;
	}

	@Column(name = "zhuprice")
	public String getZhuprice() {
		return this.zhuprice;
	}

	public void setZhuprice(String zhuprice) {
		this.zhuprice = zhuprice;
	}

	@Column(name = "ziprice")
	public String getZiprice() {
		return this.ziprice;
	}

	public void setZiprice(String ziprice) {
		this.ziprice = ziprice;
	}

	@Column(name = "price")
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}