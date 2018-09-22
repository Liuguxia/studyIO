package close;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CloseUtils {
    public static void closeMethod(InputStream in, OutputStream out){
        if(out!=null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(in!=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
