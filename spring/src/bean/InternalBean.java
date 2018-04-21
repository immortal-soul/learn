package bean;

public class InternalBean {
    private HelloWorld helloWorld;

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void sayHello(){
        System.out.println("Internal say : ");
        helloWorld.sayHello();
    }
}
