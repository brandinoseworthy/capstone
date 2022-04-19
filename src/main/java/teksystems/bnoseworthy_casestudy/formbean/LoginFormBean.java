package teksystems.bnoseworthy_casestudy.formbean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter

public class LoginFormBean {

    private Integer id;

//    @NotBlank(message = "Email is required")
    private String email;

//    @NotBlank(message = "Password required")
    private String password;



}
