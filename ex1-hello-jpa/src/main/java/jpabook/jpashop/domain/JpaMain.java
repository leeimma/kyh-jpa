package jpabook.jpashop.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            {
                Member member = em.find(Member.class, 150L);
                member.setName("hi");
            }

            {
                // 영속
                Member member1 = new Member(150L, "A");
                Member member2 = new Member(150L, "B");

                em.persist(member1);
                em.persist(member2);
            }


            /* 4.
            {
                // 비영속
                Member member = new Member();
                member.setId(101L);
                member.setName("hello!!");

                // 영속
                em.persist(member);

                Member findMember1 = em.find(Member.class, 101L);
                Member findMember2 = em.find(Member.class, 101L);

                System.out.println("findMember2 == findMember1 = " + (findMember2 == findMember1));
            }
            */


            // 3.
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }


            // 2.
//            Member findMember = em.find(Member.class, 1l);
//            findMember.setName("HelloJPA");

            // 1.
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
//            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            em.close();
        }

        emf.close();
    }
}
