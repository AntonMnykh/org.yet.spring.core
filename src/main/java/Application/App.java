package Application;

import Application.aspects.StatisticsAspect;
import Application.logger.ConsoleEventLogger;
import Application.logger.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;
    private String startupMessage;
    private StatisticsAspect statisticsAspect;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml",
                "loggers.xml", "aspects.xml", "db.xml");

        App app = (App) ctx.getBean("app");

        System.out.println(app.startupMessage);

        Client client = ctx.getBean(Client.class);
        System.out.println("Client says: " + client.getGreeting());

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for user 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "One more event for user 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event,"Some event for user 2");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "Some event for user 3");

//        app.outputLoggingCounter();

        ctx.close();
    }

    private void logEvent(EventType eventType, Event event, String msg){
        String message = msg.replaceAll(
                client.getId(), client.getFullName());
        event.setMessage(message);

        EventLogger logger = loggers.get(eventType);
        if(logger == null){
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }

//    private void outputLoggingCounter() {
//        if (statisticsAspect != null) {
//            System.out.println("Loggers statistics. Number of calls: ");
//            for (Map.Entry<Class<?>, Integer> entry: statisticsAspect.getCounter().entrySet()) {
//                System.out.println("    " + entry.getKey().getSimpleName() + ": " + entry.getValue());
//            }
//        }
//    }

    public void setStartupMessage(String startupMessage){
        this.startupMessage = startupMessage;
    }

//    public void setStatisticsAspect(StatisticsAspect statisticsAspect) {
//        this.statisticsAspect = statisticsAspect;
//    }

    public EventLogger getDefaultLogger(){
        return defaultLogger;
    }
}
