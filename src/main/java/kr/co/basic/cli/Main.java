package kr.co.basic.cli;

import kr.co.basic.cli.sevice.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        MyService myService = context.getBean(MyService.class);
        myService.check();
        context.close();
    }
}
