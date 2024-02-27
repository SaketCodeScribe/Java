package learn.io;

import java.io.FileInputStream;

/*
    The file can be red byte by byte or as a buffer array using read(), read(byte[]), read(byte[], int, int).
    FileInputStream reads data directly from file system, resulting in system call.
 */

public class ImageReaderFileInputStream {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("Java_programming_language_logo.png");

        if (fileInputStream != null){
            System.out.println("file successfully read");
            System.out.println(fileInputStream.available());
            int ch;
            while((ch = fileInputStream.read()) != -1){
                System.out.print((char)ch);
            }
        }
        else
            System.out.println("file read failed");
    }
}
