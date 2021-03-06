package com.kuang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    //游戏界面大小
    private static final int GAME_WEIGHT = 800;
    private static final int GAME_HEIGHT = 600;
    private boolean shoot = false;
    private boolean isInit = true;
    Tank myTank = new Tank(100, 200, Directory.DEFAULT);
    Bullet bullet = new Bullet(300, 400, Directory.DOWN);
    Bullet[] bullet1 = new Bullet[150];
    Bullet[] bullet2 = new Bullet[150];
    Bullet[] bullet3 = new Bullet[150];
    Bullet[] bullet4 = new Bullet[150];
    Bullet[] bullet5 = new Bullet[150];

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
        setSize(GAME_WEIGHT, GAME_HEIGHT);
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
                if (e.getKeyCode() == 32) {
                    myTank.setMoving(!myTank.isMoving());
                    gameStop = !gameStop;
                }
                //这里不用判主坦克为空
                if (e.getKeyCode() == 69) {//e键，发射子弹
                    shoot = true;
                    System.out.println(e.getKeyCode());
                    myTank.setMoving(false);
                    shoot();
                }
                //System.out.println(e.getKeyCode());
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
                isInit = false;
                if (!gameStop) {
                    if(bL || bU || bR || bD){
                        myTank.setMoving(true);
                    }else {
                        return;
                    }
                    //myTank.setMoving(true);
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

    public void shoot() {
        if (shoot) {
            switch (myTank.getDirectory()) {
                case LEFT://子弹画在主坦克的左边盒子边缘中间，···
                    for (int i = 0; i < bullet1.length; i++) {
                        if (bullet1[i] == null){
                            bullet1[i] = new Bullet(myTank.getX() - Bullet.getWEIGHT(), myTank.getY() + (myTank.getHeight() - Bullet.getHEIGHT()) / 2, myTank.getDirectory());
                            break;//break限定for只赋值一次。。。。
                        }
                    }
                    break;
                case UP:
                    for (int i = 0; i < bullet2.length; i++) {
                        if (bullet2[i] == null){
                            bullet2[i] = new Bullet(myTank.getX() + ((myTank.getWeight() - Bullet.getWEIGHT()) / 2), myTank.getY() - Bullet.getHEIGHT(), myTank.getDirectory());
                            break;
                        }
                    }
                    break;
                case RIGHT:
                    for (int i = 0; i < bullet3.length; i++) {
                        if (bullet3[i] == null){
                            bullet3[i] = new Bullet(myTank.getX() + myTank.getWeight(), myTank.getY() + (myTank.getHeight() - Bullet.getHEIGHT()) / 2, myTank.getDirectory());
                            break;
                        }
                    }
                    break;
                case DOWN:
                    for (int i = 0; i < bullet4.length; i++) {
                        if (bullet4[i] == null){
                            bullet4[i] = new Bullet(myTank.getX() + ((myTank.getWeight() - Bullet.getWEIGHT()) / 2), myTank.getY() + myTank.getHeight(), myTank.getDirectory());
                            break;
                        }
                        //break;只能发射一颗，但是能是子弹加速
                    }
                    break;
                case DEFAULT:
                    for (int i = 0; i < bullet5.length; i++) {
                        if (bullet5[i] == null){
                            bullet5[i] = new Bullet(myTank.getX() + ((myTank.getWeight() - Bullet.getWEIGHT()) / 2), myTank.getY() - Bullet.getHEIGHT(), Directory.UP);
                            break;
                        }

                        if(bullet5[0] != null)
                        System.out.println(bullet5[0]);
                        if(bullet5[1] != null)
                            System.out.println(bullet5[1]);

                    }
                    break;
                default:
                    break;
            }
        }
    }

    //双缓冲解决闪烁问题
    //调用paint前会先调用update
    Image offSrceenImage = null;

    @Override
    public void update(Graphics g) {
        if (offSrceenImage == null) {
            offSrceenImage = this.createImage(GAME_WEIGHT, GAME_HEIGHT);
        }
        Graphics gOffScreen = offSrceenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WEIGHT, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offSrceenImage, 0, 0, null);
    }

    //每一次初始化，改变窗口大小，自动调用
    @Override
    public void paint(Graphics g) {
        //Image image = new ImageIcon("src\\resouces\\7(GKRWU0(77)55]$QHG@R[N.png").getImage();
        //g.drawImage(image,1, 2, this);
        //初始化显示主坦克

        myTank.paint(g);
        
        bullet.paint(g);
        if (shoot) {
            for (Bullet bullet : bullet1) {
                if (bullet != null) {
                    bullet.paint(g);
                }
            }
            for (Bullet bullet : bullet2) {
                if (bullet != null) {
                    bullet.paint(g);
                }
            }
            for (Bullet bullet : bullet3) {
                if (bullet != null) {
                    bullet.paint(g);
                }
            }
            for (Bullet bullet : bullet4) {
                if (bullet != null) {
                    bullet.paint(g);
                }
            }
            for (Bullet bullet : bullet5) {
                if (bullet != null) {
                    bullet.paint(g);

                    //System.out.println(bullet);
                }
            }
        }
    }
}
