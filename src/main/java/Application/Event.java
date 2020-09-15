package Application;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {

    private int id;
    private String message;
    private Date date;
    private DateFormat dateFormat;

    private int randomId = (int) Math.random()*100;
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    public static boolean isDay(int start, int end){
        LocalTime time = LocalTime.now();
        return time.getHour() > start && time.getHour() < end;
    }

    public Event(int id, Date date, DateFormat dateFormat) {
        this.id = AUTO_ID.getAndIncrement();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public Event(int id, Date date, String msg) {
        this.id = id;
        this.date = date;
        this.message = msg;
    }

    public static void initAutoId(int id) {
        AUTO_ID.set(id);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
