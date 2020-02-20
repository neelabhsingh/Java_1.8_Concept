package enum_demo;

public enum Color {
    RED, GREEN, BLUE;

    public static void main(String[] args) {
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}
/*
We can declare main() method inside enum. Hence we can invoke enum directly from the Command Prompt.
* */