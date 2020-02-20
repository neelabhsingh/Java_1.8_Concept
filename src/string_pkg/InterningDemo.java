package string_pkg;

public class InterningDemo {
    public static void main(String[] args) {
        String str1 = new String("ABC");
        String str12 = str1.intern();
        String str2 = new String("ABC");
        String str22 = str2.intern();
        System.out.println(str1 == str2);
        System.out.println(str12 == str22);
    }
}
