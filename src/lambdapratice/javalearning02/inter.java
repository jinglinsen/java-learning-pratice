package lambdapratice.javalearning02;

public interface inter {
    void method();


    default void method2(){
        System.out.println("this is method2");
    }


    public static void text(){
        System.out.println("方法引用");
    }

}
