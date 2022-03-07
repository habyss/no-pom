package java8.stream.split;// streams/FileToWordsRegexp.java

import java8.stream.file.FileConstant;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToWordsRegexp {
    private final String all;

    public FileToWordsRegexp(String filePath) throws Exception {
        all = Files.lines(Paths.get(filePath))
                .skip(1) // First (comment) line
                .collect(Collectors.joining(" "));
    }

    public Stream<String> stream() {
        return Pattern
                .compile("[ .,?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws Exception {
        FileToWordsRegexp fw = new FileToWordsRegexp(FileConstant.filePath);
        fw.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
        System.out.println();
        fw.stream()
                .skip(7)
                .limit(2)
                .map(w -> w + " ")
                .forEach(System.out::print);
        System.out.println();
    }
}