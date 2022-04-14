package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class AddChildFormBean {


    private Integer id;

    @NotBlank(message = "Child First Name is required")
    private String childFirstName;

    private String childLastName;

    private Integer childAge;

    private Integer userId;

    private String userEmail;
}
