package com.mana.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Qianzhiyewu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "qianzhiyewu", catalog = "mana")
public class Qianzhiyewu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private Timestamp ctime;
	private Integer shixiao;
	private String kehuname;
	private String kehulianxiren;
	private String kehuzhiwu;
	private String kehutel;
	private String kehudizhi;
	private String kehuleixing;
	private Integer islock;
	private String piyu;
	private String hangye;
	private String type;

	// Constructors

	/** default constructor */
	public Qianzhiyewu() {
	}

	/** full constructor */
	public Qianzhiyewu(String username, Timestamp ctime, Integer shixiao,
			String kehuname, String kehulianxiren, String kehuzhiwu,
			String kehutel, String kehudizhi, String kehuleixing,
			Integer islock, String piyu, String hangye, String type) {
		this.username = username;
		this.ctime = ctime;
		this.shixiao = shixiao;
		this.kehuname = kehuname;
		this.kehulianxiren = kehulianxiren;
		this.kehuzhiwu = kehuzhiwu;
		this.kehutel = kehutel;
		this.kehudizhi = kehudizhi;
		this.kehuleixing = kehuleixing;
		this.islock = islock;
		this.piyu = piyu;
		this.hangye = hangye;
		this.type = type;
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

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "ctime", length = 19)
	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	@Column(name = "shixiao")
	public Integer getShixiao() {
		return this.shixiao;
	}

	public void setShixiao(Integer shixiao) {
		this.shixiao = shixiao;
	}

	@Column(name = "kehuname")
	public String getKehuname() {
		return this.kehuname;
	}

	public void setKehuname(String kehuname) {
		this.kehuname = kehuname;
	}

	@Column(name = "kehulianxiren")
	public String getKehulianxiren() {
		return this.kehulianxiren;
	}

	public void setKehulianxiren(String kehulianxiren) {
		this.kehulianxiren = kehulianxiren;
	}

	@Column(name = "kehuzhiwu")
	public String getKehuzhiwu() {
		return this.kehuzhiwu;
	}

	public void setKehuzhiwu(String kehuzhiwu) {
		this.kehuzhiwu = kehuzhiwu;
	}

	@Column(name = "kehutel")
	public String getKehutel() {
		return this.kehutel;
	}

	public void setKehutel(String kehutel) {
		this.kehutel = kehutel;
	}

	@Column(name = "kehudizhi")
	public String getKehudizhi() {
		return this.kehudizhi;
	}

	public void setKehudizhi(String kehudizhi) {
		this.kehudizhi = kehudizhi;
	}

	@Column(name = "kehuleixing")
	public String getKehuleixing() {
		return this.kehuleixing;
	}

	public void setKehuleixing(String kehuleixing) {
		this.kehuleixing = kehuleixing;
	}

	@Column(name = "islock")
	public Integer getIslock() {
		return this.islock;
	}

	public void setIslock(Integer islock) {
		this.islock = islock;
	}

	@Column(name = "piyu")
	public String getPiyu() {
		return this.piyu;
	}

	public void setPiyu(String piyu) {
		this.piyu = piyu;
	}

	@Column(name = "hangye")
	public String getHangye() {
		return this.hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}