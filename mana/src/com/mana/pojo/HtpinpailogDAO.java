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
 * Htpinpailog entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.mana.pojo.Htpinpailog
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HtpinpailogDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HtpinpailogDAO.class);
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
	public static final String YUEFEN = "yuefen";
	public static final String NIANFEN = "nianfen";

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

	public void save(Htpinpailog transientInstance) {
		log.debug("saving Htpinpailog instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Htpinpailog persistentInstance) {
		log.debug("deleting Htpinpailog instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Htpinpailog findById(java.lang.Integer id) {
		log.debug("getting Htpinpailog instance with id: " + id);
		try {
			Htpinpailog instance = (Htpinpailog) getCurrentSession().get(
					"com.mana.pojo.Htpinpailog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Htpinpailog> findByExample(Htpinpailog instance) {
		log.debug("finding Htpinpailog instance by example");
		try {
			List<Htpinpailog> results = (List<Htpinpailog>) getCurrentSession()
					.createCriteria("com.mana.pojo.Htpinpailog")
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
		log.debug("finding Htpinpailog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Htpinpailog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Htpinpailog> findByBianhao(Object bianhao) {
		return findByProperty(BIANHAO, bianhao);
	}

	public List<Htpinpailog> findByShiduan(Object shiduan) {
		return findByProperty(SHIDUAN, shiduan);
	}

	public List<Htpinpailog> findByGuige(Object guige) {
		return findByProperty(GUIGE, guige);
	}

	public List<Htpinpailog> findByKanlijia(Object kanlijia) {
		return findByProperty(KANLIJIA, kanlijia);
	}

	public List<Htpinpailog> findByZhekou(Object zhekou) {
		return findByProperty(ZHEKOU, zhekou);
	}

	public List<Htpinpailog> findByJingjia(Object jingjia) {
		return findByProperty(JINGJIA, jingjia);
	}

	public List<Htpinpailog> findByTianshu(Object tianshu) {
		return findByProperty(TIANSHU, tianshu);
	}

	public List<Htpinpailog> findByZongjingjia(Object zongjingjia) {
		return findByProperty(ZONGJINGJIA, zongjingjia);
	}

	public List<Htpinpailog> findByZriqi(Object zriqi) {
		return findByProperty(ZRIQI, zriqi);
	}

	public List<Htpinpailog> findByYuefen(Object yuefen) {
		return findByProperty(YUEFEN, yuefen);
	}

	public List<Htpinpailog> findByNianfen(Object nianfen) {
		return findByProperty(NIANFEN, nianfen);
	}

	public List findAll() {
		log.debug("finding all Htpinpailog instances");
		try {
			String queryString = "from Htpinpailog";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Htpinpailog merge(Htpinpailog detachedInstance) {
		log.debug("merging Htpinpailog instance");
		try {
			Htpinpailog result = (Htpinpailog) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Htpinpailog instance) {
		log.debug("attaching dirty Htpinpailog instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Htpinpailog instance) {
		log.debug("attaching clean Htpinpailog instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HtpinpailogDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (HtpinpailogDAO) ctx.getBean("HtpinpailogDAO");
	}
}