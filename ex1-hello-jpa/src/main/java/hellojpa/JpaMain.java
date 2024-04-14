package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member member1 : members) {
                System.out.println("m = "+member1.getUsername());
            }

            Team findTeam = findMember.getTeam();



//            Member member = new Member();
//            member.setUsername("C");
//
//            em.persist(member);

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
