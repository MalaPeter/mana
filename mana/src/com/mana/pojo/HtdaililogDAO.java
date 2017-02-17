package com.mana.pojo;

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
 * Htdaililog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mana.pojo.Htdaililog
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HtdaililogDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HtdaililogDAO.class);
	// property constants
	public static final String BIANHAO = "bianhao";
	public static final String SHIDUAN = "shiduan";
	public static final String GUIGE = "guige";
	public static final String KANLIJIA = "kanlijia";
	public static final String ZHEKOU = "zhekou";
	public static final String JINGJIA = "jingjia";
	public static final String TIANSHU = "tianshu";
	public static final String ZONGJINGJIA = "zongjingjia";
	public static final String ZRIQI = "zriqi";

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

	public void save(Htdaililog transientInstance) {
		log.debug("saving Htdaililog instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Htdaililog persistentInstance) {
		log.debug("deleting Htdaililog instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Htdaililog findById(java.lang.Integer id) {
		log.debug("getting Htdaililog instance with id: " + id);
		try {
			Htdaililog instance = (Htdaililog) getCurrentSession().get(
					"com.mana.pojo.Htdaililog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Htdaililog> findByExample(Htdaililog instance) {
		log.debug("finding Htdaililog instance by example");
		try {
			List<Htdaililog> results = (List<Htdaililog>) getCurrentSession()
					.createCriteria("com.mana.pojo.Htdaililog")
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
		log.debug("finding Htdaililog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Htdaililog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Htdaililog> findByBianhao(Object bianhao) {
		return findByProperty(BIANHAO, bianhao);
	}

	public List<Htdaililog> findByShiduan(Object shiduan) {
		return findByProperty(SHIDUAN, shiduan);
	}

	public List<Htdaililog> findByGuige(Object guige) {
		return findByProperty(GUIGE, guige);
	}

	public List<Htdaililog> findByKanlijia(Object kanlijia) {
		return findByProperty(KANLIJIA, kanlijia);
	}

	public List<Htdaililog> findByZhekou(Object zhekou) {
		return findByProperty(ZHEKOU, zhekou);
	}

	public List<Htdaililog> findByJingjia(Object jingjia) {
		return findByProperty(JINGJIA, jingjia);
	}

	public List<Htdaililog> findByTianshu(Object tianshu) {
		return findByProperty(TIANSHU, tianshu);
	}

	public List<Htdaililog> findByZongjingjia(Object zongjingjia) {
		return findByProperty(ZONGJINGJIA, zongjingjia);
	}

	public List<Htdaililog> findByZriqi(Object zriqi) {
		return findByProperty(ZRIQI, zriqi);
	}

	public List findAll() {
		log.debug("finding all Htdaililog instances");
		try {
			String queryString = "from Htdaililog";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Htdaililog merge(Htdaililog detachedInstance) {
		log.debug("merging Htdaililog instance");
		try {
			Htdaililog result = (Htdaililog) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Htdaililog instance) {
		log.debug("attaching dirty Htdaililog instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Htdaililog instance) {
		log.debug("attaching clean Htdaililog instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HtdaililogDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HtdaililogDAO) ctx.getBean("HtdaililogDAO");
	}
	
	public void deleteByBianhao(String bianhao) {
		String queryString = "delete from Htdaililog as model where model.bianhao='" + bianhao +"'";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.executeUpdate();
	}
	
}