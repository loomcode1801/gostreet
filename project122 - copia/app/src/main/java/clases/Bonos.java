package clases;

public class Bonos {

/*
    private String fechaInicio, fechaFinal,HoraInicio, HoraFin,  descripcion;

    private int cantidad, descuento, precio;
*/


    private String fechaInicio,fechaFinal, horaInicio, horaFin, descripcion;
    private int cantidad, descuento, precio;


    public Bonos() {
    }

    public Bonos(String fechaInicio, String fechaFinal, String horaInicio, String horaFin, int cantidad, int descuento, int precio, String descripcion) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.precio = precio;
        this.descripcion = descripcion;

    }

    public Bonos(String fechaInicio, String fechaFinal, int cantidad) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.cantidad = cantidad;
    }

    public Bonos(String fechaInicio, int cantidad) {
        this.fechaInicio = fechaInicio;
        this.cantidad = cantidad;
    }




    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    //numeros  * - -  -  -- - -    -      -
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }





}
