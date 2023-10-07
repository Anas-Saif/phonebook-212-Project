import java.util.Scanner;
public class Phonebook {
    Scanner input = new Scanner(System.in); // Create a Scanner object
    //
    public void add(LinkedList <Contact> l) {
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

            if(check(tmp,l)) {
                sort(tmp, l);
                System.out.println("Added succsesfully");
            }
            else {
                System.out.println("Contact already exist");
            }
            return ;
        }
    }
    public boolean check(Contact t,LinkedList <Contact> l){
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
    public void sort(Contact s, LinkedList <Contact> l){
        if(!l.empty()){
            l.findFirst();
            while(!l.last()){
                if(s.getContactName().compareTo(l.retrieve().getContactName())<=-1){
                    Contact tmp = l.retrieve();
                    l.update(s);
                    l.insert(tmp);
                    return;}
                l.findNext();
            }
            if(s.getContactName().compareTo(l.retrieve().getContactName())<=-1){
                Contact tmp = l.retrieve();
                l.update(s);
                l.insert(tmp);
            }
            else{
            l.insert(s);
            }
        }
        else
        l.insert(s);
    }

    //searching method by anyway

    public void searchByName(LinkedList <Contact> l){
        System.out.println("Enter contact name: ");
        String contactName = input.next();
        if(!l.empty()){
            l.findFirst();
            while(!l.last()){
                if(l.retrieve().getContactName().equals(contactName)){
                    l.retrieve().displayContactDetails();
                    return;
                }
                l.findNext();
            }
            if(l.retrieve().getContactName().equals(contactName)){
                l.retrieve().displayContactDetails();
                return;
            }
        }
        System.out.println("Contact not found");
    }
    public void searchByPhone(LinkedList <Contact> l){
        System.out.println("Enter contact Phone Number: ");
        String contactPhoneNumber = input.next();
        if(!l.empty()){
            l.findFirst();
            while(!l.last()){
                if(l.retrieve().getContactPhone().equals(contactPhoneNumber)){
                    l.retrieve().displayContactDetails();
                    return;
                }
                l.findNext();
            }
            if(l.retrieve().getContactPhone().equals(contactPhoneNumber)){
                l.retrieve().displayContactDetails();
                return;
            }
        }
        System.out.println("Contact not found");
    }
    public void searchByEmail(LinkedList <Contact> l){
        System.out.println("Enter contact Email: ");
        String contactEmail = input.next();
        boolean found=false;
        if(!l.empty()){
            l.findFirst();
            while(!l.last()){
                if(l.retrieve().getContactEmail().equals(contactEmail)){
                    l.retrieve().displayContactDetails();
                    found=true;
                }
                l.findNext();
            }

            if(l.retrieve().getContactEmail().equals(contactEmail)){
                l.retrieve().displayContactDetails();
                return;
            }
        }
        if(!found)
            System.out.println("Contact not found");
    }
    public void searchByAddress(LinkedList <Contact> l){
        System.out.println("Enter contact Address: ");
        String contactAddress = input.next();
        boolean found=false;
        if(!l.empty()){
            l.findFirst();
            while(!l.last()){
                if(l.retrieve().getContactAddress().equals(contactAddress)){
                    l.retrieve().displayContactDetails();
                    found=true;
                }
                l.findNext();
            }

            if(l.retrieve().getContactAddress().equals(contactAddress)){
                l.retrieve().displayContactDetails();
                return;
            }
        }
        if(!found)
            System.out.println("Contact not found");
    }
    public void searchByBirthday(LinkedList <Contact> l){
        System.out.println("Enter contact Birthday: ");
        String contactBirthday = input.next();
        boolean found=false;
        if(!l.empty()){
            l.findFirst();
            while(!l.last()){
                if(l.retrieve().getContactBirthday().equals(contactBirthday)){
                    l.retrieve().displayContactDetails();
                    found=true;
                }
                l.findNext();
            }

            if(l.retrieve().getContactBirthday().equals(contactBirthday)){
                l.retrieve().displayContactDetails();
                return;
            }
        }
        if(!found)
            System.out.println("Contact not found");
    }
    public void search(LinkedList <Contact> l){
        System.out.println("Search by: ");
        System.out.println("1-Name");
        System.out.println("2-Phone Number");
        System.out.println("3-Email");
        System.out.println("4-Address");
        System.out.println("5-Birthday");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                searchByName(l);
                break;
            case 2:
                searchByPhone(l);
                break;
            case 3:
                searchByEmail(l);
                break;
            case 4:
                searchByAddress(l);
                break;
            case 5:
                searchByBirthday(l);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
     /*to do:
        1-delete name or phone number.
        2- Create Events Class.
        */

    public void display(LinkedList <Contact> l){
        if(!l.empty()){
            l.findFirst();
            while (!l.last()){
                System.out.println(l.retrieve().toString());
                l.findNext();
            }
            System.out.println(l.retrieve().toString());
        }
    }
}