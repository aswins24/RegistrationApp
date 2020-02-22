package com.uttara.mvc.components;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class HsqlDAOImpl implements DAO {

	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public String insert(RegBean bean) {
		Session session = factory.openSession();
		session.beginTransaction();
		
		RegisterBean register = new RegisterBean();
		register.setuName(bean.getUname());
		register.setDob(bean.getDob());
		register.setEmail(bean.getEmail());
		register.setPass(bean.getPass());
		
		session.save(register);
		
		session.getTransaction().commit();
		session.close();
		return null;
	}

	public String update(String email, RegBean bean) {

		return null;
	}

	public String delete(String email) {

		return null;
	}

	public List<RegisterBean> getUsers() {
		Session session = factory.openSession();
		String squery = "from RegisterBean";
		
		session.beginTransaction();
		List<RegisterBean> register = session.createQuery(squery).getResultList();
		session.getTransaction().commit();
		session.close();
		
		return register;
	}

	public RegisterBean getUserInfo(String email) {
		List<RegisterBean> register = null;
		String squery = "from RegisterBean Where email in (:email)";
		Session session = factory.openSession();
		Query query = session.createQuery(squery);
		register = query.setParameter("email", email).getResultList();
		session.close();
		
		if(register.size() > 0)
		 return register.get(0);
		else 
			return null;
	}
	
	public RegisterBean getUserInfo(String email, String pass) {
        Session session = factory.openSession();
        List<RegisterBean> register = null;
        String squery = "from RegisterBean Where (email in (:email) and pass in (:pass))";
        
        session.beginTransaction();
        
        Query query = session.createQuery(squery);
        query.setParameter("email", email);
        register = query.setParameter("pass", pass).getResultList();

        session.close();
          
		return (register.size() > 0)? register.get(0) : null;
	}
}
