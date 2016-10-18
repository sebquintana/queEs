import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Error here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Error extends Actor
{
    
    private int tiempo;

    public void act(){
        
        tiempo++;
        
        if(tiempo == 80){
            getWorld().removeObject(this);
        }
    }    
}
