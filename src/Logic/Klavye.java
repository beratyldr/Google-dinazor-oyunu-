/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Views.Ekran;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Berat
 */
public class Klavye implements KeyListener {
    Ekran oyn;
    Olaylar olay;
    public Klavye(Ekran oyn){
     this.oyn=oyn;  
    
    }
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
            int c=ke.getKeyCode();
           if(c==KeyEvent.VK_SPACE){
               if(oyn.dinoY==204 && oyn.kontrol()==false) 
                      oyn.b=true;
               }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
           
    }

    
   