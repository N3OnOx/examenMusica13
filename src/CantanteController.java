import java.util.Scanner;

public class CantanteController {
    private BDController cantanteController;

    public CantanteController() {
        this.cantanteController = new BDController();
    }

    public void altaCantante(){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        int cod_cantante, cod_grupo, cod_ciudad;
        String resp;
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
            cod_ciudad = sn.nextInt();
            if (this.cantanteController.existeCiudad(cod_ciudad)) {
                cantante.setCod_ciudad(cod_ciudad);
                System.out.println("Desea introducir grupos en el cantante?");
                resp = sc.nextLine();
                if (resp.equalsIgnoreCase("si")) {
                    do {
                        System.out.println("Dime el codigo de grupo donde canta: ");
                        cod_grupo = sn.nextInt();
                        if (this.cantanteController.existeGrupo(cod_grupo)) {
                            this.cantanteController.altaCantan(cod_cantante, cod_grupo);
                        } else {
                            System.out.println("No existe ese grupo");
                        }
                        System.out.println("Introducir otro grupo?");
                        resp = sc.nextLine();
                    } while (resp.equalsIgnoreCase("si"));
                }
                this.cantanteController.altaCantante(cantante);
            }else{
                System.out.println("No existe ese código de ciudad");
            }
        }else{
            System.out.println("El codigo de cantante ya existe");
        }
    }

    public void asignarCantanteGrupo(){
        Scanner sn = new Scanner(System.in);
        int cod_cantante, cod_grupo;
        System.out.println("Dime el codigo del cantante a asignar: ");
        cod_cantante = sn.nextInt();
        if (this.cantanteController.existeCantante(cod_cantante)){
            System.out.println("Dime el codigo de grupo al que pertenece: ");
            cod_grupo = sn.nextInt();
            if (this.cantanteController.existeGrupo(cod_grupo) && !this.cantanteController.existeCantYGrupo(cod_cantante, cod_grupo)){
                this.cantanteController.altaCantan(cod_cantante,cod_grupo);
            }else{
                System.out.println("Es posible que el grupo no exista o que ya esté asignado ese cantante al grupo.");
            }
        }
    }
}
