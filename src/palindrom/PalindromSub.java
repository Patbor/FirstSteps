package palindrom;
import java.util.*;
public class PalindromSub {
    public static void main(String[] args) {


        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj słowo: ");
            String word = scan.nextLine();

            StringBuilder reversedWord = new StringBuilder (word);

            reversedWord.reverse();

            System.out.println(word);
           if( word.equals(reversedWord.toString())){
                System.out.println("To jest Polindrom");
           } else {
               System.out.println("To nie jest Polindrom");
           }




        }
    }
}
