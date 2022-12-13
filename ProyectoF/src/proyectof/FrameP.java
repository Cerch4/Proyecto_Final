/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectof;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
/**
 * * @author Cesar
 */
public class FrameP extends JFrame{
    MenuPanel panel;
    JTextField YP,VP;
    JLabel YPT, VPT;
    JButton Start, Reset, Stop, SaveYP, SaveVP, ChangeDi, ChangeSize;
    static int escala;
    
    FrameP(){
        super();
        panel = new MenuPanel(escala);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(16*escala+16, 12*escala)); // por alguna razon no se dimenciona 
        this.setTitle("Proyecto Final Tema 3");
        this.add(panel);
        this.crearGUI();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
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
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    panel.goLEFT();
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    panel.goRIGHT();
                }
            }
        });
    }
    public void crearGUI(){
        YPT= new JLabel("Altura del Avion: ");YPT.setBounds(10*escala/40,19*escala/2, 100*escala/40,10*escala/40);
        VPT= new JLabel("Velocidad del Avion: ");VPT.setBounds(10*escala/40,10*escala, 120*escala/40,10*escala/40);
        YP = new JTextField();YP.setBounds(130*escala/40,19*escala/2, 120*escala/40,15*escala/40);
        VP = new JTextField();VP.setBounds(130*escala/40,10*escala, 120*escala/40,15*escala/40);
        SaveYP = new JButton("Guardar");SaveYP.setBounds(250*escala/40, 19*escala/2, 80*escala/40,15*escala/40);
        SaveVP = new JButton("Guardar");SaveVP.setBounds(250*escala/40, 10*escala, 80*escala/40,15*escala/40);
        ChangeDi = new JButton("Cambiar Direccion");ChangeDi.setBounds(130*escala/40, 21*escala/2, 200*escala/40,15*escala/40);
        ChangeSize = new JButton("Resize");ChangeSize.setBounds(10*escala/40,21*escala/2, 100*escala/40,15*escala/40);
        Start = new JButton("Start");Start.setBounds(360*escala/40, 19*escala/2, 80*escala/40,15*escala/40);
        Reset = new JButton("Reset");Reset.setBounds(360*escala/40, 10*escala, 80*escala/40,15*escala/40);
        Stop = new JButton("Stop");Stop.setBounds(360*escala/40, 21*escala/2, 80*escala/40,15*escala/40);
        evento_Guardar(SaveYP);evento_Guardar(SaveVP);evento_Guardar(ChangeDi);evento_StartStop(Start);evento_StartStop(Stop);evento_StartStop(Reset);evento_Resize(ChangeSize);
        this.add(YPT);this.add(VPT);this.add(YP);this.add(VP);this.add(SaveYP);this.add(SaveVP);this.add(ChangeDi);this.add(Start);this.add(Stop);this.add(Reset);this.add(ChangeSize);
    }
    public void evento_Resize(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ventana();
                setVisible(false); 
                dispose();
            }
        });
    }
    public void evento_StartStop(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().y == 19*escala/2) {
                    panel.startGame();
                }
                if (act.getBounds().y == 10*escala) {
                    panel.setvp(0);
                    panel.setyp(40*escala/40);
                    panel.setxp(30*escala/40);
                    panel.setxt(0);
                    panel.stopGame();
                }
                if (act.getBounds().y == 21*escala/2) {
                    panel.stopGame();
                }
            }
        });
    }
    public void evento_Guardar(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().y == 19*escala/2) {//agregar limitantes osea si es menor a 40 no dejar y asi
                    try{
                        panel.setyp(Integer.parseInt(YP.getText()));
                    }catch(NumberFormatException b){
                        JOptionPane.showMessageDialog(null, "No se a Introducido un valor Valido");
                    }
                }
                if (act.getBounds().y == 10*escala) {
                    try{
                        panel.setvp(Integer.parseInt(VP.getText()));
                    }catch(NumberFormatException b){
                        JOptionPane.showMessageDialog(null, "No se a Introducido un valor Valido");
                    }
                }
                if (act.getBounds().y == 21*escala/2) {
                    panel.setvp(panel.getvp()*-1);
                }
            }
        });
    }
}
