package Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int[][] sneak = new int[10][3];
    static boolean right = true;
    static boolean left, down, top = false;
    static int rows = sneak.length;
    static int columns = sneak[0].length;


    public static void main(String[] args) {

        sneakArray();

        guessNumber();

        guessWord();

    }

    public static void sneakArray() {


        for (int i = 1, indexRows = 0, indexColumns = 0, rightCol = 0, leftCol = -1, topRow = -1, downRow = 0; i <= rows * columns; i++) {
            if (right) {
                if (indexColumns == columns - rightCol) {
                    right = false;
                    down = true;
                    topRow++;
                    indexColumns--;
                    i -= 2;
                } else {
                    indexColumns = goRight(i, indexRows, indexColumns);
                }
                continue;
            }

            if (left) {
                if (indexColumns == leftCol) {
                    left = false;
                    top = true;
                    indexColumns++;
                    i -= 2;
                    downRow++;
                } else {
                    indexColumns = goLeft(i, indexRows, indexColumns);
                }
                continue;
            }

            if (top) {
                if (indexRows == topRow) {
                    top = false;
                    right = true;
                    leftCol++;
                    indexRows++;
                    i -= 2;
                } else {
                    indexRows = goTop(i, indexRows, indexColumns);
                }
                continue;
            }
            if (down) {
                if (indexRows == rows - downRow) {
                    down = false;
                    left = true;
                    rightCol++;
                    indexRows--;
                    i -= 2;
                } else {
                    indexRows = goDown(i, indexRows, indexColumns);
                }
                continue;
            }
        }

//      Для проверки змейки
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                System.out.print(sneak[i][j]+"              ");
//            }
//            System.out.println();
//        }
    }

    public static int goRight(int i, int indexRows, int indexColumns) {
        sneak[indexRows][indexColumns] = i;
        indexColumns++;
        return indexColumns;

    }

    public static int goLeft(int i, int indexRows, int indexColumns) {
        sneak[indexRows][indexColumns] = i;
        indexColumns--;
        return indexColumns;
    }

    public static int goTop(int i, int indexRows, int indexColumns) {
        sneak[indexRows][indexColumns] = i;
        indexRows--;
        return indexRows;
    }

    public static int goDown(int i, int indexRows, int indexColumns) {
        sneak[indexRows][indexColumns] = i;
        indexRows++;
        return indexRows;
    }

    public static void guessNumber() {

        int attempt = 0;
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(11);
        System.out.println("Угадайте число от 0 до 10");
        Scanner sc = new Scanner(System.in);
        while (true) {

            if (attempt == 3){
                System.out.println("Вы не угадали загаданное число, загаданное число - "+number);
                break;
            }

            System.out.println("Введите число, осталось "+(3-attempt)+" попытки(а)");
            int enterNumber = sc.nextInt();

            if (enterNumber == number) {
                System.out.println("Поздравляем вы угадали загаданное число " + "'" + number + "'");
                break;
            }

            if (enterNumber>number){
                System.out.println("Загаданное число меньше введенного");
            } else {
                System.out.println("Загаданное число больше введенного");
            }

            attempt++;

        }

    }

    public static void guessWord(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner sc = new Scanner(System.in);
        Random randomNumber = new Random();
        String word = words[randomNumber.nextInt(words.length)];
        System.out.println(word);
        String resultWord = "###############";
        String enterWord = "";
        while (true){
            enterWord = sc.next();
            int lenght = (enterWord.length() > word.length() ? word.length():enterWord.length());
            for (int i = 0; i < lenght; i++) {
                if (enterWord.charAt(i) == word.charAt(i)){
                    resultWord = substituteChar(i,resultWord,enterWord.charAt(i));
                }
            }
            if (chekResult(word,resultWord)){
                System.out.println("Поздравляем вы угадали слово - "+word);
                break;
            }
            System.out.println(resultWord);
        }
    }

    public static String substituteChar(int number, String resultWord,char...symbol){
        String symbolWord = "";
        String[] arr = resultWord.split("");
        symbolWord = symbolWord.copyValueOf(symbol);
        arr[number]= symbolWord;
        resultWord ="";
        for (int i = 0; i < arr.length ; i++) {
            resultWord+=arr[i];
        }
        return resultWord;
    }

    public static boolean chekResult(String word,String resultWord){
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)!=resultWord.charAt(i)){
                result = false;
                break;
            }
        }
        return result;
    }

}


