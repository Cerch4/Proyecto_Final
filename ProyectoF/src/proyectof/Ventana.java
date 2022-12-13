package proyectof;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Ventana extends JFrame{
    private JButton e640x480, e1280x960, e1920x1440;
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
    public void crearMenu(){
        e640x480 = new JButton("640x480");e640x480.setBounds(240,220, 160, 40);
        e1280x960 = new JButton("1280x960");e1280x960.setBounds(240, 280, 160, 40);
        e1920x1440 = new JButton("1920x1440");e1920x1440.setBounds(240, 340, 160, 40);
        evento_Options(e640x480);evento_Options(e1280x960);evento_Options(e1920x1440);
        add(e640x480);add(e1280x960);add(e1920x1440); 
    }
    public void evento_Options(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().y == 220) {
                    FrameP.escala = 40;
                    new FrameP();
                    setVisible(false); 
                    dispose();
                }
                if (act.getBounds().y == 280) {
                    FrameP.escala = 80;
                    new FrameP();
                    setVisible(false); 
                    dispose();
                }
                if (act.getBounds().y == 340) {
                    FrameP.escala = 120;
                    new FrameP();
                    setVisible(false); 
                    dispose();
                }
            }
        });
    }
}
