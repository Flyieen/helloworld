package com.kuang.demo02;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式三：实现callable接口
/*

 */

public class TestCallable implements Callable<Boolean> {

    private String url;  //网络图片地址
    private String name;  //保存的文件名

    public TestCallable(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+ name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattimg." +
                "dospy.com%2Fimg%2Fday_130714%2F20130714_ec6461694efe14f339fe6JpXmWkl4kBK.jpg&refer=http%3A%2F%2Fattimg." +
                "dospy.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?" +
                "sec=1617696251&t=722c0040fa65840ed91ebeaf0ab4c3fa","风景.jpg");
        TestCallable t2 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201902%2F20%2F20190220031903_wmjkp.jpg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617697507&t=6de43036cd46a90f18c1ec9f0c431c4f","美女.jpg");
        TestCallable t3 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201304%2F03%2F234931pwcmczi1zihcucmy.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617697507&t=3d73b45ef0d2104bc5e8f7c27ad7adce","建筑.jpg");

        //创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdownNow();
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
