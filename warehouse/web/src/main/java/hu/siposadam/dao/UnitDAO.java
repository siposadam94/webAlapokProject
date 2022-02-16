package hu.siposadam.dao;

import hu.siposadam.entity.Unit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class UnitDAO {

    EntityManagerFactory entityManagerFactory;

    public UnitDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }

    public List<Unit> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createNativeQuery("select * from Unit").getResultList();
    }
}
