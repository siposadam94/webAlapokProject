package hu.siposadam.dao;

import hu.siposadam.entity.Product;
import jakarta.persistence.*;

import java.util.List;

public class ProductDAO {

    private final EntityManagerFactory entityManagerFactory;

    public ProductDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }

    public List<Product> getAll(int category, int unit, int page) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        int pageSize = 2;
        Query nativeQuery = entityManager.createNativeQuery(
                "SELECT product.name, category.name, quantity, unit.name, purchase_price, selling_price, description " +
                        "FROM product " +
                        "LEFT JOIN category ON (product.category_id = category.id) " +
                        "LEFT JOIN unit ON (product.unit_id = unit.id) "
        );


        return nativeQuery
                .setFirstResult((page-1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

//    public List<Product> getAllJPQL(String category, String unit, int page) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        int pageSize = 2;
//        Query nativeQuery = entityManager.createQuery(
//                "SELECT p FROM Product p left join Category c left join Unit u"
//        );
//        return nativeQuery
//                .setFirstResult((page-1) * pageSize)
//                .setMaxResults(pageSize)
//                .getResultList();
//    }

    public void addProduct() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.createNativeQuery("INSERT INTO Product(name, category_id, quantity, unit_id, purchase_price, selling_price, description) " +
                "VALUES('Nintendo', 2, 'pass', 1, 110.99, 140.99, 'current gen console' )").executeUpdate();
        entityTransaction.commit();
    }
}
