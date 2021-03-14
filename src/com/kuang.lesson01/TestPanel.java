package com.kuang.lesson01;

import java.awt.*;

//Panel 可以看成是一个空间，但是不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //布局的概念
        Panel panel = new Panel();

        //设置布局
        frame.setLayout(null);

        //坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(77, 156, 71, 101));

        //panel设置坐标，相对于frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(193,15,60));

        //frame.add(panel)
        frame.add(panel);

        frame.setVisible(true);

    }
}
