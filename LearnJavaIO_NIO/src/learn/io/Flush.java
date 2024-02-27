package learn.io;

import java.io.*;
import java.util.Arrays;

/*
    When you use flush(), the data will be immediately written on the file,
    which immune it from data loss.
    It's used when immediate data persistence is needed.
    The close() also does the same, it forces any unwritten buffer data to file, in addition
    to closing of the stream.
 */

public class Flush {
    public static void main(String[] args) throws Exception{
        String inputImagePath = "Java_programming_language_logo.png";
        String outputImagePath = "javaImageWriter.png";

        try (FileInputStream fis = new FileInputStream(inputImagePath);
             FileOutputStream fos = new FileOutputStream(outputImagePath)) {

            byte[] buffer = new byte[4096]; // You can adjust the buffer size as needed
            int bytesRead;

            // Read image data from input file and write to output file
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.flush(); // Flush the output stream to ensure data is written immediately

            System.out.println("Image processing complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
