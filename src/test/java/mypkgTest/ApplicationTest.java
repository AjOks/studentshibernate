package mypkgTest;

import mypkg.Student;
import mypkg.HibernateUtil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ApplicationTest {
    //initializing the log4j system
    static Logger log = Logger.getLogger(ApplicationTest.class);

    public static void main(String[] args) {
        //configuring the logger
        BasicConfigurator.configure();
        log.debug("");  //enter message you want to display once logged!!

        Student c1 = new Student();
        c1.setStudentId(001);
        c1.setName("Gabby");
        c1.setCourse("Science");


        /*Persisting the database using the hibernate API steps:-*/
        //instantiate the session factory and create a session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //open a new session from the session object
        Session session = sessionFactory.openSession();
        //begin a transaction
        session.beginTransaction();
        //save user object created
        session.save(c1);
        //end the transaction
        session.getTransaction().commit();
    }
}
