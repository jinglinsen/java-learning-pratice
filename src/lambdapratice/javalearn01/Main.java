package lambdapratice.javalearn01;

public class Main {
    public static void main(String[] args) {
        useflyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("人生得意须尽欢，莫使金樽空对月");
            }
        });
        System.out.println("------------------");
        useflyable((String s) ->{
            System.out.println(s);
            System.out.println("何须如此");
        });
    }
    public static void useflyable(Flyable f){
        f.fly("大吉大利，今晚吃鸡");
    }
}
