package lambdapratice.javalearning03;

public class text {

    public static void main(String[] args) {
//        匿名内部类
        useinter(new inter() {
            @Override
            public int convert(String s) {
                return  Integer.parseInt(s);
            }
        });
//        lambda表达式
        useinter(s -> Integer.parseInt(s));
//        方法引用
        useinter(Integer::parseInt);
    }


    public static void useinter(inter i){
        int f = i.convert("25");
        System.out.println(f);
    }

}
