import java.sql.*;
import java.util.ArrayList;

public class BDController {
    private Connection conexion;
    private PreparedStatement existeCantante;
    private PreparedStatement existeGrupo;
    private PreparedStatement existeCiudad;
    private PreparedStatement existeCantYGrupo;
    private PreparedStatement existeConcierto;

    BDController(){
        try {
            this.conexion = DriverManager.getConnection("jdbc:mysql://192.168.10.252:3306/musica", "1GS","Nelson2000");
            //this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica", "root","");
            String SQLExisteCantante = "select * from cantantes where cod_cantante = ?";
            this.existeCantante = conexion.prepareStatement(SQLExisteCantante);
            String SQLExisteGrupo = "select * from grupos where cod_grupo = ?;";
            this.existeGrupo = conexion.prepareStatement(SQLExisteGrupo);
            String SQLExisteCiudad = "select * from ciudades where cod_ciudad = ?;";
            this.existeCiudad = conexion.prepareStatement(SQLExisteCiudad);
            String SQLExisteCantYGrupo = "select * from cantan where cod_cantante = ? and cod_grupo = ?;";
            this.existeCantYGrupo = conexion.prepareStatement(SQLExisteCantYGrupo);
            String SQLExisteConcierto = "select * from conciertos where cod_concierto = ?;";
            this.existeConcierto = conexion.prepareStatement(SQLExisteConcierto);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /*----------------------ALTAS---------------------*/
    public void altaCantante(Cantante cantante){
        String sql = "insert into cantantes values ("+cantante.getCod_cantante()+",'"+cantante.getNombre()+"', "+cantante.getEdad()+", "+cantante.getCod_ciudad()+")";
        try {
            Statement ms = this.conexion.createStatement();
            ms.executeUpdate(sql);
            ms.close();
            System.out.println("Se ha dado de alta el cantante correctamente");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void altaGrupo(Grupo grupo){
        String sql = "insert into grupos values ("+grupo.getCod_grupo()+",'"+grupo.getNombre()+"', '"+grupo.getEstilo()+"')";
        try {
            Statement ms = this.conexion.createStatement();
            ms.executeUpdate(sql);
            ms.close();
            System.out.println("Se ha dado de alta el grupo correctamente");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void altaCantan(int cod_cantante, int cod_grupo){
        String sql = "insert into cantan values ("+cod_cantante+","+cod_grupo+")";
        try {
            Statement ms = this.conexion.createStatement();
            ms.executeUpdate(sql);
            ms.close();
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void altaConcierto(Concierto concierto){
        String sql = "insert into conciertos values ("+concierto.getCod_concierto()+",'"+concierto.getFecha()+"',"+concierto.getCod_grupo()+","+concierto.getCod_ciudad()+")";
        try {
            Statement ms = conexion.createStatement();
            ms.executeUpdate(sql);
            ms.close();
            System.out.println("Se ha dado de alta el concierto correctamente");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    /*----------------------CONSULTAS---------------------*/
    public ArrayList<Grupo> gruposCodigo(int cod_grupo){
        String sql = "SELECT * FROM grupos where cod_grupo = "+cod_grupo+"";
        ArrayList<Grupo> grupos = new ArrayList<>();
        try {
            Statement ms = conexion.createStatement();
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()){
                grupos.add(new Grupo(rs.getInt("cod_grupo"), rs.getString("nombre"),rs.getString("estilo")));
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return grupos;
    }
    public ArrayList<String> nombreCantantesCodigo(int cod_grupo){
        String sql = "select nombre from cantantes where cod_cantante in (select cod_cantante from cantan where cod_grupo = "+cod_grupo+");";
        ArrayList<String> nombresCantantes = new ArrayList<>();
        try {
            Statement ms = conexion.createStatement();
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()){
                nombresCantantes.add(rs.getString(1));
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return nombresCantantes;
    }
    public ArrayList<Cantante> listadoCantantes(){
        String sql = "select nombre, edad, cod_ciudad from cantantes;";
        ArrayList<Cantante> cantantes = new ArrayList<>();
        try {
            Statement ms = conexion.createStatement();
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()){
                cantantes.add(new Cantante(rs.getString("nombre"),rs.getInt("edad"),rs.getInt("cod_ciudad")));
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return cantantes;
    }
    public ArrayList<String> ciudades(){
        String sql = "select cod_ciudad, nombre from ciudades;";
        ArrayList<String> ciudades = new ArrayList<>();
        try {
            Statement ms = conexion.createStatement();
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()){
                ciudades.add("Codigo: " + rs.getInt("cod_ciudad") + " Ciudad: " + rs.getString("nombre"));
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return ciudades;
    }
    public ArrayList<Grupo> grupos(){
        String sql = "select cod_grupo, nombre from grupos;";
        ArrayList<Grupo> grupos = new ArrayList<>();
        try {
            Statement ms = conexion.createStatement();
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()){
                grupos.add(new Grupo(rs.getInt("cod_grupo"), rs.getString("nombre")));
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return grupos;
    }
    public ArrayList<Cantante> cantantes(){
        String sql = "select cod_cantante, nombre from cantantes;";
        ArrayList<Cantante> cantantes = new ArrayList<>();
        try {
            Statement ms = conexion.createStatement();
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()){
                cantantes.add(new Cantante(rs.getInt("cod_cantante"), rs.getString("nombre")));
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return cantantes;
    }

    /*----------------------TRADUCTORES---------------------*/
    public String traductorCiudad(int cod_ciudad){
        String sql = "select nombre from ciudades where cod_ciudad = "+cod_ciudad+";";
        String nombreCiudad = "";
        try {
            Statement ms = conexion.createStatement();
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()){
                nombreCiudad = rs.getString(1);
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return nombreCiudad;
    }
    public String traductorGrupo(int cod_grupo){
        String sql = "select nombre from grupos where cod_grupo = "+cod_grupo+";";
        String nombreGrupo = "";
        try {
            Statement ms = conexion.createStatement();
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()){
                nombreGrupo = rs.getString(1);
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return nombreGrupo;
    }

    /*----------------GENERADOR DE ARCHIVO--------------------*/
    public ArrayList<Concierto> conciertos(){
        ArrayList<Concierto> conciertos = new ArrayList<>();
        try {
            Statement ms = conexion.createStatement();
            ResultSet rs = ms.executeQuery("select * from conciertos");
            while(rs.next()){
                conciertos.add(new Concierto(rs.getInt("cod_concierto"),rs.getString("fecha"), rs.getInt("cod_grupo"),rs.getInt("cod_ciudad")));
            }
            rs.close();
            ms.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conciertos;
    }

    /*----------------------COMPROBACIONES---------------------*/
    public boolean existeCantante(int cod_cantante){
        boolean existe = true;
        try {
            existeCantante.setInt(1, cod_cantante);
            ResultSet rs = existeCantante.executeQuery();
            if (rs.first() == true){
                existe = true;
            }else{
                existe = false;
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return existe;
    }
    public boolean existeGrupo(int cod_grupo){
        boolean existe = true;
        try {
            existeGrupo.setInt(1, cod_grupo);
            ResultSet rs = existeGrupo.executeQuery();
            if (rs.first() == true){
                existe = true;
            }else{
                existe = false;
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return existe;
    }
    public boolean existeCiudad(int cod_ciudad){
        boolean existe = true;
        try {
            existeCiudad.setInt(1, cod_ciudad);
            ResultSet rs = existeCiudad.executeQuery();
            if (rs.first() == true){
                existe = true;
            }else{
                existe = false;
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return existe;
    }
    public boolean existeConcierto(int cod_concierto){
        boolean existe = true;
        try {
            existeConcierto.setInt(1, cod_concierto);
            ResultSet rs = existeConcierto.executeQuery();
            if (rs.first() == true){
                existe = true;
            }else{
                existe = false;
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return existe;
    }
    public boolean existeCantYGrupo(int cod_cantante, int cod_grupo){
        boolean existe = true;
        try {
            existeCantYGrupo.setInt(1, cod_cantante);
            existeCantYGrupo.setInt(2, cod_grupo);
            ResultSet rs = existeCantYGrupo.executeQuery();
            if (rs.first() == true){
                existe = true;
            }else{
                existe = false;
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return existe;
    }
}
