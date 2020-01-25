package kr.co.basic.cli;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class Main {

    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        context.close();
    }
}
