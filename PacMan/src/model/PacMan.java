package model;

public class PacMan extends Personnage
{
    //Vie :
    private int live;

    //Prochain déplacement voulu
    private String nextMove;

    //Etat animation :
    private boolean ouvert;

    //Mode grosFruit :
    private boolean fastMode;

    public PacMan(Position _position, int _speed, int _live)
    {
        super(_position, _speed);
        live = _live;
        nextMove = "A";
        ouvert = false;
        fastMode = false;
    }

    public String getNextMove()
    {
        return nextMove;
    }

    public void setNextMove(String _nextMove)
    {
        nextMove = _nextMove;
    }

    public boolean isOuvert()
    {
        return ouvert;
    }

    public void setOuvert()
    {
        ouvert = !ouvert;
    }

    public boolean isFastMode()
    {
        return fastMode;
    }

    public void setSlowMode()
    {
        fastMode = false;
    }

    public void setFastMode()
    {
        fastMode = true;
    }

    public int getLive()
    {
        return live;
    }

    public void addLive()
    {
        live++;
    }

    public void removeLive()
    {
        live--;
    }
}
