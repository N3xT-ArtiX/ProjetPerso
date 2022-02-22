package model;

public class Position
{
    private int x;
    private int y;

    public Position(int _x, int _y)
    {
        x = _x;
        y = _y;
    }

    public Position(double _x, double _y)
    {
        x = (int)_x;
        y = (int)_y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int _x)
    {
        x = _x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int _y)
    {
        y = _y;
    }

    public void setPosition(int _x, int _y)
    {
        this.setX(_x);
        this.setY(_y);
    }
}
