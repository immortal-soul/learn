package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class TestAnnotation {

    private HelloWorld helloWorld;
    private String name;
    @Autowired
    @Qualifier("children")
    private Child children;

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public String getName() {
        return name;
    }

    //Autowired中 required = false 表示此属性可以为空
    @Autowired(required = false)
    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public void printAll(){
        System.out.println(this.getClass().getName());
        System.out.println("name : " + name);
        if (helloWorld!=null)
            helloWorld.sayHello();
        else
            System.out.println("helloWorld = null");
        children.printAll();
    }
}
