package com.drvisor.images.tango;


import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

public class Tango {


    public static final TangoIconListGroup actions = new TangoIconListGroup("/org/freedesktop/tango/", "actions");
    public static final TangoIconListGroup apps = new TangoIconListGroup("/org/freedesktop/tango/", "apps");
    public static final TangoIconListGroup status = new TangoIconListGroup("/org/freedesktop/tango/", "status");
    public static final TangoIconListGroup places = new TangoIconListGroup("/org/freedesktop/tango/", "places");
    public static final TangoIconListGroup categories = new TangoIconListGroup("/org/freedesktop/tango/", "categories");
    public static final List<TangoIconListGroup> resolveSequence = List.of(actions, apps, status, places, categories);


    public static ImageIcon small(String name) {
        ImageIcon result = null;
        for (TangoIconListGroup iconList : resolveSequence) {
            result = iconList.small().get(name);
            if (result != null) break;
        }
        return result;
    }

    public static Image getImage(String iconName) {
        ImageIcon icon = small(iconName);
        if (icon != null) {
            BufferedImage bi = new BufferedImage(
                    icon.getIconWidth(),
                    icon.getIconHeight(),
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.createGraphics();
            try {
                icon.paintIcon(null, g, 0, 0);
            } finally {
                g.dispose();
            }
            return bi;
        }
        return null;
    }


}
