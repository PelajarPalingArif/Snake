package gui;

import entity.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GPanel extends JPanel implements KeyListener {
    private Snake snake;
    private boolean gameRunning;
    private char currDirection = 'd';

    public GPanel() {
        super();
        this.setBackground(new Color(255, 3, 33));
        this.setFocusable(true);
        this.addKeyListener(this);

        initGame();
    }

    public void initGame() {
        this.snake = new Snake(10);
        this.gameRunning = true;
    }

    public void runGame() {
        new Thread(() -> {
            try {
                while (this.gameRunning) {
                    snake.move(currDirection);
                    repaint();
                    Thread.sleep(1000); // Pause for 1 second
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g.setColor(Color.black);
        for (Snake.Block cell : this.snake.getBody()) {
            g.fillRect(cell.getX(), cell.getY(), snake.getSize(), snake.getSize());
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.print(e.getKeyCode());
        switch (e.getKeyCode()){
            case 40:currDirection = 's';break;
            case 39:currDirection = 'd';break;
            case 38:currDirection = 'w';break;
            case 37:currDirection = 'a';break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
