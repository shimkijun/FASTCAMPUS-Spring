package kr.co.basic.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
//        context.scan("kr.co.basic.cli");
//        context.register(AppConfig.class);
//        context.refresh();
//        B b = context.getBean(B.class);
//        log.info("{}",b);
//        context.close();
        Dao dao = context.getBean(Dao.class);
        dao.run();
        context.close();
    }
}
