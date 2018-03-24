package ImmortalSoul.io;

import java.io.*;

/**
 * Created by tansibin on 2018/3/23.
 */
public class TestFileStream {

    public static void main(String[] args) {

        File fileInput = new File("hello.txt");
        File fileOutput = new File("FileOutput.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(fileInput);
            fos = new FileOutputStream(fileOutput);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fos.write(bytes);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
