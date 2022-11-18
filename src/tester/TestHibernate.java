package tester;

import static utils.HibernateUtils.getSf;
import org.hibernate.*;
public class TestHibernate {

	public static void main(String[] args) {
		// Testing bootstrapping(initializing) of hibernate configuration
		//(creating singleton and immutable instance of SessionFactory Sf)
		try(SessionFactory sf = getSf()){
			System.out.println("Hibernate up and running");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
