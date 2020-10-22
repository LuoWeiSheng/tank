package com.kuang1;

import java.awt.*;

public class Bullet {
    private static final int WEIGHT = 15;
    private static final int HEIGHT = 15;
    private int x;
    private int y;
    private Direction direction;
    private int speed = 6;

    private volatile static int count = 0;
    public Bullet() {

    }

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        count++;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public static int getWEIGHT() {
        return WEIGHT;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public void paint(Graphics g){
        paint(g, x, y, WEIGHT, HEIGHT, speed, direction);
    }

    public void paint(Graphics g, Direction direction){
        paint(g, x, y, WEIGHT, HEIGHT, speed, direction);
    }

    public void paint(Graphics g, int x, int y, int weight, int height, int speed, Direction direction){
        Color c = g.getColor();
        g.setColor(Color.RED);
        move(direction);
        g.fillOval(x, y, WEIGHT, HEIGHT);
        g.setColor(c);
    }

    public int size(){
        return count;
    }
    public void setSize() {
        if(count > 0){
            count -= 1;
        }
    }

    private void move(Direction direction) {
        switch (direction) {
            case LEFT:
                x -= speed;
                break;
            case UP:
                y -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y += speed;
                break;
            default:
                break;
        }
    }
}
