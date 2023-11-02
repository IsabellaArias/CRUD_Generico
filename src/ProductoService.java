import java.util.ArrayList;
import java.util.List;

class ProductoService implements CrudService<Dto>{
    private List<Dto> productos = new ArrayList<>();
    @Override
    public void save(Dto producto) {
        productos.add(producto);
    }

    @Override
    public Dto get(int id) {
        return productos.stream()
        .filter(p->p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Dto producto) {
        Dto p= get(producto.getId());
        if (p != null){
            int index= productos.indexOf(p);
            productos.set(index,producto);
        }
    }

    @Override
    public void delete(int id) {
        Dto p= get(id);
        if (p != null){
            productos.remove(p);
        }
    }

    @Override
    public List<Dto> getAll() {
        return productos;
    }
}
