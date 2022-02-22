package model;

import java.util.LinkedList;
import java.util.Queue;

public class Historique
{
    private final Queue<Position> queuePos;
    private Position last;

    public Historique()
    {
        queuePos = new LinkedList<>();
    }

    public Position getNextPosition()
    {
        if (queuePos.size() > 0)
        {
            return queuePos.remove();
        }
        else
        {
            return null;
        }
    }

    public void addLastPosition(Position _pos)
    {
        if (last == null)
        {
            queuePos.add(new Position(_pos.getX(), _pos.getY()));
            last = new Position(_pos.getX(), _pos.getY());
        }
        else if (!(last.getX() == _pos.getX() && last.getY() == _pos.getY()))
        {
            queuePos.add(new Position(_pos.getX(), _pos.getY()));
            last.setPosition(_pos.getX(), _pos.getY());
        }
    }

    public void resetHistorique()
    {
        queuePos.clear();
    }
}
