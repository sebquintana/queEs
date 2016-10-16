import greenfoot.*;
import java.awt.Color;

public class LectorDeTeclado extends Actor
{
    private static final int MAX_INPUT_LENGTH = 30;
    private String text = "";
    private String[] soluciones;
    private int nivel;
    private boolean[] objetosAdivinados;
    private int aciertos;

    public LectorDeTeclado() {
        updateImage();
        text = "";
        Respuestas respuestas = new Respuestas();
        soluciones =  respuestas.leerRespuestas();
        inicializarVectorObjetosAdivinados();
    }

    public void act(){

        ganar();

        // Pasar a la sieguiente imagen
        siguiente();

        // Pasar a la imagen anterior
        anterior();

        String key = Greenfoot.getKey();
        if (key == null){ 
            return;
        }
        // Confirmar palabra
        if ("enter".equals(key) && text.length() > 0) {
            acertar();
            text = "";
            updateImage();
            return;
        }

        // Borrar palabra
        if ("backspace".equals(key) && text.length() > 0) {
            text = text.substring(0, text.length() - 1);
        }

        // espacio
        if ("space".equals(key)) key = " ";

        // escribir
        if (key.length() == 1 && text.length() < MAX_INPUT_LENGTH) text += key;

        // actualizar texto
        updateImage();
    }

    public void siguiente(){
        Siguiente siguiente = getWorld().getObjects(Siguiente.class).get(0);
        if(Greenfoot.mouseClicked(siguiente) && soluciones.length > nivel + 1){
            nivel++;
            Objeto objeto = getWorld().getObjects(Objeto.class).get(0);
            objeto.setImagen(nivel);
            Nivel nivelObject = getWorld().getObjects(Nivel.class).get(0);
            nivelObject.setImagen(nivel+1);
            mostrarPalabraAdivinada();
        }
    }

    public void anterior(){
        Anterior anterior = getWorld().getObjects(Anterior.class).get(0);
        if(Greenfoot.mouseClicked(anterior) && nivel > 0){
            nivel--;
            Objeto objeto = getWorld().getObjects(Objeto.class).get(0);
            objeto.setImagen(nivel);
            Nivel nivelObject = getWorld().getObjects(Nivel.class).get(0);
            nivelObject.setImagen(nivel+1);
            mostrarPalabraAdivinada();
        }
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(15*MAX_INPUT_LENGTH, 60);
        image.setColor(Color.black);
        image.fill();
        image.setColor(Color.white);
        image.fillRect(3, 3, image.getWidth()-6, 54);
        GreenfootImage textImage = new GreenfootImage(text.toUpperCase(), 24, Color.black, null);
        image.drawImage(textImage, (image.getWidth()-textImage.getWidth())/2, (image.getHeight()-textImage.getHeight())/2);
        setImage(image);
    }

    public void acertar() {
        if(text.equals(soluciones[nivel])){
            int i = 0 ;

            while(i < Greenfoot.getRandomNumber(8) + 3) {
                getWorld().addObject(new Globo(), Greenfoot.getRandomNumber(getWorld().getWidth()), getWorld().getHeight());
                i++;
            }
            getWorld().addObject(new Correcto(), 858, 520);
            Greenfoot.playSound("acierto.wav");
            objetosAdivinados[nivel] = true;
            aciertos++;
        } else {
            getWorld().addObject(new Error(), 858, 520);
            Greenfoot.playSound("error.wav");
            objetosAdivinados[nivel] = false;
        }

    }

    public void mostrarPalabraAdivinada() {

        if(objetosAdivinados[nivel]){
            text = soluciones[nivel];
        } else {
            text = "";
        }
        updateImage();
    }

    public void inicializarVectorObjetosAdivinados(){

        objetosAdivinados = new boolean[soluciones.length];

        for(int i = 0; i < objetosAdivinados.length; i++){
            objetosAdivinados[i] = false;
        }

    }

    public void ganar(){
        if(soluciones.length == aciertos){
            Objeto objeto = getWorld().getObjects(Objeto.class).get(0);
            objeto.mostrarVictoria(); 
        }
    }
}