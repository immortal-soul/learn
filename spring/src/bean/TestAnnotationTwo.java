package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class TestAnnotationTwo {

    private HelloWorld helloWorld;
    @Autowired(required = false)
    private String name;

    @Autowired
    public TestAnnotationTwo(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }

    public String getName(){
        return name;
    }

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
    }
}
