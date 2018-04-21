package bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloWorld {
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void sayHello(){
        System.out.println(name);
    }

    public void init(){
        System.out.println("bean初始化");
    }

    public void destory(){
        System.out.println("bean销毁");
    }

}
