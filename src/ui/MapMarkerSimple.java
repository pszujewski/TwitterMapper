package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import twitter4j.Status;

import java.awt.*;

public class MapMarkerSimple extends MapMarkerCircle {
    public static final double defaultMarkerSize = 6.0;
    private Color color;
    private Status tweet;

    public MapMarkerSimple(Layer layer, Coordinate coord, Color color, Status s) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(Color.BLACK);
        setBackColor(color);
        this.color = color;
        this.tweet = s;
    }

    public Status getTweet() {
        return tweet;
    }
}
