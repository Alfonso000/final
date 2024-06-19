package es.ufv.dis.final2022.ASA;

public class Productos {
    private String Nombre;
    private String Categoria;
    private String EAN13;
    private int precio;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getEAN13() {
        return EAN13;
    }

    public void setEAN13(String EAN13) {
        this.EAN13 = EAN13;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Productos() {
    }

    public Productos(String nombre, String categoria, String EAN13, int precio) {
        Nombre = nombre;
        Categoria = categoria;
        this.EAN13 = EAN13;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "Nombre='" + Nombre + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", EAN13='" + EAN13 + '\'' +
                ", precio=" + precio +
                '}';
    }
}
