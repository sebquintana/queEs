import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel extends Actor
{
    GreenfootImage imagen;

    public Nivel(){
        setImagen(1);
    }

    public void setImagen(int numeroImagen){
        try {
            imagen = new GreenfootImage("numero"+numeroImagen+".png");
            setImage(imagen);
        } catch (IllegalArgumentException e) {
            Greenfoot.stop();
        }

    }
}
