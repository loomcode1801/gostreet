package clases;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {
    private int id;
    private String nombre;

    public Cliente() {
    }


    // clic derecho → constructor → "id" y "nombre"
    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    // clic derecho → constructor → "id" y "nombre"





    // clic clic derecho → getter and setter → selecciona id y nombre
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // clic clic derecho → getter and setter → selecciona id y nombre



    // clic derecho → toString → selecciona los elementos que quiere mostrar en el listado
    //en este caso nombre
    @Override
    public String toString() {
        return nombre;
    }
    // clic derecho → toString → selecciona los elementos que quiere mostrar en el listado




    /*hasta aquiTodo lo que se va a utilizar en la app de momento*/
    // !   !  !  !   !  !  !   !  !  !   !  !  !   !  !  !   !  !  !   !  !





    /*
    ejemplo del video
    // clic derecho → toString → selecciona los elementos que quiere mostrar en el listado
    //en este caso nombre
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                '}';
    } 23:10
    // clic derecho → toString → selecciona los elementos que quiere mostrar en el listado
    */


    // clic derecho → generate → parcerable → string
    // solo en caso de que se quiera mandar un objeto de una ventana a otra
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nombre);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.nombre = source.readString();
    }

    protected Cliente(Parcel in) {
        this.id = in.readInt();
        this.nombre = in.readString();
    }

    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel source) {
            return new Cliente(source);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };
    // clic derecho → generate → parcerable → string
    // solo en caso de que se quiera mandar un objeto de una ventana a otra
}
