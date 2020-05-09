package com.alevel.finance;

import com.alevel.finance.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Loader {

    public static final Logger log = LoggerFactory.getLogger(Loader.class);

    public static void main(String[] args) {

        Timestamp now = Timestamp.now();

        Operation operation = new Operation();

        operation.setName("first operation");
        operation.setCost(BigDecimal.valueOf(10.0));
        operation.setTimestamps(now);

        IncomeCategory category = new IncomeCategory();

        category.setName("category");
        category.setCost(operation.getCost());
        category.setOperation(operation);
        operation.setIncomeCategory(category);

        Client client = new Client();

        client.setName(new Username("Client", "nick"));
        client.setEmail("a@a.com");
        client.setPhoneNumber("+192892179");
        client.setTimestamps(now);

        Bill bill = new Bill();

        bill.setClient(client);
        bill.setTimestamps(now);

        Configuration configuration = new Configuration().configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()
        ) {
            try {
                session.beginTransaction();

                session.save(operation);
                session.save(category);
                session.save(bill);
                session.save(client);

                session.getTransaction().commit();
            } catch (Exception e) {
                log.error("error when populating db with mock data", e);
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }

}
