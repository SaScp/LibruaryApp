package ru.alex.spring.database.DAO;

import java.util.List;

public interface ILibruaryDAO<T> {
    public void save(T newObject);
    public void update(T updateObject,int id);
    public void delete(int id);
    public T showInfo(int id);
    public List<T> index();
 }
