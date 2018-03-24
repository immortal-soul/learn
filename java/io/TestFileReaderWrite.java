package ImmortalSoul.io;

import java.io.*;

/**
 * Created by tansibin on 2018/3/23.
 */
public class TestFileReaderWrite {

    public static void main(String[] args) {

        File file = new File("hello.txt");
        File fileWrite = new File("FileWrite.txt");
        StringBuffer stringBuffer = new StringBuffer();
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(file);
            fw = new FileWriter(fileWrite);
            int len;
            char[] chars = new char[50];
            while ((len = fr.read(chars)) != -1) {
                stringBuffer.append(new String(chars, 0, len));
            }
            System.out.println(stringBuffer);

            stringBuffer.append("\nFileWrite!!");

            fw.write(stringBuffer.toString());
            fw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
