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
 * Htdaili entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mana.pojo.Htdaili
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HtdailiDAO {
	private static final Logger log = LoggerFactory.getLogger(HtdailiDAO.class);
	// property constants
	public static final String BIANHAO = "bianhao";
	public static final String DAILI = "daili";
	public static final String KEHUNAME = "kehuname";
	public static final String PRICE = "price";
	public static final String HANGYE = "hangye";
	public static final String MEITI = "meiti";
	public static final String ISSHENPI = "isshenpi";
	public static final String ISSHENHE = "isshenhe";
	public static final String CI = "ci";
	public static final String USERNAME = "username";
	public static final String KFUSER = "kfuser";
	public static final String SHENPIUSER = "shenpiuser";

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

	public void save(Htdaili transientInstance) {
		log.debug("saving Htdaili instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Htdaili persistentInstance) {
		log.debug("deleting Htdaili instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Htdaili findById(java.lang.Integer id) {
		log.debug("getting Htdaili instance with id: " + id);
		try {
			Htdaili instance = (Htdaili) getCurrentSession().get(
					"com.mana.pojo.Htdaili", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Htdaili> findByExample(Htdaili instance) {
		log.debug("finding Htdaili instance by example");
		try {
			List<Htdaili> results = (List<Htdaili>) getCurrentSession()
					.createCriteria("com.mana.pojo.Htdaili")
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
		log.debug("finding Htdaili instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Htdaili as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Htdaili> findByBianhao(Object bianhao) {
		return findByProperty(BIANHAO, bianhao);
	}

	public List<Htdaili> findByDaili(Object daili) {
		return findByProperty(DAILI, daili);
	}

	public List<Htdaili> findByKehuname(Object kehuname) {
		return findByProperty(KEHUNAME, kehuname);
	}

	public List<Htdaili> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<Htdaili> findByHangye(Object hangye) {
		return findByProperty(HANGYE, hangye);
	}

	public List<Htdaili> findByMeiti(Object meiti) {
		return findByProperty(MEITI, meiti);
	}

	public List<Htdaili> findByIsshenpi(Object isshenpi) {
		return findByProperty(ISSHENPI, isshenpi);
	}

	public List<Htdaili> findByIsshenhe(Object isshenhe) {
		return findByProperty(ISSHENHE, isshenhe);
	}

	public List<Htdaili> findByCi(Object ci) {
		return findByProperty(CI, ci);
	}

	public List<Htdaili> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<Htdaili> findByKfuser(Object kfuser) {
		return findByProperty(KFUSER, kfuser);
	}

	public List<Htdaili> findByShenpiuser(Object shenpiuser) {
		return findByProperty(SHENPIUSER, shenpiuser);
	}

	public List findAll() {
		log.debug("finding all Htdaili instances");
		try {
			String queryString = "from Htdaili";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Htdaili merge(Htdaili detachedInstance) {
		log.debug("merging Htdaili instance");
		try {
			Htdaili result = (Htdaili) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Htdaili instance) {
		log.debug("attaching dirty Htdaili instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Htdaili instance) {
		log.debug("attaching clean Htdaili instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HtdailiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HtdailiDAO) ctx.getBean("HtdailiDAO");
	}
	
	public void deleteByBianhao(String bianhao) {
		String queryString = "delete from Htdaili as model where model.bianhao='" + bianhao +"'";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.executeUpdate();
	}
	/**
	 * 自定义功能
	 * @param 业务员名称
	 */
	public List<Htdaili> vague_findByyewuyuan() {
		String queryString = "select distinct username from Htdaili as model";// where model.username like '%" + username +"%'
		Query queryObject = getCurrentSession().createQuery(queryString);
		return queryObject.list();
	}
	/**
	 * 自定义功能
	 * @param 代理公司名称
	 */
	public List<Htdaili> vague_findDailinames() {
		String queryString = "select distinct daili from Htdaili as model";// where model.username like '%" + username +"%'
		Query queryObject = getCurrentSession().createQuery(queryString);
		return queryObject.list();
	}
	/**
	 * 自定义功能
	 * @param 客户名称
	 */
	public List<Htdaili> vague_findKehunames() {
		String queryString = "select distinct kehuname from Htdaili as model";// where model.username like '%" + username +"%'
		Query queryObject = getCurrentSession().createQuery(queryString);
		return queryObject.list();
	}
	/**
	 * 自定义功能
	 * 模糊查询
	 * @param 客户名称 kehuname
	 */
	public List<Htdaili> vague_findBykehuname(String kehuname) {
		String queryString = "from Htdaili as model where model.daili like '%" + kehuname +"%'";
		Query queryObject = getCurrentSession().createQuery(queryString);
		return queryObject.list();
	}
}