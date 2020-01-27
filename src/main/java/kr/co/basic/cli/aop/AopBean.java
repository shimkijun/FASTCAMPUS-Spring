package kr.co.basic.cli.aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AopBean {

    public void beforeLog(){
        log.error("before log");
    }

    public void afterLog(){
        log.error("after log");
    }

    public void afterReturnLog(){
        log.error("after return log");
    }

    public void afterThrowingLog(){
        log.error("after throwing log");
    }
}
