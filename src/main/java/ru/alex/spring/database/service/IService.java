package ru.alex.spring.database.service;

import java.util.List;

public interface IService<T>  {
    public void save(T newObject);
    public void update(T updateObject,Integer id);
    public void delete(Integer id);
    public T showInfo(Integer id);
    public List<T> index();
}
