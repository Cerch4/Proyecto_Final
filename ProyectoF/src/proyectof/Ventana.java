package proyectof;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Ventana extends JFrame{
    private int escala;
    private int Width;
    private int Height;
    private JButton Start, Options;
    private MenuPanel MP;
    public Ventana(){
        super();
        escala = 160;
        Width = 4;
        Height = 3;
        MP = new MenuPanel(escala);
        setSize(Width*escala, Height*escala);
        setTitle("Proyecto Final Tema 3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.setResizable(false);
        crearMenu();
        setVisible(true); 
    }
    public void crearMenu(){
        Start = new JButton("Start");Start.setBounds(12*escala/8,11*escala/8, escala, escala/4);
        Options = new JButton("Options");Start.setBounds(12*escala/8, 14*escala/8, escala, escala/4);
        add(Start);add(Options);   
    }
    public void evento_Options(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(MP);
            }
        });
    }
    public void reziseV(int escala){
        this.escala = escala;
        MP = new MenuPanel(escala);
        setSize(Width*escala, Height*escala);
        crearMenu();
    }
}
