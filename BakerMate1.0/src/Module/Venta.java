package Model;

import java.sql.Date;

public class Venta {

    int id_venta;
    String fecha;
    double cantidad;
    double precio_venta;
    int id_propducto;
    int id_usuario;
    int id_tipo_venta;

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getId_propducto() {
        return id_propducto;
    }

    public void setId_propducto(int id_propducto) {
        this.id_propducto = id_propducto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_tipo_venta() {
        return id_tipo_venta;
    }

    public void setId_tipo_venta(int id_tipo_venta) {
        this.id_tipo_venta = id_tipo_venta;
    }

    public Venta() {
    }

    public Venta(int id_venta, String fecha, double cantidad, double precio_venta, int id_propducto, int id_usuario, int id_tipo_venta) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
        this.id_propducto = id_propducto;
        this.id_usuario = id_usuario;
        this.id_tipo_venta = id_tipo_venta;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + ", fecha=" + fecha + ", cantidad=" + cantidad + ", precio_venta=" + precio_venta + ", id_propducto=" + id_propducto + ", id_usuario=" + id_usuario + ", id_tipo_venta=" + id_tipo_venta + '}';
    }

}
