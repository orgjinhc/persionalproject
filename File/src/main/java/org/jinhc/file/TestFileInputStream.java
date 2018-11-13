package org.jinhc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author jinhongcai
 * @create 2018-11-13 10:22
 * @desc 文件输入流
 * 流
 * 流：指一连串流动的字符，是以先进先出方式发送信息的通道
 *
 * 输入流：源数据流向程序(读)
 *
 * 输入流：程序中的数据流向目标数据源(写)
 *
 * Java流的分类
 * 按流向
 *
 * 输出流(OutputStream和Writer作为基类)
 * 输入流(InputStream和Reader作为基类)
 * 输入输出流是相对于计算机内存来说的
 *
 * 按照处理数据单元划分
 *
 * 字节流
 *
 * 字节输入流(InputStream基类)
 * 字节输出流(OutputStream基类)
 * 字符流
 *
 * 字符输入流(Reader基类)
 * 字符输出流(Writer基类)
 * 字节流是8位(1B)通用字节流，字符流是16位(2B)Unicode字符流
 *
 * 字节流
 * FileInputStream 是 InputStream 的子类
 *
 * InputStream 类常用方法
 **/
public class TestFileInputStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\a.txt");
            fis = new FileInputStream(new File("D:\\a.txt"));
            //读取结果存入StringBuffer
            StringBuffer sb = new StringBuffer();
            System.out.println("预计读取：" + fis.available() + "字节");
            //记录每次读取的长度
            int len = 0;
            //缓冲区字节数组
            byte[] buff = new byte[1024];
            while ((len = fis.read(buff)) != -1) {
                System.out.println("还剩余：" + fis.available() + "字节");
                sb.append(new String(buff, 0, len));
            }
            System.out.println("结果：");
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
