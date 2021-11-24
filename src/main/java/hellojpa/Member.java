package hellojpa;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter @Setter
@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    // 연간관계 편의메서드
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team.toString() +
                '}';
    }


}
