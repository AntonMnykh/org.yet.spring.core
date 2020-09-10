package Application;

public class App {

    private static Client client;
    private static ConsoleEventLogger eventLogger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        App app = new App(new Client("1", "John"), new ConsoleEventLogger());

        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg){
        String message = msg.replaceAll(
                client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
