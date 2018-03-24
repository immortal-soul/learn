package ImmortalSoul.io;


import sun.nio.cs.ext.GBK;

import java.io.*;

/**
 * Created by tansibin on 2018/3/23.
 * 数据流  读数据顺序必须和存储数据顺序相同
 */
public class TestDataStream {

    public static void main(String[] args) {
        File file = new File("DataStream.txt");
        DataOutputStream dos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            dos = new DataOutputStream(fos);
            dos.writeUTF("你好世界");
            dos.writeBoolean(false);
            dos.writeInt(520);
            dos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dos!= null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        DataInputStream dis = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dis!=null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
