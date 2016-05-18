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

import com.mana.pojo.Admins;

/**
 * A data access object (DAO) providing persistence and search support for
 * Admins entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.mana.pojo.Admins
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AdminsDAO {
	private static final Logger log = LoggerFactory.getLogger(AdminsDAO.class);
	// property constants
	public static final String ADMINNAME = "adminname";
	public static final String ADMINPASS = "adminpass";
	public static final String DEPARTMENT = "department";
	public static final String IP = "ip";
	public static final String NICKNAME = "nickname";
	public static final String RLIULAN = "rliulan";
	public static final String RLURU = "rluru";
	public static final String RSHENHE = "rshenhe";
	public static final String RHUAKUAN = "rhuakuan";
	public static final String RTINGBO = "rtingbo";
	public static final String RTONGJI = "rtongji";

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

	public void save(Admins transientInstance) {
		log.debug("saving Admins instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Admins persistentInstance) {
		log.debug("deleting Admins instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Admins findById(java.lang.Integer id) {
		log.debug("getting Admins instance with id: " + id);
		try {
			Admins instance = (Admins) getCurrentSession().get(
					"com.mana.pojo.Admins", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Admins> findByExample(Admins instance) {
		log.debug("finding Admins instance by example");
		try {
			List<Admins> results = (List<Admins>) getCurrentSession()
					.createCriteria("com.mana.pojo.Admins")
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
		log.debug("finding Admins instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admins as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public Admins findByNameAndPass(String name,String pass) {
		try {
			String queryString = "from Admins as model where model.adminname=? and model.adminpass=?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, name);
			queryObject.setParameter(1, pass);
			//返回了个空,处理下
			if(queryObject.list().size() > 0) {
				return (Admins) queryObject.list().get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw null;
		}
	}
	
	public List<Admins> findByAdminname(Object adminname) {
		return findByProperty(ADMINNAME, adminname);
	}

	public List<Admins> findByAdminpass(Object adminpass) {
		return findByProperty(ADMINPASS, adminpass);
	}

	public List<Admins> findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	public List<Admins> findByIp(Object ip) {
		return findByProperty(IP, ip);
	}

	public List<Admins> findByNickname(Object nickname) {
		return findByProperty(NICKNAME, nickname);
	}

	public List<Admins> findByRliulan(Object rliulan) {
		return findByProperty(RLIULAN, rliulan);
	}

	public List<Admins> findByRluru(Object rluru) {
		return findByProperty(RLURU, rluru);
	}

	public List<Admins> findByRshenhe(Object rshenhe) {
		return findByProperty(RSHENHE, rshenhe);
	}

	public List<Admins> findByRhuakuan(Object rhuakuan) {
		return findByProperty(RHUAKUAN, rhuakuan);
	}

	public List<Admins> findByRtingbo(Object rtingbo) {
		return findByProperty(RTINGBO, rtingbo);
	}

	public List<Admins> findByRtongji(Object rtongji) {
		return findByProperty(RTONGJI, rtongji);
	}

	public List findAll() {
		log.debug("finding all Admins instances");
		try {
			String queryString = "from Admins";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admins merge(Admins detachedInstance) {
		log.debug("merging Admins instance");
		try {
			Admins result = (Admins) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admins instance) {
		log.debug("attaching dirty Admins instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admins instance) {
		log.debug("attaching clean Admins instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdminsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AdminsDAO) ctx.getBean("AdminsDAO");
	}
}