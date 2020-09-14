package Application.logger;

import Application.Event;

public class ConsoleEventLogger extends AbstractLogger {

    public void logEvent(Event event){
        System.out.println(event.toString());
    }
}
