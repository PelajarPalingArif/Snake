package entity;

import java.awt.*;
import java.util.LinkedList;

public class Snake {

    private static class Block {
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
    }

    private int size;
    private LinkedList<Block> body;

    public Snake(){}

    public Snake(int size){
        this.size = size;
        this.body = new LinkedList<Block>();
        this.body.add(new Block(1,1,null));
    }

}
