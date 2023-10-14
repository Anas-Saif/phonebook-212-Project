public class Event {
    private String title;
    private String dateAndTime;
    private String location;
    private Contact contact;

    public Event() {
    }

    public Event(String title, String dateAndTime, String location, Contact contact) {
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.location = location;
        this.contact = contact;
    }

    public Event (Event e){
        this.title = e.title;
        this.dateAndTime = e.dateAndTime;
        this.location = e.location;
        this.contact = e.contact;
    }

    public String getTitle() {
        return title;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public String getLocation() {
        return location;
    }

    public Contact getContact() {
        return contact;
    }


    public void displayEvents(){
        System.out.println("title: "+title);
        System.out.println("date and time: "+dateAndTime);
        System.out.println("location: "+location);
        System.out.println("with: "+ contact.getContactName());
    }


    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                ", location='" + location + '\'' +
                ", contact=" + contact +
                '}';
    }
}

