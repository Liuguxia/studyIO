import java.io.*;

public class CopyFile {
    /*
            拷贝文件
          1.建立联系，File对象（源头），另一File对象（目的地,文件可以不存在）
          2.选择流
               文件输入流  Inputstream、FileInputStream
               文件输出流  OutputStream、FileOutputStream
          3.操作  先读取，后输出
               btye[] flush=new byte[1024]
               int len=0
               while(-1!=(len=输入流.read(flush))){
                    输出流.write(flush,0,len);
               }
               输出流.flush();
          4.释放资源，关闭流
     */
    public static void main(String[] args) {
        File src = new File("C:\\Users\\pc\\Desktop\\In\\演示文稿1.pptx");
        File desc = new File("C:\\Users\\pc\\Desktop\\Out\\演.pptx");
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(desc);

            byte[] flush = new byte[1024];
            int len = 0;

            while (-1 != (len = in.read(flush))) {
                out.write(flush, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
