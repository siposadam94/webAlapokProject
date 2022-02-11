package hu.siposadam.dao;

import hu.siposadam.entity.Product;
import jakarta.persistence.*;

import java.util.List;

public class ProductDAO {

    EntityManagerFactory entityManagerFactory;

    public ProductDAO() {
        this.entityManagerFactory =
                Persistence.createEntityManagerFactory("persistence");
    }

    public List<Product> getAll(int category, int unit, int page) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        int pageSize = 2;

        Query nativeQuery = entityManager.createQuery(
                "SELECT p.name, p.category.name, p.quantity, p.unit.name, " +
                        "p.purchasePrice, p.sellingPrice, p.description " +
                        "FROM Product p");

        return nativeQuery
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public void addProduct() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.createNativeQuery("INSERT INTO Product(name, category_id, quantity, unit_id, purchase_price, selling_price, description) " +
                "VALUES('Nintendo', 2, 'pass', 1, 110.99, 140.99, 'current gen console' )").executeUpdate();
        entityTransaction.commit();
    }
}
