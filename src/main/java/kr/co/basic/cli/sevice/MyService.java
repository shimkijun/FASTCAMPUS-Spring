package kr.co.basic.cli.sevice;

import kr.co.basic.cli.validation.PersonForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;

@Service
@Slf4j
public class MyService {
    @Autowired
    private Validator validator;

    public void check(){
        Locale.setDefault(Locale.ENGLISH);
        PersonForm personForm = new PersonForm("    ",-1);
        Set<ConstraintViolation<PersonForm>> result = validator.validate(personForm);
        if(result.isEmpty()){
            log.info("성공");
        }else {
            log.error("실패");
            result.forEach(x ->{
                log.error(" => {} ",x.getMessage());
            });
        }
    }

}
