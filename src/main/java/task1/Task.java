package task1;

import java.util.Locale;
import java.util.Scanner;

public class Task {

    private static final int CHAR_CODE_ALPHABET_BEGINNING = 97;
    private static final int CHAR_CODE_ALPHABET_ENDING = 122;

    /**
     * Case-insensitive function which Counts have many times letter occurs in string and return int array
     * with counts of every letter.
     * English alphabet expected
     * @param s the string to count letters in
     * @return Array with count of letters a-z in indexes 0-25
     */
    public static int[] countLetters(String s) {

        s = s.toLowerCase();
        int[] countLetters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(isSmallLetter(c)) {
                countLetters[c - 97]++;
            }
        }
        return countLetters;
    }

    public static boolean isSmallLetter(char c) {
        if (c >= CHAR_CODE_ALPHABET_BEGINNING && c <= CHAR_CODE_ALPHABET_ENDING) return true;
        else return false;
    }

    public static String createReport(int[] counts) {
        
        String report = "";
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                report += (char) (i + CHAR_CODE_ALPHABET_BEGINNING) + " = " + counts[i] + "\n";
            }

        }
        return report;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        System.out.println(createReport(countLetters(input)));

    }
}
