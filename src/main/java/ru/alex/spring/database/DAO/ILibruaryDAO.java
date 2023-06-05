package ru.alex.spring.database.DAO;

import ru.alex.spring.database.domin.Book;

import java.util.List;

public interface ILibruaryDAO<T> {
    public void save(T newObject);
    public void update(T updateObject,Integer id);


    public void delete(Integer id);
    public T showInfo(Integer id);
    public List<T> index();
 }
