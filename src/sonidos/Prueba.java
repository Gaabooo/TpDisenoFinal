/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonidos;

import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Martin
 */
public class Prueba {
    
    private static InputStream path;
    Clip clip;
    
    private void dame(){
        
        path= getClass().getResourceAsStream("alertaSuave.wav");

       try{
           //Primera forma, que anda
           AudioStream audio = new AudioStream(path);
           AudioPlayer.player.start(audio);
           
           
           //Segunda forma, no se por que no anda
           /*
           clip=AudioSystem.getClip();
           clip.open(AudioSystem.getAudioInputStream(path));
           clip.start();
           // Espera mientras se esté reproduciendo.
            while (clip.isRunning())
                Thread.sleep(100);
            
            // Se cierra el clip.
            clip.close();*/
        
       }
       catch(Exception ex){
           System.err.println( ex.getMessage() );
        }
    }
    
    
    public static void main(String args[]){
        new Prueba().dame();
        
    }
}
