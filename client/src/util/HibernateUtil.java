package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//responsible for creating the session factory object and session obj is used to interact 
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	

	public static SessionFactory getSessionFactory() {
		 try {
	            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
	                    .configure("./META-INF/hibernate.cfg.xml").build();
	            Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
	            return metadata.getSessionFactoryBuilder().build();

	        } catch (HibernateException he) {
	            System.out.println("Session Factory creation failure");
	            throw he;
	        }
	    }
	
	
	public static void closeSessionFactory() {
		if(sessionFactory==null) {
			sessionFactory.close();
		}
	}
}
