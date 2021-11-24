package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member memberA = new Member();
            memberA.setUsername("손현호A");
            memberA.changeTeam(team);
            em.persist(memberA);

            Member  memberB = new Member();
            memberB.setUsername("손현호B");
            memberB.changeTeam(team);
            em.persist(memberB);

            //조회
            Member findMember = em.find(Member.class, memberA.getId());
            List<Member> members = findMember.getTeam().getMembers();
            for (Member member : members) {
                System.out.println("member.getUsername() = " + member.getUsername());
            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
