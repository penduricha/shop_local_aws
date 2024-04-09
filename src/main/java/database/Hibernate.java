package database;




import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Hibernate {
    private String persistence_Unit_Name;
    private EntityManagerFactory emf;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(EntityTransaction transaction) {
        this.transaction = transaction;
    }

    public String getPersistence_Unit_Name() {
        return persistence_Unit_Name;
    }

    public void setPersistence_Unit_Name(String persistence_Unit_Name) {
        this.persistence_Unit_Name = persistence_Unit_Name;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = Persistence.createEntityManagerFactory(persistence_Unit_Name);
    }
    public Hibernate() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Hibernate(String persistence_Unit_Name) {
        super();
        this.persistence_Unit_Name = persistence_Unit_Name;
        // Sử dụng thông tin kết nối phù hợp với MariaDB
        this.emf = Persistence.createEntityManagerFactory(persistence_Unit_Name);
        this.entityManager = emf.createEntityManager();
        this.transaction = entityManager.getTransaction();
    }

    /*
    private Map<String, String> getProperties() {
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.driver", "org.mariadb.jdbc.Driver");
        properties.put("javax.persistence.jdbc.url", "jdbc:mariadb://localhost:3306/shopPT");
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "123");
        // Thêm các thuộc tính khác nếu cần
        return properties;
    }*/
}

