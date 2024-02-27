package learn.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageWriterFileOutputStream {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("javaImageWriter.png");
        FileInputStream fileInputStream = new FileInputStream("Java_programming_language_logo.png");

        if (fileInputStream != null){
            System.out.println("file successfully read");
            int ch;
            while((ch = fileInputStream.read()) != -1){
                fileOutputStream.write(ch);
            }
            System.out.println("file successfully write");
            fileOutputStream.close();
        }
        else
            System.out.println("file read failed");

    }
}
