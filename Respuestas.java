import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*; // InputStream etc.
import java.awt.Color;

/**
 * Write a description of class Respuestas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Respuestas {

    public String[] leerRespuestas() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("respuestas/respuestas.txt");
        BufferedReader r = new BufferedReader(new InputStreamReader(is));

        String[] lines = new String[5];
        try{
            for (int i = 0; i < 5; i++) {
                lines[i] = r.readLine();
            }
        }
        catch (IOException ioe) {
            System.out.println("No se pudieron leer las respuestas!");
        }

        return lines;
    }
}
