import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.testing.java.Circle;
import com.testing.java.dao.HibernateDao;
import com.testing.java.dao.JdbcDaoImpl;

public class JdbcDemo {
	public static void main(String args[]) {
		/*
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl jdbc = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		List<Circle> clist = jdbc.getCircle();
		System.out.println("I am running ...");
		for(Circle c: clist) {
			System.out.println(c.getName());
		}
		System.out.println("*** inserting the circle ***");
		List<Circle> clist1 = new ArrayList<Circle>();
		clist1.add((Circle)ctx.getBean("circle", 13, "Second Circle"));
		clist1.add((Circle)ctx.getBean("circle", 14, "third Circle"));
		for(Circle c: clist1) {
			System.out.println(c.getName());
		}
		jdbc.insertCircle(clist1);
		System.out.println("***After  inserting the circle ***");
		List<Circle> clist2 = jdbc.getCircle();
		System.out.println("I am running ...");
		for(Circle c: clist2) {
			System.out.println(c.getName() );
		}
		
		*/

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HibernateDao jdbc = ctx.getBean("hibernateDao", HibernateDao.class);
		int count = jdbc.getCircleCount();
		System.out.println("I am running ...");
		System.out.println(count);
	}
}
