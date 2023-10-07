public class Main {
    public static void main(String[] args) {

        LinkedList<Contact> l1 = new LinkedList<Contact>();
        Phonebook p = new Phonebook();

        p.add(l1);
        p.add(l1);
        p.add(l1);
        p.display(l1);

    }
}
