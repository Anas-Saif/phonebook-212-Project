

public class Event implements Comparable <String>{
    private String title;
    private String dateAndTime;
    private String location;
    private Contact contactInEvent;
    public Event() {
    }

    public Event(String title, String dateAndTime, String location, Contact contact) {
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.location = location;
        this.contactInEvent = contact;
    }

    public Event(Event e){
        this.title = e.title;
        this.dateAndTime = e.dateAndTime;
        this.location = e.location;
        this.contactInEvent = e.contactInEvent;
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
        return contactInEvent;
    }


    public void displayEvents(){
        System.out.println("title: "+title);
        System.out.println("date and time: "+dateAndTime);
        System.out.println("location: "+location);
        System.out.println("with: "+ contactInEvent.getContactName());
    }


    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                ", location='" + location + '\'' +
                ", contact=" + contactInEvent +
                '}';
    }



    @Override
    public int compareTo(String dnt) {
       return dateAndTime.compareTo(dnt);
    }
}

