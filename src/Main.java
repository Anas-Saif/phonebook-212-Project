public class Main {
    public static void main(String[] args) {

        LinkedList<Contact> l1 = new LinkedList<Contact>(); //review
        Phonebook p = new Phonebook();
        Phonebook p2 = new Phonebook();


        p.addContact();
        p.display();
        p2.display();
        p.addEvent();
        p.addEvent();
        p.addEvent();
        p2.addEvent();
        p.deleteContact();
        p.display();



    }
}
