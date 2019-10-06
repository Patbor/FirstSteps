package deszcz;

import java.io.IOException;
import java.util.*;

public class Deszcz {


    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        char[][] krople = new char[x][y];

        clearArray(krople, x, y);



        while (true) {

            printArray(krople, x, y);
            moveArray(krople, x, y);
            Random rand = new Random();
            int a = rand.nextInt(x);
            krople[0][a] = '*';
            try {
                Thread.sleep(300);
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            } catch (InterruptedException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    private static void clearArray(char[][] tablica, int rozmiarX, int rozmiarY) {
        for (int i = 0; i < rozmiarY; ++i) {
            for (int j = 0; j < rozmiarX; ++j) {
                {
                    tablica[i][j] = ' ';
                }
            }
        }
    }

    private static void printArray(char[][] tablica, int rozmiarX, int rozmiarY) {

        for (int i = 0; i < rozmiarY + 2; ++i) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < rozmiarY; ++i) {
            System.out.print("*");
            for (int j = 0; j < rozmiarX; ++j) {

                System.out.print(tablica[i][j]);
            }
            System.out.println("*");
        }
        for (int i = 0; i < rozmiarY + 2; ++i) {
            System.out.print("*");
        }
    }

    private static void moveArray(char[][] tablica, int rozmiarY, int rozmiarX) {


        Random rand = new Random();


        //char  drop = tablica[rozmiarY-1][rozmiarX-1];
        for (int i = 0; i < rozmiarX; ++i) {

            for (int j = rozmiarY - 1; j > 0; --j) {

                tablica[j][i] = tablica[j - 1][i];

            }
            tablica[0][i] = ' ';
        }
    }
}


