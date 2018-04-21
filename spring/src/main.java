import aop.Logger;
import bean.*;
import jdbc.User;
import jdbc.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

public class main {
    public static void main(String[] args) {
        ApplicationContext c =
                new ClassPathXmlApplicationContext("JdbcConfig.xml");
        User user = (User) c.getBean("user");
        UserDao userDao = (UserDao) c.getBean("userDao");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setReg_time(timestamp);
        user.setLogin_time(timestamp);
        userDao.regUser(user);

    }

    public static void test9(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("AOP.xml");

        HelloWorld helloWorld1 = (HelloWorld) context.getBean("helloWorld1");
        HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld2");
        helloWorld1.sayHello();
        helloWorld1.destory();
        helloWorld2.sayHello();
    }

    public static void test8(){
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("Configurable.xml");
        context.start();
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.sayHello();
        context.stop();
        context.refresh();
        context.stop();
        context.close();
    }

    public static void test7(AbstractApplicationContext context){
        TestAnnotation testAnnotation = (TestAnnotation) context.getBean("testAnnotation");
        testAnnotation.printAll();

        TestAnnotationTwo testAnnotationTwo = (TestAnnotationTwo) context.getBean("testAnnotationTwo");
        testAnnotationTwo.printAll();
    }

    public static void test6(AbstractApplicationContext context){
        TestByName testByName = (TestByName) context.getBean("testByName");
        testByName.printAll();

        TestByType testByType = (TestByType) context.getBean("testByType");
        testByType.printAll();

        TestConstructor testConstructor = (TestConstructor) context.getBean("testConstructor");
        testConstructor.printAll();
    }

    public static void test5(AbstractApplicationContext context){
        TestCollection c = (TestCollection) context.getBean("collection");
        c.printAll();
    }

    public static void test4(AbstractApplicationContext context){
        InternalBean internalBean = (InternalBean) context.getBean("internalBean");
        internalBean.sayHello();
    }

    public static void test3(AbstractApplicationContext context){
        TestDIOne one = (TestDIOne) context.getBean("one");
        one.sayHello();

        TestDITwo two = (TestDITwo) context.getBean("two");
        two.sayHello();
    }

    public static void test2(AbstractApplicationContext context){
        Child child = (Child) context.getBean("child");
        child.printAll();
    }

    public static void test1(AbstractApplicationContext context){
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.sayHello();
        context.close();
    }
}
