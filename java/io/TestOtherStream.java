package ImmortalSoul.io;

import java.io.*;

/**
 * Created by tansibin on 2018/3/23.
 */
public class TestOtherStream {

    public static void main(String[] args) {
        File fileInput = new File("BufferedTest.txt");
        File fileWrite = new File("OutputStreamWrite.txt");

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            //解码
            FileInputStream fis = new FileInputStream(fileInput);
            InputStreamReader isr = new InputStreamReader(fis,"GBK");
            br = new BufferedReader(isr);

            //编码
            FileOutputStream fos = new FileOutputStream(fileWrite);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
            bw = new BufferedWriter(osw);

            String str ;
            while ((str = br.readLine())!=null){
                bw.write(str);
                bw.newLine();
                bw.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
