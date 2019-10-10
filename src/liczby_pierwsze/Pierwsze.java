package liczby_pierwsze;

import java.util.*;

public class Pierwsze {


    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj liczbe: ");
            int liczba = scan.nextInt();

            if (primeNumber(liczba)) {
                System.out.println("To jest liczba pierwsza");
            } else {
                System.out.println("To nie jest liczba pierwsza");
            }
        }
    }

    public static boolean primeNumber(int number) {
        for (int i = 2; i < number; ++i) {

            if ((number % i) == 0) {

                return false;
            }

        }

        return true;
    }

}
