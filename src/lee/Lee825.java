package lee;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lee825 {
    public static int numFriendRequests(int[] ages) {
        if (ages.length == 1) {
            return 1;
        }
        int result = 0;
        for (int x : ages) {
            for (int y : ages) {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                boolean boo1 = y < 0.5 * x + 7 || y == 0.5 * x + 7;
                boolean boo2 = y > x;
                boolean boo3 = y > 100 && x < 100;
                System.out.println("boo1 = " + boo1);
                System.out.println("boo2 = " + boo2);
                System.out.println("boo3 = " + boo3);
                System.out.println("----------------------------------------------------");
                if (x < 15) {
                    result++;
                    break;
                } else if (!boo1 && !boo3 && !boo2) {
                    result++;
                }
            }
        }
        return result - ages.length;
    }

    public static void main(String[] args) throws Exception {
//        int[] ages = {16, 16};
//        System.out.println("param => {16,16} \nresult => " + numFriendRequests(ages));
//        int[] ages1 = {16, 17, 18};
//        System.out.println("param => {16, 17, 18} \nresult => " + numFriendRequests(ages1));
        int[] ages2 = {118, 14, 7, 63, 103};
//        System.out.println("param => {108,115,5,24,82} \nresult => " + numFriendRequests(ages2));
        List<Exception> exceptions = new ArrayList<>();
        Arrays.stream(ages2).forEach(e -> {
            try {
                test();
                System.out.println("1111111111111111 = ");
            } catch (Exception ex) {
                exceptions.add(ex);
            }
        });
        if (exceptions.size() != 0) {
            String msg = exceptions.stream().map(Exception::getMessage).collect(Collectors.joining(","));
            throw new Exception(msg);
        }


    }

    public static void test() throws RuntimeException {
        System.out.println("111 = " + 111);
        long epochMilli = Instant.now().toEpochMilli();
        System.out.println("epochMilli = " + epochMilli);
        if (epochMilli % 2 == 1) {
            throw new RuntimeException("test");
        }
    }
}

