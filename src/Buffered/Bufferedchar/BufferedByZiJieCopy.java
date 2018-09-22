package Buffered.Bufferedchar;

import close.CloseUtils;

import java.io.*;
/*
    使用缓冲流包装字节流》》》》缓冲流（字节流）
 */

public class BufferedByZiJieCopy {
    public static void main(String[] args) {
        String srcPath="C:\\Users\\pc\\Desktop\\In\\B.txt";
        String descPath="C:\\Users\\pc\\Desktop\\In\\C.txt";
        copybuffered(srcPath,descPath);
    }

    //封装拷贝方法（字节流和字节缓冲流之间没有新增方法，故直接   缓冲流（字节流））
    public static void copybuffered(String srcPath,String descPath) {
        //1.建立联系
        File srcFile=new File(srcPath);   // 源头
        File descFile=new File(descPath);  //目的地
        //2.选择流
        InputStream in =null;
        OutputStream out=null;
        try {
            in=new BufferedInputStream(new FileInputStream(srcFile));
            out= new BufferedOutputStream(new FileOutputStream(descFile,false));
            //3.操作  读取+关闭
            byte[] flush=new byte[1024];
            int len=0;
            while (-1!=(len=in.read(flush))){
                out.write(flush,0,len);

                //在控制台打印(把字符数组转成字符串)
                String str=new String(flush,0,len);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {    //4.关闭流
            CloseUtils.closeMethod(in,out);
        }

    }
}
