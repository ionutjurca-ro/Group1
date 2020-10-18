package dataAccessLayer.persistanceLayer;

import dataAccessLayer.Project;
import dataAccessLayer.Task;
import dataAccessLayer.Type;
import dataAccessLayer.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtils {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/databasegroup1?serverTimezone=UTC");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "liliacului");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");//
        properties.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(properties);

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Task.class);
        configuration.addAnnotatedClass(Project.class);
        configuration.addAnnotatedClass(Type.class);

        return configuration.buildSessionFactory();
    }
}
