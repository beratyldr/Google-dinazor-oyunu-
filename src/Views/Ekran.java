/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Logic.Klavye;
import Logic.Olaylar;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Berat
 */
public class Ekran extends JPanel implements ActionListener {
    Klavye k;
    Olaylar a;
    JButton ac;
    Timer timer=new Timer(100,this); 
    //public Icon ;
    public BufferedImage dino,kaktus,kaktus3,dino1,bulut,karga,bulut1;
    public int dinoX=50,dinoY=204,kaktusX=600,kaktusY=217,skor=0,yüksekskor=0,sayi=0;
    public int kargaX=600,kargaY=150,katsayi=0;
    public boolean b=false;
    Image arkaplan;
    ImageIcon s;
    
    
    public Ekran(){
                timer.start();
                this.setBackground(Color.WHITE); 
                add(getAc()); 
                getAc().setVisible(false);
                addActionListener(getA());
                addKeyListener(getK());
                arkaplan = new ImageIcon("a.jpg").getImage();
                s= new ImageIcon("restart.png");
        try {   
                
                dino=ImageIO.read(new FileImageInputStream(new File("dino1.png")));  
                dino1=ImageIO.read(new FileImageInputStream(new File("dino2.png")));
                bulut=ImageIO.read(new FileImageInputStream(new File("bulut.png")));  
                bulut1=ImageIO.read(new FileImageInputStream(new File("bulut.png")));
                kaktus=ImageIO.read(new FileImageInputStream(new File("kaktüs.png")));
                kaktus3=ImageIO.read(new FileImageInputStream(new File("kaktüs3.png")));   
                karga=ImageIO.read(new FileImageInputStream(new File("karga.png"))); 
        } 
        catch (IOException ex) {}  
    }
           
    
   
    @Override
    public void paint(Graphics g){
        super.paint(g);       
       
        g.drawImage(arkaplan,0,217,600,50, null);
        
        if(skor%2==0) 
           g.drawImage(dino,dinoX,dinoY,dino.getWidth(),dino.getHeight(),null);  
        else{
           g.drawImage(dino1,dinoX,dinoY,dino1.getWidth(),dino1.getHeight(),null); 
        }
          // g.drawImage(bulut, 150, 25, null);
          // g.drawImage(bulut1, 250, 50, null);
       
         if(a.kargami==true){
             if(a.orta==false){ 
                 kargaY=200;
                
             }
             if(a.orta==true){
                 kargaY=150;
                 
             }
              g.drawImage(karga,kargaX,kargaY, null);
             
            kaktusX=600;
         }
         else if(a.kargami==false && (kargaX==0 ||kargaX==600))
            {
                 if(a.kak==true){
                        g.drawImage(kaktus, kaktusX, kaktusY, this);   
                    if(kaktusX==0){
                      a.kak=false;
                    }
                 }
                else{
                       g.drawImage(kaktus3, kaktusX, kaktusY-12, this);
                     if(kaktusX==0){
                        a.kak=true;
                    }
                }
            
        }
        
        g.setColor(Color.black);
        g.setFont(new Font("serif",Font.BOLD,12));   
        g.drawString("Skor="+skor,500, 20);
        g.drawString("Yüksek Skor="+yüksekskor,500, 40);
        g.setColor(Color.black);
        g.setFont(new Font("serif",Font.BOLD,25));
        
        
        
        if(kontrol()){       
            getAc().setVisible(true);  
            ac.setIcon(s);
            ac.setBounds(275,90,42,38);
            
        }
        if(a.hareket==false)
            g.drawString("Ayvayı Yedin",223,150);
        
    }
    
    
    public JButton getAc() {
        if (ac == null) {
            ac = new JButton();
            ac.setBorder(null);
            ac.addActionListener(getA());
           
        }
        return ac;
    }
    
    public void setAc(JButton ac) {
        this.ac = ac;
    }
    
    
    public Olaylar getA() {
        if (a== null) {
            a = new Olaylar(this);
        }
        return a;
    }

    public void setA(Olaylar a) {
        this.a = a;
    }

    
    public Klavye getK() {
        if (k== null) {
            k = new Klavye(this);
        }
        return k;
    }

    public void setK(Klavye k) {
        this.k = k;
    }
    
    public boolean kontrol(){
    
    if(a.kak==false){
     if(new Rectangle(dinoX,dinoY,48,48).intersects(new Rectangle(kaktusX,kaktusY,25,20))){        
        return true;
    }    
    }     
    else{
    if(new Rectangle(dinoX,dinoY,48,48).intersects(new Rectangle(kaktusX,kaktusY,10,50))){        
        return true;
    }
    }
    if(new Rectangle(dinoX,dinoY,45,48).intersects(new Rectangle(kargaX,kargaY,4,10))){        
        return true;
    }
    
    return false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(a.hareket==true)
            skor+=1;
        else{
           if(skor>yüksekskor)
                yüksekskor=skor;
        }
        if(skor%50==0){
            katsayi+=1;
        }
    }
}
