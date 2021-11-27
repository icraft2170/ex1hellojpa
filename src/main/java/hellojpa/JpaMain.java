package hellojpa;


import hellojpa.item.Item;
import hellojpa.item.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("Hello");
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, 1L);


            System.out.println(findMember.getTeam().getName());
            System.out.println("findMember.getClass() = " + findMember.getClass());
//            System.out.println("findMember.getUsername() = " + findMember.getUsername());
//            System.out.println("findMember.getId() = " + findMember.getId());

//            printMemberAndTeam(findMember);

            Scanner scanner = new Scanner(System.in);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team.getName() = " + team.getName());
    }
}




/**
 * drop table album;
 * drop table BOOK;
 * drop table LOCKER;
 * drop table MEMBER_PRODUCT;
 * drop table MOVIE;
 * drop table PRODUCT;
 * drop table TEAM;
 * drop table Member;
 * drop table team;
 * drop table posts;
 */