package kr.co.basic.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Named("a")
public class A{

    @Inject
    private B b;

    @Value("${catalog.name}")
    private String catalogName;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    void init(){
        log.error("A post");
    }

    @PreDestroy
    void destroy(){
        log.error("A pre destroy");
    }
}
