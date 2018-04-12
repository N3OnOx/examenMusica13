import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int opcion;
        CantanteController cantanteController = new CantanteController();
        GrupoController grupoController = new GrupoController();
        CiudadController ciudadController = new CiudadController();
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
                    ciudadController.altaCiudad();
                    break;
                case 4:
                    cantanteController.asignarCantanteGrupo();
                    break;
                case 5:
                    conciertoController.altaConcierto();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    System.out.println("Has elegido salir");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }while (opcion!=11);
    }
    private static void mostrarMenu(){
        System.out.println("1.  Alta cantante");
        System.out.println("2.  Alta grupo");
        System.out.println("3.  Alta ciudad");
        System.out.println("4.  Asignar cantantes a grupos");
        System.out.println("5.  Alta Concierto");
        System.out.println("6.  ");
        System.out.println("7.  ");
        System.out.println("8.  ");
        System.out.println("9.  ");
        System.out.println("10.  ");
        System.out.println("11.  Salir");

    }
}
