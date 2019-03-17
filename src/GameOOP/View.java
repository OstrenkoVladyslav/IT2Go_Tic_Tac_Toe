package GameOOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Math.min;

public class View implements Observer {
    private Model model;
    private Controller controller;
    private JFrame window;

    public View(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        model.addObserver(this);
        //window = new Window();

       // window.addMouseListener(new );
    }

    public void createView() {
        window = new Window(model);
    }

    private void display(Model model) {

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Model) {
            Model model = (Model) o;
            display(model);
        }
    }
}

class Window extends JFrame {
    public Window(Model model) {
        setTitle("Tic-tac-toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        int screenWidth = dimension.width;
        int screenHeigth = dimension.height;
        int frameSize = min(screenHeigth, screenWidth)/3;
        setSize(frameSize,frameSize+50);
        setLocationByPlatform(true);
        setResizable(false);
        setLayout(new BorderLayout());

        Container contantPane = this.getContentPane();

        JPanel panel = new Panel(model);
        contantPane.add(panel, BorderLayout.CENTER);

        JPanel jButtomPanel = new JPanel();
        jButtomPanel.setLayout(new FlowLayout());

        JButton jButtonStart = new JButton("Start new game");
        jButtonStart.setSize(200, 50);
        jButtonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start");
            }
        });
        jButtomPanel.add(jButtonStart);

        JButton jButtonEnd = new JButton("Exit");
        jButtonEnd.setSize(75, 50);
        jButtonEnd.addActionListener(new Listener());
        jButtomPanel.add(jButtonEnd);

        contantPane.add(jButtomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

class Listener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Something happened...");
    }
}

class Panel extends JPanel {
    private int width, height;
    private int cellWidth, cellHeight;
    Model model;

    public Panel(Model model) {

        this.model = model;
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int clickX = e.getX() / cellWidth;//int clickX = 0;

                int clickY = e.getY() / cellHeight;//int clickY = 0;
                //field.setCell(clickX, clickY, field.getX_cell());
                System.out.println("X=" + clickX + ", Y=" + clickY);
                System.out.println("FIELD:");
                System.out.println(model);
                //repaint();
//                game.dumbMove();
                repaint();

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        width = height = min(getWidth(), getHeight());
        g.fillRect(0, 0, width, height);
        cellHeight = cellWidth = height / model.getSize();
        //cellHeight = cellWidth = 50;
        g.setColor(Color.black);
        for (int i = 1; i < model.getSize(); i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, height);
            g.drawLine(0, i * cellHeight, width, i * cellHeight);
        }
        g.setColor(Color.red);
        for (int i = 0; i < model.getSize(); i++) {
            for (int j = 0; j < model.getSize(); j++) {
                if (model.getCell(i, j) == model.getO_CELL()) {
                    g.drawOval((int) (cellWidth * (j + 0.1)), (int) (cellHeight * (i + 0.1)), (int) (cellWidth * 0.8), (int) (cellHeight * 0.8));
                }
                if (model.getCell(i, j) == model.getX_CELL()) {
                    g.drawLine(j * cellWidth + 10, i * cellHeight + 10, j * cellWidth + 10 + cellWidth - 20, i * cellHeight + 10 + cellHeight - 20);
                    g.drawLine(j * cellWidth + 10 + cellWidth - 20, i * cellHeight + 10, j * cellWidth + 10, i * cellHeight + 10 + cellHeight - 20);
                }
            }
        }
    }

}