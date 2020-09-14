package Application.logger;

import Application.Event;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class CacheFileEventLogger extends FileEventLogger{

    int cacheSize;
    List<Event> cache;

    public CacheFileEventLogger() {

    }

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @PostConstruct
    public void initCache(){
        this.cache = new ArrayList<Event>(cacheSize);
    }

    public void logEvent(Event event){
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        cache.stream().forEach(super::logEvent);
    }

    @PreDestroy
    public void destroy() {
        if(!cache.isEmpty())
            writeEventsFromCache();
    }
}
