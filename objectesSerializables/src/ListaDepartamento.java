import java.io.Serializable;

public class ListaDepartamento implements Serializable
{
    public int num;
    public String nombre;
    public String localidad;

    public ListaDepartamento(int num, String nombre, String localidad) {
        this.num = num;
        this.nombre = nombre;
        this.localidad = localidad;
    }

   /* @Override
    public String toString() {
        return
                "Departamento: " + num +
                ", Nombre: " + nombre  +
                ", Localidad: " + localidad ;
    }*/

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


}
