package ZiFuLiu;


import java.io.*;

public class CopyFileByChar {
    public static void main(String[] args) {
        //1.建立文件联系  源头+目的地
        File srcPath=new File("C:\\Users\\pc\\Desktop\\In\\A.txt");
        File descPath=new File("C:\\Users\\pc\\Desktop\\In\\B.txt");
        copyFileBychar(srcPath,descPath);
    }

    //拷贝纯文本，使用字符流
    public static void copyFileBychar(File srcFile,File descFile){
        //2.选择流 Reader FileReader,Writer FileWriter
        Reader reader =null;
        Writer wtriter =null;
        try {
            reader = new FileReader(srcFile);
            wtriter = new FileWriter(descFile,true);
            //读取
            char[] flush = new char[1024];
            int len=0;
            while(-1!=(len=reader.read(flush))){
                //写出
                wtriter.write(flush,0,len);
                //在控制台打印
                //把字符数组转变成字符串
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(wtriter!=null){
                try {
                    wtriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
