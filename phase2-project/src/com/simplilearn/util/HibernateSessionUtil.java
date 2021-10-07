package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import com.simplilearn.model.ClassSchedule;
import com.simplilearn.model.ClassShedule;
import com.simplilearn.model.Subject;

public class HibernateSessionUtil {
	
	private static SessionFactory factory;
	
	public static SessionFactory buildSessionFactory() {
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClassShedule.class)
				.addAnnotatedClass(Subject.class)
				.buildSessionFactory();
		return factory;
	}

}
