package by.itacademy.workbook.beans;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    private int id;

    @Override
    public String toString() {
        return "Entity=[" + id + "].";
    }
}
