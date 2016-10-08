import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Correcto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Correcto extends Actor
{

    private int tiempo;

    public void act() {
        
        tiempo++;

        if(tiempo == 100){
            getWorld().removeObject(this);
        }
    }    
}
