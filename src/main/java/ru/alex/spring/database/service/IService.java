package ru.alex.spring.database.service;

import ru.alex.spring.database.domin.Book;
import ru.alex.spring.database.domin.Person;

import java.util.List;

public interface IService<T>  {
    public void save(T newObject);
    public void update(Object data, Integer id, String actions);
    public void delete(Integer id);
    public T showInfo(Integer id);
    public List<T> index();
}
