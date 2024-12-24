package Clase1;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GestionFicheros {

    public void trabajoFicherosBase(){

        // File file = new File("src/Clase1/resources/ejemplo.txt");
        // file es logico y fisico
        File file = new File("src/Clase1/resources/ejemplo1.txt");
        // logico
        File carpeta = new File("src/Clase1/resources/ficheros");
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
        if(!carpeta.exists()){
            carpeta.mkdir();
        }

        // carpeta.list();  // String[] nombre de los ficheros que están dentro
        for (String item:carpeta.list()){
            System.out.println(item);
        }

        // carpeta.listFiles() // File[] ficheros que estan dentro
        for (File item: carpeta.listFiles()){
            // solo mostrar los ficheros no hidden, si no, se mostra todos los ficheros
            if(!item.isHidden()){
                System.out.println(item.getName());
            }
        }

        // 给定某个路径，展示路径下所有的文件和文件夹。如果是文件夹，还展示文件夹下的文件和文件夹
        File carpeta2 = new File("C:\\Users\\ACER\\Documents\\League of Legends");
        for(File item : Objects.requireNonNull(carpeta2.listFiles())){
            if(!item.isHidden()){
                if(item.isDirectory()){
                    System.out.println(item.getName());
                    for (File subItem : Objects.requireNonNull(item.listFiles())){
                        System.out.println("\t" + subItem.getName());
                    }
                }else{
                    System.out.println(item.getName());
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
