package histogram;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is a frame. It is a welcome screen. It contains a button to start an application.
 *
 * @author Anna Antończak
 * @since 23.02.2018
 */
public class StartWindow extends JFrame {
    private JButton startButton;
    private JPanel panel1;


    StartWindow() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/Ania/Documents/pwr/Rok3/semestr6/Zaawansowane_techniki_JAVA/Histogram/icon/64x64.png"));
        panel1.setPreferredSize(new Dimension(300, 250));
        add(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                panel1 = new MainWindow().getPanel1();
                panel1.setPreferredSize(new Dimension(300, 250));
                add(panel1);
                revalidate();
                pack();
            }
        });
    }

    public static void main(String[] args) {
        StartWindow startWindow = new StartWindow();
    }
}