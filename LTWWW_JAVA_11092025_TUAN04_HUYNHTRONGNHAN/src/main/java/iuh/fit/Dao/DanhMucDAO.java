package iuh.fit.Dao;

import iuh.fit.Models.DanhMuc;
import iuh.fit.Utils.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class DanhMucDAO {

    public List<DanhMuc> findAll() {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            return em.createQuery("SELECT d FROM DanhMuc d", DanhMuc.class).getResultList();
        }
    }

    public DanhMuc findById(int id) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            return em.find(DanhMuc.class, id);
        }
    }
}
