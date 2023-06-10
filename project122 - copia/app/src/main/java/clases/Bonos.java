package clases;

public class Bonos {

    private String fechaInicio, fechaFinal,HoraInicio;


    public Bonos() {
    }


    public Bonos(String fechaInicio, String fechaFinal, String horaInicio) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        HoraInicio = horaInicio;
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
        return HoraInicio;
    }

    public void setHoraInicio(String horaInicio) {
        HoraInicio = horaInicio;
    }

    @Override
    public String toString() {
        return fechaInicio ;
    }

}
