package proyectof;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class FrameP extends JFrame{
    /**MenuPanel es una extension de JPanel la cual sera la parte Grafica/Animacion de esta Ventana*/
    private MPanel panel;
    /**JTextField Consiste en una Espacio de Texto en la GUI que sirve para recivir parametros escritos durante la ejecucion de la aplicacion en este caso altura y velocidad de avion respectivamente */
    private JTextField YP,VP, VT;
    /**JLabel para almacenar el texto que se busca imprimir en pantalla para identificar YP y VP*/
    private JLabel YPT, VPT, VTT;
    /**JButton para imprirse en Ventana y perimitir Interaccion con la interfaz*/
    private JButton Start, Reset, Stop, SaveYP, SaveVP, SaveVT, ChangeDi, ChangeSize, ChangeTD;
    /**int para almacenar la escala de esta ventana, parametro que consiste en el ancho y alto de la ventana siendo 16*escala el ancho y 12*escala el alto*/
    private int escala;
    /**Metodo Constructor de FrameP*/
    public FrameP(){
        super();
        this.escala = Escala.getescala();
        this.panel = new MPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(16*escala+16, 12*escala)); 
        this.setTitle("Proyecto Final Tema 3");
        this.add(panel);
        this.crearGUI();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    /**Crea new de las variables JLabel, JTextField y JButton, les da su dimencion y posicion en pantalla ademas de agregarles sus eventos y luego agregarlos al Frame*/
    public void crearGUI(){
        YPT= new JLabel("Altura del Avion: ");YPT.setBounds(10*escala/40,19*escala/2, 100*escala/40,10*escala/40);
        VPT= new JLabel("Velocidad del Avion: ");VPT.setBounds(10*escala/40,10*escala, 120*escala/40,10*escala/40);
        VTT= new JLabel("Velocidad del Target: ");VTT.setBounds(10*escala/40,21*escala/2, 130*escala/40,15*escala/40);
        YP = new JTextField();YP.setBounds(140*escala/40,19*escala/2, 120*escala/40,15*escala/40);
        VP = new JTextField();VP.setBounds(140*escala/40,10*escala, 120*escala/40,15*escala/40);
        VT = new JTextField();VT.setBounds(140*escala/40,21*escala/2, 120*escala/40,15*escala/40);
        SaveYP = new JButton("Guardar");SaveYP.setBounds(260*escala/40, 19*escala/2, 80*escala/40,15*escala/40);
        SaveVP = new JButton("Guardar");SaveVP.setBounds(260*escala/40, 10*escala, 80*escala/40,15*escala/40);
        SaveVT = new JButton("Guardar");SaveVT.setBounds(260*escala/40, 21*escala/2, 80*escala/40,15*escala/40);
        ChangeDi = new JButton("Cambiar Direccion Avion");ChangeDi.setBounds(450*escala/40, 10*escala, 180*escala/40,15*escala/40);
        ChangeTD = new JButton("Cambiar Direccion Target");ChangeTD.setBounds(450*escala/40, 21*escala/2, 180*escala/40,15*escala/40);
        ChangeSize = new JButton("Resize");ChangeSize.setBounds(450*escala/40, 19*escala/2, 180*escala/40,15*escala/40);
        Start = new JButton("Start");Start.setBounds(360*escala/40, 19*escala/2, 80*escala/40,15*escala/40);
        Reset = new JButton("Reset");Reset.setBounds(360*escala/40, 10*escala, 80*escala/40,15*escala/40);
        Stop = new JButton("Stop");Stop.setBounds(360*escala/40, 21*escala/2, 80*escala/40,15*escala/40);
        evento_Guardar(SaveYP);evento_Guardar(SaveVP);evento_Guardar(SaveVT);evento_CambDireccion(ChangeDi);evento_CambDireccion(ChangeTD);evento_StartStop(Start);evento_StartStop(Stop);evento_StartStop(Reset);evento_Resize(ChangeSize);
        this.add(YPT);this.add(VPT);this.add(YP);this.add(VP);this.add(SaveYP);this.add(SaveVP);this.add(ChangeDi);this.add(Start);this.add(Stop);this.add(Reset);this.add(ChangeTD);this.add(ChangeSize);this.add(VTT);this.add(VT);this.add(SaveVT);
    }
    /**Metodo de evento para reajustar el tamañan de la pantalla
     *@param act JButton al cual se le aplicara el evento*/
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
    /**Metodo de evento para Iniciar, Resetear y Detener la Animacion
     *@param act JButton al cual se le aplicara el evento*/
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
                    int temp = (int) (Math.random() * 10 - 5);
                    if(temp<0){
                        panel.setxt(599);
                    }else{
                        panel.setxt(0);
                    }
                    panel.setvt(temp);
                    try{
                        panel.getMisil().changexy(17*escala,13*escala);
                    }catch(Exception ex){
                        
                    }
                    panel.stopGame();
                }
                if (act.getBounds().y == 21*escala/2) {
                    panel.stopGame();
                }
            }
        });
    }
    /**Metodo de evento para Usar los datos ingresados en los TextField precionando sus respectivos JButton adyacentes
     *@param act JButton al cual se le aplicara el evento*/
    public void evento_Guardar(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().y == 19*escala/2) {//agregar limitantes osea si es menor a 40 no dejar y asi
                    try{
                        panel.setyp(Integer.parseInt(YP.getText())*escala/40);
                    }catch(NumberFormatException b){
                        JOptionPane.showMessageDialog(null, "No se a Introducido un valor Valido");
                    }
                }
                if (act.getBounds().y == 10*escala) {
                    try{
                        panel.setvp(Integer.parseInt(VP.getText())*escala/40);
                    }catch(NumberFormatException b){
                        JOptionPane.showMessageDialog(null, "No se a Introducido un valor Valido");
                    }
                }
                
                if (act.getBounds().y == 21*escala/2) {
                    try{
                        panel.setvt(Integer.parseInt(VT.getText())*escala/40);
                    }catch(NumberFormatException b){
                        JOptionPane.showMessageDialog(null, "No se a Introducido un valor Valido");
                    }
                }
            }
        });
    }
    /**Metodo para Cambiar la Direccion de JButton
     *@param act JButton al cual se le aplicara el evento*/
    public void evento_CambDireccion(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().y == 10*escala) {
                    panel.setvp(panel.getvp()*-1);
                    panel.rotateP();
                }
                if (act.getBounds().y == 21*escala/2) {
                    panel.setvt(panel.getvt()*-1);
                }
            }
        });
    }
}
