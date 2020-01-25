package kr.co.basic.cli;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

@Slf4j
public class Main {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");

        Dao2 dao2 = context.getBean("dao2",Dao2.class);
        try {
            dao2.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
