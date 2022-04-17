package teksystems.bnoseworthy_casestudy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "child")

    public class Child {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "age")
        private Integer age;

        @ToString.Exclude
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
        private User user;

        @Column(name = "user_id")
        private Integer userId;

        @OneToMany(mappedBy = "child", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
        private Set<ChildrenAttending> childAttending;
    }



