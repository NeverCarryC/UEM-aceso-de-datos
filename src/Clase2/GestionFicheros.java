package Clase2;

import Clase2.model.Usuario;

import java.io.*;
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


    public static void recursiveFile(File dir) {
        // 检查参数是否为 null
        if (dir == null) {
            System.out.println("Directory is null.");
            return;
        }

        // 检查是否是有效的目录
        if (dir.isDirectory()) {
            File[] files = dir.listFiles(); // 获取子文件和子目录

            // 检查 listFiles() 返回值是否为 null
            if (files == null) {
                System.out.println("Cannot access directory: " + dir.getAbsolutePath());
                return;
            }

            // 遍历子文件和子目录
            for (File item : files) {
                if (item.isFile()) {
                    System.out.println("File: " + item.getName());
                } else if (item.isDirectory()) {
                    System.out.println("Directory: " + item.getName());
                    recursiveFile(item); // 递归处理
                }
            }
        } else {
            System.out.println(dir.getAbsolutePath() + " is not a directory.");
        }
    }


    public static void main(String[] args) {
        Clase2.GestionFicheros gestionFicheros = new GestionFicheros();
        // gestionFicheros.flujoEscrituraConFileWtriter("src/Clase2/recources/escritura.txt");
        // gestionFicheros.flujoEscrituraConBufferedWriter("src/Clase2/recources/escritura.txt");
        // gestionFicheros.flujoEscrituraConPrintWriter("src/Clase2/recources/escritura.txt");
        gestionFicheros.flujoEscrituraObjetos("src/Clase2/recources/escritura.obj");
    }

    public void flujoEscrituraConFileWtriter(String path){
        // FIle -> FIleWriter -> BufferedWriter
        File file = new File(path);
        FileWriter fw = null;
        try {
            // si no encuentra la ruta -> lo creo createNewFile() -> FileNotFoundException
            fw = new FileWriter(file, true);
            fw.write(125); // Devolver '}'
            fw.write("123\n");
            fw.write("Esto es otra línea");
        } catch (IOException e) {
            System.out.println("Error en la apertura del fichero");
        } finally {
            try {
                fw.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado fichero");
            }
        }

    }

    public void flujoEscrituraConBufferedWriter(String path){
        File file = new File(path);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file, true));
            bf.write(123);
            bf.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bf.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void flujoEscrituraConPrintWriter(String path){
        File file = new File(path);

        PrintWriter pw = null;

        try {
           //  pw = new PrintWriter(file);
            pw = new PrintWriter(new FileWriter(file, true));
            // pw.write("Hello, I am PrintWriter");
            pw.println("Esto es una linea nueva en el fichero");
            pw.println("Esto es otra linea nueva en el fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                pw.close();
            }catch (NullPointerException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void flujoLecturaConFileReader(String path){
        // File -> FileREader(caracter a catracter) -> BufferedReader(linea a linea)
        File file = new File(path);
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            // int numeroASCI = fileReader.read(); // numero ASCI del caracter leido
            int numeroASCI = -1;
            while((numeroASCI = fileReader.read()) >-1){
                System.out.println((char)numeroASCI);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } finally {
            try {
                fileReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void flujoLecturaConBufferedReader(String path){
        // File -> FileREader(caracter a catracter) -> BufferedReader(linea a linea)
        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;

            while((linea = bufferedReader.readLine()) != null){
                System.out.println(linea);
            }


        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void flujoEscrituraObjetos(String path){
        // File -> FIleOutputStream -> ObjectOutputStream
        File file = new File(path);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new Usuario("Nico", "sd" ,"sd", "asd"));
            oos.writeObject(new Usuario("Nico", "sd" ,"sd", "asd"));
        } catch (IOException e) {
            // System.out.println("Error en la escritura del fichero");
            throw new RuntimeException(e);
        }finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
        Usuario usuario = new Usuario();
        usuario.getApellido();
    }
}
