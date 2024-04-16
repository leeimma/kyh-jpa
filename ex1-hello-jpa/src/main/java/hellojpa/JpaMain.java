package hellojpa;

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

            Address address = new Address("city", "street", "10000");

            Address address1 = new Address();

//            Member member = new Member();
//            member.setUsername ("hello");
//            member.setAddress(address);
//            em.persist(member);
//
//
//
//            Member member2 = new Member();
//            member2.setUsername ("hello");
//            member2.setAddress(address);
//
//            em.persist(member2);


            em.flush();
            em.clear();


            tx.commit();
        } catch (Exception e) {
            em.close();
        }

        emf.close();
    }


}
