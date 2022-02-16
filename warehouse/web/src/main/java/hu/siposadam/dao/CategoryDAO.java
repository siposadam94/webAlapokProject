package hu.siposadam.dao;

import hu.siposadam.entity.Category;
import hu.siposadam.entity.Product;
import javax.persistence.*;

import java.util.List;

public class CategoryDAO {

    EntityManagerFactory entityManagerFactory;

    public CategoryDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }

    public List<Category> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createNativeQuery("select * from Category").getResultList();
    }
}
