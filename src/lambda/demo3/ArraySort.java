package lambda.demo3;

import java.util.Arrays;
import java.util.stream.Stream;

class Dog{
    String name;
    int height;
    int weight;

    public Dog(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
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
    public String toString() {
        return getName() + ": size=" + getHeight() + " weight=" + getWeight()
                + " \n";
    }
}
public class ArraySort {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Max", 2, 50);
        Dog dog2 = new Dog("Rocky", 1, 30);
        Dog dog3 = new Dog("Bear", 3, 40);
        Dog [] dogs = {dog1, dog2, dog3};
        Arrays.sort(dogs, (Dog d1, Dog d2) -> d1.getWeight() - d2.getWeight());
        printDogs(dogs);

        //Use stream to sort dog by height.
        Stream<Dog> dogStream = Stream.of(dogs);
        Stream<Dog> sortedDogStream = dogStream.sorted((Dog m, Dog n) -> Integer.compare(m.getHeight(), n.getHeight()));
        System.out.println("After sorting by height of each dog.");
        sortedDogStream.forEach( d -> {
            System.out.print(d);
        });
    }
    public static void printDogs(Dog[] dogs) {
        System.out.println("--Dog List--");
        for (Dog d : dogs)
            System.out.print(d);
        System.out.println();
    }
}
