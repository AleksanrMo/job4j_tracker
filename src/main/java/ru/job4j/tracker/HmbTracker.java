package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HmbTracker implements Store, AutoCloseable {

    private final SessionFactory sf = new Configuration()
            .configure().addAnnotatedClass(Item.class)
            .buildSessionFactory();

    @Override
    public void init() {
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        Session session = sf.openSession();
        session.beginTransaction();
        Item i = session.get(Item.class, id);
        if (i != null) {
            i.setName(item.getName());
            i.setCreated(item.getCreated());
            i.setDescription(item.getDescription());
            session.update(i);
            session.getTransaction().commit();
            session.close();
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        Session session = sf.openSession();
        session.beginTransaction();
        Item i = session.get(Item.class, id);
        if (i != null) {
            session.delete(i);
            session.getTransaction().commit();
            session.close();
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery(key).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item i = session.get(Item.class, id);
        return i;
    }

    @Override
    public void close() throws Exception {
        sf.close();
    }
}
