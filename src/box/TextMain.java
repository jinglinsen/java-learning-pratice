package box;


public class TextMain {
    public static void main(String[] args) {
        ArrayBox<Integer> ab=new ArrayBox();
        long t1= System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            ab.add(i*3);
        }
        System.out.println(ab.getSize());
        for (int i = 0; i < ab.getSize(); i++) {
            System.out.print(ab.get(i)+",");
        }
        System.out.println("\t");
        System.out.println(ab.getSize());
        System.out.println("\t");
        System.out.println("-------");
        for (int i = 0; i < ab.getSize(); i++) {
            System.out.print(ab.get(i)+",");
        }
        System.out.println("\t");
        ArrayBox<String> st=new ArrayBox<>();
        st.add("李白乘舟将欲行,");
        st.add("忽闻岸上踏歌声.");
        System.out.println(st.get(0)+st.get(1));
        st.remove(0);
        for (int i = 0; i < st.getSize(); i++) {
            System.out.print(st.get(i));
        }
        ArrayBox<Object> cd = new ArrayBox<>();
        cd.add("411");
//        long t2=System.currentTimeMillis();
//        System.out.println(t2-t1);
    }
}
