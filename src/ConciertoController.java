import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ConciertoController {
    private BDController conciertoController;

    public ConciertoController() {
        this.conciertoController = new BDController();
    }

    public BDController getConciertoController() {
        return conciertoController;
    }

    public void setConciertoController(BDController conciertoController) {
        this.conciertoController = conciertoController;
    }

    public void altaConcierto(){
        Scanner sn = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Concierto concierto = new Concierto();
        boolean checkFecha;
        int cod_concierto, cod_grupo, cod_ciudad;
        System.out.println("Dime el código del concierto: ");
        cod_concierto = sn.nextInt();
        if (!this.conciertoController.existeConcierto(cod_concierto)){
            concierto.setCod_concierto(cod_concierto);
            do {
                System.out.println("Dime la fecha del concierto: ");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = sc.nextLine();
                try {
                    Date date = formatter.parse(fecha);
                    System.out.println("La fecha del concierto es: "+formatter.format(date));
                    checkFecha = true;
                    concierto.setFecha(fecha);
                } catch (ParseException e) {
                    System.out.println("Error, el formato de fecha debe ser dd/mm/aaaa");
                    checkFecha = false;
                }
            }while (!checkFecha);

            System.out.println("Dime el codigo de la ciudad del concierto: ");
            System.out.println();
            for (String ciudad : this.conciertoController.ciudades()) {
                System.out.println(ciudad);
            }
            System.out.print("Codigo--> ");
            cod_ciudad = sn.nextInt();
            if (this.conciertoController.existeCiudad(cod_ciudad)) {
                concierto.setCod_ciudad(cod_ciudad);
                System.out.println("Dime el codigo de un grupo del concierto: ");
                System.out.println();
                for (Grupo grupo : this.conciertoController.grupos()) {
                    System.out.println("Código: "+grupo.getCod_grupo() + " Nombre: "+grupo.getNombre());
                }
                System.out.print("Codigo--> ");
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

    public void archivoConciertos(){
        ArrayList<Concierto> conciertos = this.conciertoController.conciertos();
        String ruta = "Conciertos.txt";
        File fichero = new File(ruta);
        String linea = "";
        if(fichero.exists()){
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
                for(int i = 0; i < conciertos.size(); i++){
                    linea = "Concierto Código: "+conciertos.get(i).getCod_concierto() + " - Fecha: "+conciertos.get(i).getFecha()+ " - Grupo: " + this.conciertoController.traductorGrupo(conciertos.get(i).getCod_grupo()) + " - Ciudad: " + this.conciertoController.traductorCiudad(conciertos.get(i).getCod_ciudad()) ;
                    bw.write(linea);
                    bw.newLine();
                }
                bw.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }else{
            try{
                fichero.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
                for(int i = 0; i < conciertos.size(); i++){
                    linea = "Concierto Código: "+conciertos.get(i).getCod_concierto() + " - Fecha: "+conciertos.get(i).getFecha()+ " - Grupo: " + this.conciertoController.traductorGrupo(conciertos.get(i).getCod_grupo())+ " - Ciudad: " + this.conciertoController.traductorCiudad(conciertos.get(i).getCod_ciudad()) ;
                    bw.write(linea);
                    bw.newLine();
                }
                bw.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
