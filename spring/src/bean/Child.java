package bean;


public class Child {

    private String name;
    private int age;
    private String sex;
    private String hobby;

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void printAll(){
        System.out.println("name : "+ name);
        System.out.println("age : "+ age);
        System.out.println("sex : "+ sex);
        System.out.println("hobby : "+ hobby);
    }
}
