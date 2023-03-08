public class Objeto {
    private String nombre;
    private String cateogria;
    private int existence;
    public Objeto(String objeto, String categoria, int existence)
    {
        this.nombre = objeto;
        this.cateogria = categoria;
        this.existence = existence;
    }

    
    public String getNombre() {
        return this.nombre;
    }

    
    public void setNombre(String objeto) {
        this.nombre = objeto;
    }

            
    public String getCateogria() {
        return this.cateogria;
    }

    
    
    public void setCateogria(String cateogria) {
        this.cateogria = cateogria;
    }

    
    public int getExistence() {
        return this.existence;
    }

    
    
    public void setExistence(int existence) {
        this.existence = existence;
    }

    @Override
    public String toString() {
        return "{" +
            " producto='" + getNombre() + "'" +
            ", cateogria='" + getCateogria() + "'" +
            ", existence='" + getExistence() + "'" +
            "}";
    }
    
    
}
