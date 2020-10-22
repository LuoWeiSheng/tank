package com.kuang1;

public class Main {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        TankFrame frame = new TankFrame();
        //可以注释掉，手动操纵移动
        while (true){
            try{
                Thread.sleep(150);
                //游戏有没暂停时，定时定向移动
                //不让主坦克自动移动
                frame.myTank.setMoving(false);
                frame.repaint();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
