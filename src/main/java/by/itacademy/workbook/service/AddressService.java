package by.itacademy.workbook.service;

import by.itacademy.workbook.beans.Address;
import by.itacademy.workbook.beans.Employee;
import by.itacademy.workbook.dao.AddressDAO;
import by.itacademy.workbook.dao.EmployeeDAO;
import by.itacademy.workbook.exceptions.OperationIsNotSupportedException;
import by.itacademy.workbook.utils.ConsoleReaderWriter;

public class AddressService implements IService {

    private Address address;
    private AddressDAO addressDAO = new AddressDAO();

    @Override
    public void add() throws Exception {
        address = new Address();

        Employee employee = getEmployee();

        ConsoleReaderWriter.write("Enter address employee.\n Enter city:");
        address.setCity(ConsoleReaderWriter.read());

        ConsoleReaderWriter.write("Enter street:");
        address.setStreet(ConsoleReaderWriter.read());

        ConsoleReaderWriter.write("Enter house:");
        address.setHouse(ConsoleReaderWriter.read());

        address.setEmployee(employee);
        addressDAO.save(address);
        ConsoleReaderWriter.write("Address of the user with id=" + employee.getEmployeeId() + " added");
    }

    @Override
    public void update() throws Exception {
        address = new Address();

        Employee employee = getEmployee();

        ConsoleReaderWriter.write("Enter new address employee.\n Enter city:");
        address.setCity(ConsoleReaderWriter.read());

        ConsoleReaderWriter.write("Enter street:");
        address.setStreet(ConsoleReaderWriter.read());

        ConsoleReaderWriter.write("Enter house:");
        address.setHouse(ConsoleReaderWriter.read());

        address.setEmployee(employee);
        addressDAO.update(address);
        ConsoleReaderWriter.write("Address of the user with id=" + employee.getEmployeeId() + " updated");
    }

    @Override
    public void delete() throws Exception {
        address = new Address();
        Employee employee = getEmployee();
        address.setEmployee(employee);
        addressDAO.delete(address);
    }

    @Override
    public void show() throws Exception {
        throw new OperationIsNotSupportedException("Operation is not supported.");
    }

    @Override
    public void showAll() throws Exception {
        throw new OperationIsNotSupportedException("Operation is not supported.");
    }

    private Employee getEmployee() throws Exception {
        ConsoleReaderWriter.write("Enter ID employee:");
        int id = Integer.parseInt(ConsoleReaderWriter.read());
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.get(id);
        return employee;
    }
}
