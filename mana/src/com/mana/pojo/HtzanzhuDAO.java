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
 * Htzanzhu entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mana.pojo.Htzanzhu
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HtzanzhuDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HtzanzhuDAO.class);
	// property constants
	public static final String BIANHAO = "bianhao";
	public static final String KEHUNAME = "kehuname";
	public static final String MEITI = "meiti";
	public static final String HANGYE = "hangye";
	public static final String ISSHENPI = "isshenpi";
	public static final String ISSHENHE = "isshenhe";
	public static final String ISZUOFEI = "iszuofei";
	public static final String CI = "ci";
	public static final String USERNAME = "username";
	public static final String KFUSER = "kfuser";
	public static final String ZHEKOU = "zhekou";
	public static final String SHOUR = "shour";
	public static final String SMINUTE = "sminute";
	public static final String EHOUR = "ehour";
	public static final String EMINUTE = "eminute";
	public static final String JIEMU0 = "jiemu0";
	public static final String JIEMU6 = "jiemu6";
	public static final String JIEMU7 = "jiemu7";

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

	public void save(Htzanzhu transientInstance) {
		log.debug("saving Htzanzhu instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Htzanzhu persistentInstance) {
		log.debug("deleting Htzanzhu instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Htzanzhu findById(java.lang.Integer id) {
		log.debug("getting Htzanzhu instance with id: " + id);
		try {
			Htzanzhu instance = (Htzanzhu) getCurrentSession().get(
					"com.mana.pojo.Htzanzhu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Htzanzhu> findByExample(Htzanzhu instance) {
		log.debug("finding Htzanzhu instance by example");
		try {
			List<Htzanzhu> results = (List<Htzanzhu>) getCurrentSession()
					.createCriteria("com.mana.pojo.Htzanzhu")
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
		log.debug("finding Htzanzhu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Htzanzhu as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Htzanzhu> findByBianhao(Object bianhao) {
		return findByProperty(BIANHAO, bianhao);
	}

	public List<Htzanzhu> findByKehuname(Object kehuname) {
		return findByProperty(KEHUNAME, kehuname);
	}

	public List<Htzanzhu> findByMeiti(Object meiti) {
		return findByProperty(MEITI, meiti);
	}

	public List<Htzanzhu> findByHangye(Object hangye) {
		return findByProperty(HANGYE, hangye);
	}

	public List<Htzanzhu> findByIsshenpi(Object isshenpi) {
		return findByProperty(ISSHENPI, isshenpi);
	}

	public List<Htzanzhu> findByIsshenhe(Object isshenhe) {
		return findByProperty(ISSHENHE, isshenhe);
	}

	public List<Htzanzhu> findByIszuofei(Object iszuofei) {
		return findByProperty(ISZUOFEI, iszuofei);
	}

	public List<Htzanzhu> findByCi(Object ci) {
		return findByProperty(CI, ci);
	}

	public List<Htzanzhu> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<Htzanzhu> findByKfuser(Object kfuser) {
		return findByProperty(KFUSER, kfuser);
	}

	public List<Htzanzhu> findByZhekou(Object zhekou) {
		return findByProperty(ZHEKOU, zhekou);
	}

	public List<Htzanzhu> findByShour(Object shour) {
		return findByProperty(SHOUR, shour);
	}

	public List<Htzanzhu> findBySminute(Object sminute) {
		return findByProperty(SMINUTE, sminute);
	}

	public List<Htzanzhu> findByEhour(Object ehour) {
		return findByProperty(EHOUR, ehour);
	}

	public List<Htzanzhu> findByEminute(Object eminute) {
		return findByProperty(EMINUTE, eminute);
	}

	public List<Htzanzhu> findByJiemu0(Object jiemu0) {
		return findByProperty(JIEMU0, jiemu0);
	}

	public List<Htzanzhu> findByJiemu6(Object jiemu6) {
		return findByProperty(JIEMU6, jiemu6);
	}

	public List<Htzanzhu> findByJiemu7(Object jiemu7) {
		return findByProperty(JIEMU7, jiemu7);
	}

	public List findAll() {
		log.debug("finding all Htzanzhu instances");
		try {
			String queryString = "from Htzanzhu";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Htzanzhu merge(Htzanzhu detachedInstance) {
		log.debug("merging Htzanzhu instance");
		try {
			Htzanzhu result = (Htzanzhu) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Htzanzhu instance) {
		log.debug("attaching dirty Htzanzhu instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Htzanzhu instance) {
		log.debug("attaching clean Htzanzhu instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HtzanzhuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HtzanzhuDAO) ctx.getBean("HtzanzhuDAO");
	}
	/**
	 * 自定义功能
	 * @param 业务员名称
	 */
	public List<Htzanzhu> vague_findByyewuyuan() {
		String queryString = "select distinct username from Htzanzhu as model";// where model.username like '%" + username +"%'
		Query queryObject = getCurrentSession().createQuery(queryString);
		return queryObject.list();
	}
	/**
	 * 自定义功能
	 * @param 客户名称
	 */
	public List<Htzanzhu> vague_findKehunames() {
		String queryString = "select distinct kehuname from Htzanzhu as model";// where model.username like '%" + username +"%'
		Query queryObject = getCurrentSession().createQuery(queryString);
		return queryObject.list();
	}
	/**
	 * 自定义功能
	 * 模糊查询
	 * @param 客户名称 kehuname
	 */
	public List<Htzanzhu> vague_findBykehuname(String kehuname) {
		String queryString = "from Htzanzhu as model where model.kehuname like '%" + kehuname +"%'";
		Query queryObject = getCurrentSession().createQuery(queryString);
		return queryObject.list();
	}
}