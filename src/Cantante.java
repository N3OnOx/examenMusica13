public class Cantante {
    private int cod_cantante;
    private String nombre;
    private int edad;
    private int cod_ciudad;

    public Cantante() {
    }

    public Cantante(int cod_cantante, String nombre) {
        this.cod_cantante = cod_cantante;
        this.nombre = nombre;
    }

    public Cantante(String nombre, int edad, int cod_ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.cod_ciudad = cod_ciudad;
    }

    public int getCod_cantante() {
        return cod_cantante;
    }

    public void setCod_cantante(int cod_cantante) {
        this.cod_cantante = cod_cantante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(int cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    @Override
    public String toString() {
        return "Cantante{" +
                "cod_cantante=" + cod_cantante +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", cod_ciudad=" + cod_ciudad +
                '}';
    }
}
