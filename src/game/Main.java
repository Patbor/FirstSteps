package game;

import java.util.*;

public class Main {
    private static class ComPoint {
        int a;
        int b;

        public ComPoint(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static class Point {
        int X;
        int Y;

        public Point(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }

    public static void main(String[] args) {
        int x = 3, y = 3;
        char[][] gra = new char[x][y];
        clearArray(gra, x, y);
        System.out.println("Wybierz 'o' albo 'x' :");
        Scanner scan = new Scanner(System.in);
        String choise = scan.nextLine();
        while (true) {

            System.out.println();
            printArray(gra, x, y);
            System.out.println();
            Point N = numbers();
            int X = N.X;
            int Y = N.Y;

            while (gra[X][Y] != ' ') {
                System.out.println("Wpisz nowe współrzedne");
                N = numbers();
                X = N.X;
                Y = N.Y;
            }
            if ("o".equals(choise)) {
                gra[X][Y] = 'o';
            } else {
                gra[X][Y] = 'x';
            }
            ComPoint computer = comNumbers(x, y);
            int a = computer.a;
            int b = computer.b;

            while (gra[a][b] != ' ') {
                computer = comNumbers(x, y);
                a = computer.a;
                b = computer.b;
            }
            if ("o".equals(choise)) {

                gra[a][b] = 'x';
            } else {
                gra[a][b] = 'o';
            }

            if (toWInX(gra, x, y)) {
                infX(choise);
                if (end()) {
                    clearArray(gra, x, y);
                } else {
                    break;
                }


            }
            if (toWInO(gra, x, y)) {
                infO(choise);
                if (end()) {
                    clearArray(gra, x, y);
                } else {
                    break;
                }
            }
        }
    }

    private static boolean end() {
        System.out.println("Chcesz zagrać jeszcze raz?");
        Scanner scan = new Scanner(System.in);
        String ans = scan.nextLine();
        if ("yes".equals(ans)) {
            return true;
        } else {
            return false;
        }
    }

    private static void infX(String sign) {
        if ("x".equals(sign)) {
            System.out.println("Wygrałeś");
        } else {
            System.out.println("Przegrałeś");
        }
    }

    private static void infO(String sign) {
        if ("o".equals(sign)) {
            System.out.println("Wygrałeś");
        } else {
            System.out.println("Przegrałeś");
        }
    }

    private static ComPoint comNumbers(int rozX, int rozY) {
        Random rand = new Random();
        int a = rand.nextInt(rozX);
        int b = rand.nextInt(rozY);
        ComPoint comNumers = new ComPoint(a, b);
        return comNumers;
    }

    private static Point numbers() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj współrzędna Wiersza tabeli: ");
        int X = scan.nextInt();
        System.out.println("Podaj współrzędna Kolumny tabeli: ");
        int Y = scan.nextInt();
        Point number = new Point(X, Y);
        return number;

    }

    private static void printArray(char tablica[][], int sizeX, int sizeY) {
        for (int i = 0; i < sizeY + 2; ++i) {
            System.out.print("*");
        }
        System.out.println("");
        for (int i = 0; i < sizeX; ++i) {
            System.out.print("|");
            for (int j = 0; j < sizeY; ++j) {
                System.out.print(tablica[i][j]);
            }
            System.out.println("|");
        }
        for (int i = 0; i < sizeX + 2; ++i) {
            System.out.print("*");
        }

    }

    private static void clearArray(char[][] tablica, int sizeX, int sizeY) {
        for (int i = 0; i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                tablica[i][j] = ' ';
            }
        }
    }

    private static boolean toWInX(char[][] tablica, int SizeX, int SizeY) {

        int resultU1 = 0;
        int resultU2 = 0;
        for (int i = 0; i < SizeX; ++i) {
            int resultW = 0;
            int resultK = 0;
            for (int j = 0; j < SizeY; ++j) {
                if (tablica[i][j] == 'x') {
                    ++resultW;
                    if (resultW == 3) {
                        return true;
                    }

                }
                if (tablica[j][i] == 'x') {
                    ++resultK;
                    if (resultK == 3) {
                        return true;
                    }

                }
                if (tablica[i][j] == 'x' && i == j) {
                    ++resultU1;
                    if (resultU1 == 3) {
                        return true;
                    }
                }
                if (tablica[i][j] == 'x' && i + j == 2) {
                    ++resultU2;
                    if (resultU2 == 3) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private static boolean toWInO(char[][] tablica, int SizeX, int SizeY) {

        int resultU1 = 0;
        int resultU2 = 0;
        for (int i = 0; i < SizeX; ++i) {
            int resultW = 0;
            int resultK = 0;
            for (int j = 0; j < SizeY; ++j) {
                if (tablica[i][j] == 'o') {
                    ++resultW;
                    if (resultW == 3) {
                        return true;
                    }

                }
                if (tablica[j][i] == 'o') {
                    ++resultK;
                    if (resultK == 3) {
                        return true;
                    }

                }
                if (tablica[i][j] == 'o' && i == j) {
                    ++resultU1;
                    if (resultU1 == 3) {
                        return true;
                    }
                }
                if (tablica[i][j] == 'o' && i + j == 2) {
                    ++resultU2;
                    if (resultU2 == 3) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

}