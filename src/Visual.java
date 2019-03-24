import javax.swing.*;
import java.awt.*;

class Visual extends JPanel {
    String x, y, _y, current, greencurrent, redcurrent, result, greenx, redx, borders;
    int tries = 0;
    Color c;
    Visual(){
        x = "";
        y = "";
        _y = "";
        current = "";
        greencurrent = "";
        redcurrent = "";
        greenx = "";
        redx = "";

        result = "";
        borders = "";
        c = Color.BLACK;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 51, 198));
        g.fillRect(0, 0, 8000, 400);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", Font.BOLD, 25));
        g.drawString("X", 50, 70);
        g.drawString(x, 60, 101);

        g.drawString("Y", 50, 132);
        g.drawString(y, 60, 163);

        g.drawString(_y, 60, 194);
        g.drawString(current, 60, 225);
        g.drawString(x, 60, 256);
        g.drawString("Tries: " + tries, 60, 287);

        g.setColor(c);
        g.drawString(result, 60, 325);

        g.setColor(Color.RED);
        g.drawString(redcurrent, 60, 225);
        g.drawString(redx, 60, 256);
        g.setColor(Color.GREEN);
        g.drawString(greencurrent, 60, 225);
        g.drawString(greenx, 60, 256);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 25));
        g.drawString(borders, 68, 220);
        g.drawString(borders, 68, 230);
    }
}