package lambdapratice.javalearning02;

public class text {
    public static void main(String[] args) {
inter i=new interiml();
//        i.method();
//        i.method2();

//        useintermothed(System.out::println);
        useintermothed(new inter() {
            @Override
            public void method() {
                System.out.println("1111111");
            }
        });
    }
    private static void useintermothed(inter i ){
        i.method();
        i.method2();
    }
}
