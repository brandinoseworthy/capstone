package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.Date;

@ToString
@Getter
@Setter

public class PlayDatePostFormBean {

    private Integer id;

    private Date createAt;

    @NotBlank(message = "Playdate Post Message Needed")
    @Lob
    private String postMessage;

    @NotBlank(message = "Playdate Location Message Needed")
    private String location;

    private Integer userId;

    private String playdateDate;

    private String playdateTime;






}
