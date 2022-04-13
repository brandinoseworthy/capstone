package teksystems.bnoseworthy_casestudy.database.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playdate_posts")
public class PlayDatePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;


    @Lob
    @Column(name = "post_message")
    private String postMessage;

    @Column(name = "location")
    private String location;

    @Column(name = "user_id")
    private Integer userId;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;





    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "id")
    private Set<PlayDatePost> playDatePosts;

}
