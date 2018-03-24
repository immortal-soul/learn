package ImmortalSoul.io;

import java.io.*;

/**
 * Created by tansibin on 2018/3/23.
 *
 * 用缓冲流会加速文件处理
 *
 * BufferedInputStream  BufferedOutputStream
 *
 * BufferedReader  BufferedWrite
 */
public class TestBufferd {

    public static void main(String[] args) {
        File fileInput = new File("BufferedTest.txt");
        File fileOutput = new File("BufferedOutputStream.txt");
        File fileWrite = new File("BufferedWrite.txt");
        testStream(fileInput,fileOutput);
        testReaderWrite(fileInput,fileWrite);
    }

    public static void testStream(File fileInput , File fileOutput){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream(fileInput);
            fos = new FileOutputStream(fileOutput);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[bis.available()];
            bis.read(bytes);
            bos.write(bytes);
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //BufferedInputStream和BufferedOutputStream中会自动关闭FileInputStream和FileOutputStream流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void testReaderWrite(File fileInput , File fileWrite){

        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            fr = new FileReader(fileInput);
            fw = new FileWriter(fileWrite);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            String str;
            while ((str = br.readLine())!=null){
                bw.write(str);
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //BufferedReader和BufferedWriter中会自动关闭FileReader和FileWriter流
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
