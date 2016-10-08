import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotonJugar extends Actor
{
    /**
     * Act - do whatever the Inicio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            comenzar();
        }
    }    

    public void comenzar() {
        Objeto objeto = new Objeto();
        getWorld().addObject(objeto,527,338);
        LectorDeTeclado input = new LectorDeTeclado();
        getWorld().addObject(input,544,514);
        Siguiente siguiente = new Siguiente();
        getWorld().addObject(siguiente,990,300);
        getWorld().removeObject(this);
    }
}
