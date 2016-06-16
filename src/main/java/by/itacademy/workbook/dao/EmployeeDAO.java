package by.itacademy.workbook.dao;

import by.itacademy.workbook.constants.ExceptionMessageConstants;
import by.itacademy.workbook.beans.Employee;
import by.itacademy.workbook.exceptions.DoesNotExistsException;
import by.itacademy.workbook.exceptions.ListIsEmptyException;
import by.itacademy.workbook.utils.SessionManager;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDAO implements IDAO<Employee> {
    Session session;

    public EmployeeDAO(){
        session = SessionManager.getSessionFactory().openSession();
    }
    @Override
    public void save(Employee employee) {
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Employee employee) throws Exception {
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employeeDelete = (Employee) session.get(Employee.class, employee.getEmployeeId());
        if (null == employeeDelete)
            throw new DoesNotExistsException(ExceptionMessageConstants.EMPLOYEE_DOES_NOT_EXIST);
        session.delete(employeeDelete);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Employee employee) throws Exception {
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employeeUpdate = (Employee) session.get(Employee.class, employee.getEmployeeId());
        if (null == employeeUpdate)
            throw new DoesNotExistsException(ExceptionMessageConstants.EMPLOYEE_DOES_NOT_EXIST);
        employeeUpdate.setName(employee.getName());
        employeeUpdate.setSurname(employee.getSurname());
        employeeUpdate.setAddress(employee.getAddress());
        session.update(employeeUpdate);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Employee get(int id) throws Exception {
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, id);
        if (null == employee)
            throw new DoesNotExistsException(ExceptionMessageConstants.EMPLOYEE_DOES_NOT_EXIST);
        session.close();
        return employee;
    }

    @Override
    public List<Employee> getList() throws Exception {
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee");
        List<Employee> list = query.list();
        if (list.isEmpty())
            throw new ListIsEmptyException(ExceptionMessageConstants.EMPLOYEE_LIST_EMPTY);
        session.close();
        return list;
    }
}
