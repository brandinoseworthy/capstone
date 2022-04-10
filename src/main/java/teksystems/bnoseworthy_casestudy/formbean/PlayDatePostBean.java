package teksystems.bnoseworthy_casestudy.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Lob;
import java.util.Date;

@ToString
@Getter
@Setter

public class PlayDatePostBean {

    private Integer id;

    private Date createAt;

    @Lob
    private String postMessage;

    private String location;

    private Integer userId;






}
