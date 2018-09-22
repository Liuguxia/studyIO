package ZiFuLiu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
      使用字符流Reader读取
 */
public class ReaderChar {
    public static void main(String[] args) {
        //1.建立联系（选择源头）
        File srcPath=new File("C:\\Users\\pc\\Desktop\\In\\A.txt");
        //2.选择流
        Reader reader=null;
        try {
            reader=new FileReader(srcPath);
            //3.读取
            char[] flush=new char[1024];
            int len=0;
            while (-1!=(len=reader.read(flush))){
                //因为要在控制台输出读到的内容，故要把字符数组转为字符串
                String str=new String(flush,0,len);
                //str.getBytes("GB2312");      乱码不会弄啊
                System.out.println(str);
            }
            //4.关闭
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
