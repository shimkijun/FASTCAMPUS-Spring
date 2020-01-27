package kr.co.basic.cli.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class TransactionBean {

    private Connection connection;

    public TransactionBean(Connection connection){
        this.connection = connection;
    }

    public void aroundTransaction(ProceedingJoinPoint pjp) throws SQLException {
        log.error("before Transaction");
        connection.setAutoCommit(false);
        try {
            Object proceed = pjp.proceed();
            connection.commit();
            log.error("commit");
        } catch (Throwable throwable) {
            connection.rollback();
            log.error("rollback");
        }
        log.error("after Transaction");
    }
}
