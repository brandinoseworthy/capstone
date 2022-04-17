package teksystems.bnoseworthy_casestudy.database.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "children_attending")
public class ChildrenAttending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "child_id", nullable = false)
    @EqualsAndHashCode.Exclude private Child child;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @EqualsAndHashCode.Exclude private PlayDatePost playdatePost;




}