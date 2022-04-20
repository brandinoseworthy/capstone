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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "town_state")
    private String townState;

    @Column(name = "description")
    private String description;

    @Column(name = "favorite_place_for_playdates")
    private String favoritePlaceForPlaydates;

    @Column(name = "profile_img")
    private String profileImg;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "id")
    private Set<User> users;





    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "id")
    private Set<PlayDatePost> playDatePosts;

}

