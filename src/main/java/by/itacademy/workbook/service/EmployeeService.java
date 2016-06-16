package by.itacademy.workbook.service;

import by.itacademy.workbook.dao.EmployeeDAO;
import by.itacademy.workbook.beans.Employee;
import by.itacademy.workbook.exceptions.DoesNotExistsException;
import by.itacademy.workbook.exceptions.ListIsEmptyException;
import by.itacademy.workbook.utils.ConsoleReaderWriter;

import java.io.IOException;
import java.util.List;

public class EmployeeService implements IService{

    private Employee employee;
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void add() throws IOException {
        employee = new Employee();

        ConsoleReaderWriter.write("Enter name:");
        String name = ConsoleReaderWriter.read();
        employee.setName(name);

        ConsoleReaderWriter.write("Enter surname:");
        String surname = ConsoleReaderWriter.read();
        employee.setSurname(surname);

        employeeDAO.save(employee);
        ConsoleReaderWriter.write("User added.\n");
    }

    @Override
    public void update() throws IOException {
        employee = new Employee();

        ConsoleReaderWriter.write("Enter ID:");
        int id = Integer.parseInt(ConsoleReaderWriter.read());
        employee.setEmployeeId(id);

        ConsoleReaderWriter.write("Enter new name:");
        String name = ConsoleReaderWriter.read();
        employee.setName(name);

        ConsoleReaderWriter.write("Enter new surname:");
        String surname = ConsoleReaderWriter.read();
        employee.setSurname(surname);

        try{
            employeeDAO.update(employee);
            ConsoleReaderWriter.write("User updated.\n");
        }
        catch (Exception e){
            ConsoleReaderWriter.write(e.getMessage());
        }
    }

    @Override
    public void delete() throws IOException {
        ConsoleReaderWriter.write("Enter ID:");
        int id = Integer.parseInt(ConsoleReaderWriter.read());
        employee = new Employee();
        employee.setEmployeeId(id);
        try{
            employeeDAO.delete(employee);
            ConsoleReaderWriter.write("User deleted.\n");
        }
        catch (Exception e){
            ConsoleReaderWriter.write(e.getMessage());
        }
    }

    @Override
    public void show() throws IOException {
        ConsoleReaderWriter.write("Enter ID:");
        int id = Integer.parseInt(ConsoleReaderWriter.read());
        try {
            ConsoleReaderWriter.write(employeeDAO.get(id) + "\n");
        }
        catch (Exception e){
            ConsoleReaderWriter.write(e.getMessage());
        }
    }

    @Override
    public void showAll() {
        try {
            List<Employee> list = employeeDAO.getList();
            for (Employee entity:list)
                ConsoleReaderWriter.write(entity.toString());
            ConsoleReaderWriter.write("\n");
        } catch (Exception e) {
            ConsoleReaderWriter.write(e.getMessage());
        }
    }
}
