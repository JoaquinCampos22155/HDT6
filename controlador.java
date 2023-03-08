import java.util.Map;
import java.util.Scanner;

public class controlador {

private int opcionMenu;
private LectorInventario lector = new LectorInventario();
private Map<Integer, Objeto> inv;
private int opcion;
private Map<Integer, Objeto> carrito;
private boolean flag = true;
private Scanner teclado = new Scanner(System.in);
private tiendirria tiendirria = new tiendirria();
public void iniciar() {
    System.out.println("Bienvenido ¿Qué tipo de mapa deseas utilizar? \n1. TreeMap \n2. HashMap \n3. LinkedHashMap");
    opcion = teclado.nextInt();
    inv = Mapas.fabrica(opcion);
    carrito = Mapas.fabrica(opcion);
    lector.getInventory(inv, "ListadodeObjetos.txt");
    
    while (flag) {
        System.out.println("¿Qué desea hacer? \n 1. Agregar un producto a la carreta \n 2. Ver la categoría del producto \n 3. Ver el contenido de la carreta \n 4. Ordenar por categoria \n 5. Ver todos los productos y sus categorías \n 6. Ver todos los productos y sus categorías ordenados \n 7. Salir");
        opcionMenu = teclado.nextInt();

        switch (opcionMenu) {
            case 1:
                System.out.println("Nombre del producto? ");
                String nombre = teclado.next();
                System.out.println("Categoría del producto? ");
                String categoria = teclado.next();
                System.out.println("Cantidad de producto: ");
                int cantidad = teclado.nextInt();
                boolean flag2 = false;
                
                for (Map.Entry<Integer, Objeto> entry : inv.entrySet()) {
                    Objeto objeto= entry.getValue();
                    if (objeto.getNombre().equals(nombre) && objeto.getCateogria().equals(categoria)) {
                        tiendirria.addCarreta(carrito, nombre, categoria, cantidad);
                        flag2 = true;
                    }
                }
                if (!flag2) {
                    System.out.println("No se encontró ningún producto");
                }
                break;

            case 2:
                System.out.println("Ingresa el nombre del producto:");
                String nombreObjeto = teclado.next();
                System.out.println(tiendirria.buscarCategoriaObjeto(inv, nombreObjeto));
                break;

            case 3:
                System.out.println(tiendirria.produtosSinSort(carrito));
                break;

            case 4:
                System.out.println(tiendirria.objetosOrdPorCategoria(carrito));
                break;

            case 5:
                System.out.println(tiendirria.produtosSinSort(inv));
                break;

            case 6:
                System.out.println(tiendirria.objetosOrdPorCategoria(inv));
                break;

            case 7:
                System.out.println("Feliz dia");
                flag = false;
                break;

            default:
                System.out.println("Error. ingrese valor valido");
                break;
        }
    }
}

}