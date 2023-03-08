import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.List;

public class tiendirria {
    
    
    /** 
     * @param carreta
     * @param objeto
     * @param categoria
     * @param cantidad
     */
    public void addCarreta(Map<Integer, Objeto> carreta, String objeto, String categoria, int cantidad)
    {
        int key = carreta.size() +1;
        Objeto Objeto = new Objeto(objeto, categoria, cantidad);
        carreta.put(key, Objeto);
    }

    
    /** 
     * @param objetos
     * @return String
     */
    public String objetosOrdPorCategoria(Map<Integer, Objeto> objetos) {
        Map<String, List<Objeto>> objetosPorCategoria = new HashMap<>();
        for (Objeto objeto : objetos.values()) {
            String categoria = objeto.getCateogria();
            objetosPorCategoria.computeIfAbsent(categoria, k -> new ArrayList<>()).add(objeto);
        }
        List<String> categoriasOrdenadas = new ArrayList<>(objetosPorCategoria.keySet());
        Collections.sort(categoriasOrdenadas);
    
        String resultado = "";
        for (String categoria : categoriasOrdenadas) {
            resultado += "\n\t\tCategoría: " + categoria + "\n";            
            List<Objeto> objetosDeCategoria = objetosPorCategoria.get(categoria);
            objetosDeCategoria.sort(Comparator.comparing(Objeto::getNombre));
            for (Objeto objeto : objetosDeCategoria) {
                resultado += "Categoría: " + objeto.getCateogria() + "; Producto: " + objeto.getNombre() + "; Cantidad: " + objeto.getExistence() + "\n---------------------------------------------------------------------------------\n";
            }
        }
        return resultado;
    }
    
    
    /** 
     * @param objetos
     * @param nombreObjeto
     * @return String
     */
    public String buscarCategoriaObjeto(Map<Integer, Objeto> objetos, String nombreObjeto) {
        for (Objeto objeto : objetos.values()) {
            if (objeto.getNombre().equals(nombreObjeto)) {
                return String.format("La categoría del producto '%s' es '%s'", nombreObjeto, objeto.getCateogria());
            }
        }
        return String.format("No se encontró el producto", nombreObjeto);
    }
    
    
    /** 
     * @param objetos
     * @return String
     */
    public String produtosSinSort(Map<Integer, Objeto> objetos) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Objeto> objeto : objetos.entrySet()) {
            int indice = objeto.getKey();
            String categoria = objeto.getValue().getCateogria();
            String nombre = objeto.getValue().getNombre();
            int existencias = objeto.getValue().getExistence();
            sb.append("Producto número: ").append(indice).append("; Categoría: ").append(categoria).append("; Producto: ").append(nombre).append("; Cantidad: ").append(existencias).append("\n");
        }
        return sb.toString();
    }
    
    
    
}