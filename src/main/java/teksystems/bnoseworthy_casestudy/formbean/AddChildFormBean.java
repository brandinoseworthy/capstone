package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import javax.persistence.*;

@ToString
@Getter
@Setter

public class AddChildFormBean {


    private Integer id;

    private String childFirstName;

    private String childLastName;

    private Integer childAge;

    private Integer userId;
}
