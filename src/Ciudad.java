public class Ciudad {
    private int cod_ciudad;
    private int num_hab;
    private String nombre;

    public Ciudad() {
    }

    public Ciudad(int cod_ciudad, int num_hab, String nombre) {
        this.cod_ciudad = cod_ciudad;
        this.num_hab = num_hab;
        this.nombre = nombre;
    }

    public int getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(int cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    public int getNum_hab() {
        return num_hab;
    }

    public void setNum_hab(int num_hab) {
        this.num_hab = num_hab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "cod_ciudad=" + cod_ciudad +
                ", num_hab=" + num_hab +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
