package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Locker {

    @Id @GeneratedValue
    @Column(name = "locker_id")
    private Long id;
    private String name;
//
//    @OneToOne(mappedBy = "locker")
//    private Member member;

}
