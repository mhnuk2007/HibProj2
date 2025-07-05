package com.learning;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setBrand("Dell");
        l1.setModel("XPS");
        l1.setRam(4);

        Alien a1 = new Alien();
        a1.setAid(105);
        a1.setAname("Munesh");
        a1.setTech("UI/UX");
        a1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.learning.Alien.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(a1);

        transaction.commit();

        Alien a2 = session.get(Alien.class,104);

        System.out.println(a2);

        List<Alien> aliens = session.createQuery("from Alien").list();
        System.out.println(aliens);
        session.close();
        sf.close();





    }
}