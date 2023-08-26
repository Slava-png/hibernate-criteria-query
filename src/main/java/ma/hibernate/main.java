package ma.hibernate;

import ma.hibernate.dao.PhoneDao;
import ma.hibernate.dao.PhoneDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        PhoneDao phoneDao = new PhoneDaoImpl(sessionFactory);

        Map<String, String[]> params = new HashMap<>();
        params.put("countryManufactured", new String[]{"China"});
        params.put("maker", new String[]{"apple", "nokia", "samsung"});
        params.put("color", new String[]{"WHITE", "RED"});

        System.out.println(params.entrySet());

        params.values().forEach(Arrays::toString);

        phoneDao.findAll(params).forEach(System.out::println);
    }
}
