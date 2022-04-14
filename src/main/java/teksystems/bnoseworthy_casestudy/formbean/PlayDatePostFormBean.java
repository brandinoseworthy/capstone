package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Lob;
import java.sql.Time;
import java.util.Date;

@ToString
@Getter
@Setter

public class PlayDatePostFormBean {

    private Integer id;

    private Date createAt;

    @Lob
    private String postMessage;

    private String location;

    private Integer userId;

    private String playdateDate;

    private String playdateTime;






}
