package xiii.geekbrains.lesson_10;

import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, String> phoneBookData = new HashMap<>();



    public void getPhoneNumberOfPerson (String secondName) {
        System.out.printf("Найдены номера телефонов по фамилии \"%s\": %s", secondName, this.phoneBookData.get(secondName));
    }

    public void addPhoneNumberOfPerson (String secondName, String phoneNumber) {
        if (this.phoneBookData.get(secondName) != null) {
            this.phoneBookData.put(secondName, this.phoneBookData.get(secondName) + ", " + phoneNumber);
        } else {
            this.phoneBookData.put(secondName, phoneNumber);
        }
    }
}
