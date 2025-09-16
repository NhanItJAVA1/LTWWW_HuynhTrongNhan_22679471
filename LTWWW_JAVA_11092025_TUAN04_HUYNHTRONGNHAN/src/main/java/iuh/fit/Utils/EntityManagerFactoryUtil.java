package iuh.fit.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory entityManageFactory;
    static {
        try {
            entityManageFactory = Persistence.createEntityManagerFactory("shoppingdb");
        } catch (Throwable er) {
            System.err.println("Khởi tạo bất thành😔😔😔😔" + er);
            throw new ExceptionInInitializerError(er);
        }
    }
    public static EntityManager getEntityManager() {
        return entityManageFactory.createEntityManager();
    }
    public static void close() {
        if (entityManageFactory.isOpen()) {
            entityManageFactory.close();
        }
    }
}
