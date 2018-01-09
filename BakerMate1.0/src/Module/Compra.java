package Model;

import java.sql.Date;

public class Compra {

    int id_compra;
    String fecha;
    double cantidad;
    int id_estado_compra;
    int id_producto;
    int id_usuario;

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
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

    public int getId_estado_compra() {
        return id_estado_compra;
    }

    public void setId_estado_compra(int id_estado_compra) {
        this.id_estado_compra = id_estado_compra;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Compra() {
    }

    public Compra(int id_compra, String fecha, double cantidad, int id_estado_compra, int id_producto, int id_usuario) {
        this.id_compra = id_compra;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.id_estado_compra = id_estado_compra;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Compra{" + "id_compra=" + id_compra + ", fecha=" + fecha + ", cantidad=" + cantidad + ", id_estado_compra=" + id_estado_compra + ", id_producto=" + id_producto + ", id_usuario=" + id_usuario + '}';
    }

}
