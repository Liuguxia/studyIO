package ZiFuLiu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterChar {
    public static void main(String[] args) {
        //1.建立联系（选择目的地）
        File descPath=new File("C:\\Users\\pc\\Desktop\\Out\\七步诗.txt");
        //2.选择流
        Writer wr=null;
        try {
            wr = new FileWriter(descPath,false);
            //3.写出
            String str="\uFEFF七步诗\n" +
                    "\n" +
                    "作者：曹植\n" +
                    "\n" +
                    "煮豆持作羹，漉菽以为汁。\n" +
                    "萁在釜下燃，豆在釜中泣。\n" +
                    "本自同根生，相煎何太急？";
            wr.write(str);

            /*
                在控制台打印出来（此步可以无有）
             */
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //4.关闭流
            if(wr!=null){
                try {
                    wr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
