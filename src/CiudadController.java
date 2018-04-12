import java.util.Scanner;

public class CiudadController {
    private BDController ciudadController;

    public CiudadController() {
        this.ciudadController = new BDController();
    }

    public void altaCiudad(){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        Ciudad ciudad = new Ciudad();
        int cod_ciudad;
        System.out.println("Dime el código de la ciudad: ");
        cod_ciudad = sn.nextInt();
        if (!this.ciudadController.existeCiudad(cod_ciudad)){
            ciudad.setCod_ciudad(cod_ciudad);
            System.out.println("Dime el número de habitantes: ");
            ciudad.setNum_hab(sn.nextInt());
            System.out.println("Dime el nombre de la ciudad: ");
            ciudad.setNombre(sc.nextLine());
            this.ciudadController.altaCiudad(ciudad);
        }else{
            System.out.println("El código de ciudad ya existe.");
        }
    }
}
