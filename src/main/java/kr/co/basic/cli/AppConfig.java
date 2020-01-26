package kr.co.basic.cli;

import kr.co.basic.cli.sevice.MyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


import java.sql.Connection;

@Configuration
@Profile({"default","dev"})
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class AppConfig {

    @Bean
    public Connection connection(ConnectionFactory connectionFactory){
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection){
        return new Dao(connection);
    }

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public ConnectionFactory connectionFactory(
            @Value("${jdbc.driverClass}") String driverClass,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.user}") String user,
            @Value("${jdbc.password}") String password
    ){
        return new ConnectionFactory(driverClass,url,user,password);
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MyService myService(){
        return new MyService();
    }
}
