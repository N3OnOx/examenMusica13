public class Grupo {
    private int cod_grupo;
    private String nombre;
    private String estilo;

    public Grupo() {
    }

    public Grupo(int cod_grupo, String nombre, String estilo) {
        this.cod_grupo = cod_grupo;
        this.nombre = nombre;
        this.estilo = estilo;
    }

    public int getCod_grupo() {
        return cod_grupo;
    }

    public void setCod_grupo(int cod_grupo) {
        this.cod_grupo = cod_grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "cod_grupo=" + cod_grupo +
                ", nombre='" + nombre + '\'' +
                ", estilo='" + estilo + '\'' +
                '}';
    }
}
