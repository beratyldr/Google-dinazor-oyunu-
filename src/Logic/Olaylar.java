/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Views.Ekran;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Berat
 */
public class Olaylar implements ActionListener{
    Ekran o;
    Timer timer=new Timer(10,this);
    Klavye kla;
    Graphics g;
    public boolean hareket=true,kak=true,kargami=false,orta=true;
    
    public Olaylar(Ekran o){     
        timer.start();
        this.o=o;        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
          
          if (ae.getSource() == o.getAc()){
                
                hareket=true;            
                o.kaktusX=600;
                o.kargaX=600;
                o.getAc().setVisible(false);
                o.skor=0;
                o.requestFocus(false);
                kak=true;
                o.katsayi=0;
                kargami=false;
                o.repaint();
           }
         
        
         if(o.b==true && o.kontrol()==false){
             o.dinoY-=6;             
         }   
         
         if(o.dinoY==72 && o.kontrol()==false){
             o.b=false;
         }
        
         if(o.b==false && o.kontrol()==false){
             if(o.dinoY==204){                
             
             }
             else{  
                o.dinoY+=6;                   
             }
         }
         
         if(o.dinoY>=208){
             o.dinoY=208;
         }
         if(o.kaktusX==0){
             o.kaktusX=600;   
             
         }
         if((hareket==true && kargami==false) && (o.kargaX==0 ||o.kargaX==600)){         
             o.kaktusX-=4;
             
         }
         
         if(o.kontrol()==false){
             o.repaint();      
            
         }
         else{                    
             hareket=false;            
             o.getAc().setVisible(true);
             o.repaint();
         }
         
         if((hareket==true && o.katsayi%2>0) && (o.kaktusX==600 || o.kaktusX==0)){
               kargami=true;
               o.kargaX-=5;
               
         }
         if(o.kargaX==0){
             o.kargaX=600;
             if(orta==true)
                orta=false;
             else
                orta=true;
         }
         
         if(o.katsayi%2!=1 && hareket==true)
         {   
             
             if(o.kargaX!=0 && kargami==true){
                 o.kargaX-=5;
             }
             if(o.kargaX==0){
             o.kargaX=600;
             kargami=false;
             }
             
             
            
         }
         
         o.repaint();
    }

   
    
    
    public Ekran getO() {
        o=new Ekran();
        return o;
    }

    public void setO(Ekran o) {
        this.o = o;
    }

   
    
}
