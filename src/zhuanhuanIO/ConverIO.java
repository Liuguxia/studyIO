package zhuanhuanIO;
/*
    转换流:把字节流转成字符流
    编码与解码的字符集一致，就不乱码
    与原文件的编码不一致，就乱码
 */

import java.io.*;

public class ConverIO {
    public static void main(String[] args) {
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            br=new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(new File("C:\\Users\\pc\\Desktop\\In\\编码.txt")),"gbk"));
            bw=new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream(new File("C:\\Users\\pc\\Desktop\\In\\解码.txt"),true),"gbk"));
            //读取
            String line=null;
            while (null!=(line=br.readLine())){
                //写出
                bw.write(line);
                bw.newLine();
                System.out.println(line);
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
