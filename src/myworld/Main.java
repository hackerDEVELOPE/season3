package myworld;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(toJadenCase("hi hello pararaarararar tututuut fmfmf papapap papapa papap"));
    }
    static public String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) return null;
        StringBuilder sb = new StringBuilder(phrase);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' '){
                sb.setCharAt(i+1, Character.toUpperCase(sb.charAt(i+1)));
            }
        }
        return Arrays.stream(phrase.split(" "))
                .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
                .collect(Collectors.joining(" "));

    }

}
