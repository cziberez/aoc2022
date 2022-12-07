package aoc2022;

import java.util.ArrayList;
import java.util.List;

public class Nap01 {
    public static void main(String[] args) {
        List<Integer> elfek = elfekFeldolgozasa(STRING_INPUT);
        System.out.println(elfek.get(0));
        System.out.println(top3ElfSumma(elfek));
    }

    private static int top3ElfSumma(List<Integer> elfek) {
        return elfek.stream().limit(3).mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> elfekFeldolgozasa(String stringInput) {
        int[] jelenlegi = new int[]{0};
        String[] split = stringInput.split("\n");
        List<Integer> elfek = new ArrayList<>(split.length);
        for (String sor : split) {
            if (sor.isBlank()) {
                elfek.add(jelenlegi[0]);
                jelenlegi[0] = 0;
            } else {
                jelenlegi[0] = Integer.parseInt(sor);
            }
        }
        elfek.add(jelenlegi[0]);
        elfek.sort((a, b) -> b - a);
        return elfek;
    }

    private static final String STRING_INPUT = "1000\n" +
            "2000\n" +
            "3000\n" +
            "\n" +
            "4000\n" +
            "\n" +
            "5000\n" +
            "6000\n" +
            "\n" +
            "7000\n" +
            "8000\n" +
            "9000\n" +
            "\n" +
            "10000";
}