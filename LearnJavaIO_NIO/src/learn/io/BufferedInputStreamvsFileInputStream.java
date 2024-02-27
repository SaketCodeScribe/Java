package learn.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Field;

/*
    BufferedInputStream has a private buf array of size n, in which streams are copied.
    When you use the read(), then the stream is copied into the buf array.
    Once you call the read(byte[]), then the internal buf array returns the data into the byte[] and gets depleted.
    You need to call read() again to replenish the buf array. ie on every read request the buf array internall
    stores the data.
    If the requested data is more than buffer size, then bufferdinputstream internally handles it.
    It also has mark and reset method, which helps in marking a byte and on call of reset, brings the
    cursor back to the set mark.
    Internally the read() call invokes inputstream read call which is a system call.

    Adv of buffered over fileinput are:
    1. internal buf array which helps in reducing system calls, which makes operation faster, as the buf array
        can be utilised.
    2. has the ability to mark and reset.
 */

public class BufferedInputStreamvsFileInputStream {
    public static void main(String[] args) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("fileread.txt"), 8);

            byte[] buffers = new byte[10];
            bis.read(buffers);
            for(byte b: buffers)
                System.out.print(b+" ");
            System.out.println();
            bis.read();
            // Using reflection to access the internal buffer
            Field bufField = BufferedInputStream.class.getDeclaredField("buf");
            bufField.setAccessible(true); // Enable access to private field
            byte[] buffer = (byte[]) bufField.get(bis); // Get the value of the field

            // Use the buffer array
            System.out.println("Buffer size: " + buffer.length);
            for(byte b:buffer)
                System.out.print(b+" ");
            System.out.println();
            // Modify the buffer array (just an example, not recommended in practice)
            buffer[0] = 100;
            System.out.println("First element of buffer modified: " + buffer[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
