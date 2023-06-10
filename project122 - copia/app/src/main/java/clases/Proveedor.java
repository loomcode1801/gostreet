package clases;

public class Proveedor {

    private int id;
    private String usuario, correo, password, direccion, documento, razonSocial, telefono;

    public Proveedor() {
    }


    //constructor

    public Proveedor(String usuario, String correo, String password, String direccion, String documento, String razonSocial, String telefono) {
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
        this.direccion = direccion;
        this.documento = documento;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
    }

    //constructor


    // clic clic derecho → getter and setter → selecciona id, nombre Email



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    // clic clic derecho → getter and setter → selecciona id, nombre Email



}
