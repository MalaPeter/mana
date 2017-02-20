package com.mana.pojo;

import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Htpinpai entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mana.pojo.Htpinpai
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HtpinpaiDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HtpinpaiDAO.class);
	// property constants
	public static final String BIANHAO = "bianhao";
	public static final String DAILI = "daili";
	public static final String KEHUNAME = "kehuname";
	public static final String PRICE = "price";
	public static final String HANGYE = "hangye";
	public static final String MEITI = "meiti";
	public static final String ISSHENPI = "isshenpi";
	public static final String ISSHENHE = "isshenhe";
	public static final String ISZUOFEI = "iszuofei";
	public static final String CI = "ci";
	public static final String USERNAME = "username";
	public static final String KFUSER = "kfuser";
	public static final String SHENPIUSER = "shenpiuser";
	public static final String SHENPIREMARK = "shenpiremark";
	public static final String SHENHEREMARK = "shenheremark";
	public static final String JIANMIAN = "jianmian";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Htpinpai transientInstance) {
		log.debug("saving Htpinpai instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Htpinpai persistentInstance) {
		log.debug("deleting Htpinpai instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Htpinpai findById(java.lang.Integer id) {
		log.debug("getting Htpinpai instance with id: " + id);
		try {
			Htpinpai instance = (Htpinpai) getCurrentSession().get(
					"com.mana.pojo.Htpinpai", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Htpinpai> findByExample(Htpinpai instance) {
		log.debug("finding Htpinpai instance by example");
		try {
			List<Htpinpai> results = (List<Htpinpai>) getCurrentSession()
					.createCriteria("com.mana.pojo.Htpinpai")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Htpinpai instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Htpinpai as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Htpinpai> findByBianhao(Object bianhao) {
		return findByProperty(BIANHAO, bianhao);
	}

	public List<Htpinpai> findByDaili(Object daili) {
		return findByProperty(DAILI, daili);
	}

	public List<Htpinpai> findByKehuname(Object kehuname) {
		return findByProperty(KEHUNAME, kehuname);
	}

	public List<Htpinpai> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<Htpinpai> findByHangye(Object hangye) {
		return findByProperty(HANGYE, hangye);
	}

	public List<Htpinpai> findByMeiti(Object meiti) {
		return findByProperty(MEITI, meiti);
	}

	public List<Htpinpai> findByIsshenpi(Object isshenpi) {
		return findByProperty(ISSHENPI, isshenpi);
	}

	public List<Htpinpai> findByIsshenhe(Object isshenhe) {
		return findByProperty(ISSHENHE, isshenhe);
	}

	public List<Htpinpai> findByIszuofei(Object iszuofei) {
		return findByProperty(ISZUOFEI, iszuofei);
	}

	public List<Htpinpai> findByCi(Object ci) {
		return findByProperty(CI, ci);
	}

	public List<Htpinpai> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<Htpinpai> findByKfuser(Object kfuser) {
		return findByProperty(KFUSER, kfuser);
	}

	public List<Htpinpai> findByShenpiuser(Object shenpiuser) {
		return findByProperty(SHENPIUSER, shenpiuser);
	}

	public List<Htpinpai> findByShenpiremark(Object shenpiremark) {
		return findByProperty(SHENPIREMARK, shenpiremark);
	}

	public List<Htpinpai> findByShenheremark(Object shenheremark) {
		return findByProperty(SHENHEREMARK, shenheremark);
	}

	public List<Htpinpai> findByJianmian(Object jianmian) {
		return findByProperty(JIANMIAN, jianmian);
	}

	public List findAll() {
		log.debug("finding all Htpinpai instances");
		try {
			String queryString = "from Htpinpai";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Htpinpai merge(Htpinpai detachedInstance) {
		log.debug("merging Htpinpai instance");
		try {
			Htpinpai result = (Htpinpai) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Htpinpai instance) {
		log.debug("attaching dirty Htpinpai instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Htpinpai instance) {
		log.debug("attaching clean Htpinpai instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HtpinpaiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HtpinpaiDAO) ctx.getBean("HtpinpaiDAO");
	}
	/**
	 * 自定义功能
	 * 模糊查询
	 * @param 客户名称 kehuname
	 */
	public List<Htpinpai> vague_findByBianhao(String kehuname) {
		String queryString = "from Htpinpai as model where model.kehuname like '%" + kehuname +"%'";
		Query queryObject = getCurrentSession().createQuery(queryString);
		return queryObject.list();
	}
}