package ImmortalSoul.io;

import java.io.*;

/**
 * Created by tansibin on 2018/3/23.
 * 对象流 读取数据不能多余存储的数据
 * 对象需要提供一个版本号，不然可能在硬盘中会找不到
 * private static final Long serialVersionUID
 * 对象流不能序列化 static 和 transient  ，也就是说用这两个修饰的参数不能保存
 */
public class TestObjectStream {

    public static void main(String[] args) {
        File file = new File("ObjectStream.txt");

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            Person man = new Person("小明",20);
            Person woman = new Person("小红",18);
            oos.writeObject(man);
            oos.flush();
            oos.writeObject(woman);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            System.out.println(ois.readObject().toString());
            System.out.println(ois.readObject().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

/**
 * 类必须可序列化才可以被对象流使用
 * 必须实现以下两个接口之一
 * Serailizable（常用）
 * Externalizable
 *
 * 对象需要提供一个版本号，不然可能在硬盘中会找不到
 * private static final Long serialVersionUID
 */
class Person implements Serializable {

    private static final Long serialVersionUID = 312321321L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
