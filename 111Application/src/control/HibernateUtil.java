package control;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static Configuration configuration=new Configuration().configure();
    private static SessionFactory sessionFactory=null;
    private static Session session=null;
    
    public static Session getOpenSession(){
        if (sessionFactory==null || sessionFactory.isClosed()) {
            sessionFactory = configuration.buildSessionFactory();
        } 
        if (session==null || !session.isOpen()) {
            session=sessionFactory.openSession();
        }
        return session;
    }
    
    public static void closeSession(){
        if (session!=null) {
            session.close();
        }
        if (sessionFactory!=null) {
            sessionFactory.close();
        }
    }
}
