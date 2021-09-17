
package modelo;


public class Producto {
    
    private String nArticulo;
    private String Seccion;
    private String Precio;
    private String Porigen;
    
    public Producto(){
    
        nArticulo = "";
        Seccion = "";
        Precio = "";
        Porigen = "";
    }

    public String getnArticulo() {
        return nArticulo;
    }

    public void setnArticulo(String nArticulo) {
        this.nArticulo = nArticulo;
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getPorigen() {
        return Porigen;
    }

    public void setPorigen(String Porigen) {
        this.Porigen = Porigen;
    }
    
     
}
