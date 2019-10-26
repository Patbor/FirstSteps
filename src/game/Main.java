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

            while (X > 2 || Y > 2 && gra[X][Y] != ' ') {
                System.out.println("Wpisz nowe współrzedne");
                N = numbers();
                X = N.X;
                Y = N.Y;
            }

            gra[X][Y] = "o".equals(choise) ? 'o' : 'x';
            ComPoint computer = comNumbers(x, y);
            int a = computer.a;
            int b = computer.b;
            while (gra[a][b] != ' ') {
                computer = comNumbers(x, y);
                a = computer.a;
                b = computer.b;
            }
            gra[a][b] = "o".equals(choise) ? 'x' : 'o';
            if (printGameResult(gra, x, y, 'x')) {
                printResult(choise, "o");
                if (end()) {
                    clearArray(gra, x, y);
                } else {
                    break;
                }
            }
            if (printGameResult(gra, x, y, 'x')) {
                printResult(choise, "x");
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

    private static void printResult(String sign, String noughtsOrCrosses) {
        System.out.println(noughtsOrCrosses.equals(sign) ? "Wygrałeś" : "Przegrałeś");
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


    private static boolean printGameResult(char[][] tablica, int SizeX, int SizeY, char noughtsOrCrosses) {

        int diagonal1 = 0;
        int diagonal2= 0;
        for (int i = 0; i < SizeX; ++i) {
            int row = 0;
            int column = 0;
            for (int j = 0; j < SizeY; ++j) {
                if (tablica[i][j] == noughtsOrCrosses) {
                    ++row;
                    if (row == 3) {
                        return true;
                    }

                }
                if (tablica[j][i] == noughtsOrCrosses) {
                    ++column;
                    if (column == 3) {
                        return true;
                    }

                }
                if (tablica[i][j] == noughtsOrCrosses && i == j) {
                    ++diagonal1;
                    if (diagonal1 == 3) {
                        return true;
                    }
                }
                if (tablica[i][j] == noughtsOrCrosses && i + j == 2) {
                    ++diagonal2;
                    if (diagonal2 == 3) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

}