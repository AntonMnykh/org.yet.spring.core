package Application;

import java.text.DateFormat;
import java.util.Date;

public class Event {

    private int id;
    private String message;
    private Date date;
    private DateFormat dateFormat;

    private int randomId = (int) Math.random()*100;

    public Event(Date date, DateFormat dateFormat) {
        this.id = randomId;
        this.date = date;
        this.dateFormat = dateFormat;
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
