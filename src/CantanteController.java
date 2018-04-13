import java.util.Scanner;

public class CantanteController {
    private BDController cantanteController;

    public CantanteController() {
        this.cantanteController = new BDController();
    }

    public BDController getCantanteController() {
        return cantanteController;
    }

    public void setCantanteController(BDController cantanteController) {
        this.cantanteController = cantanteController;
    }

    public void altaCantante(){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        int cod_cantante, cod_ciudad;
        Cantante cantante = new Cantante();
        System.out.println("Dime el codigo del cantante: ");
        cod_cantante = sn.nextInt();
        if (!cantanteController.existeCantante(cod_cantante)){
            cantante.setCod_cantante(cod_cantante);
            System.out.println("Dime su nombre: ");
            cantante.setNombre(sc.nextLine());
            System.out.println("Dime su edad: ");
            cantante.setEdad(sn.nextInt());
            System.out.println("Dime su codigo de ciudad: ");
            System.out.println();
            for (String ciudad : this.cantanteController.ciudades()) {
                System.out.println(ciudad);
            }
            cod_ciudad = sn.nextInt();
            if (this.cantanteController.existeCiudad(cod_ciudad)) {
                cantante.setCod_ciudad(cod_ciudad);
                this.cantanteController.altaCantante(cantante);
            }else{
                System.out.println("No existe ese código de ciudad");
            }
        }else{
            System.out.println("El codigo de cantante ya existe");
        }
    }

    public void listadoCantantes(){
        for (Cantante cantante : this.cantanteController.listadoCantantes()) {
            System.out.println("Cantante: "+cantante.getNombre() + " - Edad: "+cantante.getEdad() + " - Ciudad: "+this.cantanteController.traductorCiudad(cantante.getCod_ciudad()));
        }
    }
}
