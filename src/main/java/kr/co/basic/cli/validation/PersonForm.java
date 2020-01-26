package kr.co.basic.cli.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm{

    @NotBlank
    @Size(max = 10)
    private String name;

    @Min(0)
    @Max(120)
    private int age;

}
