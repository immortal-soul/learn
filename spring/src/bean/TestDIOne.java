package bean;

public class TestDIOne {

    private HelloWorld helloWorld;

    public TestDIOne(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }

    public void sayHello(){
        System.out.println("DIone say : ");
        helloWorld.sayHello();
    }

}
