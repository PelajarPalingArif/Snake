package entity;

import java.awt.*;
import java.util.LinkedList;

public class Snake {



    public static class Block {
        static Color DEFAULT_COLOR = new Color(0,0,0);
        int x;
        int y;
        Color color;
        public Block(){}
        public Block(int x, int y, Color color){
            this.x = x;
            this.y = y;
            this.color = (color == null) ? DEFAULT_COLOR : color;
        }
        public int getX(){return x;}
        public int getY(){return y;}
        public void addX(int addition) {this.x += addition;}
        public void addY(int addition) {this.y += addition;}
    }

    private int size;
    private LinkedList<Block> body;

    public Snake(){}

    public Snake(int size){
        this.size = size;
        this.body = new LinkedList<Block>();
        this.body.add(new Block(this.size,this.size,null));
        this.body.add(new Block(this.size,this.size - 10,null));

    }
    public void grow(){

    }

    public void reset(){
        this.getBody().clear();
    }

    public void move(char currDirection) {
        int prevX = this.body.getFirst().getX();
        int prevY = this.body.getFirst().getY();

        switch (currDirection){
            case 'w':this.body.getFirst().addY(-this.size);break;
            case 'a':this.body.getFirst().addX(-this.size);break;
            case 's':this.body.getFirst().addY(this.size);break;
            case 'd':this.body.getFirst().addX(this.size);break;
        }
        int tempX, tempY;
        for(int i = 1; i < this.body.size(); i++){
            Block cell = this.body.get(i);
            tempX = cell.getX();
            tempY = cell.getY();
            cell.x = prevX;
            cell.y = prevY;
            prevX = tempX;
            prevY = tempY;
        }
    }

    public LinkedList<Block> getBody() {
        return body;
    }

    public void setBody(LinkedList<Block> body) {
        this.body = body;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
