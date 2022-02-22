package model;

public abstract class Personnage
{
    //model.Position du personnage
    private Position position;

    //Vitesse du personnage 3 - 6
    private final int speed;

    //Direction du personnage : "A (Aucune), N, S, D, G"
    private String direction;

    //Etat du personnage
    private boolean dead;

    public Personnage (Position _position, int _speed)
    {
        position = new Position(_position.getX(), _position.getY());
        speed = _speed;
        direction = "A";
        dead = false;
    }

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position _position)
    {
        position = _position;
    }

    public String getDirection()
    {
        return direction;
    }

    public void setDirection(String _direction)
    {
        direction = _direction;
    }

    public boolean isDead()
    {
        return dead;
    }

    public void setDead(boolean _dead)
    {
        dead = _dead;
    }
}
