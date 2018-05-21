package Lesson7;

public class Main {
    public static void main(String[] args) {
        parseString();
    }

    static void parseString(){
        String string = "Предложение     один  Теперь  два      А сейчас три";
        string = string.replaceAll(" +"," ");

        StringBuilder stringBuilder = new StringBuilder(string);

        for (int i = 1; i < stringBuilder.length() ; i++) {
            if (stringBuilder.charAt(i)>='A' && stringBuilder.charAt(i)<='Я'){
                stringBuilder.setCharAt(i-1,'.');
            }
        }

        for (int i = stringBuilder.length()-1; i > 0; i--) {
            if (stringBuilder.charAt(i) == '.'){
                stringBuilder.insert(i+1," ");
            }

        }
        stringBuilder.append('.');
        System.out.println(stringBuilder.toString());

    }
}
