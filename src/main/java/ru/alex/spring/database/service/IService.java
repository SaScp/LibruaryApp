package ru.alex.spring.database.service;

import java.util.List;

public interface IService<T>  {
    public void save(T newObject);
    public void update(T updateObject,int id);
    public void delete(int id);
    public T showInfo(int id);
    public List<T> index();
}
