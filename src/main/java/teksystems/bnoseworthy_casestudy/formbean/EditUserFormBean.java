package teksystems.bnoseworthy_casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import teksystems.bnoseworthy_casestudy.validation.EmailUnique;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ToString
@Getter
@Setter

public class EditUserFormBean {

    private Integer id;

    private String email;

    private String firstName;

    private String lastName;

    private String zip;


    private String description;

    private String favoritePlaceForPlaydates;



}
