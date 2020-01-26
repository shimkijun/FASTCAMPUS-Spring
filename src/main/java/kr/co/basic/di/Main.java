package kr.co.basic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        boolean condition = false;
//        B b = new B(condition);
//        A a = new A(b);

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        A a = context.getBean("a",A.class);
        a.print();
    }
}
