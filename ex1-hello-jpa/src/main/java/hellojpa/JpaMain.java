package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // EntityManagerFactory: 하나만 생성해서 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // EntityManager: 쓰레드간에 공유하면 안됨(사용하고 버려야 함)
        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();

        member.setId(2L);
        member.setName("HelloB");

        em.persist(member);

        tx.commit();

        // Transaction: 모든 데이터 변경은 트랜잭션 안에서 실행
        em.close();

        // EntityManagerFactory는 애플리케이션 종료 시 꼭 닫아야 함
        emf.close();
    }
}
