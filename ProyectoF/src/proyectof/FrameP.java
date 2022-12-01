/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectof;

import java.awt.*;

import javax.swing.*;
/**
 *
 * @author Cesar
 */
public class FrameP extends JFrame{
    PanelP panel;
    
    FrameP(){
        panel = new PanelP( 3 );
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
}
