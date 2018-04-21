package bean;

public class TestDITwo {
    private HelloWorld helloWorld;
    private TestDIOne testDIOne;

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public TestDIOne getTestDIOne() {
        return testDIOne;
    }

    public void setTestDIOne(TestDIOne testDIOne) {
        this.testDIOne = testDIOne;
    }

    public void sayHello(){
        System.out.println("DITwo say : ");
        helloWorld.sayHello();
        testDIOne.sayHello();
    }
}
