package com.seveneleven.mycontactapp.tag;
import java.util.HashMap;
import java.util.Map;
public class TagFactory {
    private static final Map<String, Tag> tagPool = new HashMap<>();
    public static Tag getTag(String name) {
        name = name.toLowerCase();
        if (!tagPool.containsKey(name)) {
            tagPool.put(name, new Tag(name));
        }
        return tagPool.get(name);
    }
}