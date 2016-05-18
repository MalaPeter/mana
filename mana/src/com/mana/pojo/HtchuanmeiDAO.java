package com.mana.pojo;

import java.util.Date;
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
 * Htchuanmei entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mana.pojo.Htchuanmei
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HtchuanmeiDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HtchuanmeiDAO.class);
	// property constants
	public static final String BIANHAO = "bianhao";
	public static final String KEHUNAME = "kehuname";
	public static final String MEITI = "meiti";
	public static final String GUIGE = "guige";
	public static final String SHIDUAN = "shiduan";
	public static final String ZHEKOU = "zhekou";
	public static final String BOCHUTIANSHU = "bochutianshu";
	public static final String BOCHUCISHU = "bochucishu";
	public static final String PRICE = "price";
	public static final String FKFANGSHI = "fkfangshi";
	public static final String BEIZHU = "beizhu";
	public static final String ISLOCK = "islock";
	public static final String ISPAY = "ispay";
	public static final String ISTINGBO = "istingbo";
	public static final String USERNAME = "username";
	public static final String ISEDIT = "isedit";

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
	/**
	 * 新增方法
	 * 根据当前日期 返回列表
	 * @return
	 */
	public List<Htchuanmei> getByCdate() {
		try {
			String queryString = "from Htchuanmei where cdate=curdate()";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	/**
	 * 新增方法
	 * 根据 用户名称和系统编号查询
	 * @return
	 */
	public List<Htchuanmei> getByIDAndUname(String id,String username) {
		try {
			String queryString = "from Htchuanmei where id="+id+" and username='"+username+"'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public void save(Htchuanmei transientInstance) {
		log.debug("saving Htchuanmei instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Htchuanmei persistentInstance) {
		log.debug("deleting Htchuanmei instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Htchuanmei findById(java.lang.Integer id) {
		log.debug("getting Htchuanmei instance with id: " + id);
		try {
			Htchuanmei instance = (Htchuanmei) getCurrentSession().get(
					"com.mana.pojo.Htchuanmei", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Htchuanmei> findByExample(Htchuanmei instance) {
		log.debug("finding Htchuanmei instance by example");
		try {
			List<Htchuanmei> results = (List<Htchuanmei>) getCurrentSession()
					.createCriteria("com.mana.pojo.Htchuanmei")
					.add(create(instance)).addOrder(Order.desc("cdate")).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Htchuanmei instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Htchuanmei as model where model."
					+ propertyName + "= ? order by cdate desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Htchuanmei> findByBianhao(Object bianhao) {
		return findByProperty(BIANHAO, bianhao);
	}

	public List<Htchuanmei> findByKehuname(Object kehuname) {
		return findByProperty(KEHUNAME, kehuname);
	}

	public List<Htchuanmei> findByMeiti(Object meiti) {
		return findByProperty(MEITI, meiti);
	}

	public List<Htchuanmei> findByGuige(Object guige) {
		return findByProperty(GUIGE, guige);
	}

	public List<Htchuanmei> findByShiduan(Object shiduan) {
		return findByProperty(SHIDUAN, shiduan);
	}

	public List<Htchuanmei> findByZhekou(Object zhekou) {
		return findByProperty(ZHEKOU, zhekou);
	}

	public List<Htchuanmei> findByBochutianshu(Object bochutianshu) {
		return findByProperty(BOCHUTIANSHU, bochutianshu);
	}

	public List<Htchuanmei> findByBochucishu(Object bochucishu) {
		return findByProperty(BOCHUCISHU, bochucishu);
	}

	public List<Htchuanmei> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<Htchuanmei> findByFkfangshi(Object fkfangshi) {
		return findByProperty(FKFANGSHI, fkfangshi);
	}

	public List<Htchuanmei> findByBeizhu(Object beizhu) {
		return findByProperty(BEIZHU, beizhu);
	}

	public List<Htchuanmei> findByIslock(Object islock) {
		return findByProperty(ISLOCK, islock);
	}

	public List<Htchuanmei> findByIspay(Object ispay) {
		return findByProperty(ISPAY, ispay);
	}

	public List<Htchuanmei> findByIstingbo(Object istingbo) {
		return findByProperty(ISTINGBO, istingbo);
	}

	public List<Htchuanmei> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<Htchuanmei> findByIsedit(Object isedit) {
		return findByProperty(ISEDIT, isedit);
	}

	public List findAll() {
		log.debug("finding all Htchuanmei instances");
		try {
			String queryString = "from Htchuanmei";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Htchuanmei merge(Htchuanmei detachedInstance) {
		log.debug("merging Htchuanmei instance");
		try {
			Htchuanmei result = (Htchuanmei) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Htchuanmei instance) {
		log.debug("attaching dirty Htchuanmei instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Htchuanmei instance) {
		log.debug("attaching clean Htchuanmei instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HtchuanmeiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HtchuanmeiDAO) ctx.getBean("HtchuanmeiDAO");
	}
}