package hellojpa;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            List<Member> resultList = em.createQuery("select m from Member m where m.username like '%kim%'").getResultList();


            //Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            //루트 클래스 (조회를 시작할 클래스)
            Root<Member> m = query.from(Member.class);
            //쿼리 생성
            CriteriaQuery<Member> cq =
            query.select(m).where(cb.equal(m.get("username"), "kim"));
            List<Member> resultList = em.createQuery(cq).getResultList();

            tx.commit();
        } catch (Exception e) {
            em.close();
        }

        emf.close();
    }


}
