package com.kuang.lesson01;

import java.awt.*;

//GUI的第一个界面
public class TestFrame {
    public static void main(String[] args) {
        //Frame 对象
        Frame frame = new Frame("我i的第一Java图像窗口");

        //需要设置可见性
        frame.setVisible(true);

        //设置窗口大小 weight  height
        frame.setSize(400,400);

        //设置背景颜色  Color
        frame.setBackground(new Color(25, 108, 18));

        //弹出的初始位置
        frame.setLocation(200,200);

        //设置大小固定
        frame.setResizable(false);
    }
}
