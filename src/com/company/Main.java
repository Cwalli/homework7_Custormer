package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Customer Customer1 = new Customer("Иван","Иванов","+777374274277");
        Customer Customer2 = new Customer("Петр","Петров","+7773745343534");
        Customer Customer3 = new Customer("Поп","Попов","+7773555555555");
        Customer Customer4 = new Customer("Поп","Попов","+7773555555555");

        // Создание коллекции типа List и вывод ее в консоль
        ArrayList<String> customers = new ArrayList<String>();
        customers.add(Customer1.toString());
        customers.add(Customer2.toString());
        customers.add(Customer3.toString());
        customers.add(Customer4.toString());
        System.out.println("-------------------------------------------------");
        System.out.println("Создание коллекции типа List и вывод ее в консоль");
        for (String custom : customers) {
            System.out.println(custom);
        }

        // Создание коллекции типа Set и вывод ее в консоль
        HashSet<String> customersSet = new HashSet<String>();
        customersSet.add(Customer1.toString());
        customersSet.add(Customer2.toString());
        customersSet.add(Customer3.toString());
        customersSet.add(Customer4.toString());
        System.out.println("-------------------------------------------------");
        System.out.println("Создание коллекции типа Set и вывод ее в консоль");
        for (String  item : customersSet) {
            System.out.println(item);
        }
        // Создание коллекции типа Map и вывод ее в консоль
        Map<String, String> vocabulary = new HashMap<String, String >();
        vocabulary.put("абажур", "Колпак для лампы, светильника.");
        vocabulary.put("аббат", "Настоятель мужского католического монастыря.");
        vocabulary.put("абзац", "Красная строка, отступ в начале строки.");
        vocabulary.put("абонемент", "Документ, предоставляющий право на пользование чем-н., какое-н. обслуживание, а также само такое право.");
        System.out.println("-------------------------------------------------");
        System.out.println("Создание коллекции типа Map и вывод ее в консоль");
        for(Map.Entry<String, String > item : vocabulary.entrySet()){

            System.out.printf("%s - %s \n", item.getKey(), item.getValue());
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Толковый словарь НЕдаля");

        for( int i=0 ; i!=4;) {
            Scanner in = new Scanner(System.in);
            Scanner inWord = new Scanner(System.in);
            System.out.println("-------------------------------------------------");
            System.out.println("Введите номер необходимого действия:" + "\n" + "1 - Вывод значения по введенному слову"
                    + "\n" + "2 - Редактирование существующего значения слова" + "\n" + "3 - Добавление нового слова"
                    + "\n" + "4 - Выход из программы");

            int answer = in.nextInt();
            i = answer;
            if (answer < 4 & answer > 0) {
                switch (answer) {
                    case (1):
                        System.out.println("Введите слово, значение которого хотите узнать...");
                        String ansver1 = inWord.nextLine();
                        if (vocabulary.containsKey(ansver1)) {
                            System.out.println(ansver1 + " - " + vocabulary.get(ansver1));
                        }

                        break;
                    case (2):
                        System.out.println("Введите слово, значение которого хотите отредактировать...");
                        String ansver2 = inWord.nextLine();
                        if (vocabulary.containsKey(ansver2)) {
                            System.out.println("Введите новое значение слова...");
                            String ansver3 = inWord.nextLine();
                            vocabulary.put(ansver2, ansver3);
                        } else System.out.println("Введенного слова нет в словаре.");
                        break;
                    case (3):
                        System.out.println("Введите новое слово...");
                        String ansver4 = inWord.nextLine();
                        System.out.println("Введите новое значение слова...");
                        String ansver5 = inWord.nextLine();
                        // if (vocabulary.containsKey(ansver4) & vocabulary.containsKey(ansver5))
                    {
                        vocabulary.putIfAbsent(ansver4, ansver5);
                    }
                    break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + answer);

                }
                //break;
            }

        }
    }
}
