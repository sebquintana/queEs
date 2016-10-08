import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private boolean comenzo = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(null) && !comenzo){
            comenzar();
            comenzo = true;
        }
    }
    
    
    public void comenzar() {
        Objeto objeto = new Objeto();
        addObject(objeto,527,338);
        LectorDeTeclado input = new LectorDeTeclado();
        addObject(input,544,514);
        Siguiente siguiente = new Siguiente();
        addObject(siguiente,986,59);
        Anterior anterior = new Anterior();
        addObject(anterior,89,59);
        setBackground( new GreenfootImage("fondoJuego.png"));
        Nivel nivel = new Nivel();
        addObject(nivel,510,94);
        
    }
}
