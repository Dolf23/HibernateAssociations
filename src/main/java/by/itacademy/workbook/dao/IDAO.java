package by.itacademy.workbook.dao;

import by.itacademy.workbook.beans.Entity;

import java.util.List;

public interface IDAO<TYPE extends Entity> {
    void save(TYPE type);
    void delete(TYPE type) throws Exception;
    void update(TYPE type) throws Exception;
    TYPE get(int id) throws Exception;
    List<TYPE> getList() throws Exception;
}

