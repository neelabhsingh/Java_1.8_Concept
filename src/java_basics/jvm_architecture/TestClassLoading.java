package java_basics.jvm_architecture;

import java.lang.reflect.Method;

class Student{
    private String name;
    private String rollNumber;

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}
public class TestClassLoading {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("java_basics.jvm_architecture.Student");
            Method [] methods = c.getMethods();
            for(Method method : methods){
                System.out.println(method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Student s1 = new Student("Neelabh", "123");
        Student s2 = new Student("Neelabh", "123");
        Class c1 = s1.getClass();
        Class c2 = s2.getClass();
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1 == c2);
    }
}
