package vue;

import model.GameData;
import model.Ghost;
import model.Position;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FenetreJeu extends JPanel
{
    //Preparation de la taille :
    public static Dimension TAILLE;
    public static Dimension TAILLE_PLATEAU;
    public static Position POS_RELATIF_PLATEAU;

    //Image virage :
    public static BufferedImage COIN_HAUT_DROIT;
    public static BufferedImage COIN_HAUT_GAUCHE;
    public static BufferedImage COIN_BAS_GAUCHE;
    public static BufferedImage COIN_BAS_DROIT;

    //Image ligne
    public static BufferedImage MUR_HORIZONTAL;
    public static BufferedImage MUR_VERTICAL;

    //Image bout :
    public static BufferedImage BOUT_HAUT;
    public static BufferedImage BOUT_BAS;
    public static BufferedImage BOUT_DROITE;
    public static BufferedImage BOUT_GAUCHE;

    //Image T :
    public static BufferedImage T_HAUT;
    public static BufferedImage T_BAS;
    public static BufferedImage T_DROITE;
    public static BufferedImage T_GAUCHE;

    //Image PacMan (2 version) :
    public static BufferedImage PACMAN_OUVERT_NORMAL;
    public static BufferedImage PACMAN_FERME_NORMAL;

    public static BufferedImage PACMAN_OUVERT_FAST;
    public static BufferedImage PACMAN_FERME_FAST;

    //Image ghost :
    public static BufferedImage GHOST_PINK;
    public static BufferedImage GHOST_RED;
    public static BufferedImage GHOST_BLUE;
    public static BufferedImage GHOST_ORANGE;

    public FenetreJeu(Double x, Double y, Double pos)
    {
        TAILLE = new Dimension();
        TAILLE.setSize(x, y);
        this.setSize(TAILLE);
        this.setLocation((int)Math.round(pos), 0);
        this.setBackground(Color.BLACK);

        //Definition taille plateau :
        TAILLE_PLATEAU = new Dimension();
        TAILLE_PLATEAU.setSize(777, 999);

        //Definition position relative :
        POS_RELATIF_PLATEAU = new Position(((TAILLE.getWidth()) - TAILLE_PLATEAU.getWidth()) / 2, ((TAILLE.getHeight()) - TAILLE_PLATEAU.getHeight()) / 2);

        //Definition des images :
        try
        {
            COIN_HAUT_DROIT = ImageIO.read(new File("./img/VIRAGE_GB.png"));
            COIN_HAUT_GAUCHE = ImageIO.read(new File("./img/VIRAGE_DB.png"));
            COIN_BAS_GAUCHE = ImageIO.read(new File("./img/VIRAGE_HB.png"));
            COIN_BAS_DROIT = ImageIO.read(new File("./img/VIRAGE_DH.png"));

            MUR_HORIZONTAL = ImageIO.read(new File("./img/ROUTE_GD.png"));
            MUR_VERTICAL = ImageIO.read(new File("./img/ROUTE_HB.png"));

            BOUT_HAUT = ImageIO.read(new File("./img/FIN_B.png"));
            BOUT_BAS = ImageIO.read(new File("./img/FIN_H.png"));
            BOUT_DROITE = ImageIO.read(new File("./img/FIN_G.png"));
            BOUT_GAUCHE = ImageIO.read(new File("./img/FIN_D.png"));

            T_HAUT = ImageIO.read(new File("./img/ROUTE_GHD.png"));
            T_BAS = ImageIO.read(new File("./img/ROUTE_GBD.png"));
            T_DROITE = ImageIO.read(new File("./img/ROUTE_HGB.png"));
            T_GAUCHE = ImageIO.read(new File("./img/ROUTE_GHB.png"));

            PACMAN_OUVERT_NORMAL = ImageIO.read(new File("./img/PACMAN_OPEN.png"));
            PACMAN_FERME_NORMAL = ImageIO.read(new File("./img/PACMAN_CLOSE.png"));

            PACMAN_OUVERT_FAST = ImageIO.read(new File("./img/PACMAN_FAST_OPEN.png"));
            PACMAN_FERME_FAST = ImageIO.read(new File("./img/PACMAN_FAST_CLOSE.png"));

            GHOST_PINK = ImageIO.read(new File("./img/PINK_GHOST.png"));
            GHOST_RED = ImageIO.read(new File("./img/RED_GHOST.png"));
            GHOST_BLUE = ImageIO.read(new File("./img/BLUE_GHOST.png"));
            GHOST_ORANGE = ImageIO.read(new File("./img/ORANGE_GHOST.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        drawTerrain(g);
        drawPacMan(g);
        drawGhost(g);
    }

    private void drawPacMan(Graphics g)
    {
        //Recuperer la position de PacMan :
        Position posPacMan = GameData.getInstance().getPacMan().getPosition();

        //Dessiner PacMan :
        if (!GameData.getInstance().getPacMan().isFastMode())
        {
            if (GameData.getInstance().getPacMan().isOuvert())
            {
                drawImagePacMan(g, posPacMan, PACMAN_OUVERT_NORMAL);
            }
            else
            {
                drawImagePacMan(g, posPacMan, PACMAN_FERME_NORMAL);
            }
        }
        else
        {
            if (GameData.getInstance().getPacMan().isOuvert())
            {
                drawImagePacMan(g, posPacMan, PACMAN_OUVERT_FAST);
            }
            else
            {
                drawImagePacMan(g, posPacMan, PACMAN_FERME_FAST);
            }
        }
    }

    private void drawImagePacMan(Graphics g, Position posPacMan, BufferedImage pacman)
    {
        g.drawImage(pacman, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * posPacMan.getX())), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * posPacMan.getY())), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);
        GameData.getInstance().getPacMan().setOuvert();
    }

    private void drawGhost(Graphics g)
    {
        //Recuperer la liste des ghost :
        ArrayList<Ghost> ghost = GameData.getInstance().getGhost();

        //Dessiner Ghost :
        for (Ghost ghst : ghost)
        {
            switch (ghst.getType())
            {
                case "Pink" -> g.drawImage(GHOST_PINK, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * ghst.getPosition().getX())), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * ghst.getPosition().getY())), (int) TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int) TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);
                case "Red" -> g.drawImage(GHOST_RED, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * ghst.getPosition().getX())), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * ghst.getPosition().getY())), (int) TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int) TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);
                case "Blue" -> g.drawImage(GHOST_BLUE, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * ghst.getPosition().getX())), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * ghst.getPosition().getY())), (int) TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int) TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);
                case "Orange" -> g.drawImage(GHOST_ORANGE, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * ghst.getPosition().getX())), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * ghst.getPosition().getY())), (int) TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int) TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);
            }
        }
    }

    private void drawTerrain(Graphics g)
    {
        //Récupération du terrain
        int[][] terrain = GameData.getInstance().getPlateau().getPlateau();

        //On dessine le terrain
        for (int y = 0 ; y < terrain.length ; y ++)
        {
            for ( int x = 0 ; x < terrain[y].length ; x++ )
            {
                g.setColor(Color.BLACK);
                g.fillRect((int)(POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int)(POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y);

                switch (terrain[y][x])
                {
                    case -4, -3, 0 -> {}

                    case -2 -> {
                        g.setColor(Color.WHITE);
                        g.fillOval((int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x) + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) / 2)) - 10, (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y) + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) / 2)) - 10, 20, 20);
                    }

                    case -1 -> {
                        g.setColor(Color.WHITE);
                        g.fillOval((int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x) + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) / 2)) - 4, (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y) + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) / 2)) - 4, 8, 8);
                    }

                    case 1 -> g.drawImage(COIN_HAUT_DROIT, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 2 -> g.drawImage(COIN_HAUT_GAUCHE, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 3 -> g.drawImage(COIN_BAS_GAUCHE, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 4 -> g.drawImage(COIN_BAS_DROIT, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 5 -> g.drawImage(MUR_HORIZONTAL, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 6 -> g.drawImage(MUR_VERTICAL, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 7 -> g.drawImage(BOUT_BAS, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 8 -> g.drawImage(BOUT_HAUT, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 9 -> g.drawImage(BOUT_DROITE, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 10 -> g.drawImage(BOUT_GAUCHE, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 11 -> g.drawImage(T_BAS, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 12 -> g.drawImage(T_HAUT, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 13 -> g.drawImage(T_DROITE, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    case 14 -> g.drawImage(T_GAUCHE, (int) (POS_RELATIF_PLATEAU.getX() + ((TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * x)), (int) (POS_RELATIF_PLATEAU.getY() + ((TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y) * y)), (int)TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X, (int)TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y, null);

                    default -> throw new IllegalStateException("Unexpected value: " + terrain[y][x]);
                }
            }
        }
    }
}
