public class Concierto {
    private int cod_concierto;
    private String fecha;
    private int cod_grupo;
    private int cod_ciudad;

    public Concierto() {
    }

    public Concierto(int cod_concierto, String fecha, int cod_grupo, int cod_ciudad) {
        this.cod_concierto = cod_concierto;
        this.fecha = fecha;
        this.cod_grupo = cod_grupo;
        this.cod_ciudad = cod_ciudad;
    }

    public int getCod_concierto() {
        return cod_concierto;
    }

    public void setCod_concierto(int cod_concierto) {
        this.cod_concierto = cod_concierto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCod_grupo() {
        return cod_grupo;
    }

    public void setCod_grupo(int cod_grupo) {
        this.cod_grupo = cod_grupo;
    }

    public int getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(int cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    @Override
    public String toString() {
        return "Concierto{" +
                "cod_concierto=" + cod_concierto +
                ", fecha='" + fecha + '\'' +
                ", cod_grupo=" + cod_grupo +
                ", cod_ciudad=" + cod_ciudad +
                '}';
    }
}
