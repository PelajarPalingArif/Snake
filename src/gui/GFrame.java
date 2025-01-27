package gui;

import javax.swing.*;
import java.awt.*;

public class GFrame extends JFrame {
    public GFrame(){
        super();
        this.setSize(600,600);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(18, 20, 108));
        this.setVisible(true);
        this.setTitle("Snake");
    }
}
