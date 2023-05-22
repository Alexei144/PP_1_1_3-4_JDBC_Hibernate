package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;// удалить импорт сделать сесион фактори


public class UserDaoHibernateImpl implements UserDao {


    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS Users (" +
                "Id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(65)," +
                "lastName VARCHAR(65)," +
                "age TINYINT)";

        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery(createTable);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        String deleteTable = "DROP TABLE IF EXISTS  Users";
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery(deleteTable);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = getSessionFactory().getCurrentSession()) {
            User user = new User(name, lastName, age);
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete User where id = id").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            allUsers = session.createQuery("from User").getResultList();
            for (User u : allUsers) {
                System.out.println(u);
            }
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
