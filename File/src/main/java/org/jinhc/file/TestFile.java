package org.jinhc.file;

import java.io.File;
import java.io.IOException;

/**
 * @author jinhongcai
 * @create 2018-11-13 10:02
 * @desc 测试文件类
 **/
public class TestFile {
    public static void main(String[] args) {
        //创建File对象 传入文件的路径
        File file=new File("D:\\a.txt");
        //创建File对象 传入文件夹的路径
        File dir=new File("D:/word");
        //判断是否存在
        if(file.exists()) {
            if(file.isFile()) {
                //getName()获取名字
                System.out.println(file.getName()+" 是文件");
            }else if(file.isDirectory()){
                System.out.println(file.getName()+" 是目录");
            }
        }else {
            System.out.println(file.getName()+" 不存在！");
            try {
                //创建文件
                file.createNewFile();
                System.out.println("文件大小："+file.length()+" 字节");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(dir.exists()) {
            if(dir.isFile()) {
                System.out.println(dir.getName()+" 是文件");
            }else if(dir.isDirectory()) {
                System.out.println(dir.getName()+" 是文件夹");
                //绝对路径
                System.out.println(dir.getAbsolutePath());
            }
        }else {
            System.out.println(dir.getName()+" 不存在！");
            //创建目录
            dir.mkdirs();
        }
    }
}
