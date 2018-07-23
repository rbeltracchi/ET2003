package control;

import entity.Module;
import entity.Topic;
import entity.User;
import java.util.List;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Avk
 */
public class Manager {

    private Session session = null;
    private Transaction tx = null;

    private void beginTransaction() throws HibernateException {
        session = HibernateUtil.getOpenSession();
        tx = session.beginTransaction();
    }

    private void successTransaction() throws HibernateException {
        tx.commit();
    }

    private void failedTransaction() throws HibernateException {
        tx.rollback();
    }

    public boolean insert(User u) {
        try {
            beginTransaction();
            session.save(u);
            successTransaction();

        } catch (HibernateException e) {
            failedTransaction();
            System.out.println(e);
            return false;
        } //-----------------------------------------------------
        catch (ConstraintViolationException cve) {
            failedTransaction();
            for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
                System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
                JOptionPane.showMessageDialog(null,/*"En el campo '" + constraintViolation.getPropertyPath() + "':" + */ constraintViolation.getMessage());
                return false;
            }
        }
        return true;
    }

//    public void update(User u) {
//        try {
//            beginTransaction();
//            session.update(u);
//            successTransaction();
//        } catch (HibernateException e) {
//            failedTransaction();
//            System.out.println(e);
//        }
//    }
    public boolean update(User u) {
        try {
            beginTransaction();
            session.update(u);
            successTransaction();
        } catch (HibernateException e) {
            failedTransaction();
            System.out.println(e);
        }
        catch (ConstraintViolationException cve) {
            failedTransaction();
            for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
                System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
                JOptionPane.showMessageDialog(null,/*"En el campo '" + constraintViolation.getPropertyPath() + "':" + */ constraintViolation.getMessage());
                return false;
            }
        }
        return true;
    }

    public void delete(User u) {
        try {
            beginTransaction();
            session.delete(u);
            successTransaction();
        } catch (HibernateException e) {
            failedTransaction();
            System.out.println(e);
        }
    }

    public User getUser(long idUser, boolean lazy) {
        User u = null;
        try {
            beginTransaction();
            u = session.get(User.class, idUser);
            if (lazy) {
                Hibernate.initialize(u.getCompletedExercises());
            }
            successTransaction();
        } catch (HibernateException e) {
            failedTransaction();
            System.out.println(e);
        }
        return u;
    }

    public User getUser(long idUser) {
        return getUser(idUser, false);
    }

    public List<User> getUsers(boolean lazy) {
        List<User> users = null;
        try {
            beginTransaction();
            users = session.createQuery(" from entity.User ").list();
            if (lazy) {
                for (User u : users) {
                    Hibernate.initialize(u.getCompletedExercises());
                }
            }

            successTransaction();
        } catch (HibernateException e) {
            failedTransaction();
            System.out.println(e);
        }
        return users;
    }

    public List<User> getUsers() {
        return getUsers(false);
    }

    public Topic getTopic(long idTopic, boolean lazy) {
        Topic t = null;
        try {
            beginTransaction();
            t = session.get(Topic.class, idTopic);
            if (lazy) {
                Hibernate.initialize(t.getExercises());
            }
            successTransaction();
        } catch (HibernateException e) {
            failedTransaction();
            System.out.println(e);
        }
        return t;
    }

    public Topic getTopic(long idTopic) {
        return getTopic(idTopic, false);
    }

    public List<Topic> getTopics(boolean lazy) {
        List<Topic> topics = null;
        try {
            beginTransaction();
            topics = session.createQuery(" from entity.Topic ").list();
            if (lazy) {
                for (Topic t : topics) {
                    Hibernate.initialize(t.getExercises());
                }
            }

            successTransaction();
        } catch (HibernateException e) {
            failedTransaction();
            System.out.println(e);
        }
        return topics;
    }

    public List<Topic> getTopics() {
        return getTopics(false);
    }

    public Module getModule(long idModule, boolean lazy) {
        Module m = null;
        try {
            beginTransaction();
            m = session.get(Module.class, idModule);
            if (lazy) {
                Hibernate.initialize(m.getTopics());
            }
            successTransaction();
        } catch (HibernateException e) {
            failedTransaction();
            System.out.println(e);
        }
        return m;
    }

    public Module getModule(long idModule) {
        return getModule(idModule, false);
    }

    public List<Module> getModules(boolean lazy) {
        List<Module> modules = null;
        try {
            beginTransaction();
            modules = session.createQuery(" from entity.Module ").list();
            if (lazy) {
                for (Module t : modules) {
                    Hibernate.initialize(t.getTopics());
                }
            }

            successTransaction();
        } catch (HibernateException e) {
            failedTransaction();
            System.out.println(e);
        }
        return modules;
    }

    public List<Module> getModules() {
        return getModules(false);
    }
}
