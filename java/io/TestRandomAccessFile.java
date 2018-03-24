package ImmortalSoul.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by tansibin on 2018/3/23.
 * RandomAccessFile(...,String mode)
 * 构造器中 mode的值代表的意思
 * r： 只读
 * rw： 可读可写
 * rwd： 可读可写，同步文件内容更新
 * rws： 可读可写，同步文件内容和元数据更新
 */
public class TestRandomAccessFile {

    public static void main(String[] args) {

        File file = new File("hello.txt");
        File file1 = new File("RandomAccessFile.txt");
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            raf = new RandomAccessFile(file,"r");
            raf1 = new RandomAccessFile(file1,"rw");
            byte[] bytes = new byte[50];
            int len;
            while ((len = raf.read(bytes))!=-1){
                raf1.write(bytes,0,len);
            }
            //执行的是覆盖，不是插入
//            raf1.seek(4);
//            raf1.write("java".getBytes());
            //执行插入
            raf1.seek(4);
            String str = raf1.readLine();
            raf1.seek(4);
            raf1.write("java".getBytes());
            raf1.write(str.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf !=null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
