package lambdapratice.javalearn;

import java.sql.SQLOutput;

public class LambdaDemo {
    public static void main(String[] args) {
//        实现类的方式实现
/*        Runnable my=new MyRunable();
        Thread t =new Thread(my);
        t.start();*/


//        匿名内部类实现
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程启动");
            }
        }).start();
*/


//        lambda表达式实现
        new Thread(() ->{
            System.out.println("多线程启动");
        }).start();
    }
}
