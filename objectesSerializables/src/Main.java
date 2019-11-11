import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException {
        File fichero = new File("ficheroBytes.dat");
        FileOutputStream fileOut= new FileOutputStream(fichero,true);
        ObjectOutputStream dataOut= new ObjectOutputStream(fileOut);

        FileInputStream fileInt= new FileInputStream(fichero);
        ObjectInputStream dataInt= new ObjectInputStream(fileInt);

        ListaDepartamento listDep;
      //  ArrayList<ListaDepartamento> list = new ArrayList<ListaDepartamento>();
        int num[]={10,15,20,25,30,35,40,45,50};
        String nombres[]={"INFORMÁTICA","MARKETING","CONTABILIDAD","VENTAS","COMPRAS","PERSONAL","RECURSOS","ADMINISTRACIÓN","ECONOMÍA"};
        String localidades[]={"MADRID","SEVILLA","LEÓN","TOLEDO","GUADALAJARA","CUENCA","OVIEDO","BILBAO","VALENCIA"};
        /*
        list.add(new ListaDepartamento(10,"INFORMÁTICA","MADRID"));
        list.add(new ListaDepartamento(15,"MARKETING", "SEVILLA"));
        list.add(new ListaDepartamento(20,"CONTABILIDAD",	"LEÓN"));
        list.add(new ListaDepartamento(25,"VENTAS",	"TOLEDO"));
        list.add(new ListaDepartamento(30,"COMPRAS",	"GUADALAJARA"));
        list.add(new ListaDepartamento(35,"PERSONAL",	"CUENCA"));
        list.add(new ListaDepartamento(40,"RECURSOS",	"OVIEDO"));
        list.add(new ListaDepartamento(45,"ADMINISTRACIÓN",	"BILBAO"));
        list.add(new ListaDepartamento(50,"ECONOMÍA",	"VALENCIA"));
        */

        for (int i = 0; i < num.length; i++) {

            listDep= new ListaDepartamento(num[i],nombres[i],localidades[i]);
            dataOut.writeObject(listDep);
        }
        dataOut.close();

        int i=1;
        try {

            System.out.println("LISTADO DE DEPARTAMENTOS:");
            System.out.println("=======================================================");
            while (true) { //lectura del fichero
                listDep= (ListaDepartamento) dataInt.readObject(); //leer una ListaDepartamento
                System.out.println("Departament: " + listDep.getNum() + ", Nombre: " + listDep.getNombre()+ " Localidad: "+ listDep.getLocalidad());
            }
        }catch (EOFException eo) {}

        catch (StreamCorruptedException x) {} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("=======================================================");

        dataInt.close();  //cerrar stream de entrada
    }

    }

