import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.IllegalArgumentException;

/**
 * Write a description of class Objeto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objeto extends Actor
{

    GreenfootImage imagen;

    public Objeto(){
        setImagen(0);
    }

    /**
     * Act - do whatever the Objeto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    public void setImagen(int numeroImagen){
        try {
            imagen = new GreenfootImage(numeroImagen+".png");
            setImage(imagen);
        } catch (IllegalArgumentException e) {        
            e.printStackTrace();
        }

    }

    public void mostrarVictoria() {
        Greenfoot.playSound("victoria.wav");
        getWorld().addObject(new Ganaste(), 540, 408);
        Greenfoot.delay(100);
        Greenfoot.stop();
    }
}
