package vue;

import controller.Animation;
import controller.Deplacement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fenetre extends JFrame
{
    //Partie singleton :
    private static Fenetre fenetre;

    //Preparation de la taille :
    public static Dimension TAILLE;

    //Definition des jpanel :
    private static FenetreJeu jeu;
    private static FenetreScore score;

    //Definition des animations :
    private static Animation animation;

    //Definition des déplacements :
    private static Deplacement deplacement;

    private Fenetre()
    {
        //Definition de la fenetre :
        this.setTitle("PacMan made by Loïc, designed by Enzo");
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Definition de la taille :
        TAILLE = new Dimension();
        TAILLE.setSize(this.getSize().width, (double) this.getSize().height);

        //Definition des jpanel :
        jeu = new FenetreJeu(TAILLE.getWidth() * 0.60, TAILLE.getHeight(), (double) 0);
        score = new FenetreScore(TAILLE.getWidth() * 0.40, TAILLE.getHeight(), TAILLE.getWidth() * 0.70);

        //Ajout des jpanel à la fenetre :
        this.add(jeu);
        this.add(score);

        //Definition des animations :
        animation = Animation.getInstance();

        //Definition des deplacements :
        deplacement = Deplacement.getInstance();

        //Ajout des touches sur la fenetre :
        addKeyListener(deplacement);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e)
            {
                requestFocus();
            }
        });
    }

    public static Fenetre getInstance()
    {
        if (fenetre == null)
        {
            fenetre = new Fenetre();
        }

        return fenetre;
    }

    public void repaintFenetre()
    {
        repaint();
    }
}
