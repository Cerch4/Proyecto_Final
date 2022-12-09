/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectof;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
/**
 * * @author Cesar

 */
public class FrameP extends JFrame{
    MenuPanel panel;
    
    FrameP(){
        
        panel = new MenuPanel(40, 2);
        this.setSize(16*40, 9*40);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(new KeyListener(){
             @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        System.out.println("Hi");
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        panel.misilLaunch();
                    }
                   
                }
        });
        
        }
   

}

