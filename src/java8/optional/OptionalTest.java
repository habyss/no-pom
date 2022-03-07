package java8.optional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("test");
        OptionalConsumer.of(o).ifPresent(s -> System.out.println("isPresent " + s))
                .ifNotPresent(() -> System.out.println("! isPresent"));
    }
}
