package aop;

public class TimeHandle {

    /**
     * This is the method which i would like to execute before a selected method execution
     *
     * 这是我想在被选定的方法执行之前执行的方法
     */
    public void beforeAdvice(){
        System.out.println(this.getClass().getName()+".beforeAdvice");
    }

    /**
     * This is the method which i would like to execute after a selected method execution
     *
     * 这是我想在选定方法执行之后执行的方法
     */
    public void afterAdvice(){
        System.out.println(this.getClass().getName()+".afterAdvice");
    }

    /**
     * This is a the method which i would like to execute when any method returns
     *
     * 这是我想在任何方法返回时执行的方法
     */
    public void afterReturningAdvice(){
        System.out.println(this.getClass().getName()+".afterReturningAdvice");
    }

    /**
     * This is a method which i would like to execute
     * if there is a exception raised
     *
     * 如果出现异常，我想执行的方法
     */
    public void afterThrowingAdvice(){
        System.out.println(this.getClass().getName()+".afterThrowingAdvice");
    }
}
