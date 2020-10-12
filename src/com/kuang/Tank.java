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

    public void paint(Graphics g) {
        move();
        g.fillRect(x, y, 50, 50);
    }

    private void move() {
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
