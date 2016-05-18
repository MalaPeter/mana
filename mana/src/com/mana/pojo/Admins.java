package com.mana.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admins entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admins", catalog = "mana")
public class Admins implements java.io.Serializable {

	// Fields

	private Integer id;
	private String adminname;
	private String adminpass;
	private String department;
	private String ip;
	private String nickname;
	private Integer rliulan;
	private Integer rluru;
	private Integer rshenhe;
	private Integer rshenpi;
	private Integer rhuakuan;
	private Integer rtingbo;
	private Integer rtongji;
	private Integer rsys;
	private String islock;

	// Constructors

	/** default constructor */
	public Admins() {
	}

	/** full constructor */
	public Admins(String adminname, String adminpass, String department,
			String ip, String nickname, Integer rliulan, Integer rluru,
			Integer rshenhe, Integer rshenpi, Integer rhuakuan,
			Integer rtingbo, Integer rtongji, Integer rsys, String islock) {
		this.adminname = adminname;
		this.adminpass = adminpass;
		this.department = department;
		this.ip = ip;
		this.nickname = nickname;
		this.rliulan = rliulan;
		this.rluru = rluru;
		this.rshenhe = rshenhe;
		this.rshenpi = rshenpi;
		this.rhuakuan = rhuakuan;
		this.rtingbo = rtingbo;
		this.rtongji = rtongji;
		this.rsys = rsys;
		this.islock = islock;
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

	@Column(name = "adminname")
	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	@Column(name = "adminpass")
	public String getAdminpass() {
		return this.adminpass;
	}

	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}

	@Column(name = "department")
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "ip")
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "nickname")
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "rliulan")
	public Integer getRliulan() {
		return this.rliulan;
	}

	public void setRliulan(Integer rliulan) {
		this.rliulan = rliulan;
	}

	@Column(name = "rluru")
	public Integer getRluru() {
		return this.rluru;
	}

	public void setRluru(Integer rluru) {
		this.rluru = rluru;
	}

	@Column(name = "rshenhe")
	public Integer getRshenhe() {
		return this.rshenhe;
	}

	public void setRshenhe(Integer rshenhe) {
		this.rshenhe = rshenhe;
	}

	@Column(name = "rshenpi")
	public Integer getRshenpi() {
		return this.rshenpi;
	}

	public void setRshenpi(Integer rshenpi) {
		this.rshenpi = rshenpi;
	}

	@Column(name = "rhuakuan")
	public Integer getRhuakuan() {
		return this.rhuakuan;
	}

	public void setRhuakuan(Integer rhuakuan) {
		this.rhuakuan = rhuakuan;
	}

	@Column(name = "rtingbo")
	public Integer getRtingbo() {
		return this.rtingbo;
	}

	public void setRtingbo(Integer rtingbo) {
		this.rtingbo = rtingbo;
	}

	@Column(name = "rtongji")
	public Integer getRtongji() {
		return this.rtongji;
	}

	public void setRtongji(Integer rtongji) {
		this.rtongji = rtongji;
	}

	@Column(name = "rsys")
	public Integer getRsys() {
		return this.rsys;
	}

	public void setRsys(Integer rsys) {
		this.rsys = rsys;
	}

	@Column(name = "islock")
	public String getIslock() {
		return this.islock;
	}

	public void setIslock(String islock) {
		this.islock = islock;
	}

}