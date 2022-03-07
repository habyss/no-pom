package lee;

public class LeeEx {
    public static final Integer LEVEL_ONE = 24 * 60 * 60;

    public static void main(String[] args) {
        int total = 198720;
        int nextTotal = 0, nextLevel = 0;
        double currentLevelUp = LEVEL_ONE;
        while (nextTotal <= total) {
            if (nextLevel > 0) {
                currentLevelUp = currentLevelUp * 1.3;
            }
            nextTotal = (int) currentLevelUp + nextTotal;
            nextLevel++;
        }
        System.out.println("nextLevel = " + nextLevel);
        System.out.println("nextTotal = " + nextTotal);
        System.out.println("currentLevel = " + nextLevel);
        System.out.println("currentLevelUp = " + (int) currentLevelUp);
        System.out.println("currentEx = " + (int) (currentLevelUp - (nextTotal - total)));
        System.out.println("total = " + total);

    }


}
