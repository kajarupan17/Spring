package com.Rupan.springmvchibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ProjDao {
	StandardServiceRegistry ssreg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta = new MetadataSources(ssreg).getMetadataBuilder().build();  
  
    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    Session session = factory.openSession();  
    Transaction tra = session.beginTransaction();
	
	public boolean saveProject(Project p) {
		session.save(p);  
	    tra.commit();  
	    System.out.println("successfully saved");    
	    factory.close();  
	    session.close();
	    return true;
	}
	
	public List<Project> getProjects(){
		@SuppressWarnings("unchecked")
		List<Project> projects = session.createQuery("FROM Projects").list();
		return projects;
	}
}
