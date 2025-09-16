package iuh.fit.Dao;

import iuh.fit.Models.Product;
import iuh.fit.Utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductDAO {

    public List<Product> findAll() {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
            List<Product> list = query.getResultList();
            System.out.println("DEBUG: Found products = " + list.size());
            return query.getResultList();
        }
    }

    public void insert(Product p) {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }
    }

    public void delete(int id) {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            em.getTransaction().begin();
            Product p = em.find(Product.class, id);
            if (p != null) {
                em.remove(p);
            }
            em.getTransaction().commit();
        }
    }

    public Product findById(int id) {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            return em.find(Product.class, id);
        }
    }

    public void update(Product p) {
        try (EntityManager em = EntityManagerFactoryUtil.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }
    }
}
