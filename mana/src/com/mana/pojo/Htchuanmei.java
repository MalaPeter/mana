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
 * Htchuanmei entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "htchuanmei", catalog = "mana")
public class Htchuanmei implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bianhao;
	private String kehuname;
	private String hangye;
	private Date cdate;
	private Date sdate;
	private Date edate;
	private String nodate;
	private String meiti;
	private String guige;
	private String shiduan;
	private String zhekou;
	private Integer bochutianshu;
	private Integer bochucishu;
	private Integer price;
	private Date fkyddate;
	private Date fkdate;
	private String fkfangshi;
	private String beizhu;
	private String islock;
	private String ispay;
	private String istingbo;
	private String username;
	private String isedit;
	private String zuofei;
	private String iszengsong;
	private String zsshiduan;
	private String kfbeizhu;
	private String kfuser;
	private String shenpiuser;
	private String pinming;

	// Constructors

	/** default constructor */
	public Htchuanmei() {
	}

	/** full constructor */
	public Htchuanmei(String bianhao, String kehuname, String hangye,
			Date cdate, Date sdate, Date edate, String nodate, String meiti,
			String guige, String shiduan, String zhekou, Integer bochutianshu,
			Integer bochucishu, Integer price, Date fkyddate, Date fkdate,
			String fkfangshi, String beizhu, String islock, String ispay,
			String istingbo, String username, String isedit, String zuofei,
			String iszengsong, String zsshiduan, String kfbeizhu,
			String kfuser, String shenpiuser, String pinming) {
		this.bianhao = bianhao;
		this.kehuname = kehuname;
		this.hangye = hangye;
		this.cdate = cdate;
		this.sdate = sdate;
		this.edate = edate;
		this.nodate = nodate;
		this.meiti = meiti;
		this.guige = guige;
		this.shiduan = shiduan;
		this.zhekou = zhekou;
		this.bochutianshu = bochutianshu;
		this.bochucishu = bochucishu;
		this.price = price;
		this.fkyddate = fkyddate;
		this.fkdate = fkdate;
		this.fkfangshi = fkfangshi;
		this.beizhu = beizhu;
		this.islock = islock;
		this.ispay = ispay;
		this.istingbo = istingbo;
		this.username = username;
		this.isedit = isedit;
		this.zuofei = zuofei;
		this.iszengsong = iszengsong;
		this.zsshiduan = zsshiduan;
		this.kfbeizhu = kfbeizhu;
		this.kfuser = kfuser;
		this.shenpiuser = shenpiuser;
		this.pinming = pinming;
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

	@Column(name = "kehuname")
	public String getKehuname() {
		return this.kehuname;
	}

	public void setKehuname(String kehuname) {
		this.kehuname = kehuname;
	}

	@Column(name = "hangye")
	public String getHangye() {
		return this.hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "cdate", length = 10)
	public Date getCdate() {
		return this.cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
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

	@Column(name = "nodate")
	public String getNodate() {
		return this.nodate;
	}

	public void setNodate(String nodate) {
		this.nodate = nodate;
	}

	@Column(name = "meiti")
	public String getMeiti() {
		return this.meiti;
	}

	public void setMeiti(String meiti) {
		this.meiti = meiti;
	}

	@Column(name = "guige")
	public String getGuige() {
		return this.guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	@Column(name = "shiduan")
	public String getShiduan() {
		return this.shiduan;
	}

	public void setShiduan(String shiduan) {
		this.shiduan = shiduan;
	}

	@Column(name = "zhekou")
	public String getZhekou() {
		return this.zhekou;
	}

	public void setZhekou(String zhekou) {
		this.zhekou = zhekou;
	}

	@Column(name = "bochutianshu")
	public Integer getBochutianshu() {
		return this.bochutianshu;
	}

	public void setBochutianshu(Integer bochutianshu) {
		this.bochutianshu = bochutianshu;
	}

	@Column(name = "bochucishu")
	public Integer getBochucishu() {
		return this.bochucishu;
	}

	public void setBochucishu(Integer bochucishu) {
		this.bochucishu = bochucishu;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fkyddate", length = 10)
	public Date getFkyddate() {
		return this.fkyddate;
	}

	public void setFkyddate(Date fkyddate) {
		this.fkyddate = fkyddate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fkdate", length = 10)
	public Date getFkdate() {
		return this.fkdate;
	}

	public void setFkdate(Date fkdate) {
		this.fkdate = fkdate;
	}

	@Column(name = "fkfangshi")
	public String getFkfangshi() {
		return this.fkfangshi;
	}

	public void setFkfangshi(String fkfangshi) {
		this.fkfangshi = fkfangshi;
	}

	@Column(name = "beizhu")
	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	@Column(name = "islock")
	public String getIslock() {
		return this.islock;
	}

	public void setIslock(String islock) {
		this.islock = islock;
	}

	@Column(name = "ispay")
	public String getIspay() {
		return this.ispay;
	}

	public void setIspay(String ispay) {
		this.ispay = ispay;
	}

	@Column(name = "istingbo")
	public String getIstingbo() {
		return this.istingbo;
	}

	public void setIstingbo(String istingbo) {
		this.istingbo = istingbo;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "isedit")
	public String getIsedit() {
		return this.isedit;
	}

	public void setIsedit(String isedit) {
		this.isedit = isedit;
	}

	@Column(name = "zuofei")
	public String getZuofei() {
		return this.zuofei;
	}

	public void setZuofei(String zuofei) {
		this.zuofei = zuofei;
	}

	@Column(name = "iszengsong")
	public String getIszengsong() {
		return this.iszengsong;
	}

	public void setIszengsong(String iszengsong) {
		this.iszengsong = iszengsong;
	}

	@Column(name = "zsshiduan")
	public String getZsshiduan() {
		return this.zsshiduan;
	}

	public void setZsshiduan(String zsshiduan) {
		this.zsshiduan = zsshiduan;
	}

	@Column(name = "kfbeizhu")
	public String getKfbeizhu() {
		return this.kfbeizhu;
	}

	public void setKfbeizhu(String kfbeizhu) {
		this.kfbeizhu = kfbeizhu;
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

	@Column(name = "pinming")
	public String getPinming() {
		return this.pinming;
	}

	public void setPinming(String pinming) {
		this.pinming = pinming;
	}

}