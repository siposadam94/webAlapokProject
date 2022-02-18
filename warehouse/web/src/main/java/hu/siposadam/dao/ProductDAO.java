package hu.siposadam.dao;

import hu.siposadam.entity.Category;
import hu.siposadam.entity.Product;
import hu.siposadam.entity.Unit;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.util.List;
import java.util.Set;

public class ProductDAO {

    EntityManagerFactory entityManagerFactory;
    static int pageSize = 4;

    public ProductDAO() {
        this.entityManagerFactory =
                Persistence.createEntityManagerFactory("persistence");
    }

    public List<Product> getAll(int category, int unit, int page) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        https://www.baeldung.com/spring-data-jpa-null-parameters

        String select = "SELECT p.name, p.category.name, p.quantity, p.unit.name, " +
                "p.purchasePrice, p.sellingPrice, p.description " +
                "FROM Product p";
        Query query;

        if (category != 0 && unit != 0) {
            select += " WHERE p.category.id = :categoryId AND p.unit.id = :unitId";

            query = entityManager.createQuery(select);
            query.setParameter("categoryId", category);
            query.setParameter("unitId", unit);

        } else if (category != 0) {
            select += " WHERE p.category.id = :categoryId";
            query = entityManager.createQuery(select);
            query.setParameter("categoryId", category);

        } else if (unit != 0) {
            select += " WHERE p.unit.id = :unitId";
            query = entityManager.createQuery(select);
            query.setParameter("unitId", unit);

        } else {
            query = entityManager.createQuery(select);
        }

        return query
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public List<Product> findByName(String name, int page) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String queryString = "SELECT p.name, p.category.name, p.quantity, p.unit.name,p.purchasePrice, p.sellingPrice, p.description FROM Product p ";
        Query query;

        if (StringUtils.isNotEmpty(name)) {
            queryString += "WHERE p.name LIKE :name";

            query = entityManager.createQuery(queryString);
            query.setParameter("name", "%" + name + "%");
        } else {
            query = entityManager.createQuery(queryString);
        }

        return query
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public void addProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Unit unit = entityManager.find(Unit.class, product.getUnit().getId());
        Category category = entityManager.find(Category.class, product.getCategory().getId());
        product.setCategory(category);
        product.setUnit(unit);

        try {
            entityManager.persist(product);
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
            for (ConstraintViolation v : constraintViolations) {
                System.out.println(v.getMessage());
            }
        }
        entityTransaction.commit();
        entityManager.close();
    }
}
