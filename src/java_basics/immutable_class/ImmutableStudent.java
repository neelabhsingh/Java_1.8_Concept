package java_basics.immutable_class;
class Age{
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

public final class ImmutableStudent {
    private final int id;
    private final String name;
    private final Age age;
    /*
    public ImmutableStudent(int id, String name, Age age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
     */
    public ImmutableStudent(int id, String name, Age age) {
        Age cloneAge = new Age();
        cloneAge.setYear(age.getDay());
        cloneAge.setYear(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.id = id;
        this.name = name;
        this.age = cloneAge;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public static void main(String[] args) {
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1992);
        ImmutableStudent student = new ImmutableStudent(1, "Alex", age);
        System.out.println("Alex age before modification = " + student.getAge().getYear());
        age.setYear(1993);
        System.out.println("Alex age year after modification " + student.getAge().getYear());
    }
}
