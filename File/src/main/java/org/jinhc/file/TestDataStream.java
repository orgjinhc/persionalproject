package org.jinhc.file;

import java.io.*;

/**
 * @author jinhongcai
 * @create 2018-11-13 11:00
 * @desc 数据流
 **/
public class TestDataStream {
    public static void main(String[] args) {
        //文件输入流
        FileInputStream fis=null;
        //数据输入流(包装fis得到)
        DataInputStream dis=null;
        //文件输出流
        FileOutputStream fos=null;
        //数据输出流(包装fos得到)
        DataOutputStream dos=null;

        try {
            fis=new FileInputStream("D:\\a.jpg");
            dis=new DataInputStream(fis);
            fos=new FileOutputStream("E:\\b.jpg");
            dos=new DataOutputStream(fos);
            //缓冲数组
            byte[] buff=new byte[1024*1024];
            //记录每次读取的字节个数
            int len=0;
            //循环读入
            while((len=dis.read(buff))!=-1) {
                System.out.println(fis.available());
                //循环写入len个字节
                dos.write(buff,0,len);
            }
            System.out.println("完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (dis!=null) {
                    dis.close();
                }
                if (dos!=null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
