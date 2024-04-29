package learn.io;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;

public class FileBufferedOutputStream {
    public static void main(String[] args) throws Exception {

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("f1.txt"));

        for(int i=0; i<26; i++) {
            char ch = (char)('A'+i);
            bufferedOutputStream.write(ch);
        }

//        Field bufField = BufferedOutputStream.class.getDeclaredField("buf");
//        bufField.setAccessible(true);
//        byte[] buffer = (byte[])bufField.get(bufferedOutputStream);
//        for(byte b:buffer)
//            System.out.print(b+" ");
        System.out.println();
        Field bufField = BufferedInputStream.class.getDeclaredField("buf");
        bufField.setAccessible(true); // Enable access to private field
        byte[] buffer = (byte[]) bufField.get(bufferedOutputStream);
        bufferedOutputStream.close();

    }
}
