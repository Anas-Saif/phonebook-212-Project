import java.util.Scanner;
public class Phonebook {

    public void add(LinkedList <Contact> l) {
        Scanner input = new Scanner(System.in);
        {


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

            Contact tmp = new Contact(contactName, contactPhone, contactEmail, contactAddress, contactBirthday, contactNotes);

            if(ckeck(tmp,l))
                l.insert(tmp);//sort then add !!!!!!!!!!
            else
                System.out.println("Contact already exist");
            return ;
        }
    }
    public boolean ckeck(Contact t,LinkedList <Contact> l){
        if(!l.empty()){
            l.findFirst();
            while(!l.last())
            {
                //Check if there conflict in name or phone
                if(l.retrieve().getContactName().equals(t.getContactName()) || l.retrieve().getContactPhone().equals(t.getContactPhone()) )
                    return false;
                l.findNext();
            }
            //check last element
            if(l.retrieve().getContactName().equals(t.getContactName()) || l.retrieve().getContactPhone().equals(t.getContactPhone()))
                return false;

        }
        return true;
    }
}