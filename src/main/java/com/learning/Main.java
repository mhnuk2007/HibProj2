package com.learning;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setBrand("Dell");
        l1.setModel("Inspiron");
        l1.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setAname("Honey");
        a1.setTech("Java");
        a1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.learning.Alien.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(a1);

        transaction.commit();

        session.close();
        sf.close();


        System.out.println(a1);


    }
}