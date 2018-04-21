package bean;

public class TestByType {
    private HelloWorld helloWorld;
    private String name;


    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public String getName() {
        return name;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printAll(){
        System.out.println(this.getClass().getName());
        System.out.println("name : " + name);
        helloWorld.sayHello();
    }
}
