package lee;

import java.util.stream.Stream;

public class LeeStreamEx {
    public static final Integer LEVEL_ONE = 24 * 60 * 60;

    double currentLevelUp = LEVEL_ONE;
    int level = 1;
    @Override
    public String toString() {
        return "LeeStreamEx{" +
                "currentLevelUp=" + currentLevelUp +
                ", level=" + level +
                '}';
    }

    Stream<Integer> nextTotal() {
        return Stream.iterate(86400, t -> {
            level = level + 1;
            return (int) (currentLevelUp = currentLevelUp * 1.3) + t;
        });
    }


    public static void main(String[] args) {
        LeeStreamEx leeStreamEx = new LeeStreamEx();
        leeStreamEx.nextTotal()
                .filter(total -> total > 198720)
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println("leeStreamEx = " + leeStreamEx);


        System.out.println(LEVEL_ONE);
        System.out.println(LEVEL_ONE + LEVEL_ONE * 1.3);
        System.out.println(LEVEL_ONE + LEVEL_ONE * 1.3 + LEVEL_ONE * 1.3 * 1.3);
    }

}
