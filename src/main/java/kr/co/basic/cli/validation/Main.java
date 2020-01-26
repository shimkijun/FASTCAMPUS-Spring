package kr.co.basic.cli.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Person person = new Person("",200);
        PersonValidator validator = new PersonValidator();
        if(validator.supports(person.getClass())){
            BindException error = new BindException(person,"person");
            validator.validate(person,error);
            log.info("=> {}",error.hasErrors());
            log.info("=> {}",error.getAllErrors());
        }else{
            log.error("invalid class");
        }
    }
}
