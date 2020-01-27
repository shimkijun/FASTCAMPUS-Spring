package kr.co.basic.cli.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import kr.co.basic.cli.controller.MemberController;
import kr.co.basic.cli.dao.MemberDao;
import kr.co.basic.cli.sevice.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application-default.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driverClass}") String driverClass,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.user}") String user,
            @Value("${jdbc.password}") String password){

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClass);
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);

        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public MemberDao memberDao(JdbcTemplate dataSource){
        return new MemberDao(dataSource);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public MemberService memberService(MemberDao dao){
        return new MemberService(dao);
    }

    @Bean
    public MemberController memberController(MemberService service){
        return new MemberController(service);
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }
}
