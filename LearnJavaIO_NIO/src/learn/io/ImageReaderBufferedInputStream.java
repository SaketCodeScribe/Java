package learn.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/*
    BuffereInputstream works by copying data from stream(inputStream) to a buffer array.
    This doesn't have direct system calls.

 */

public class ImageReaderBufferedInputStream {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("fileread.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // buffer array in which input stream will be saved
        byte[] buffer = new byte[8];
        // no. of bytes read by the read() method.
        int bytesRead;

        if (fileInputStream != null){
            System.out.println("file successfully read");
            bytesRead = fileInputStream.read(buffer);
            System.out.println(bytesRead+" "+buffer.length);
            for(byte b:buffer)
                System.out.print(b+" ");
            System.out.println();
            fileInputStream.skip(4);
            bytesRead = fileInputStream.read(buffer);
            for(byte b:buffer)
                System.out.print(b+" ");
//            bytesRead = bufferedInputStream.read(buffer);
//            for(byte b:buffer)
//                System.out.print(b+" ");
//            System.out.println();
//            bufferedInputStream.skip(4);
//            bytesRead = bufferedInputStream.read(buffer);
//            for(byte b:buffer)
//                System.out.print(b+" ");
//            System.out.println();
        }
        else
            System.out.println("file read failed");
    }
}
