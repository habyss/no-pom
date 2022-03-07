package lee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeeTest {
    public static void main(String[] args) {

        List<Info> infos = new ArrayList<>();

        Map<String, List<Info>> collect = infos.stream().collect(Collectors.groupingBy(Info::getName));
        System.out.println("collect = " + collect);
    }

    static class Info{
        private String name;

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        private String sex;
    }
}
