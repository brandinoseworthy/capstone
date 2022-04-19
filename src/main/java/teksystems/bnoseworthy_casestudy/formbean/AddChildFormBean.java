package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import javax.persistence.*;
import javax.validation.constraints.*;

@ToString
@Getter
@Setter
public class AddChildFormBean {


    private Integer id;

    @NotBlank(message = "Child First Name is required")
    private String childFirstName;

    private String childLastName;


    @Min(value = 0, message =  "Age should not be less than 0")
    @Max(value = 16, message = "Age should not be greater than 16")
    @NotNull(message = "Age is required")
    private Integer childAge;

    private Integer userId;

}
