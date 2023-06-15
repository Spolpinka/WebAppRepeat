import dao.EmployeeDAO;
import dao.impls.EmployeeDAOImpl;
import model.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        //получение всего списка сотрудников
        employeeDAO.getAllEmployee().forEach(System.out::println);

        //создаем нового сотрудника
        Employee employee = new Employee("Gadya", "Petrovich-Hrenovo", "female", 35, 3);
        //добавляем его в таблицу employee
        employeeDAO.save(employee);

        //получаем единичного сотрудника по id
        Employee employeeForUpdate = employeeDAO.getEmployeeById(1);
        System.out.println(employeeForUpdate);

        //Изменение сотрудника
        employeeForUpdate.setFirstName("Gadya Petrovich Hrenovo");
        employeeDAO.update(employeeForUpdate);


        //удаляем сотрудника
        employeeDAO.delete(employee);

    }
}
