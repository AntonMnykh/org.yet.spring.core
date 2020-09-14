package Application.logger;

import Application.Event;

import java.util.Collection;
import java.util.Collections;

public class CombinedEventLogger extends AbstractLogger{

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event){
        for (EventLogger eventLogger : loggers){
            eventLogger.logEvent(event);
        }
    }

    public Collection<EventLogger> getLoggers() {
        return Collections.unmodifiableCollection(loggers);
    }
}
