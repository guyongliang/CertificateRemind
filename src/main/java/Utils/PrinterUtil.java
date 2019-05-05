package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PrinterUtil {
    public static Process process = null;
    public static void messageRemind() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/guyongliang/Documents/newFile.txt"));
        process = runtime.exec("cd ~ mkdir aaa");
        InputStream inputStream = process.getInputStream();

        int a = 0;
            byte[] buffer1 = new byte[2048];
            while ((a=inputStream.read())!=-1){
                int b = inputStream.read(buffer1);
                fileOutputStream.write(b);
            }
//            process.waitFor(10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws IOException {
        messageRemind();
    }
}
