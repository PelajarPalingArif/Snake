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
    private Point food;

    public GPanel() {
        super();
        this.setBackground(new Color(255, 3, 33));
        this.setFocusable(true);
        this.addKeyListener(this);
        spawnFood();
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
                    checkCollision();
                    repaint();
                    Thread.sleep(650); // Pause for .7 second
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void checkCollision() {
        Snake.Block head = snake.getBody().getFirst();
        // Food Collision
        if(head.getX() == food.x && head.getY() == food.y) {
            snake.grow(currDirection);
        }

        int headX = head.getX();
        int headY = head.getY();
        int i = 0;
        for (Snake.Block cell : this.snake.getBody()){
            if(i == 0){
                i = 1;
                continue;
            }

            if (cell.getX() == headX && cell.getY() == headY){
                System.out.print("Game Over");
            }
        }


    }

    public void spawnFood() {
        food = new Point();
        food.setLocation(20,40);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.blue);
        g.fillRect(this.food.x, this.food.y, snake.getSize(), snake.getSize());
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
