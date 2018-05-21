package Lesson1;

public class Lesson1 {

    public static void main(String[] args) {
        byte byte1 = 10;
        short short1 = 200;
        int int1 = 2;
        long long1 = 122121L;
        float float1 = 12.1f;
        double double1 = 12.6;
        boolean boolean1 = true;
        char char1 = 'A';

        //------------------------------------------

        int a = 10;
        int b = 15;
        int c = 2;
        int d = 1;

        int e = summa(a, b, c, d);

        //-------------------------------------------

        boolean bool = between(a, b);

        //------------------------------------------

        testPositive(a);

        //-----------------------------------------

        bool = testPositiveVer2(a);

        String name = "Радион";
        strPrintName(name);

        //-------------------------------------------

        int year = 2000;

        testYear(year);


    }

    static int summa(int a, int b, int c, int d) {

        int f = a * (b + (c / d));
        return f;
    }

    static boolean between(int a, int b) {
        boolean bw = false;
        int c = a + b;
        if (c >= 10 && c <= 20) {
            bw = false;
        }
        return bw;
    }

    static void testPositive(int a) {

        if (a < 0) {
            System.out.println("Число " + a + " отрицательное");
        } else {
            System.out.println("Число " + a + " положительное");
        }

    }

    static boolean testPositiveVer2(int a) {
        boolean b = false;

        if (a >= 0) {
            b = true;
        }
        return b;
    }

    static void strPrintName(String name) {
        System.out.println("Привет " + name);
    }

    static void testYear(int year) {

        int remainder = year % 4;

        if (remainder != 0) {
            System.out.println("Год " + year + " не является высокосным");
            return;
        }

        if (year % 100 == 0 && year % 400 != 0){
            System.out.println("Год " + year + " не является высокосным");
            return;
        }

        System.out.println("Год " + year + " является высокосным");

    }
}
