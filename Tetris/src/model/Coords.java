package model;

import java.util.AbstractMap;
import java.util.Map;

public class Coords
{
    private int x, y;

    public Coords(int _x, int _y)
    {
        super();
        setCoord(_x, _y);
    }

    public Map<String, Integer> getCoords()
    {
        return Map.ofEntries(
                new AbstractMap.SimpleEntry<String, Integer>("x", Integer.valueOf(x)),
                new AbstractMap.SimpleEntry<String, Integer>("y", Integer.valueOf(y))
        );
    }

    public void setCoord(int _x, int _y)
    {
        if (x > -1 && x < 12)
        {
            this.x = _x;
            this.y = _y;
        }
    }
}
