package com.kuang.annotation;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2 implements Runnable {
    private String url;  //网络图片地址
    private String name;  //保存的文件名

    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+ name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattimg." +
                "dospy.com%2Fimg%2Fday_130714%2F20130714_ec6461694efe14f339fe6JpXmWkl4kBK.jpg&refer=http%3A%2F%2Fattimg." +
                "dospy.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?" +
                "sec=1617696251&t=722c0040fa65840ed91ebeaf0ab4c3fa","风景.jpg");
        TestThread2 t2 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201902%2F20%2F20190220031903_wmjkp.jpg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617697507&t=6de43036cd46a90f18c1ec9f0c431c4f","美女.jpg");
        TestThread2 t3 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201304%2F03%2F234931pwcmczi1zihcucmy.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617697507&t=3d73b45ef0d2104bc5e8f7c27ad7adce","建筑.jpg");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }
}

class WebDownloader{
    //下载方法
    public void downloader(String url, String name)  {
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("下载方法执行错误");
        }

    }
}
