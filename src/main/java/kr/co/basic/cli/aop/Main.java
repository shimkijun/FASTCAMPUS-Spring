package kr.co.basic.cli.aop;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Service serviceBean = context.getBean(Service.class);
        serviceBean.log();
        context.close();
    }
}
