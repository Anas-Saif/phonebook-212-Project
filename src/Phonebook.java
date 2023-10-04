import java.util.Scanner;
public class Phonebook {

    public boolean add() {
        Scanner input = new Scanner(System.in);
        {
            Contact tmp = new Contact();

            System.out.println("Enter contact name: ");
            String contactName = input.next();

            System.out.println("Enter contact phone: ");
            String contactPhone = input.next();

            System.out.println("Enter contact email: ");
            String contactEmail = input.next();

            System.out.println("Enter contact address: ");
            String contactAddress = input.next();

            System.out.println("Enter contact birthday: ");
            String contactBirthday = input.next();

            System.out.println("Enter contact notes: ");
            String contactNotes = input.next();


            return true;
        }
    }
}