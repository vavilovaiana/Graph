/**
 * Created by svetlanka on 26.06.17.
 */

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph extends JFrame {

    private GraphPanel g;

    public Graph()
    {
        List d = new ArrayList();

        for (int x = 1; x <= 500; x++) {
            d.add(2*Math.cos(0.1*x));
        }
        g = new GraphPanel(d);
        getContentPane().add(g);
        setBounds(10, 10, 800, 800);
    }

    public static void main(String[] args) {
        Graph t = new Graph();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setVisible(true);
    }
}

class GraphPanel extends JPanel {
    private List data;

    public GraphPanel(List data) {
        this.data = data;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        double Kx = getWidth() / 500.0;
        double Ky = getHeight() / 10.0;
        double xo = -1;
        double yo = -1;

        double x = 0;
        for (Iterator<Double> it = data.iterator(); it.hasNext();) {
            double y = it.next().doubleValue();

            if (xo >= 0.0) {
                int x1 = (int) ((xo + 1) * Kx);
                int x2 = (int) ((x + 1) * Kx);

                int y1 = (int) (getHeight() - (yo + 5) * Ky);
                int y2 = (int) (getHeight() - (y + 5) * Ky);
                g.drawLine(x1, y1, x2, y2);
            }

            xo = x;
            yo = y;
            x += 1;
        }
    }
}
