package Application.logger;

import Application.Event;

public class AbstractLogger implements EventLogger{

    private String name;

    @Override
    public void logEvent(Event event) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
