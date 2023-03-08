import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;
public class Mapas {

    public static Map<Integer, Objeto> fabrica(int tipo)
    {
        switch(tipo)
        {
            case 1:
            {
                return new TreeMap<Integer, Objeto>();
            }
            case 2:
            {
                return new HashMap<Integer,Objeto>();
            }
            case 3:
            {
                return new LinkedHashMap<Integer, Objeto>();
            }
            default:
            {
                throw new IllegalArgumentException("Selecciona una opción correcta");
            }
        }
    }
}
