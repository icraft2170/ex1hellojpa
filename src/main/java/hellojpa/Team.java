package hellojpa;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA는 리플렉션을 위해 기본 생성자가 필요
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "team_id")
    List<Member> members = new ArrayList<Member>();

}
