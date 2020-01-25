package kr.co.basic.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException {
        logger.info("Hello World");

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        Dao dao = context.getBean("dao",Dao.class);
        //Dao new_dao = context.getBean("new_dao",Dao.class);
        dao.run();
        //new_dao.run();

        //System.out.println(dao == new_dao);

    }
}
