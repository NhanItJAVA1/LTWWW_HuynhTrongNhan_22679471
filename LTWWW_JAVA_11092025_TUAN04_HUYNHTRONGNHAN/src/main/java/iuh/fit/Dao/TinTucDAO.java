package iuh.fit.Dao;

import iuh.fit.Models.TinTuc;
import iuh.fit.Utils.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.List; 

public class TinTucDAO {

    public List<TinTuc> findByDanhMuc(int maDM) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            return em.createQuery(
                            "SELECT t FROM TinTuc t WHERE t.danhMuc.maDM = :maDM", TinTuc.class)
                    .setParameter("maDM", maDM)
                    .getResultList();
        }
    }

    public List<TinTuc> findAll() {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            return em.createQuery("SELECT t FROM TinTuc t", TinTuc.class).getResultList();
        }
    }

    public void save(TinTuc t) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        }
    }

    public void delete(int maTT) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            em.getTransaction().begin();
            TinTuc t = em.find(TinTuc.class, maTT);
            if (t != null) em.remove(t);
            em.getTransaction().commit();
        }
    }
}
