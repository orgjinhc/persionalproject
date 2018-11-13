package org.jinhc.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jinhongcai
 * @create 2018-11-13 10:50
 * @desc 文件输出流
 **/
public class TestFileOutputStream {
    public static void main(String[] args) {
        FileOutputStream fos=null;
        try {
            //创建输出流对象
            File file = new File("D:\\d.txt");
            if (file.exists()) {
                System.out.println("文件不存在");
            } else {
                System.out.println(file.getName()+" 不存在！");
            }
            fos=new FileOutputStream("D:\\d.txt");
            //要输出的字符
            String str="hello world 你好";
            //将字符串转成字节数组并写入到流中
            fos.write(str.getBytes());
            //刷新流
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
