import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<String>(
                Arrays.asList("a", "b", "c", "a", "b", "d", "a", "b", "c", "f", "b", "c", "a", "b", "c"));
        Set<String> set = new HashSet<String>(arr1);
        System.out.println(set);

        Map<String, Integer> map = new HashMap<>();
        arr1.forEach(el -> {
            map.put(el, map.getOrDefault(el, 0) + 1);
        });
        System.out.println(map);

        Contact person1 = new Contact("Ivanov", "112");
        Contact person2 = new Contact("Petrov", "1122");
        Contact person3 = new Contact("Ivanov", "3344");

        Contacts myPhoneBook = new Contacts(new ArrayList<Contact>(Arrays.asList(person1, person2)));
        myPhoneBook.addContact(person3);

        System.out.println(myPhoneBook.get("Ivanov"));
    }

}
