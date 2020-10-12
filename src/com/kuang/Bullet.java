package com.kuang;

import java.awt.*;

public class Bullet {
    private static final int WEIGHT = 15;
    private static final int HEIGHT = 15;
    private int x;
    private int y;
    private Directory directory;
    private int speed = 4;
    public Bullet() {

    }

    public Bullet(int x, int y, Directory directory) {
        this.x = x;
        this.y = y;
        this.directory = directory;
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

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        move();
        g.fillOval(x, y, WEIGHT, HEIGHT);
        g.setColor(c);
    }

    private void move() {
        switch (directory) {
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
