import java.util.ArrayList;
import java.util.List;

public class Contacts {
    private ArrayList<Contact> myPhoneBook = new ArrayList<>();

    public Contacts(ArrayList<Contact> myPhoneBook){
        this.myPhoneBook = myPhoneBook;
    }

    public void addContact(Contact contact){
        myPhoneBook.add(contact);
    }

    public List<String> get(String lastName){
        return myPhoneBook.stream().filter(it ->it.lastName == lastName).map(it-> it.phone).toList();
    }
}
