package daofactory;

import java.util.ArrayList;

public interface IDAO <T>{
    public abstract T getById(int id);
    public abstract ArrayList<T> findAll();
    public abstract boolean create(T object);
    public abstract boolean update(T object);
    public abstract boolean delete(T object);
}
