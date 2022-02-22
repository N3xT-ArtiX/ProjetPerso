package model;

import java.util.ArrayList;
import java.util.Objects;

public class GameData
{
    //Taille du plateau : 777 x 999
    //Partie singleton :
    private static GameData dataGame;

    //Partie définition des infos global :
    public static int NBR_CASE_X = 21;
    public static int NBR_CASE_Y = 27;
    public static int NBR_GHOST = 4;
    public static int DEFAULT_LIVE = 3;
    public static int DEFAULT_SPEED = 3;
    public static int DEFAULT_FAST_SPEED= 3;

    //Information de la partie
    private int point;
    private int lastPoint;
    private boolean ghostActive;
    private int ghostKilledFast = 0;

    //Donnée du jeu :
    private final Plateau plateau;
    private final PacMan pacMan;
    private final ArrayList<Ghost> ghost = new ArrayList<>();

    private GameData()
    {
        //Définition du plateau :
        plateau = Plateau.getInstance();

        //Definition des points :
        point = 0;
        lastPoint = 0;
        ghostActive = false;

        //Définition du personnage :
        pacMan = new PacMan(plateau.getSpawnPacMan(), DEFAULT_SPEED, DEFAULT_LIVE);

        //Définition des ghosts :
        for (int i = 0 ; i < NBR_GHOST ; i++)
        {
            ghost.add(new Ghost(plateau.getSpawnGhost(), i));
        }

        //Reset des position possible de spawn des ghost (en cas de mort) :
        plateau.definedSpawnGhost();

        //Initialisation de la position de départ de pacman
        for (Ghost ghst : ghost)
        {
            if (Objects.equals(ghst.getType(), "Red"))
            {
                ghst.addLastPosition(pacMan.getPosition());
            }
        }
    }

    public static GameData getInstance()
    {
        if (dataGame == null)
        {
            dataGame = new GameData();
        }

        return dataGame;
    }

    public int getPoint()
    {
        return point;
    }

    public void setPoint(int _point)
    {
        point = _point;
    }

    //Pac-Dot = 10 Pts
    //Power Pellet = 50 Pts
    //1st Ghost = 200 Pts
    //2nd Ghost = 400 Pts
    //3rd Ghost = 800 Pts
    //4th Ghost = 1600 Pts
    //Cherry = 100 Pts
    //Strawberry = 300 Pts
    //Orange = 500 Pts
    //Apple = 700 Pts
    //Melon = 1000 Pts
    //Galaxian = 2000 Pts
    //Bell = 3000 Pts
    //Key = 5000 Pts

    public void addPoint(int _point)
    {
        point += _point;

        if ((point - lastPoint) - 10000 >= 0)
        {
            lastPoint += 10000;
            GameData.getInstance().getPacMan().addLive();
        }
    }

    public int getGhostKilled()
    {
        return ghostKilledFast;
    }

    public void addGhostKilled()
    {
        ghostKilledFast++;
    }

    public void resetGhostKilled()
    {
        ghostKilledFast = 0;
    }

    public Plateau getPlateau()
    {
        return plateau;
    }

    public PacMan getPacMan()
    {
        return pacMan;
    }

    public ArrayList<Ghost> getGhost()
    {
        return ghost;
    }

    public boolean isGhostActive()
    {
        return ghostActive;
    }

    public void setGhostActive(boolean _ghostActive)
    {
        ghostActive = _ghostActive;
    }
}
