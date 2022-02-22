package model;

import java.util.HashMap;

public class PositionBlock
{
    private HashMap<Integer, Coords> position;

    public PositionBlock(Coords zero, Coords un, Coords deux, Coords trois)
    {
        position.put(0, zero);
        position.put(1, un);
        position.put(2, deux);
        position.put(3, trois);
    }

    public HashMap<Integer, Coords> getPosition()
    {
        return position;
    }

    public void setPosition(int pos, int x, int y)
    {
        if (pos > 0 && pos < 4)
        {
            position.get(pos).setCoord(x, y);
        }
    }
}
