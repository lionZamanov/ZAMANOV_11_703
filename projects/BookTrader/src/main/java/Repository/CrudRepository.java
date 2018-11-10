package Repository;

public interface CrudRepository<T> {
    void save(T model);
    T find(int id);
    boolean update(int id);
    boolean remove(int id);
}
