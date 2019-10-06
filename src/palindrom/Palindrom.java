package palindrom;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj słowo: ");
            String word = scan.nextLine();
            System.out.println("Sprawdzmy czy " + word + " jest  Palindromem.");
            System.out.println();
            if (isPalidnrom(word)) {
                System.out.println("Słowo " + word + " jest Palindromem!");
            } else {
                System.out.println("Słowo " + word + " nie jest Palindromem!");
            }
        }
    }

    public static boolean isPalidnrom(String word) {


        for (int i = 0; i < word.length() / 2; ++i) {
            if (!(word.charAt(i) == (word.charAt(word.length() - i - 1)))) {
                return false;
            }
        }
        return true;
    }
}


