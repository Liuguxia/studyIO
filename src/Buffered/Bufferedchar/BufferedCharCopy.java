package Buffered.Bufferedchar;

import close.CloseUtils;

import java.io.*;
/*
    字符缓冲流   》缓冲流（字符流），不能发生多态
 */
public class BufferedCharCopy {
    public static void main(String[] args) {
        String srcPath="C:\\Users\\pc\\Desktop\\In\\B.txt";
        String descPath="C:\\Users\\pc\\Desktop\\In\\1.txt";
        bufferedCopyBychar(srcPath,descPath);
    }

    public static void bufferedCopyBychar(String srcPath,String descPath) {
        //1.建立联系
        File srcFile = new File(srcPath);
        File descFile = new File(descPath);
        //2.选择流
        BufferedReader r=null;
        BufferedWriter w=null;
        try {
            r=new BufferedReader(new FileReader(srcFile));
            w=new BufferedWriter(new FileWriter(descFile,false));
            //3.操作
            String line=null;
            while (null!=(line=r.readLine())){
                w.write(line);
                //w.append("\r\n");
                w.newLine();   //使用新增方法，换行

                System.out.println(line);
            }
            w.flush();  //强制刷新
//            char[] flush = new char[1024];
//            int len=0;
//            while (-1!=(len=r.read(flush))){
//                w.write(flush,0,len);
//
//                //在控制台打印
//                String str=new String(flush,0,len);
//                System.out.println(str);
//            }
//            w.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {//4.关闭
            //CloseUtils.closeMethod(r,w);   类型不对，故不能用
            if(w!=null){
                try {
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(r!=null){
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
