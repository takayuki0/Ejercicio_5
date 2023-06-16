import java.io.*;

/**
 * 5.- Se tiene un archivo de caracteres de nombre “SALAS.DAT” (Crear dicho archivo con al menos 20 líneas).
 * Escribir un programa para crear el archivo “SALAS.BIN” con el contenido del primer archivo,
 * pero en modo binario.
 */
public class Main {
    public static void main(String[] args) {

        int misBytes[] = new int[263];
        int contador = 0;

        try {
            //Primero cree un objero de la clase FileImputStream para comenzar a leer el fichero.
            //Esta clase lee el fichero pero en modo binario es decir byte por byte
            FileInputStream leeEnBinario = new FileInputStream("G:\\Gabriel\\Ies El Rincon\\Programación\\Java\\UT7 Excepciones y ficheros (JAVA)\\Actividad 7.1\\Ejercicio_5\\src\\SALAS.DAT");

            //Creo una variable int para ir ingresando los bytes de mi fichero
            int byteEntrada = leeEnBinario.read();

            while (byteEntrada != -1) {
                //Procedo a guardar los bytes en mi arrray en la posición contador que ire incrementando en cada vuelta del bucle
                misBytes[contador] = byteEntrada;
                //Ahora continúo leyendo y repito esta operación hasta que se cumpla la condición del while
                byteEntrada = leeEnBinario.read();
                System.out.println(misBytes[contador]);
                contador++;

            }
            leeEnBinario.close();

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo!");
        }
        System.out.println("Contador: " + contador);

        try {
            //Hacemos lo mismo que en el paso anterior pero esta vez con la clase FileOutputStream para ir escribiendo un nuevo fichero
            //Como siempre instanciamos la clase y le pasamos como argumento la posición y el nombre del archivo que vamos a crear
            FileOutputStream escribirBinario = new FileOutputStream("G:\\Gabriel\\Ies El Rincon\\Programación\\Java\\UT7 Excepciones y ficheros (JAVA)\\Actividad 7.1\\Ejercicio_5\\src\\SALAS.BIN");

            //Esta vez escribimos los bytes de nuestro fichero en el nuevo fichero que queremos crear
            //Para ello hacemos uso del método .write()
            //Ahora con ayuda de un for recorremos el array previamente creado y vamos escribiendo el contenido de bytes de cada posición en nuestro nuevo fichero.
            for (int i = 0; i < misBytes.length; i++) {
                escribirBinario.write(misBytes[i]);
            }

            escribirBinario.close();


        } catch (IOException e) {
            System.out.println("Lo siento, algo ha salido mal.");;
        }

    }
}