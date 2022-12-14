package proyectof;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Ventana extends JFrame{
    /**JButton para imprirse en Ventana y perimitir Interaccion con la interfaz*/
    private JButton e640x480, e1280x960, e1920x1440;
    /**Metodo Constructor de esta Ventana*/
    public Ventana(){
        super();
        setSize(640, 480);
        setTitle("Proyecto Final Tema 3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        crearMenu();
        setVisible(true); 
    }
    /**Crea new de las variables JButton, les da su dimencion y posicion en pantalla ademas de agregarles sus eventos y luego agregarlos a la Ventana*/
    public void crearMenu(){
        e640x480 = new JButton("640x480");e640x480.setBounds(240,220, 160, 40);
        e1280x960 = new JButton("1280x960");e1280x960.setBounds(240, 280, 160, 40);
        e1920x1440 = new JButton("1920x1440");e1920x1440.setBounds(240, 340, 160, 40);
        evento_Options(e640x480);evento_Options(e1280x960);evento_Options(e1920x1440);
        add(e640x480);add(e1280x960);add(e1920x1440); 
    }
    /**Metodo de evento para Definir las Dimensiones de FrameP y sus JPanels siendo estas dimensiones 640x480, 1280x960 y 1920x1440 respectivamente*/
    public void evento_Options(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().y == 220) {
                    Escala.setescala(40);
                    new FrameP();
                    setVisible(false); 
                    dispose();
                }
                if (act.getBounds().y == 280) {
                    Escala.setescala(80);
                    new FrameP();
                    setVisible(false); 
                    dispose();
                }
                if (act.getBounds().y == 340) {
                    Escala.setescala(120);
                    new FrameP();
                    setVisible(false); 
                    dispose();
                }
            }
        });
    }
}
