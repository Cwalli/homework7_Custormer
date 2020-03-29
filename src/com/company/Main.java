package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Customer[] customers;
    private static Map<String, String> vocabulary = new HashMap<String, String>();



    public static void main(String[] args) {
        // write your code here

        init();
        createList();
        createSet();
        createMap();
        outMap();
        MenuFace();
        for (int i = 0 ; i != 4; ) {
//            Scanner in = new Scanner(System.in);
//            if (i == 0)
//            if (in.hasNextInt())
//            {
//            int answer = in.nextInt();
            int answer = getInt();
            i = answer;
//                if (in.hasNextInt()) {answer =0; continue ;}
            if (answer < 5 & answer > 0) {

                switch (answer) {
                    case (1):
                        OutWordValue();
                        MenuFace();
                        break;
                    case (2):
                        AddNewWordValue();
                        MenuFace();
                        break;
                    case (3):
                        AddNewWord();
                        MenuFace();
                        break;
                    case (4):
                        System.out.println("Выполняется выход из программы!!!");
                        break;
                }
            } else System.out.println("Введено некорректное значение!! Повторите попытку");
            }
//            else {System.out.println("Введено некорректное значение!! Повторите ввод");}
        }

//    }
    public static int getInt()
    {
        Scanner in = new Scanner(System.in);
        String s = null;
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = null;

        do
        {
            System.out.println("Введите номер необходимого действия:");
            s = in.nextLine();
            m = p.matcher(s);
        } while(!m.matches());

        return Integer.parseInt(s);
    }
    public static void init() {
        customers = new Customer[4];
        customers[0] = new Customer("Иван", "Иванов", "+777374274277");
        customers[1] = new Customer("Петр", "Петров", "+7773745343534");
        customers[2] = new Customer("Поп", "Попов", "+7773555555555");
        customers[3] = new Customer("Поп", "Попов", "+7773555555555");

    }

    public static void createList() {
        // Создание коллекции типа List и вывод ее в консоль
        ArrayList<Customer> customersList = new ArrayList<>();
        customersList.addAll(Arrays.asList(customers));
        System.out.println("-------------------------------------------------");
        System.out.println("Создание коллекции типа List и вывод ее в консоль");
        for (Customer custom : customersList) {
            System.out.println(custom);
        }
    }

    public static void createSet() {
        // Создание коллекции типа Set и вывод ее в консоль
        HashSet<Customer> customersSet = new HashSet<>();
        customersSet.addAll(Arrays.asList(customers));
        System.out.println("-------------------------------------------------");
        System.out.println("Создание коллекции типа Set и вывод ее в консоль");

        for (Customer item : customersSet) {
            System.out.println(item);
        }
    }

    public static void createMap() {
        // Создание коллекции типа Map и вывод ее в консоль
        //       Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("Абажур", "Колпак для лампы, светильника.");
        vocabulary.put("Аббат", "Настоятель мужского католического монастыря.");
        vocabulary.put("Абзац", "Красная строка, отступ в начале строки.");
        vocabulary.put("Абонемент", "Документ, предоставляющий право на пользование чем-н., какое-н. обслуживание, а также само такое право.");

    }
    public static void outMap () {
        System.out.println("-------------------------------------------------");
        System.out.println("Вывод в консоль коллекции типа Map ");
        System.out.println("-------------------------------------------------");
        System.out.println("Толковый словарь НЕдаля");
        System.out.println("-------------------------------------------------");
        for (Map.Entry<String, String> item : vocabulary.entrySet()) {
            System.out.printf("%s - %s \n", item.getKey(), item.getValue());
        }
    }


    public static void MenuFace() {
        System.out.println("-------------------------------------------------");
        System.out.println( "1 - Вывод значения по введенному слову"
                + "\n" + "2 - Редактирование существующего значения слова" + "\n" + "3 - Добавление нового слова"
                + "\n" + "4 - Выход из программы");
    }

    public static void OutWordValue() {
        String ansver1 = inputString("Введите слово, значение которого хотите узнать...");
        ansver1 = ansver1.substring(0, 1).toUpperCase() + ansver1.substring(1).toLowerCase();
        if (vocabulary.containsKey(ansver1))
            System.out.println(ansver1 + " - " + vocabulary.get(ansver1));
        else System.out.println("Введенного слова нет в словаре...");
    }

    public static String inputString(String message) {
        String string;
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        do  {
                string = scanner.nextLine();
                if (string.length() == 0) {System.out.println("Введена пустая строка, повторите ввод!!");
                continue;}
        }
        while (string.length() == 0);
//        if (scanner.nextLine().equals("")) {
////            System.out.println("!!!!!!Введена пустая строка!!!! Изменение значения слова не произошло.");
////            }
        return string;

    }

    public static void AddNewWordValue() {
        String ansver2 = inputString("Введите слово, значение которого хотите отредактировать...");
        ansver2 = ansver2.substring(0, 1).toUpperCase() + ansver2.substring(1).toLowerCase();
        if (vocabulary.containsKey(ansver2)) {
            String ansver3 = inputString("Введите новое значение слова...");
            ansver3 = ansver3.substring(0, 1).toUpperCase() + ansver3.substring(1).toLowerCase();
            vocabulary.put(ansver2, ansver3);
//            if (ansver3.length()!=0) vocabulary.put(ansver2, ansver3);
//            else System.out.println("!!!!!!Введена пустая строка!!!! Изменение значения слова не произошло.");
        } else System.out.println("Введенного слова нет в словаре.");
    }

    public static void AddNewWord() {
        String ansver4 = inputString("Введите новое слово...");
        String ansver5 = inputString("Введите значение нового  слова...");
        ansver4 = ansver4.substring(0, 1).toUpperCase() + ansver4.substring(1).toLowerCase();
        ansver5 = ansver5.substring(0, 1).toUpperCase() + ansver5.substring(1).toLowerCase();
//      if (!ansver4.isEmpty() & !ansver5.isEmpty()) {
            vocabulary.putIfAbsent(ansver4, ansver5);
//        }else System.out.println("!!!!!Введены некорректные данные!!!!!");
    }

}
