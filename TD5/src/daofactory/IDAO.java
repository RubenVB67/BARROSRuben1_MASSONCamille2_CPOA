<<<<<<< HEAD
package daofactory;

import java.util.ArrayList;

public interface IDAO <T>{
    public abstract T getById(int id);
    public abstract ArrayList<T> findAll();
    public abstract boolean create(T object);
    public abstract boolean update(T object);
    public abstract boolean delete(T object);
}
=======
package daofactory;

import java.util.ArrayList;

public interface IDAO <T>{
    //public abstract T getById(int id); mis dans les metiers sql
    public abstract ArrayList<T> findAll();
    public abstract boolean create(T object);
    public abstract boolean update(T object);
    public abstract boolean delete(T object);
}
>>>>>>> 509b770864a6dee7ba0d4f0e59639ed62484fcc1
