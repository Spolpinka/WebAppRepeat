package dao.impls;

import dao.EmployeeDAO;
import model.Employee;

import javax.persistence.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAllEmployee() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        String queryString = "SELECT e FROM Employee e ORDER BY id";
        TypedQuery<Employee> query = entityManager.createQuery(queryString, Employee.class);

        List<Employee> employees = query.getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return employees;
    }

    @Override
    public void save(Employee employee) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        /*String queryString = "INSERT INTO Employee (id, first_name, last_name, gender, age, city_id) " +
                "VALUES (:id, :first_name, :last_name, :gender, :age, :city_id)";
        entityManager.createNativeQuery(queryString)
                .setParameter("id", employee.getId())
                .setParameter("first_name", employee.getFirstName())
                .setParameter("last_name", employee.getLastName())
                .setParameter("gender", employee.getGender())
                .setParameter("age", employee.getAge())
                .setParameter("city_id", employee.getCityId())
                .executeUpdate();
        */
        entityManager.persist(employee);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public Employee getEmployeeById(int id) {
        //get Employee by id
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee employee = entityManager.find(Employee.class, id);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return employee;
    }

    @Override
    public void update(Employee employee) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(employee);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void delete(Employee employee) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.remove(employee);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
