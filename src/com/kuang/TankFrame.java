package com.kuang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank myTank = new Tank(100, 200, Directory.DEFAULT);
    Bullet bullet = new Bullet(300, 400, Directory.DOWN);

    public boolean isGameStop() {
        return gameStop;
    }

    public void setGameStop(boolean gameStop) {
        this.gameStop = gameStop;
    }

    //枚举定义方向，初始化
    //Directory directory = directory = Directory.DEFAULT;
    //初始化游戏是否暂停
    private boolean gameStop = false;

    public TankFrame() {
        setSize(800, 600);
        setResizable(true);
        setTitle("Tank World");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            boolean bL = false;
            boolean bU = false;
            boolean bR = false;
            boolean bD = false;

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 65 || e.getKeyCode() == 37) {
                    bL = true;
                    //System.out.println("L");
                }
                if (e.getKeyCode() == 87 || e.getKeyCode() == 38) {
                    bU = true;
                    //System.out.println("U");
                }
                if (e.getKeyCode() == 68 || e.getKeyCode() == 39) {
                    bR = true;
                    //System.out.println("R");
                }
                if (e.getKeyCode() == 83 || e.getKeyCode() == 40) {
                    bD = true;
                    //System.out.println("D");
                }
                if(e.getKeyCode() == 32){
                    myTank.setMoving(!myTank.isMoving());
                    gameStop = !gameStop;
                }
               /* switch (e.getKeyCode()) {
                    case 65:
                    case KeyEvent.VK_LEFT:
                        bL = true;
                        break;
                    case 87:
                    case KeyEvent.VK_UP:
                        bU = true;
                        break;
                    case 68:
                    case KeyEvent.VK_RIGHT:
                        bR = true;
                        break;
                    case 83:
                    case KeyEvent.VK_DOWN:
                        bD = true;
                        break;
                    default:
                        System.out.println(e.getKeyCode());
                        break;
                }*/
                setMainTankDir(myTank);
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //使用if-esle更灵活
                if (e.getKeyCode() == 65 || e.getKeyCode() == 37) {
                    bL = false;
                }
                if (e.getKeyCode() == 87 || e.getKeyCode() == 38) {
                    bU = false;
                }
                if (e.getKeyCode() == 68 || e.getKeyCode() == 39) {
                    bR = false;
                }
                if (e.getKeyCode() == 83 || e.getKeyCode() == 40) {
                    bD = false;
                }
                /*switch (e.getKeyCode()) {
                    case 65:
                    case KeyEvent.VK_LEFT:
                        bL = false;
                        break;
                    case 87:
                    case KeyEvent.VK_UP:
                        bU = false;
                        break;
                    case 68:
                    case KeyEvent.VK_RIGHT:
                        bR = false;
                        break;
                    case 83:
                    case KeyEvent.VK_DOWN:
                        bD = false;
                        break;
                    default:
                        System.out.println(e.getKeyCode());
                        break;
                }*/
            }

            //根据移动按键设置方向，只能上下左右
            private void setMainTankDir(Tank tank) {
                //游戏初始化，不用按空格，可以直接操作上下左右,并且暂停时不可以更改方向，像贪吃虫逻辑
                if(!gameStop){
                    myTank.setMoving(true);
                    if (bL) {
                        tank.setDirectory(Directory.LEFT);
                        //x -= speed;
                    }
                    if (bU) {
                        tank.setDirectory(Directory.UP);
                        //y -= speed;
                    }
                    if (bR) {
                        tank.setDirectory(Directory.RIGHT);
                        //x += speed;
                    }
                    if (bD) {
                        tank.setDirectory(Directory.DOWN);
                        //y += speed;
                    }
                }
            }
        });
    }

    //每一次初始化，改变窗口大小，自动调用
    @Override
    public void paint(Graphics g) {

        //Image image = new ImageIcon("src\\resouces\\7(GKRWU0(77)55]$QHG@R[N.png").getImage();
        //g.drawImage(image,1, 2, this);
        myTank.paint(g);
        bullet.paint(g);
    }
}
