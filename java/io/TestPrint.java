package ImmortalSoul.io;

import java.io.*;
import java.security.spec.PSSParameterSpec;

/**
 * Created by tansibin on 2018/3/23.
 */
public class TestPrint {

    public static void main(String[] args) {
        File file = new File("PrintStream.txt");
        File fileWrite = new File("PrintWrite.txt");

        testStream(file);
        testWrite(fileWrite);

    }

    public static void testStream(File file){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PrintStream ps = new PrintStream(fos);
        if (ps!=null)
            System.setOut(ps);
        System.out.println("PrintStream \nI love you");
        ps.close();

    }
    public static void testWrite(File file){
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter pw = new PrintWriter(fw);
        pw.println("PrintWriter \nI love you");
        pw.close();
    }
}
