package Application;

public class Client {
    String id;
    String fullName;
    String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
