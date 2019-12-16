package snake;


import point.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

import static direct.Direct.*;

public class Snake {
    public static void main(String[] args) {
        int row = 10;
        int column = 10;
        char[][] map = new char[row][column];
        Point p1 = new Point(row / 2, 0);
        Point p2 = new Point(row / 2, 1);
        Point p3 = new Point(row / 2, 2);
        Point p4 = new Point(row / 2, 3);
        Point p5 = new Point(row / 2, 4);
        Point p6 = new Point(row / 2, 5);
        Point p7 = new Point(row / 2, 6);
        Point p8 = new Point(row / 2, 7);
        List<Point> snake = new ArrayList<>();
        snake.add(p1);
        snake.add(p2);
        snake.add(p3);
        snake.add(p4);
        snake.add(p5);
        snake.add(p6);
        snake.add(p7);
        snake.add(p8);
        clearArray(map, row, column);
        for (Point pointXY : snake) {
            System.out.print(map[pointXY.getX()][pointXY.getY()] = '*');
        }
        System.out.println();

        printApple(map, row, column);
        while (true) {

            Point headOfSnake = snake.get(snake.size() - 1);
            System.out.println(headOfSnake.getX());
            System.out.println(headOfSnake.getY());
            printMap(map, row, column);
            System.out.println();
            System.out.println("Podaj kierunek: ");
            Scanner scan = new Scanner(System.in);
            String moves = scan.nextLine();
            if (conditionsOfGame(snake, moves, row, column) || movesOfSnake(snake, map, moves, row, column)) {
                break;
            }
            detectSign(snake, moves, map, 'x', row, column);

        }
        System.out.println("Przegrałeś");
    }

    public static void printApple(char[][] array, int row, int column) {
        Random rand = new Random();
        int x = rand.nextInt(row);
        int y = rand.nextInt(column);
        if (array[x][y] != ' ') {

            x = rand.nextInt(row);
            y = rand.nextInt(column);
        } else {
            array[x][y] = 'x';
        }

    }

    public static boolean detectSign(List<Point> list, String word, char[][] array, char appleOrBody, int row, int column) {
        Point headOfSnake = list.get(list.size() - 1);

        if (headOfSnake.getX() >= 1 && headOfSnake.getX() <= row - 2 && headOfSnake.getY() >= 1 && headOfSnake.getY() <= column - 2) {
            return array[headOfSnake.getX() - 1][headOfSnake.getY()] == appleOrBody && word.equals(UP.name()) ||
                    array[headOfSnake.getX() + 1][headOfSnake.getY()] == appleOrBody && word.equals(DOWN.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() - 1] == appleOrBody && word.equals(LEFT.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() + 1] == appleOrBody && word.equals(RIGHT.name());
        }
        if(headOfSnake.getX() == 0 && headOfSnake.getY() == 0 && !word.equals(UP.name()) && !word.equals(LEFT.name())){
            return array[headOfSnake.getX() + 1][headOfSnake.getY()] == appleOrBody && word.equals(DOWN.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() + 1] == appleOrBody && word.equals(RIGHT.name());
        }
        if(headOfSnake.getX() == 0 && headOfSnake.getY() == column - 1 && !word.equals(UP.name()) && !word.equals(RIGHT.name())) {
            return array[headOfSnake.getX() + 1][headOfSnake.getY()] == appleOrBody && word.equals(DOWN.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() - 1] == appleOrBody && word.equals(LEFT.name());
        }
        if(headOfSnake.getX() == row - 1 && headOfSnake.getY() == 0 && !word.equals(DOWN.name()) && !word.equals(LEFT.name())) {
            return array[headOfSnake.getX() - 1][headOfSnake.getY()] == appleOrBody && word.equals(UP.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() + 1] == appleOrBody && word.equals(RIGHT.name());
        }
        if(headOfSnake.getX() == row - 1 && headOfSnake.getY() == column - 1 && !word.equals(DOWN.name()) && !word.equals(RIGHT.name())) {
            return array[headOfSnake.getX() - 1][headOfSnake.getY()] == appleOrBody && word.equals(UP.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() - 1] == appleOrBody && word.equals(LEFT.name());
        }
        if (headOfSnake.getX() == 0 && !(headOfSnake.getY() == 0) && !(headOfSnake.getY() == column - 1) && !word.equals(UP.name()) )   {
            return array[headOfSnake.getX() + 1][headOfSnake.getY()] == appleOrBody && word.equals(DOWN.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() - 1] == appleOrBody && word.equals(LEFT.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() + 1] == appleOrBody && word.equals(RIGHT.name());
        }
        if (headOfSnake.getX() == row - 1 && !(headOfSnake.getY() == 0) && !(headOfSnake.getY() == column - 1) &&!word.equals(DOWN.name())) {
            return array[headOfSnake.getX() - 1][headOfSnake.getY()] == appleOrBody && word.equals(UP.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() - 1] == appleOrBody && word.equals(LEFT.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() + 1] == appleOrBody && word.equals(RIGHT.name());
        }
        if(headOfSnake.getY() == 0 && !(headOfSnake.getX() == row - 1) && !(headOfSnake.getX() == 0) && !word.equals(LEFT.name())){
            return array[headOfSnake.getX() - 1][headOfSnake.getY()] == appleOrBody && word.equals(UP.name()) ||
                    array[headOfSnake.getX() + 1][headOfSnake.getY()] == appleOrBody && word.equals(DOWN.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() + 1] == appleOrBody && word.equals(RIGHT.name());
        }
        if(headOfSnake.getY() == column - 1 && !(headOfSnake.getX() == 0) && !(headOfSnake.getX() == row - 1) && !word.equals(RIGHT.name())){
            return array[headOfSnake.getX() - 1][headOfSnake.getY()] == appleOrBody && word.equals(UP.name()) ||
                    array[headOfSnake.getX() + 1][headOfSnake.getY()] == appleOrBody && word.equals(DOWN.name()) ||
                    array[headOfSnake.getX()][headOfSnake.getY() - 1] == appleOrBody && word.equals(LEFT.name());
        }

        return false;
    }

