package Application.logger;

import Application.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger{

    File file;
    String fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event){
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
