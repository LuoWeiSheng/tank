package com.kuang1;

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
    private Direction direction;
    private int speed = 10;
    private boolean moving = false;
    private int weight = 50;
    private int height = 50;
    private TankFrame tankFrame;

    public Tank() {
    }

    public Tank(int x, int y, Direction direction, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
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
        if (!moving) return;
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

    public void fire() {
        Bullet bullet = null;
        switch (this.getDirection()) {
            case LEFT://子弹画在主坦克的左边盒子边缘中间，···
                if (bullet == null) {
                    bullet = new Bullet(this.getX() - Bullet.getWEIGHT(), this.getY() + (this.getHeight() - Bullet.getHEIGHT()) / 2, this.getDirection());
                    break;//break限定for只赋值一次。。。。
                }
                break;
            case UP:
                if (bullet == null) {
                    bullet = new Bullet(this.getX() + ((this.getWeight() - Bullet.getWEIGHT()) / 2), this.getY() - Bullet.getHEIGHT(), this.getDirection());
                    break;
                }
                break;
            case RIGHT:
                if (bullet == null) {
                    bullet = new Bullet(this.getX() + this.getWeight(), this.getY() + (this.getHeight() - Bullet.getHEIGHT()) / 2, this.getDirection());
                    break;
                }
                break;
            case DOWN:
                if (bullet == null) {
                    bullet = new Bullet(this.getX() + ((this.getWeight() - Bullet.getWEIGHT()) / 2), this.getY() + this.getHeight(), this.getDirection());
                    break;
                }
                break;
            case DEFAULT:

                if (bullet == null) {
                    bullet = new Bullet(this.getX() + ((this.getWeight() - Bullet.getWEIGHT()) / 2), this.getY() - Bullet.getHEIGHT(), direction.UP);
                    break;
                }
                break;
            default:
                break;
        }
        tankFrame.bullets.add(bullet);
    }
}
