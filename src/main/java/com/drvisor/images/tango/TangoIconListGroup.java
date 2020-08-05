
package com.drvisor.images.tango;


import java.util.HashMap;
import java.util.Map;

public class TangoIconListGroup {
    private final String grName;
    private final String path;
    private final Map<Integer, TangoIconList> sizeMap = new HashMap<>();

    public TangoIconListGroup(String path, String groupName) {
        this.path = path;
        this.grName = groupName;
    }

    public TangoIconList getSized(int size) {
        return sizeMap.computeIfAbsent(size, s -> new TangoIconList(path + s + "x" + s + "/" + grName + "/"));
    }

    public TangoIconList small() {
        return getSized(16);
    }

    public TangoIconList medium() {
        return getSized(22);
    }

    public TangoIconList big() {
        return getSized(32);
    }


}
