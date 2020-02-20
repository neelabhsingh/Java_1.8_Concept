package lambda.demo1;

import java.util.Arrays;
import java.util.Comparator;

class Dog{
    String name;
    int height;
    int weight;

    public Dog(String n, int s, int w) {
        this.name = n;
        this.height = s;
        this.weight = w;
    }

    public String toString() {
        return getName() + ": size=" + getHeight() + " weight=" + getWeight()
                + " \n";
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
public class SortDogUsingLambda {
    public static void main(String[] args) {
        Dog d1 = new Dog("Max", 2, 51);
        Dog d2 = new Dog("Rocky", 1, 3);
        Dog d3 = new Dog("Bear", 3, 40);

        Dog[] dogArray = { d1, d2, d3 };
        Dog[] dogArray2 = { d1, d2, d3 };
        printDogs(dogArray);
        Arrays.sort(dogArray, new Comparator<Dog>() {
            @Override
            public int compare(Dog dog1, Dog dog2) {
                return dog1.getWeight() - dog2.getWeight();
            }
        });
        printDogs(dogArray);

        System.out.println("Sort Dogs in increasing order of heights using lambda expression");
        Arrays.sort(dogArray, (Dog dog1, Dog dog2) -> dog1.height - dog2.height);
        printDogs(dogArray);
    }

    public static void printDogs(Dog[] dogs) {
        System.out.println("--Dog List--");
        for (Dog d : dogs)
            System.out.print(d);
        System.out.println();
    }
}
