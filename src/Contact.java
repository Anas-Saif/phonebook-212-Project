public class Contact implements Comparable <String>{

    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String contactAddress;
    private String contactBirthday;
    private String contactNotes;

    public Contact(String contactName, String contactPhone, String contactEmail, String contactAddress, String contactBirthday, String contactNotes) {
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.contactAddress = contactAddress;
        this.contactBirthday = contactBirthday;
        this.contactNotes = contactNotes;
    }

    public Contact(Contact c){
        this.contactName=c.contactName;
        this.contactPhone=c.contactPhone;
        this.contactEmail=c.contactEmail;
        this.contactAddress=c.contactAddress;
        this.contactBirthday=c.contactBirthday;
        this.contactNotes=c.contactNotes;
    }

    //default
    public Contact(){
    }

    @Override
    public int compareTo(String cn) {
        return contactName.compareTo(cn);
    }

    public void displayContactDetails(){
        System.out.println("Name: "+contactName);
        System.out.println("Phone Number: "+contactPhone);
        System.out.println("Email Address: "+contactEmail);
        System.out.println("Address: "+contactAddress);
        System.out.println("Birthday: "+contactBirthday);
        System.out.println("Notes: "+contactNotes);
    }
}
