package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
				.buildSessionFactory();
		//Unit of Work
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			//HQL -> Hibernate Query Language
			// select * from city
			//from City c where c.countryCode='TUR' AND c.district='Marmara'
			//from City c where c.name LIKE '%is%'
			/*
			 * List<City> cities =
			 * session.createQuery("from City c where c.name LIKE '%is%'").getResultList();
			 * 
			 * for (City city : cities) { System.out.println(city.getName()); }
			 */
			
			City city = new City();
			city.setName("Düzce 10");
			city.setCountryCode("TUR");
			city.setDistrict("Karadeniz");
			city.setPopulation(100000);
			session.save(city);
			System.out.println("Þehir eklendi");
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
