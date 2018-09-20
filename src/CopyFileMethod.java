import java.io.*;

public class CopyFileMethod {
    public static void main(String[] args) {
        String srcPath="C:\\Users\\pc\\Desktop\\In\\演示文稿1.pptx";
        String descPath="C:\\Users\\pc\\Desktop\\Out\\演示文稿copy.pptx";
        copyFile(srcPath,descPath);
    }

    //封装的方法
    public static void copyFile(String srcPath,String descPath){
        File src = new File(srcPath);
        File desc = new File(descPath);
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