    public static boolean snakeAteItself(List<Point> list, String word, char[][] array, int row, int column) {
        Point headOfSnake = list.get(list.size() - 1);

        if ((headOfSnake.getX() <= (list.get(list.size() - 2)).getX()) && word.equals(DOWN.name()) ||
                (headOfSnake.getX() >= (list.get(list.size() - 2)).getX()) && word.equals(UP.name()) ||
                (headOfSnake.getY() <= (list.get(list.size() - 2)).getY()) && word.equals(RIGHT.name()) ||
                (headOfSnake.getY() >= (list.get(list.size() - 2)).getY()) && word.equals(LEFT.name())) {
            return false;
        }
        return detectSign(list, word, array, '*', row, column);
    }

    public static boolean conditionsOfGame(List<Point> list, String word, int row, int column) {
        Point headOfSnake = list.get(list.size() - 1);


        return headOfSnake.getX() == 0 && word.equals(UP.name()) ||
                headOfSnake.getX() == row - 1 && word.equals(DOWN.name()) ||
                headOfSnake.getY() == 0 && word.equals(LEFT.name()) ||
                headOfSnake.getY() == column - 1 && word.equals(RIGHT.name());
    }

    public static boolean movesOfSnake(List<Point> list, char array[][], String word, int row, int column) {
        Point headOfSnake = list.get(list.size() - 1);
        Point tail = list.get(0);

        if (!detectSign(list, word, array, 'x', row, column) &&
                ((headOfSnake.getX() <= (list.get(list.size() - 2)).getX()) && word.equals(UP.name()) ||
                        (headOfSnake.getX() >= (list.get(list.size() - 2)).getX()) && word.equals(DOWN.name()) ||
                        (headOfSnake.getY() <= (list.get(list.size() - 2)).getY()) && word.equals(LEFT.name()) ||
                        (headOfSnake.getY() >= (list.get(list.size() - 2)).getY()) && word.equals(RIGHT.name()))) {
            list.remove(0);
            array[tail.getX()][tail.getY()] = ' ';
        }
        if (detectSign(list, word, array, 'x', row, column)) {
            printApple(array, row, column);
        }
        if (snakeAteItself(list, word, array, row, column)) {
            return true;
        }
        if ((headOfSnake.getX() <= (list.get(list.size() - 2)).getX()) && word.equals(UP.name())) {
            list.add(new Point(headOfSnake.getX() - 1, headOfSnake.getY()));
            array[headOfSnake.getX() - 1][headOfSnake.getY()] = '*';
        }
        if ((headOfSnake.getX() >= (list.get(list.size() - 2)).getX()) && word.equals(DOWN.name())) {
            list.add(new Point(headOfSnake.getX() + 1, headOfSnake.getY()));
            array[headOfSnake.getX() + 1][headOfSnake.getY()] = '*';
        }
        if ((headOfSnake.getY() <= (list.get(list.size() - 2)).getY()) && word.equals(LEFT.name())) {
            list.add(new Point(headOfSnake.getX(), headOfSnake.getY() - 1));
            array[headOfSnake.getX()][headOfSnake.getY() - 1] = '*';
        }

        if ((headOfSnake.getY() >= (list.get(list.size() - 2)).getY()) && word.equals(RIGHT.name())) {
            list.add(new Point(headOfSnake.getX(), headOfSnake.getY() + 1));
            array[headOfSnake.getX()][headOfSnake.getY() + 1] = '*';
        }
        word = " ";
        return false;
    }

    public static void clearArray(char[][] array, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = ' ';
            }
        }
    }

    public static void printMap(char[][] array, int row, int column) {
        {
            for (int i = 0; i < column + 2; ++i) {
                System.out.print("*");
            }
            System.out.println("");
            for (int i = 0; i < row; ++i) {
                System.out.print("*");
                for (int j = 0; j < column; ++j) {
                    System.out.print(array[i][j]);
                }
                System.out.println("*");
            }
            for (int i = 0; i < row + 2; ++i) {
                System.out.print("*");
            }
        }
    }
}
