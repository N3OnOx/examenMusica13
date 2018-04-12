import java.util.Scanner;

public class ConciertoController {
    private BDController conciertoController;

    public ConciertoController() {
        this.conciertoController = new BDController();
    }

    public void altaConcierto(){
        Scanner sn = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Concierto concierto = new Concierto();
        int cod_concierto, cod_grupo, cod_ciudad;
        String resp;
        System.out.println("Dime el código del concierto: ");
        cod_concierto = sn.nextInt();
        if (!this.conciertoController.existeConcierto(cod_concierto)){
            concierto.setCod_concierto(cod_concierto);
            System.out.println("Dime la fecha del concierto: ");
            concierto.setFecha(sc.nextLine());
            System.out.println("Dime la ciudad del concierto: ");
            cod_ciudad = sn.nextInt();
            if (this.conciertoController.existeCiudad(cod_ciudad)) {
                concierto.setCod_ciudad(cod_ciudad);
                System.out.println("Dime un grupo del concierto: ");
                cod_grupo = sn.nextInt();
                if (this.conciertoController.existeGrupo(cod_grupo)) {
                    concierto.setCod_grupo(cod_grupo);
                    this.conciertoController.altaConcierto(concierto);
                } else {
                    System.out.println("No existe ningun grupo con ese codigo");
                }
            }else{
                System.out.println("No existe ninguna ciudad con ese codigo");
            }
        }else{
            System.out.println("Ya existe un concierto con ese código");
        }
    }
}
