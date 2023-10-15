

import java.time.LocalDateTime;

import java.util.Scanner;
public class Phonebook {
    private LinkedList <Contact> c = new LinkedList<>();
    private LinkedList <Event> allEvents = new LinkedList<>();
    Scanner input = new Scanner(System.in); // Create a Scanner object
    //

    public void addContact() {
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

            if(check(tmp)) {
                sort(tmp);
                System.out.println("Added Successfully");
            }
            else {
                System.out.println("Contact already exists");
            }
            return ;
        }
    }
    public boolean check(Contact t){
        if(!c.empty()){
            c.findFirst();
            while(!c.last())
            {
                //Check if there conflict in name or phone
                if(c.retrieve().getContactName().equals(t.getContactName()) || c.retrieve().getContactPhone().equals(t.getContactPhone()) )
                    return false;
                c.findNext();
            }
            //check last element
            if(c.retrieve().getContactName().equals(t.getContactName()) || c.retrieve().getContactPhone().equals(t.getContactPhone()))
                return false;

        }
        return true;
    }
    public void sort(Contact s){
        if(!c.empty()){
            c.findFirst();
            while(!c.last()){
                if(s.getContactName().compareTo(c.retrieve().getContactName())<=-1){
                    Contact tmp = c.retrieve();
                    c.update(s);
                    c.insert(tmp);
                    return;}
                c.findNext();
            }
            if(s.getContactName().compareTo(c.retrieve().getContactName())<=-1){
                Contact tmp = c.retrieve();
                c.update(s);
                c.insert(tmp);
            }
            else{
            c.insert(s);
            }
        }
        else{
        c.insert(s);}
    }

    //searching method by anyway

    public void searchByName(){
        System.out.println("Enter contact name: ");
        String contactName = input.next();
        if(!c.empty()){
            c.findFirst();
            while(!c.last()){
                if(c.retrieve().getContactName().equalsIgnoreCase(contactName)){
                    c.retrieve().displayContactDetails();
                    return;
                }
                c.findNext();
            }
            if(c.retrieve().getContactName().equals(contactName)){
                c.retrieve().displayContactDetails();
                return;
            }
        }
        System.out.println("Contact not found");
    }
    public void searchByPhone(){
        System.out.println("Enter contact Phone Number: ");
        String contactPhoneNumber = input.next();
        if(!c.empty()){
            c.findFirst();
            while(!c.last()){
                if(c.retrieve().getContactPhone().equals(contactPhoneNumber)){
                    c.retrieve().displayContactDetails();
                    return;
                }
                c.findNext();
            }
            if(c.retrieve().getContactPhone().equals(contactPhoneNumber)){
                c.retrieve().displayContactDetails();
                return;
            }
        }
        System.out.println("Contact not found");
    }
    public void searchByEmail(){
        System.out.println("Enter contact Email: ");
        String contactEmail = input.next();
        boolean found=false;
        if(!c.empty()){
            c.findFirst();
            while(!c.last()){
                if(c.retrieve().getContactEmail().equals(contactEmail)){
                    c.retrieve().displayContactDetails();
                    found=true;
                }
                c.findNext();
            }

            if(c.retrieve().getContactEmail().equals(contactEmail)){
                c.retrieve().displayContactDetails();
                return;
            }
        }
        if(!found)
            System.out.println("Contact not found");
    }
    public void searchByAddress(){
        System.out.println("Enter contact Address: ");
        String contactAddress = input.next();
        boolean found=false;
        if(!c.empty()){
            c.findFirst();
            while(!c.last()){
                if(c.retrieve().getContactAddress().equals(contactAddress)){
                    c.retrieve().displayContactDetails();
                    found=true;
                }
                c.findNext();
            }

            if(c.retrieve().getContactAddress().equals(contactAddress)){
                c.retrieve().displayContactDetails();
                return;
            }
        }
        if(!found)
            System.out.println("Contact not found");
    }
    public void searchByBirthday(){
        System.out.println("Enter contact Birthday: ");
        String contactBirthday = input.next();
        boolean found=false;
        if(!c.empty()){
            c.findFirst();
            while(!c.last()){
                if(c.retrieve().getContactBirthday().equals(contactBirthday)){
                    c.retrieve().displayContactDetails();
                    found=true;
                }
                c.findNext();
            }

            if(c.retrieve().getContactBirthday().equals(contactBirthday)){
                c.retrieve().displayContactDetails();
                return;
            }
        }
        if(!found)
            System.out.println("Contact not found");
    }
    public void search(){
        System.out.println("Search by: ");
        System.out.println("1-Name");
        System.out.println("2-Phone Number");
        System.out.println("3-Email");
        System.out.println("4-Address");
        System.out.println("5-Birthday");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                searchByName();
                break;
            case 2:
                searchByPhone();
                break;
            case 3:
                searchByEmail();
                break;
            case 4:
                searchByAddress();
                break;
            case 5:
                searchByBirthday();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void deleteContact(){
        System.out.println("Enter the contact name that you want to delete");
        String name = input.next();
        Contact tmp = searchByNameP(name);
        if (tmp != null) {
            c.remove();
            System.out.println("Contact has been deleted");
            return;
        }
        System.out.println("The contact does not exists");
        return;
    }

    private Contact searchByNameP(String n){  //private method to retrieve the contact by contact name

        if(!c.empty()){
            c.findFirst();
            while(!c.last()){
                if(c.retrieve().getContactName().equals(n)){
                    c.retrieve();
                    return c.retrieve();
                }
                c.findNext();
            }
            if(c.retrieve().getContactName().equals(n)){
                c.retrieve();
                return c.retrieve();
            }
        }
        System.out.println("Contact not found");
        return null;
    }
    public void addEvent() {

        System.out.println("Enter event title: ");
        String eventTitle = input.next();

        System.out.println("Enter contact name: ");
        String contactName = input.next();


        Contact tmpContact = searchByNameP(contactName);
        if (tmpContact!= null && !check(tmpContact)) {
            System.out.println("Enter event date Ex: YYYY/MM/DD ");
            String date = input.next();
            System.out.println("Enter event Start time Ex: HH:MM ");
            String startTime = input.next();
            System.out.println("Enter event End time Ex: HH:MM ");
            String endTime = input.next();
            int year= Integer.parseInt(date.split("/")[0]);
            int month= Integer.parseInt(date.split("/")[1]);
            int day= Integer.parseInt(date.split("/")[2]);
            int startHour=Integer.parseInt(startTime.split(":")[0]);
            int startMinute=Integer.parseInt(startTime.split(":")[1]);
            int endHour=Integer.parseInt(endTime.split(":")[0]);
            int endMinute=Integer.parseInt(endTime.split(":")[1]);
            LocalDateTime startEvent = LocalDateTime.of(year,month,day,startHour,startMinute);
            LocalDateTime endEvent = LocalDateTime.of(year,month,day,endHour,endMinute);



            System.out.println("Enter event location: ");
            String eventLocation = input.next();
            Event tmpEvent = new Event(eventTitle , startEvent ,endEvent, eventLocation, tmpContact);
            if (!isConflict(tmpEvent)){
                sortEvent(tmpContact,tmpEvent);
                tmpContact.setEventsInContact(tmpEvent);
            }
        }
        else {
            System.out.println("The contact does not exist");
            return;
        }
    }
    public boolean isConflict(Event e){ // in the event linked list
        if (!allEvents.empty()){
          allEvents.findFirst();
            while (!allEvents.last()){
                if ( allEvents.retrieve().getStartTime().compareTo(e.getStartTime())==0
                || allEvents.retrieve().getEndTime().compareTo(e.getEndTime()) ==0
                || allEvents.retrieve().getStartTime().compareTo(e.getStartTime()) < 0 && allEvents.retrieve().getEndTime().compareTo(e.getEndTime()) > 0){
                    System.out.println("There's a conflict with other event");
                    return true;
                }
                allEvents.findNext();
            }
            if (  allEvents.retrieve().getStartTime().compareTo(e.getStartTime())==0
                    || allEvents.retrieve().getEndTime().compareTo(e.getEndTime()) ==0
                    || allEvents.retrieve().getStartTime().compareTo(e.getStartTime()) < 0 && allEvents.retrieve().getEndTime().compareTo(e.getEndTime()) > 0){
                System.out.println("There's a conflict with other event");
                return true;
            }
            else{
                return false;
            }
        }
        System.out.println("There's no Contact in your phonebook");
        return true;

    }

    public void sortEvent(Contact c,Event s){

        if (!allEvents.empty()){

            allEvents.findFirst();
            while (!allEvents.last()){
                if (s.getTitle().toLowerCase().compareTo(allEvents.retrieve().getTitle().toLowerCase()) <= -1){
                    Event tmp = allEvents.retrieve();
                    allEvents.update(s);
                    allEvents.insert(tmp);
                    return;
                }
                allEvents.findNext();
            }
            if (s.getTitle().toLowerCase().compareTo(allEvents.retrieve().getTitle().toLowerCase()) <= -1){
                Event tmp = allEvents.retrieve();
                allEvents.update(s);
                allEvents.insert(tmp);
                return;
            }

            }
        allEvents.insert(s);
        return;
    }

     /*to do:
        1-delete name or phone number.
        2- Create Events Class.
        */

    public void display(){
        if(!c.empty()){
            c.findFirst();
            while (!c.last()){
                System.out.println(c.retrieve().toString());
                c.findNext();
            }
            System.out.println(c.retrieve().toString());
        }
    }
}