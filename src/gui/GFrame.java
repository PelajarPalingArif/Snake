package gui;

import javax.swing.*;
import java.awt.*;

public class GFrame extends JFrame {
    public static int WINDOW_HEIGHT = 600;
    public static int WINDOW_WIDTH = 600;
    public GFrame(){
        super();
        GPanel gpanel = new GPanel();
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setVisible(true);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gpanel);
        gpanel.runGame();
    }
}
