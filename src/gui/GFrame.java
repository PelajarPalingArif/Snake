package gui;

import javax.swing.*;
import java.awt.*;

public class GFrame extends JFrame {
    public GFrame(){
        super();
        GPanel gpanel = new GPanel();
        this.setSize(600,600);
        this.setVisible(true);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gpanel);
        gpanel.runGame();
    }
}
