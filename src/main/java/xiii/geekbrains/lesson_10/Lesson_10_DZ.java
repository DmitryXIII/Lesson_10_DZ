package xiii.geekbrains.lesson_10;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
   Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
   Посчитать, сколько раз встречается каждое слово.
2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
   В этот телефонный справочник с помощью метода add() можно добавлять записи,
   а с помощью метода get() искать номер телефона по фамилии.
   Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
   тогда при запросе такой фамилии должны выводиться все телефоны.
   Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
   взаимодействие с пользователем через консоль и т.д).
   Консоль использовать только для вывода результатов проверки телефонного справочника.
*/

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashSet;

public class Lesson_10_DZ {
    public static void main(String[] args) {
        String[] arrayOfWords = getWordsFromString("Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)." +
                "Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем)." +
                "Посчитать, сколько раз встречается каждое слово.");

        String countThisWord = "МАССИВ";
        System.out.println("Слово \"" + countThisWord + "\" в массиве встречается " + countThisWord(arrayOfWords, countThisWord) + " раз");

        //телефонная книга
        System.out.println("=======================================================");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhoneNumberOfPerson("Иванов", "111-222");
        phoneBook.addPhoneNumberOfPerson("Петров", "222-333");
        phoneBook.addPhoneNumberOfPerson("Иванов", "333-444");

        phoneBook.getPhoneNumberOfPerson("Иванов");
    }

    /**
     * Метод, возвращающий массив слов из переданной строки (алгоритм применения BreakIterator честно нагуглил:) )
     */
    public static String[] getWordsFromString(String text) {
        ArrayList<String> words = new ArrayList<>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }
        String[] arrOfWords = new String[words.size()];
        for (int i = 0; i < arrOfWords.length; i++) {
            arrOfWords[i] = words.get(i);
        }
        return arrOfWords;
    }

    /**
     * Подсчет количества повторений искомого слова в массиве (регистр слова при подсчете повторений игнорируется)
     */
    public static int countThisWord(String[] arrayOfWords, String word) {
        int counter = 0;
        for (int i = 0; i < arrayOfWords.length; i++) {
            if (arrayOfWords[i].toLowerCase().equals(word.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Получение списка уникальных слов из массива слов
     */
    public static void getListOfUnicWords(String[] arrayOfWords) {
        HashSet<String> listOfUnicWords = new HashSet<>();
        for (int i = 0; i < arrayOfWords.length; i++) {
            listOfUnicWords.add(arrayOfWords[i]);
        }
        System.out.println("Список уникальных слов из массива: ");
        for (String s :
                listOfUnicWords) {
            System.out.println(s);
        }
        System.out.println("");
    }
}
