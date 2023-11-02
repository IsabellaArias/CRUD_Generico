import java.util.Scanner;

public interface MainCRUD {
    static void main(String[] args) {
        ProductoService producto=new ProductoService();
        Scanner sc=new Scanner(System.in);

        int opcion= 0;
        while (opcion != 5){
            System.out.println("\nMenu\n1. Agregar Producto\n2. Actualizar Producto\n3. Eliminar Producto\n4. Mostrar Productos\n5. Salir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1: {
                    System.out.println("Ingrese el id para el producto: ");
                    int id=sc.nextInt();

                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = sc.next();

                    System.out.print("Ingrese la Cantidad: ");
                    int cantidad = sc.nextInt();

                    Dto p = new Dto();
                    p.setId(id);
                    p.setProducto(nombre);
                    p.setCantidad(cantidad);

                    producto.save(p);
                    System.out.println("Producto agregada!");
                    break;
                }
                case 2: {

                    System.out.print("Ingrese el id del producto a actualizar: ");
                    int id = sc.nextInt();

                    Dto p = producto.get(id);

                    if (p == null) {
                        System.out.println("Producto no encontrado");
                    } else {
                        System.out.print("Ingrese el nuevo nombre del producto: ");
                        String nuevoNombre =sc.next();

                        p.setProducto(nuevoNombre);

                        System.out.print("Ingrese la cantidad: ");
                        int nuevaCantidad = sc.nextInt();

                        p.setCantidad(nuevaCantidad);

                        producto.update(p);

                        System.out.println("Producto actualizado!");
                    }

                    break;
                }
                case 3: {

                    System.out.print("Ingrese el id del producto a eliminar: ");
                    int id = sc.nextInt();

                    producto.delete(id);

                    System.out.println("Producto eliminado!");

                    break;
                }
                case 4: {
                    producto.getAll().forEach(pro -> {
                        System.out.println("Id: " + pro.getId() + " \n"+"Producto: " + pro.getProducto() + "\n"+"Cantidad: " + pro.getCantidad());
                    });
                    break;
                }
            }
        }
    }
}
