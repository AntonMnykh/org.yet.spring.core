package Application.logger;

import Application.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class FileEventLogger implements EventLogger{

    private File file;
    //@Value("${events.file:target/events_log.txt}");

    private String fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public FileEventLogger() {
    }

    public void logEvent(Event event){
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() throws IOException {
        this.file = new File(fileName);
        if (file.exists() && !file.canWrite()){
            throw new IllegalArgumentException("Can't write to the file " + fileName);
        } else if (!file.exists()){
            try {
                file.createNewFile();
            } catch (Exception e){
                throw new IllegalArgumentException("Can't create file", e);
            }
        }
    }
}
