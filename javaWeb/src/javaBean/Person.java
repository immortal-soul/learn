package javaBean;

public class Person {

    //私有属性
    private String name;
    private int age;
    private String sex;

    //无参构造
    public Person(){}

    //javaBean类对外提供用于访问私有属性的public方法
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
