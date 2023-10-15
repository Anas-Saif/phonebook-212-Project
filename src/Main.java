import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
/*        LocalDateTime a = LocalDateTime.of(2023,02,23,12);
//        LocalDateTime d = LocalDateTime.of();
//        System.out.println(d.compareTo(a));
//        System.out.println( d.getHour());

        System.out.println("Enter event date and time Ex: YYYY/MM/DD ");
         String date = "2023/05/11";
         String year= date.split("/")[0];
        String month= date.split("/")[1];
        String day= date.split("/")[2];
        System.out.println(year);
        System.out.println(month);
        System.out.println(date);
        */
        Phonebook p = new Phonebook();
        Phonebook p2 = new Phonebook();
        p.addContact();
        p.display();
        p2.display();
        p.addEvent();
        p.addEvent();
        p.addEvent();
        p2.addEvent();
        p.deleteContact();
        p.display();



    }
}
