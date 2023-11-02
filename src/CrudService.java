import java.util.List;

interface CrudService <T> {
    void save(T t);
    T get(int id);
    void update(T t);
    void delete(int id);
    List<T> getAll();
}
