package lesson_03;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //1.
        Map<String, Integer> mapWords = new HashMap<String, Integer>();
        String str = "Ночь на земле. Ковер земли и сон. \n" +
                     "Ночь под землей. Навес земли и сон. \n" +
                     "Мелькнули тени, где-то зароились \n" +
                     "И скрылись вновь. Пустыня… тайна… сон.";

        System.out.println(str);
        System.out.println("------------------------------------------");

        String[] words = str.toLowerCase().replaceAll("[^[\\p{P}\\n]-]", "" ).split(" ");
        System.out.println(Arrays.toString(words));

        for (String word: words) {
            int freq = (mapWords.get(word) == null) ? 1 : mapWords.get(word) + 1;
            mapWords.put(word, freq);
        }
        System.out.println(mapWords);
        System.out.println("\n------------------------------------------");
        System.out.println("------------------------------------------");


        //2.
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact ( new Person("Ivanov"), "111-111-111, 222-222-222", "boss_email@mail.ru, email2@mail.ru");
        phoneBook.addContact ( new Person("Sidorov"), "111-111-111, 222-222-222, 333-333-333");
        phoneBook.addContact ( new Person("Alexeev"), "555-555-555", "alexeev@gmail.com, alexeev@mail.com");
        phoneBook.addContact ( new Person("Petrov"), "888-888-888", "petrov@yandex.ru");
        phoneBook.addContact ( new Person("Morozov"), "777-777-777", "");

        System.out.println("Содержание справочника: ");
        phoneBook.getAllPersonsInfo();

        System.out.println("------------------------------------------");
        System.out.println("Поиск:");
        System.out.println("------------------------------------------");
        phoneBook.getPersonInfo("Ivanov");
        System.out.println("------------------------------------------");

        phoneBook.getPhones("Ivanov");
        phoneBook.getPhones("Sidorov");
        phoneBook.getPhones("Alexeev");
        phoneBook.getPhones("Petrov");
        phoneBook.getPhones("Novikov");
        phoneBook.getPhones("Morozov");
        System.out.println("------------------------------------------");

        phoneBook.getEmails("Ivanov");
        phoneBook.getEmails("Sidorov");
        phoneBook.getEmails("Alexeev");
        phoneBook.getEmails("Petrov");
        phoneBook.getEmails("Novikov");
        phoneBook.getEmails("Morozov");
        System.out.println("------------------------------------------");
    }
}
