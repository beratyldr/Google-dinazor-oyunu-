/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinazor;

import Views.Ekran;
import javax.swing.JFrame;

/**
 *
 * @author Berat
 */
public class MainGui extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          
        MainGui ekran = new MainGui();
        ekran.setResizable(false);
        ekran.setFocusable(false);       
        ekran.setSize(600,300);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Ekran e=new Ekran();
        e.setFocusable(true);             
        ekran.add(e);       
        ekran.setVisible(true);
    }
    
}
