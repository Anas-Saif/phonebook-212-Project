import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Phonebook {
    private LinkedList <Contact> c = new LinkedList<>();
    private LinkedList <Event> allEvents = new LinkedList<>();
    Scanner input = new Scanner(System.in); // Create a Scanner object
    //

    // Method to add a new contact to the phonebook




        public void addContact () {
            try {
                // Prompt the user for contact detail
                System.out.print("Enter contact name: ");
                String contactName = input.nextLine();
                contactName = contactName.toLowerCase();

                System.out.print("Enter contact phone: ");
                String contactPhone = input.next();

                //check phone number format
                while (!contactPhone.matches("\\d{10}")) {
                    System.out.println("Wrong Phone number format! Please enter 10 numeric digits.");
                    System.out.print("Enter contact Phone Number: ");
                    contactPhone = input.next();
                }

                System.out.print("Enter contact email: ");
                String contactEmail = input.next();

                System.out.print("Enter contact address: ");
                String contactAddress = input.next();

                System.out.print("Enter contact birthday (YYYY/MM/DD): ");
                String contactBirthday = input.next();
                input.nextLine();

                //check date format
                while (!contactBirthday.matches("^\\d{4}/\\d{2}/\\d{2}$")) {
                    System.out.println("Invalid date of birth format. Use (YYYY/MM/DD).");
                    System.out.print("Enter contact birthday (YYYY/MM/DD): ");
                    contactBirthday = input.next();
                }

                System.out.print("Enter contact notes: ");
                String contactNotes = input.nextLine();


        Contact tmp = new Contact(contactName, contactPhone, contactEmail, contactAddress, contactBirthday, contactNotes);
        // Check if the contact already exists and add it to the phonebook
        if (check(tmp)) {
            sort(tmp); // Sort the phonebook to maintain alphabetical order
            System.out.println("Added Successfully");
        } else {
            System.out.println("Contact already exists");
        }
            } catch (InputMismatchException e){
                System.out.println("Input miss match");
            }

        return;
    }

    // Method to check if a new contact conflicts with existing contacts
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
    // Method to sort and insert a contact into the phonebook
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
    // Method to search for a contact by name
    public void searchByName(){
            try {

        input.nextLine();
        System.out.print("Enter contact name: ");
        String contactName = input.nextLine();
        if(!c.empty()){
            c.findFirst();
            while(!c.last()){
                if(c.retrieve().getContactName().equalsIgnoreCase(contactName)){
                    c.retrieve().displayContactDetails();
                    return;
                }
                c.findNext();
            }
            if(c.retrieve().getContactName().equalsIgnoreCase(contactName)){
                c.retrieve().displayContactDetails();
                return;
            }
        }
        System.out.println("Contact not found");
            } catch (InputMismatchException e){
                System.out.println("Input miss match");
            }
    }
    // Method to search for a contact by phone
    public void searchByPhone(){
            try {

        input.nextLine();
        System.out.print("Enter contact Phone Number: ");
        String contactPhoneNumber = input.next();

        //check phone number format
        while (!contactPhoneNumber.matches("\\d{10}")) {
            System.out.println("Wrong Phone number format! Please enter 10 numeric digits.");
            System.out.print("Enter contact Phone Number: ");
            contactPhoneNumber = input.next();
        }
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
            } catch (InputMismatchException e){
                System.out.println("Input miss match");
            }
    }
    // Method to search for a contact by email
    public void searchByEmail(){
            try{
        input.nextLine();
        System.out.print("Enter contact Email: ");
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
            } catch (InputMismatchException e){
                System.out.println("Input miss match");
            }
    }
    // Method to search for a contact by address
    public void searchByAddress(){
            try {
        input.nextLine();
        System.out.print("Enter contact Address: ");
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
            } catch (InputMismatchException e){
                System.out.println("Input miss match");
            }
    }
    // Method to search for a contact by birthday
    public void searchByBirthday(){
            try{
        input.nextLine();
        System.out.print("Enter contact birthday (YYYY/MM/DD): ");
        String contactBirthday = input.next();

        //check date format
        while (!contactBirthday.matches("^\\d{4}/\\d{2}/\\d{2}$")) {
            System.out.println("Invalid date of birth format. Use (YYYY/MM/DD).");
            System.out.print("Enter contact birthday (YYYY/MM/DD): ");
            contactBirthday = input.next();
        }

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
            } catch (InputMismatchException e){
                System.out.println("Input miss match");
            }
    }

    public void search(){
            try{
        System.out.println("Search by: ");
        System.out.println("1-Name");
        System.out.println("2-Phone Number");
        System.out.println("3-Email");
        System.out.println("4-Address");
        System.out.println("5-Birthday");
        System.out.print("Enter your choice: ");
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
            } catch (InputMismatchException e){
                System.out.println("Input miss match");
            }
    }
    public void searchByFirstName(){
            try{
        System.out.print("Enter First Name: ");
        String firstName = input.next();
        firstName= firstName.split(" ")[0];
        boolean found=false;
        if(!c.empty()){
            c.findFirst();
            while(!c.last()){
                if(c.retrieve().getContactName().split(" ")[0].equalsIgnoreCase(firstName)){
                    c.retrieve().displayContactDetails();
                    found=true;
                }
                c.findNext();
            }

            if(c.retrieve().getContactName().split(" ")[0].equalsIgnoreCase(firstName)){
                c.retrieve().displayContactDetails();
                return;
            }
        }
        if(!found)
            System.out.println("Contact not found");
            } catch (InputMismatchException e){
                System.out.println("Input miss match");
            }
    }
    // Method to delete a contact
    public void deleteContact(){
            try {
        input.nextLine();
        System.out.print("Enter the contact name that you want to delete :");
        String name = input.nextLine();
        input.nextLine();
        Contact tmp = searchByNameP(name);
        if (tmp != null) {
            deleteEvent(tmp);
            c.remove();
            System.out.println("Contact has been deleted");
            return;
        }
        System.out.println("The contact does not exists");
            } catch (InputMismatchException e){
                System.out.println("Input miss match");
            }
        return;
    }
    // Method take Contact to delete all events related to this contact
    public void deleteEvent(Contact c){
        if(!allEvents.empty()){
            allEvents.findFirst();
            while(!allEvents.last()){
                if(allEvents.retrieve().getContact().getContactName().equalsIgnoreCase(c.getContactName())){
                    allEvents.remove();
                }
                else{
                    allEvents.findNext();
                }
            }
            if(allEvents.retrieve().getContact().getContactName().equalsIgnoreCase(c.getContactName())){
                allEvents.remove();
            }
        }

    }
    //private method to retrieve the contact by contact name
    private Contact searchByNameP(String n){

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
        //System.out.println("Contact not found");
        return null;
    }
    // Method to add a new event
    public void addEvent() {
        try {
            System.out.print("Enter event title: ");
            String eventTitle = input.nextLine();

            System.out.print("Enter contact name: ");
            String contactName = input.nextLine();

            // Search for the contact by name
            Contact tmpContact = searchByNameP(contactName);
            if (tmpContact != null && !check(tmpContact)) {
                // Prompt for event details
                System.out.print("Enter event date Ex: YYYY/MM/DD : ");
                String date = input.next();

                //check date format
                while (!date.matches("^\\d{4}/\\d{2}/\\d{2}$")) {
                    System.out.println("Invalid date of birth format. Use (YYYY/MM/DD).");
                    System.out.print("Enter contact birthday (YYYY/MM/DD): ");
                    date = input.next();
                }

                System.out.print("Enter event Start time Ex: HH:MM : ");
                String startTime = input.next();
                System.out.print("Enter event End time Ex: HH:MM : ");
                String endTime = input.next();

                // Parse date and time information and create a LocalDateTime object
                int year = Integer.parseInt(date.split("/")[0]);
                int month = Integer.parseInt(date.split("/")[1]);
                int day = Integer.parseInt(date.split("/")[2]);
                int startHour = Integer.parseInt(startTime.split(":")[0]);
                int startMinute = Integer.parseInt(startTime.split(":")[1]);
                int endHour = Integer.parseInt(endTime.split(":")[0]);
                int endMinute = Integer.parseInt(endTime.split(":")[1]);

                // represent the event's start and end times
                LocalDateTime startEvent = LocalDateTime.of(year, month, day, startHour, startMinute);
                LocalDateTime endEvent = LocalDateTime.of(year, month, day, endHour, endMinute);
                System.out.print("Enter event location: ");
                String eventLocation = input.next();

                // Create a new Event object
                Event tmpEvent = new Event(eventTitle, startEvent, endEvent, eventLocation, tmpContact);
                if (!isConflict(tmpEvent)) {
                    sortEvent(tmpContact, tmpEvent);
                    tmpContact.setEventsInContact(tmpEvent);
                    System.out.println("Event has been added successfully");
                }
            } else {
                System.out.println("The contact does not exist");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Miss Mach");
        }
    }


    // Method to check if a new event conflicts with existing events
    public boolean isConflict(Event e) {
        if (!allEvents.empty()) {
            allEvents.findFirst();
            while (!allEvents.last()) {
                Event currentEvent = allEvents.retrieve();
                if (currentEvent.getStartTime().compareTo(e.getEndTime()) < 0
                        && currentEvent.getEndTime().compareTo(e.getStartTime()) > 0) {
                    System.out.println("There's a conflict with another event");
                    return true;
                }
                allEvents.findNext();
            }

            // Check the last event after the loop
            Event currentEvent = allEvents.retrieve();
            if (currentEvent.getStartTime().compareTo(e.getEndTime()) < 0
                    && currentEvent.getEndTime().compareTo(e.getStartTime()) > 0) {
                System.out.println("There's a conflict with another event");
                return true;
            }
        }
        return false;
    }
    // Method to sort and insert an event into the events list
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
    // Method to search for an event by title
    public void searchEventByTitle() {
        try {
            input.nextLine(); //buffer cleaner
            System.out.print("Enter event title: ");
            String eventTitle = input.nextLine();
            boolean found = false;
            if (!allEvents.empty()) {
                allEvents.findFirst();
                while (!allEvents.last()) {
                    if (allEvents.retrieve().getTitle().equalsIgnoreCase(eventTitle)) {
                        allEvents.retrieve().displayEvent();
                        found = true;
                    }
                    allEvents.findNext();
                }
                if (allEvents.retrieve().getTitle().equalsIgnoreCase(eventTitle)) {
                    allEvents.retrieve().displayEvent();
                    return;
                }
            }
            if (!found)
                System.out.println("Event not found");
        } catch (InputMismatchException e){
        System.out.println("Input miss match");
        }
    }
    // Method to search for an event by contact name
    public void searchEventByContactName() {
        try {
            input.nextLine(); // buffer cleaner
            System.out.print("Enter contact name: ");
            String contactName = input.nextLine();
            boolean found = false;
            if (!allEvents.empty()) {
                allEvents.findFirst();
                while (!allEvents.last()) {
                    if (allEvents.retrieve().getContact().getContactName().equalsIgnoreCase(contactName)) {
                        allEvents.retrieve().displayEvent();
                        found = true;
                    }
                    allEvents.findNext();
                }
                if (allEvents.retrieve().getContact().getContactName().equalsIgnoreCase(contactName)) {
                    allEvents.retrieve().displayEvent();
                    return;
                }
            }
            if (!found)
                return;
        } catch (InputMismatchException e) {
            System.out.println("Input miss match");
        }
    }
    // Method to search event by title or contact name
    public void searchEvent() {
        try {
            System.out.println("Search by: ");
            System.out.println("1-Title");
            System.out.println("2-Contact Name");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    searchEventByTitle();
                    break;
                case 2:
                    searchEventByContactName();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input miss match");
        }
    }
    // Method to display all events
    public void displayAllEvents(){
        if(!allEvents.empty()){
            allEvents.findFirst();
            while (!allEvents.last()){
                allEvents.retrieve().displayEvent();
                allEvents.findNext();
            }
            allEvents.retrieve().displayEvent();
        }
        System.out.println("No events to display");
    }
    // Method to display all contacts
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