package es.ufv.dis.final2022.ASA;

public class Productos {
    private String nombre;
    private String categoria;
    private String ean13;
    private String precio;

    public Productos() {
    }

    public Productos(String nombre, String categoria, String ean13, String precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.ean13 = ean13;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", ean13='" + ean13 + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
