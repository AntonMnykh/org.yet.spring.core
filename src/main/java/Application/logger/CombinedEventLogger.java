package Application.logger;

import Application.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger{

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event){
        for (EventLogger eventLogger : loggers){
            eventLogger.logEvent(event);
        }
    }


}
