import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    private Visual panel;
    public static void main(String[] args) {
        // Enter pause in ms
        MorphString ms = new MorphString(200);
        Main main = new Main();
        // First argument is X string, second is Y string
        if(ms.check("100101011001", "AAAABBAAAABBBAAAAAABB", main.panel))
        {
            main.panel.result = "It is possible";
            main.panel.c = Color.GREEN;
        }
        else {
            main.panel.result = "It's impossible";
            main.panel.c = Color.RED;
        }
        main.panel.repaint();
    }

    Main(){
        panel = new Visual();
        add(panel);
        setSize(1280, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
