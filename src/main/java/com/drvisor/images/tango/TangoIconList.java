
package com.drvisor.images.tango;

import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.Map;

public class TangoIconList {
    private final String path;
    private final Map<String, ImageIcon> cache = new HashMap<>();


    public TangoIconList(String path) {
        this.path = path.endsWith("/") ? path : path + "/";
    }

    public ImageIcon get(String iconId) {
        ImageIcon result = cache.get(iconId);
        if (result == null) {
            ClassLoader cl = TangoIconList.class.getClassLoader();
            java.net.URL url = this.getClass().getResource(path + iconId);
            if (url != null) {
                result = new ImageIcon(url);
                cache.put(iconId, result);
            }
        }
        return result;
    }


}
