package kr.co.basic.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
@Configuration
//excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = B.class)
@ComponentScan(basePackageClasses = Main.class)
public class Main {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        B b = context.getBean(B.class);
        log.info("{}",b);
        context.close();
    }
}
