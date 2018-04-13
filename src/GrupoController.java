import java.util.Scanner;

public class GrupoController {
    private BDController grupoController;

    public GrupoController() {
        this.grupoController = new BDController();
    }

    public BDController getGrupoController() {
        return grupoController;
    }

    public void setGrupoController(BDController grupoController) {
        this.grupoController = grupoController;
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
            do {
                System.out.println("Dime el codigo del cantante: ");
                System.out.println();
                for (Cantante cantante : this.grupoController.cantantes()) {
                    System.out.println("Código: "+cantante.getCod_cantante()+" Nombre: "+cantante.getNombre());
                }
                System.out.print("Codigo --> ");
                cod_cantante =  sn.nextInt();
                if (this.grupoController.existeCantante(cod_cantante)){
                    if (!this.grupoController.existeCantYGrupo(cod_cantante,cod_grupo)){
                        this.grupoController.altaCantan(cod_cantante,cod_grupo);
                    }else{
                        System.out.println("Ya existe este cantante en el grupo");
                    }
                }else{
                    System.out.println("No existe ese cantante");
                }
                System.out.println("Introducir otro cantante?");
                resp = sc.nextLine();
            }while (resp.equalsIgnoreCase("si"));
            System.out.println("Dime el nombre del grupo: ");
            grupo.setNombre(sc.nextLine());
            System.out.println("Dime el estilo del grupo: ");
            grupo.setEstilo(sc.nextLine());
            this.grupoController.altaGrupo(grupo);
        }else{
            System.out.println("Ya existe ese grupo");
        }
    }
    public void mostrarGruposCodigo(){
        Scanner sn = new Scanner(System.in);
        int cod_grupo;
        System.out.println("Dime el código del grupo: ");
        cod_grupo = sn.nextInt();
        if (this.grupoController.existeGrupo(cod_grupo)){
            for (Grupo grupo : this.grupoController.gruposCodigo(cod_grupo)) {
                System.out.println("Grupo: "+grupo.getNombre() + " - Estilo: "+grupo.getEstilo());
                System.out.print("  Cantantes: ");
                for (int i = 0; i < this.grupoController.nombreCantantesCodigo(cod_grupo).size(); i++) {
                    if (i == this.grupoController.nombreCantantesCodigo(cod_grupo).size()-1){
                        System.out.print(this.grupoController.nombreCantantesCodigo(cod_grupo).get(i)+".");
                    }else {
                        System.out.print(this.grupoController.nombreCantantesCodigo(cod_grupo).get(i) + ", ");
                    }
                }
                System.out.println();
            }
        }else{
            System.out.println("No existe ningun grupo con ese código");
        }
    }
}
