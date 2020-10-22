package com.kuang;

import java.awt.*;

public class Tank {
    //坦克应该有的属性：
    /*
    * 1坐标x，y
    * 2方向
    * 3初始速度
    * 4是否静止
    * */
    private int x;
    private int y;
    private Directory directory;
    private int speed = 10;
    private boolean moving = false;
    private int weight = 50;
    private int height = 50;

    public Tank() {
    }

    public Tank(int x, int y, Directory directory) {
        this.x = x;
        this.y = y;
        this.directory = directory;
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

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void paint(Graphics g) {
        move(moving);
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
    }

    private void move(Boolean moving) {
        if(!moving) return;
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
