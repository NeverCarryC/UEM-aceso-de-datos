package Clase1;

import java.io.File;

public class GestionFicheros {

    public void trabajoFicherosBase(){
        // file es logico, no es fisico
        // File file = new File("src/Clase1/resources/ejemplo.txt");
        File file = new File("src/Clase1/resources/ejemplo1.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isFile());
        System.out.println(file.isHidden());
    }

    public static void main(String[] args) {

    }
}
