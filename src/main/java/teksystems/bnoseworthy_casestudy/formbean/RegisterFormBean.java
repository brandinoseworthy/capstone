package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import teksystems.bnoseworthy_casestudy.validation.EmailUnique;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@ToString
@Getter
@Setter

public class RegisterFormBean {

    private Integer id;

    @EmailUnique(message = "Email already exists in the database")
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message="Email format invalid with regex")
    private String email;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Length(min = 3, max = 15, message = "Password must be between 3 and 15 characters")
    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    @NotBlank(message = "Zip Code is required")
    private String zip;

    private String description;

    private String favoritePlaceForPlaydates;

    @AssertTrue(message = "Checkbox is required")
    private boolean checkbox;

}
