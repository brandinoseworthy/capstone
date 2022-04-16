package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AddChildToPlaydatePostFormBean {

    //we want to register children to a user playdate post

    private Integer id;

    private Integer childId;

    private Integer postId;

}