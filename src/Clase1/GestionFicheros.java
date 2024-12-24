package Clase1;

import java.io.File;
import java.io.IOException;

public class GestionFicheros {

    public void trabajoFicherosBase(){
        // file es logico, no es fisico
        // File file = new File("src/Clase1/resources/ejemplo.txt");
        File file = new File("src/Clase1/resources/ejemplo1.txt");

        if(!file.exists()){
            try {
                file.createNewFile();// logico -> fisico
                System.out.println(file.getName());
                System.out.println(file.getAbsolutePath());
                System.out.println(file.canRead());
                System.out.println(file.canWrite());
                System.out.println(file.isFile());
                System.out.println(file.isHidden());
            } catch (IOException e) {
                // throw new RuntimeException(e);
                System.out.println("Error en la creación del fichero");
            }
        }
    }

    public static void main(String[] args) {

    }
}
