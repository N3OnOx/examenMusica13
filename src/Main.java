import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int opcion;
        CantanteController cantanteController = new CantanteController();
        GrupoController grupoController = new GrupoController();
        ConciertoController conciertoController = new ConciertoController();
        do {
            mostrarMenu();
            opcion = sn.nextInt();
            switch (opcion){
                case 1:
                    cantanteController.altaCantante();
                    break;
                case 2:
                    grupoController.altaGrupo();
                    break;
                case 3:
                    conciertoController.altaConcierto();
                    break;
                case 4:
                    grupoController.mostrarGruposCodigo();
                    break;
                case 5:
                    cantanteController.listadoCantantes();
                    break;
                case 6:
                    conciertoController.archivoConciertos();
                    break;
                case 7:
                    System.out.println("Has elegido salir");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }while (opcion!=7);
    }
    private static void mostrarMenu(){
        System.out.println("1.  Alta cantante");
        System.out.println("2.  Alta grupo");
        System.out.println("3.  Alta concierto");
        System.out.println("4.  Consulta de grupo");
        System.out.println("5.  Listado de cantantes");
        System.out.println("6.  Generar archivo conciertos");
        System.out.println("7.  Salir");

    }
}
