package com.mahato.hibernate;

import org.hibernate.Session;

public class AppTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Here We are creating a User in DB - Start
        session.beginTransaction();
        User user = new User();
        user.setName("PrasenjitMahato");
        user.setEmail("PrasenjitMahato@yopmail.com");
        session.persist(user);
        session.getTransaction().commit();
        session.close();
      //Here We are creating a User in DB - End. 
        

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        User myUser = null;
        myUser = (User)session1.get(User.class, new Long(1));
        System.out.println(myUser);

	}

}
