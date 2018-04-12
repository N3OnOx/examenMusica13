import java.sql.*;

public class BDController {
    private Connection conexion;
    private PreparedStatement existeCantante;
    private PreparedStatement existeGrupo;

    BDController(){
        try {
            //this.conexion = DriverManager.getConnection("jdbc:mysql://192.168.10.252:3306/videojuegos", "1GS","Nelson2000");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica", "root","");
            String SQLExisteCantante = "select * from cantantes where cod_cantante = ?";
            this.existeCantante = conexion.prepareStatement(SQLExisteCantante);
            String SQLExisteGrupo = "select * from grupos where cod_grupo = ?";
            this.existeGrupo = conexion.prepareStatement(SQLExisteGrupo);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void altaCantante(Cantante cantante){
        String sql = "insert into cantantes values ("+cantante.getCod_cantante()+",'"+cantante.getNombre()+"', "+cantante.getEdad()+", "+cantante.getCod_ciudad()+")";
        try {
            Statement ms = this.conexion.createStatement();
            ms.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void altaGrupo(Grupo grupo){
        String sql = "insert into grupos values ("+grupo.getCod_grupo()+",'"+grupo.getNombre()+"', '"+grupo.getEstilo()+"')";
        try {
            Statement ms = this.conexion.createStatement();
            ms.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void altaCantan(int cod_cantante, int cod_grupo){
        String sql = "insert into cantan values ("+cod_cantante+","+cod_grupo+")";
        try {
            Statement ms = this.conexion.createStatement();
            ms.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

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

}
