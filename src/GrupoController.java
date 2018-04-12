import java.util.Scanner;

public class GrupoController {
    private BDController grupoController;

    public GrupoController() {
        this.grupoController = new BDController();
    }

    public void altaGrupo(){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        int cod_grupo;
        String resp;
        int cod_cantante;
        Grupo grupo = new Grupo();
        System.out.println("Dime el codigo del grupo: ");
        cod_grupo = sn.nextInt();
        if (!this.grupoController.existeGrupo(cod_grupo)){
            grupo.setCod_grupo(cod_grupo);
            System.out.println("Dime el nombre del grupo: ");
            grupo.setNombre(sc.nextLine());
            System.out.println("Dime el estilo del grupo: ");
            grupo.setEstilo(sc.nextLine());
            do {
                System.out.println("Dime el codigo del cantante: ");
                cod_cantante = sn.nextInt();
                if (this.grupoController.existeCantante(cod_cantante)){
                    this.grupoController.altaCantan(cod_cantante,cod_grupo);
                }else{
                    System.out.println("No existe ese cantante");
                }
                System.out.println("Introducir otro cantante?");
                resp = sc.nextLine();
            }while (resp.equalsIgnoreCase("si"));
            this.grupoController.altaGrupo(grupo);
        }else{
            System.out.println("Ya existe ese grupo");
        }
    }
}
