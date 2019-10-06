package piramida;

public class Piramida {
    public static void main(String[] args) {
        try {
            printArray(piramida(6));
        } catch (Exception ex) {
           System.err.print(ex.toString());
        }
    }

   private static void printArray(char[][] array) {

        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
   }
   private static char[][] piramida(int width) throws Exception  {
        if (width % 2 == 0) {
            throw new Exception("Argument musi być nie parzysty bo sie wyjebie");
        }

        int height = (width + 1) / 2;
        char[][] tab1 = new char[height][width];
        int x = 0;
        for(int i = height - 1; i >= 0; --i) {
            ++x;
            for(int j = height - i - 1; j < width - x + 1; ++j) {
                tab1[i][j] = 'x';
            }
        }
        return tab1;
   }
}











