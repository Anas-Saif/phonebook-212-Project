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
                sort(tmp,l);
            else
                System.out.println("Contact already exist");
            return ;
        }
    }
    public boolean ckeck(Contact t,LinkedList <Contact> l){
        if(!l.empty()){
            l.findFirst();
            while(!l.last()){
                if(l.retrieve().getContactName().equals(t.getContactName()))
                    return false;

                if(l.retrieve().getContactPhone().equals(t.getContactPhone()))
                    return false;

                l.findNext();
            }
            if(l.retrieve().getContactName().equals(t.getContactName()))
                return false;

            if(l.retrieve().getContactPhone().equals(t.getContactPhone()))
                return false;

        }
        return true;
    }
    public void sort(Contact s, LinkedList <Contact> l){
        if(!l.empty()){
            l.findFirst();
            while(!l.last()){
                if(l.retrieve().getContactName().compareTo(s.getContactName())==-1){
                    l.insert(s);
                    return;}
                l.findNext();
            }
            if(l.retrieve().getContactName().compareTo(s.getContactName())==-1)
                l.insert(s);

            l.findNext();
            l.insert(s);
        }
        l.insert(s);
    }

    //searchin method by anyway



}