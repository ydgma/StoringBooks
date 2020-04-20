package com.ydprojects.config;

import com.ydprojects.entity.book.BookImpl;
import com.ydprojects.entity.book.PDF;
import com.ydprojects.entity.book.UTF8;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateConfig {
    private static SessionFactory sessionFactory;
    public static String USERNAME;
    public static String PASSWORD;
    public static String CONN_URL;
    public static String DRIVER;
    private static final Logger LOG = LoggerFactory.getLogger(HibernateConfig.class);

    public static void loadProperties() {
        try (InputStream input = new FileInputStream("src/project.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            USERNAME = prop.getProperty("db.user");
            PASSWORD = prop.getProperty("db.password");
            CONN_URL = prop.getProperty("db.url");
            DRIVER = prop.getProperty("jdbc.driver");

        } catch (IOException ex) {
            LOG.info("{}",ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                loadProperties();
                Configuration configuration = new org.hibernate.cfg.Configuration();
                Properties properties = new Properties();
                properties.put(Environment.URL, CONN_URL);
                properties.put(Environment.USER, USERNAME);
                properties.put(Environment.PASS, PASSWORD);
                properties.put(Environment.DRIVER, DRIVER);
                properties.put(Environment.SHOW_SQL, "true");
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(BookImpl.class);
                configuration.addAnnotatedClass(UTF8.class);
                configuration.addAnnotatedClass(PDF.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                LOG.info("{}",e);
            }
        }
        return sessionFactory;
    }
}
