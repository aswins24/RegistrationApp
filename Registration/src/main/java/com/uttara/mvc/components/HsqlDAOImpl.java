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
		
		Register register = new Register();
		register.setuName(bean.getUname());
		register.setDob(bean.getDob());
		register.setEmail(bean.getEmail());
		register.setPass(bean.getPass());
		
		session.save(register);
		
		session.getTransaction().commit();
		session.close();
		return null;
	}
	public Long insert(RegisterBean bean) {
		Long id =  null;
		Session session = factory.openSession();
		session.beginTransaction();
		
		Register_2 register = new Register_2();
		register.setName(bean.getName());
		register.setEmail(bean.getEmail());
		register.setPassword(bean.getPassword());
		
		id = (Long) session.save(register);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	public String update(String email, RegBean bean) {

		return null;
	}

	public String delete(String email) {

		return null;
	}

	public List<Register> getUsers() {
		Session session = factory.openSession();
		String squery = "from Register";
		
		session.beginTransaction();
		List<Register> register = session.createQuery(squery).getResultList();
		session.getTransaction().commit();
		session.close();
		
		return register;
	}

	public Register getUserInfo(String email) {
		List<Register> register = null;
		String squery = "from Register Where email in (:email)";
		Session session = factory.openSession();
		Query query = session.createQuery(squery);
		register = query.setParameter("email", email).getResultList();
		session.close();
		
		if(register.size() > 0)
		 return register.get(0);
		else 
			return null;
	}
	
	public Register getUserInfo(String email, String pass) {
        Session session = factory.openSession();
        List<Register> register = null;
        String squery = "from Register Where (email in (:email) and pass in (:pass))";
        
        session.beginTransaction();
        
        Query query = session.createQuery(squery);
        query.setParameter("email", email);
        register = query.setParameter("pass", pass).getResultList();

        session.close();
          
		return (register.size() > 0)? register.get(0) : null;
	}
	public Register_2 getUser(String email) {
		List<Register_2> register = null;
		
		Session session = factory.openSession();
		String sQuery = "from Register_2 Where email in (:email)";
		Query query = session.createQuery(sQuery);
		register = query.setParameter("email", email).getResultList();
		session.close();
		System.out.println("in hsqldao.getUser -> "+register);
		return register.size() > 0 ? register.get(0): null;
		
	}
}
