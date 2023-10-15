import java.time.LocalDateTime;

public class Event implements Comparable <String>{
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private Contact contactInEvent;
    public Event() {
    }

    public Event(String title, LocalDateTime startTime,LocalDateTime endTime, String location, Contact contact) {
        this.title = title;
        this.startTime = startTime;
        this.endTime=endTime;
        this.location = location;
        this.contactInEvent = contact;
    }

    public Event(Event e){
        this.title = e.title;
        this.startTime = e.startTime;
        this.endTime=e.endTime;
        this.location = e.location;
        this.contactInEvent = e.contactInEvent;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {return endTime;}


    public String getLocation() {
        return location;
    }

    public Contact getContact() {
        return contactInEvent;
    }


    public void displayEvents(){
        System.out.println("title: "+title);
        System.out.println("start Time: "+ startTime);
        System.out.println("end Time: "+ endTime);
        System.out.println("location: "+location);
        System.out.println("with: "+ contactInEvent.getContactName());
    }


    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", location='" + location + '\'' +
                ", contact=" + contactInEvent +
                '}';
    }


    @Override
    public int compareTo(String title) {
        return this.title.compareTo(title);
    }
}

