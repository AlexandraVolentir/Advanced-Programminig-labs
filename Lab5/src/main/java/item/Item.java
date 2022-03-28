package item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {

    private Map<String, Object> tags = new HashMap<>();

    public void addTag(String key, Object obj){
        tags.put(key, obj);
    }

    public abstract String getId();

    abstract void setId(String id);

    public abstract String getTitle();

    abstract void setTitle(String title);

    public abstract String getLocation();

    abstract void setLocation(String location);
}
