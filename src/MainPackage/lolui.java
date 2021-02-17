package MainPackage;

import javax.swing.*;

public class lolui extends JFrame {
    JButton query  = new JButton("Find MainPackage.Summoner");
    JTextField search = new JTextField();
    public lolui(){

        super("LoL Stats Header");
        setSize(1200,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(search);
        panel.add(query);
        add(panel);
    }
    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            //ignore error
        }
    }
}
