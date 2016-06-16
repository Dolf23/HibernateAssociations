package by.itacademy.workbook.dao;

import by.itacademy.workbook.constants.ExceptionMessageConstants;
import by.itacademy.workbook.beans.Address;
import by.itacademy.workbook.exceptions.DoesNotExistsException;
import by.itacademy.workbook.exceptions.ListIsEmptyException;
import by.itacademy.workbook.utils.SessionManager;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class AddressDAO implements IDAO<Address> {

    private Session session;

    @Override
    public void save(Address address) {
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Address address) throws DoesNotExistsException{
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Address addressDelete = (Address) session.get(Address.class, address.getAddressId());
         if (null == addressDelete)
             throw new DoesNotExistsException(ExceptionMessageConstants.ADDRESS_DOES_NOT_EXIST);
        session.delete(addressDelete);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Address address) throws DoesNotExistsException {
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Address addressUpdate = (Address) session.get(Address.class, address.getAddressId());
        if (null == addressUpdate)
            throw new DoesNotExistsException(ExceptionMessageConstants.ADDRESS_DOES_NOT_EXIST);
        addressUpdate.setCity(address.getCity());
        addressUpdate.setStreet(address.getStreet());
        addressUpdate.setHouse(address.getHouse());
        session.update(addressUpdate);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Address get(int id) throws DoesNotExistsException {
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Address address = (Address) session.get(Address.class, id);
        if (null == address)
            throw new DoesNotExistsException(ExceptionMessageConstants.ADDRESS_DOES_NOT_EXIST);
        session.close();
        return address;
    }

    @Override
    public List<Address> getList() throws ListIsEmptyException {
        session = SessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Address ");
        List<Address> list = query.list();
        if (list.isEmpty())
            throw new ListIsEmptyException(ExceptionMessageConstants.ADDRESS_LIST_EMPTY);
        session.close();
        return list;
    }
}
