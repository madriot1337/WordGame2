import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static String letter;
    static ArrayList<String> inputLetters = new ArrayList<>();
    private static String selectedWord;
    static ArrayList<String> letters = new ArrayList<>();
    static ArrayList<String> secWordList = new ArrayList<>();
    private static int tries = 0;

    public static void main(String[] args) throws IOException {
        while (true) {
            startGameProcess();
            restartGame();
        }

    }

    public static void startMenu() throws IOException {
        System.out.println("Приветствую в игре Висилица. " +
                "Напиши GO, чтобы начать, или EXIT для выхода из игры.");

        String answer = scanner.nextLine();


        if (answer.equalsIgnoreCase("EXIT")) {
            System.exit(0);
        } else if (answer.equalsIgnoreCase("GO")) {
            getMask(getWord());
        } else {
            while (!(answer.equalsIgnoreCase("EXIT") || answer.equalsIgnoreCase("GO"))) {
                System.out.println("Введите одно из значений GO/EXIT");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("EXIT")) {
                System.exit(0);
            } else if (answer.equalsIgnoreCase("GO")) {
                getMask(getWord());
            }
        }

    }

    public static void restartGame() throws IOException {
        System.out.println("Желаете начать новую игру? Напишите GO/EXIT");

        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("EXIT")) {
            System.exit(0);
        } else if (answer.equalsIgnoreCase("GO")) {

        } else {
            while (!(answer.equalsIgnoreCase("EXIT") || answer.equalsIgnoreCase("GO"))) {
                System.out.println("Введите одно из значений GO/EXIT");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("EXIT")) {
                System.exit(0);
            } else if (answer.equalsIgnoreCase("GO")) {

            }
        }
    }

    public static void startGameProcess() throws IOException {
            startMenu();
            while (secWordList.contains("*") && tries < 10) {
                getCorrectInput();
                checkContainsLetter();
        }
            clean();

    }

    // блок генерации и шифровки слова
    public static String getWord() throws IOException {
        String file = "Words.txt";
        ArrayList<String> wordsList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        String read;
        while ((read = br.readLine()) != null) {
            wordsList.add(read);
        }
        selectedWord = wordsList.get((int) (Math.random() * wordsList.size())).toLowerCase();
        return selectedWord;
    }

    public static void getMask(String word) {
        int wordSize = word.length();


        String secretWord = "";

        String[] array = word.split("");
        Collections.addAll(letters, array);

        for (int i = 0; i < wordSize; i++) {
            secretWord += "*";
        }
        String[] array1 = secretWord.split("");
        Collections.addAll(secWordList, array1);
        System.out.println("Загадано слово: " + secretWord);
    }


    //ввод буквы и проверка ввода на корректность
    public static void getCorrectInput() {
        do {
            System.out.print("Введите букву: ");
            letter = scanner.nextLine();
            char c = letter.charAt(0);

            boolean right = false;


            for (String have : inputLetters) {
                if (have.equals(letter)) {
                    right = true;
                }
            }

            if (letter.length() > 1) {
                System.out.println("Ввести можно только одну букву!");
            } else if (!Character.isLetter(c)) {
                System.out.println("Ввести можно только букву!");
            } else if (right) {
                System.out.println("Вы уже вводили букву " + letter.toUpperCase());
            } else {
                inputLetters.add(letter);
                return;
            }
        } while (true);

    }

    public static void checkContainsLetter() throws IOException {

        if (selectedWord.contains(letter.toLowerCase())) {
            System.out.println("Найдена верная буква: " + letter);
            for (int i = 0; i < letters.size(); i++) {
                int index;
                if (letters.get(i).equals(letter.toLowerCase())) {
                    index = i;
                    secWordList.set(index, letter.toLowerCase());
                }

                System.out.print(secWordList.get(i));
            }
            System.out.println();
            if (!(secWordList.contains("*"))) {
                System.out.println("\nТЫ ВЫИГРАЛ");
                System.out.println();
            }
        } else {
            tries++;
            print();
        }
    }

    public static void print() throws IOException {
        ArrayList<String> picture = new ArrayList<>();
        picture.add("-------");
        picture.add("_______");
        picture.add("|");
        picture.add("O");
        picture.add("/");
        picture.add("\\");

        switch (tries) {
            case 1:
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println(picture.get(0) + picture.get(0));
                countTries();
                break;
            case 2:
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(0) + picture.get(0));
                countTries();
                break;
            case 3:
                System.out.println(" " + picture.get(1));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(0) + picture.get(0));
                countTries();
                break;
            case 4:
                System.out.println(" " + picture.get(1));
                System.out.println(picture.get(2) + "      " + picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(0) + picture.get(0));
                countTries();
                break;
            case 5:
                System.out.println(" " + picture.get(1));
                System.out.println(picture.get(2) + "      " + picture.get(2));
                System.out.println(picture.get(2) + "      " + picture.get(3));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(0) + picture.get(0));
                countTries();
                break;
            case 6:
                System.out.println(" " + picture.get(1));
                System.out.println(picture.get(2) + "      " + picture.get(2));
                System.out.println(picture.get(2) + "      " + picture.get(3));
                System.out.println(picture.get(2) + "      " + picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(0) + picture.get(0));
                countTries();
                break;
            case 7:
                System.out.println(" " + picture.get(1));
                System.out.println(picture.get(2) + "      " + picture.get(2));
                System.out.println(picture.get(2) + "      " + picture.get(3));
                System.out.println(picture.get(2) + "     " + picture.get(4) + picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(0) + picture.get(0));
                countTries();
                break;
            case 8:
                System.out.println(" " + picture.get(1));
                System.out.println(picture.get(2) + "      " + picture.get(2));
                System.out.println(picture.get(2) + "      " + picture.get(3));
                System.out.println(picture.get(2) + "     " + picture.get(4) + picture.get(2) + picture.get(5));
                System.out.println(picture.get(2));
                System.out.println(picture.get(2));
                System.out.println(picture.get(0) + picture.get(0));
                countTries();
                break;
            case 9:
                System.out.println(" " + picture.get(1));
                System.out.println(picture.get(2) + "      " + picture.get(2));
                System.out.println(picture.get(2) + "      " + picture.get(3));
                System.out.println(picture.get(2) + "     " + picture.get(4) + picture.get(2) + picture.get(5));
                System.out.println(picture.get(2) + "     " + picture.get(4));
                System.out.println(picture.get(2));
                System.out.println(picture.get(0) + picture.get(0));
                countTries();
                break;
            case 10:
                System.out.println(" " + picture.get(1));
                System.out.println(picture.get(2) + "      " + picture.get(2));
                System.out.println(picture.get(2) + "      " + picture.get(3));
                System.out.println(picture.get(2) + "     " + picture.get(4) + picture.get(2) + picture.get(5));
                System.out.println(picture.get(2) + "     " + picture.get(4) + " " + picture.get(5));
                System.out.println(picture.get(2));
                System.out.println(picture.get(0) + picture.get(0));
                System.out.println("ТЫ ПРОИГРАЛ     СЛОВО: " + selectedWord);
        }

    }

    public static void countTries() {
        for (int i = 0; i < letters.size(); i++) {
            System.out.print(secWordList.get(i));
        }
        System.out.println("\nНеудачные попытки: " + tries);
    }

    public static void clean(){
        tries = 0;
        secWordList.removeAll(secWordList);
        inputLetters.removeAll(inputLetters);
        letters.removeAll(letters);


    }


}
