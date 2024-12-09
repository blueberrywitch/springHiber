package dika.springhibernate.dao;

import dika.springhibernate.model.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from dika.springhibernate.model.User");
        return query.getResultList();
    }

    @Override
    public User findByCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("from dika.springhibernate.model.User where car.series = :series and car.model = :model", User.class);
        query.setParameter("series", series);
        query.setParameter("model", model);
        return query.getSingleResult();
    }

}
