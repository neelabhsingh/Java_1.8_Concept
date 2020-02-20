package lambda.sort;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

class Person{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
public class LambdaInSortingUsingComparator {
    public static void main(String[] args) {
        Comparator<Person> perAgeCom = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> perFirstNameCom = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> perLastNameCom = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
        Function<Person, Integer> f1 = p -> p.getAge();
        Function<Person, String> f2 = p -> p.getFirstName();
        Function<Person, String> f3 = p -> p.getLastName();

    }
}
