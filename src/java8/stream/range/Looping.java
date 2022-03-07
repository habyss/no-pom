package java8.stream.range;// streams/Looping.java

import static java8.stream.range.Repeat.repeat;

public class Looping {
    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("Looping!"));
        repeat(2, Looping::hi);
    }
}