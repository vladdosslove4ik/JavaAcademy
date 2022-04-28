package task1;

import java.util.Locale;
import java.util.Scanner;

/**
 * JavaAcademy test task solution
 *
 * <b>Note there is a problem with task (word "MyApp" is also counted and in output should be letter "e = 1")</b>
 * <p>
 * Task:
 * <p>
 * Please create a simple program that consumes one string as an application argument.
 * Program should count the number of each letter in the string and present the results to the console.
 * <p>
 * Sample:
 * c:\java MyApp JavaAcademy
 * <p>
 * Output:
 * Counted letters:
 * m = 2
 * y = 2
 * a = 5
 * p = 2
 * j = 1
 * v = 1
 * c = 1
 * d = 1
 * <p>
 * So the argument is “JavaAcademy”.
 * Additionally, it would be nice if the results are sorted alphabetically.
 */
public class Task {

    private static final int CHAR_CODE_ALPHABET_BEGINNING = 97;
    private static final int CHAR_CODE_ALPHABET_ENDING = 122;

    /**
     * Case-insensitive function which Counts have many times letter occurs in string and return int array
     * with counts of every letter. <br>
     * <b>Note:</b> english alphabet is expected
     *
     * @param s the string to count letters in
     * @return Array with count of letters a-z in indexes 0-25
     */
    public static int[] countLetters(String s) {

        s = s.toLowerCase(Locale.ROOT);
        int[] countLetters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isSmallLetter(c)) {
                countLetters[c - 97]++;
            }
        }
        return countLetters;
    }

    /**
     * Checks if character is a small letter
     *
     * @param c char to check
     * @return {@code true} if char is a small letter
     */
    public static boolean isSmallLetter(char c) {
        if (c >= CHAR_CODE_ALPHABET_BEGINNING && c <= CHAR_CODE_ALPHABET_ENDING) return true;
        else return false;
    }

    /**
     * Create a report excluding all letters which not occur
     *
     * @param counts counted letters
     * @return ready to print report
     */
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

        System.out.println("Counted letters:");
        System.out.print(createReport(countLetters(input)));
    }
}
