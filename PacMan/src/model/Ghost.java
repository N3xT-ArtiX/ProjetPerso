package model;

public class Ghost extends Personnage
{
    //Type de fantome :
    private String type;
    private Historique histo;

    //Temps de mort :
    private int dead = 0;

    public Ghost(Position _position, int _type)
    {
        super(_position, 3);

        switch (_type)
        {
            case 0 -> {
                type = "Red";
                histo = new Historique();
            }
            case 1 -> type = "Pink";
            case 2 -> type = "Blue";
            case 3 -> type = "Orange";
            default -> System.out.println("Problème dans la couleur du model.Ghost");
        }
    }

    public String getType()
    {
        return type;
    }

    public Position getNextPosition()
    {
        return histo.getNextPosition();
    }

    public void addLastPosition(Position _pos)
    {
        histo.addLastPosition(_pos);
    }

    public void resteHistorique()
    {
        histo.resetHistorique();
    }

    public int getDead()
    {
        return dead;
    }

    public void addDead()
    {
        dead++;
    }

    public void resetDead()
    {
        dead = 0;
    }
}
