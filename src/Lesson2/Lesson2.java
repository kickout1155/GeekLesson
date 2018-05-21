package Lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {

        changeArray();

        //---------------------

        fillArray();

        //---------------------

        enlargeArray();

        //---------------------


        diagonalArray();

        //---------------------

        minMax();

        //---------------------

        int[] array = {1, 2, 3, 6};
        boolean arrayBoolean = checkBalance(array);
        System.out.println(arrayBoolean);
        //---------------------
        int n = 12;
        replaceArray(array, n);

    }

    static void changeArray() {

        int[] array = new int[9];
        for (int i = 0; i < array.length; i++) {
            if ((int) Math.random() * 2 % 2 == 0) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }

        for (int j = 0; j < array.length; j++) {
            if (array[j] == 0) {
                array[j] = 1;
            } else {
                array[j] = 0;
            }
        }


    }

    static void fillArray() {

        int[] array = new int[8];

        for (int i = 0, j = 0; i < array.length; i++, j += 3) {
            array[i] = j;
        }

    }

    static void enlargeArray() {

        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    static void diagonalArray() {
        int range = 10;
        int[][] array = new int[range][range];

        //Заполняем одну диагональ
        for (int i = 0, j = 0; i < range; i++, j++) {
            array[i][j] = 1;
        }

        //Заполняем другую диагональ
        for (int i = 0, j = range - 1; i < range; i++, j--) {
            array[i][j] = 1;
        }
    }

    static void minMax() {

        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = (int) Math.random() * 100;
        }

        int min = array[0];
        int max = min;

        for (int j : array) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
        }
    }

    static boolean checkBalance(int[] array) {

        boolean result = false;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < array.length-1; i++) {
            sum1 += array[i];
            for (int j=i+1;j<array.length;j++){
                sum2 += array[j];
            }
             if (sum1 == sum2) {
                 result = true;
                 break;
             } else {
                sum2 = 0;
             }
        }
        return result;
    }

    static void replaceArray(int[] array, int n) {

        int first = array[0];
        int last;
        boolean aliquot;
        int index=0;


        if (n<0){
            n = array.length+n;
        }

        System.out.println(Arrays.toString(array));

        //Нет смысла рассматривать, т.к. элементы не сместятся
        if (n%array.length == 0) {
            return;
        }

        if (n > array.length) {
            int m = (int) n / array.length;
            n -= m * array.length;
        }


        if (array.length%n == 0){
            aliquot = true;
        } else {
            aliquot = false;
        }

        for (int i = 0; i <= array.length; i++) {
            if (index>=array.length){
                if (aliquot){
                    index =index - array.length +1;
                    array[index-1] = first;
                } else {
                    index = index - array.length;
                }
                if (i == array.length && aliquot){
                    break;
                }
                if ( i == array.length && !aliquot ){
                    array[index] = first;
                    break;
                }
            }

            last = array[index];
            array[index] = first;
            first = last;
            index+=n;

        }

        System.out.println(Arrays.toString(array));
    }
}
