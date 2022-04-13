package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter

public class AddChildFormBean {


    private Integer id;

    @NotBlank(message = "Child First Name is required")
    private String childFirstName;

    private String childLastName;

    @NotBlank(message = "Child Age is required")
    private Integer childAge;

    private Integer userId;
}
