package controller;

import model.GameData;
import model.Ghost;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Deplacement implements KeyListener
{
    //Partie singleton :
    private static Deplacement deplacement;

    //Compteur de lancement :
    private int compt;
    private int comptFastMode;
    private int activeGhost;

    private Deplacement()
    {
        ActionListener taskPerformer = evt -> {
            //Compter le temps avant de respawn un ghost :
            for ( Ghost ghst : GameData.getInstance().getGhost())
            {
                if(ghst.isDead())
                {
                    if (ghst.getDead() != 200)
                    {
                        ghst.addDead();
                    }
                    else
                    {
                        ghst.setDead(false);
                        ghst.resetDead();
                    }
                }
            }

            //Faire bouger pacman toute les 10 itérations de 50ms :
            if (compt == 9)
            {
                deplacementPersonnage(false);
                compt = 0;
            }
            else
            {
                compt++;
            }

            //Faire bouger l'animation de pacman toute les 5 itération de 50ms en non fast mode :
            if (!GameData.getInstance().getPacMan().isFastMode())
            {
                if (compt % 5 == 0)
                {
                    Animation.getInstance().animerPacMan();
                }
            }
            else
            {
                //Désactiver le fast mode après 160 itération de 50 ms (8s) :
                if (comptFastMode == 160)
                {
                    GameData.getInstance().getPacMan().setSlowMode();
                    resetTimeFastMode();
                }

                //Faire bouger l'animation de pacman toute les 3 itération de 50ms en fast mode :
                if (compt % 3 == 0)
                {
                    Animation.getInstance().animerPacMan();
                }

                //Effectuer un deuxième mouvement de pacman, permettant de doubler la capacité de mouvement de pacman :
                if (compt == 5)
                {
                    deplacementPersonnage(true);
                }

                comptFastMode++;
            }

            if (activeGhost == 150)
            {
                GameData.getInstance().setGhostActive(true);
            }
            else
            {
                activeGhost++;
            }
        };

        compt = 0;
        comptFastMode = 0;
        activeGhost = 0;

        int delay = 50;
        new Timer(delay, taskPerformer).start();
    }

    public static Deplacement getInstance()
    {
        if (deplacement == null)
        {
            deplacement = new Deplacement();
        }

        return deplacement;
    }

    public void resetTimeFastMode()
    {
        comptFastMode = 0;
    }

    private void deplacementPersonnage(boolean fast)
    {
        GameData.getInstance().getPlateau().deplacementPersonnage(fast);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D ->
                    // Droite
                    GameData.getInstance().getPacMan().setNextMove("D");
            case KeyEvent.VK_LEFT, KeyEvent.VK_Q ->
                    // Gauche
                    GameData.getInstance().getPacMan().setNextMove("G");
            case KeyEvent.VK_DOWN, KeyEvent.VK_S ->
                    //Haut
                    GameData.getInstance().getPacMan().setNextMove("B");
            case KeyEvent.VK_UP, KeyEvent.VK_Z ->
                    //Bas
                    GameData.getInstance().getPacMan().setNextMove("H");
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
