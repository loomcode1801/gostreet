package clases;

import android.os.Parcel;
import android.os.Parcelable;

public class Bonos {

    private String fechaInicio, fechaFinal,Horario, codigo, cantidad, descuento,
            sinDescuento, descripcion;
    public Bonos() {
    }
    public Bonos(
            String fechaInicio, String fechaFinal, String Horario, String codigo, String cantidad,
            String descuento, String sinDescuento,String descripcion) {

        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.Horario = Horario;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.sinDescuento = sinDescuento;
        this.descripcion = descripcion;
    }

    public Bonos(String finicio, String ffinal, String horario, String codigo, String cantidad, String cantidad1, String descuento, String sindesc, String descrip) {
    }

    public String getfechaInicio() {
        return fechaInicio;
    }

    public void setfechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getfechaFinal() {
        return fechaFinal;
    }

    public void setfechaFina(String fechaFinal) {
        fechaFinal = fechaFinal;
    }
    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        Horario = Horario;
    }

    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String codigo) {
        codigo = codigo;
    }

    public String getcantidad() {
        return cantidad;
    }

    public void setcantidad(String cantidad) {
        cantidad = cantidad;
    }

    public String getdescuento() {
        return descuento;
    }

    public void setdescuento(String password) {
        descuento = descuento;
    }

    public String getsinDescuento() {
        return sinDescuento;
    }

    public void setsinDescuento(String sinDescuento) {
        sinDescuento = sinDescuento;
    }
    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String password) {
        descripcion = descripcion;
    }
    @Override
    public String toString() {
        return cantidad;
    }





}
