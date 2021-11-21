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
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("손현호");
//            em.persist(member);
//
//            Member member = em.find(Member.class, 1L);
//            System.out.println("member.getId() = " + member.getId() + " member.getName() = " + member.getName());
//            member.setName("손현호(modify)");
//            em.remove(member);

            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
            members.forEach(member -> System.out.println("member = " + member.getName()));
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
