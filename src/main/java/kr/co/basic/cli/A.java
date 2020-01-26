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
public class A{

    private B b;

    public A(B b) {
        this.b = b;
    }

    void init(){
        log.error("A post" + b);
    }
    
    void destroy(){
        log.error("A pre destroy");
    }
}
