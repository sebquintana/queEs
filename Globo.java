import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Globo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Globo extends Actor
{
    public void act() {
        mover();
        desaparecer();
    }    

    public void mover() {
        setLocation(getX(), getY() - 4);
    }

    public void desaparecer() {

        if(getY() < 10){
            getWorld().removeObject(this);
        }
    }
}
