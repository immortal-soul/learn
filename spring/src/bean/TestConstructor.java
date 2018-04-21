package bean;

public class TestConstructor {

    private HelloWorld helloWorld;
    private String name;

    public TestConstructor(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
//        this.name = name;
    }

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
