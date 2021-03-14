package com.kuang.lesson01;

import java.awt.*;

public class TestFrame2 {
    public static void main(String[] args) {
        //展示多个窗口 new
        new MyFrame(100,100,200,200,Color.BLUE);
        new MyFrame(300,100,200,200,Color.yellow);
        new MyFrame(100,300,200,200,Color.cyan);
        new MyFrame(300,300,200,200,Color.RED);
    }
}

class MyFrame extends Frame{
    static int id = 0;  //可能存在多个窗口，我们需要一个计数器
    public MyFrame(int x, int y, int w,int h,Color color){
        super("Myframe"+(++id));
        setBackground(color);
        setVisible(true);
        setBounds(x,y,w,h);
    }
}
