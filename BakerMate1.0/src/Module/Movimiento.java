package Model;

public class Movimiento {

    int id_movimiento;
    String fecha;
    String detalle;
    double monto;
    int id_tipo_movimiento;
    int id_usuario;

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getId_tipo_movimiento() {
        return id_tipo_movimiento;
    }

    public void setId_tipo_movimiento(int id_tipo_movimiento) {
        this.id_tipo_movimiento = id_tipo_movimiento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Movimiento() {
    }

    public Movimiento(int id_movimiento, String fecha, String detalle, double monto, int id_tipo_movimiento, int id_usuario) {
        this.id_movimiento = id_movimiento;
        this.fecha = fecha;
        this.detalle = detalle;
        this.monto = monto;
        this.id_tipo_movimiento = id_tipo_movimiento;
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "id_movimiento=" + id_movimiento + ", fecha=" + fecha + ", detalle=" + detalle + ", monto=" + monto + ", id_tipo_movimiento=" + id_tipo_movimiento + ", id_usuario=" + id_usuario + '}';
    }

}
