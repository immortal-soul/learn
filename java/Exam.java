package ImmortalSoul.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by tansibin on 2018/3/23.
 */
public class Exam {

    public static void main(String[] args) {
        exam();
    }

    public static void exam() {

        BufferedReader br = null;

        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in);
        br = new BufferedReader(isr);
        try {
            while (true) {
                System.out.println("请输入字符串：");
                String str = br.readLine();
                if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(str.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
