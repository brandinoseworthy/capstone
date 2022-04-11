package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@ToString
@Getter
@Setter
public class RegisterPlayDatePostBean {

    //we want to register children to a user playdate post

    private Integer id;

    private Integer childId;

    private Integer postId;

}