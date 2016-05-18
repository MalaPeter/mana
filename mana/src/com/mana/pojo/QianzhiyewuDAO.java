package com.mana.pojo;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Qianzhiyewu entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.mana.pojo.Qianzhiyewu
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class QianzhiyewuDAO {
	private static final Logger log = LoggerFactory
			.getLogger(QianzhiyewuDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String SHIXIAO = "shixiao";
	public static final String KEHUNAME = "kehuname";
	public static final String KEHULIANXIREN = "kehulianxiren";
	public static final String KEHUZHIWU = "kehuzhiwu";
	public static final String KEHUTEL = "kehutel";
	public static final String KEHUDIZHI = "kehudizhi";
	public static final String KEHULEIXING = "kehuleixing";
	public static final String ISLOCK = "islock";

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

	public void save(Qianzhiyewu transientInstance) {
		log.debug("saving Qianzhiyewu instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Qianzhiyewu persistentInstance) {
		log.debug("deleting Qianzhiyewu instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Qianzhiyewu findById(java.lang.Integer id) {
		log.debug("getting Qianzhiyewu instance with id: " + id);
		try {
			Qianzhiyewu instance = (Qianzhiyewu) getCurrentSession().get(
					"com.mana.pojo.Qianzhiyewu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Qianzhiyewu> findByExample(Qianzhiyewu instance) {
		log.debug("finding Qianzhiyewu instance by example");
		try {
			List<Qianzhiyewu> results = (List<Qianzhiyewu>) getCurrentSession()
					.createCriteria("com.mana.pojo.Qianzhiyewu")
					.add(create(instance)).addOrder(Order.desc("ctime")).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Qianzhiyewu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Qianzhiyewu as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 新增方法
	 * 根据 用户名称查询，客户名称列，并去除重复名称，返回
	 * 只查询 没有被锁定的客户名称
	 * @return
	 */
	public List<Qianzhiyewu> getKeHuname(String propertyName) {
		try {
			String queryString = "select distinct kehuname from Qianzhiyewu where username='"+propertyName+"' and islock=1";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<Qianzhiyewu> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<Qianzhiyewu> findByShixiao(Object shixiao) {
		return findByProperty(SHIXIAO, shixiao);
	}

	public List<Qianzhiyewu> findByKehuname(Object kehuname) {
		return findByProperty(KEHUNAME, kehuname);
	}

	public List<Qianzhiyewu> findByKehulianxiren(Object kehulianxiren) {
		return findByProperty(KEHULIANXIREN, kehulianxiren);
	}

	public List<Qianzhiyewu> findByKehuzhiwu(Object kehuzhiwu) {
		return findByProperty(KEHUZHIWU, kehuzhiwu);
	}

	public List<Qianzhiyewu> findByKehutel(Object kehutel) {
		return findByProperty(KEHUTEL, kehutel);
	}

	public List<Qianzhiyewu> findByKehudizhi(Object kehudizhi) {
		return findByProperty(KEHUDIZHI, kehudizhi);
	}

	public List<Qianzhiyewu> findByKehuleixing(Object kehuleixing) {
		return findByProperty(KEHULEIXING, kehuleixing);
	}

	public List<Qianzhiyewu> findByIslock(Object islock) {
		return findByProperty(ISLOCK, islock);
	}

	public List findAll() {
		log.debug("finding all Qianzhiyewu instances");
		try {
			String queryString = "from Qianzhiyewu order by ctime desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Qianzhiyewu merge(Qianzhiyewu detachedInstance) {
		log.debug("merging Qianzhiyewu instance");
		try {
			Qianzhiyewu result = (Qianzhiyewu) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Qianzhiyewu instance) {
		log.debug("attaching dirty Qianzhiyewu instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Qianzhiyewu instance) {
		log.debug("attaching clean Qianzhiyewu instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static QianzhiyewuDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (QianzhiyewuDAO) ctx.getBean("QianzhiyewuDAO");
	}
}