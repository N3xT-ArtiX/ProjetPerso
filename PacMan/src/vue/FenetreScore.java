package vue;

import model.GameData;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FenetreScore extends JPanel
{
    //Preparation de la taille :
    public static Dimension TAILLE;
    public static Double relativePositionX;

    //Definition de la police :
    Font titleFont;
    Font scoringFont;

    public FenetreScore(Double x, Double y, Double pos)
    {
        TAILLE = new Dimension();
        TAILLE.setSize(x, y);
        relativePositionX = pos;
        this.setSize(TAILLE);
        this.setLocation((int)Math.round(pos), 0);
        this.setBackground(Color.BLACK);

        //Definition des polices personnalisé :
        try
        {
            titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("./typo/Kallisto_Medium.otf")).deriveFont(50f);
            scoringFont = Font.createFont(Font.TRUETYPE_FONT, new File("./typo/Kallisto_Heavy.otf")).deriveFont(60f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(titleFont);
            ge.registerFont(scoringFont);
        }
        catch (IOException | FontFormatException e)
        {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        drawTitreScore(g);
        drawScore(g);
        drawLive(g);
        drawLevel(g);
    }

    private void drawTitreScore(Graphics g)
    {
        g.setFont(titleFont);
        g.setColor(Color.decode("#6536F9"));
        g.drawString("Score :", relativePositionX.intValue(), 150);
    }

    private void drawScore(Graphics g)
    {
        g.setFont(scoringFont);
        g.setColor(Color.decode("#F7D300"));
        int score = GameData.getInstance().getPoint();
        g.drawString(String.valueOf(score), relativePositionX.intValue(), 200);
    }

    private void drawLive(Graphics g)
    {
        g.setFont(titleFont);
        g.setColor(Color.decode("#6536F9"));
        g.drawString("Vie :", relativePositionX.intValue(), 380);

        int live = GameData.getInstance().getPacMan().getLive();

        for (int i = 0 ; i < live ; i++)
        {
            if (i > 10)
            {
                break;
            }

            g.drawImage(FenetreJeu.PACMAN_OUVERT_NORMAL, relativePositionX.intValue() + (((int) FenetreJeu.TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X) * i) + (10 * i), 400, ((int) FenetreJeu.TAILLE_PLATEAU.getWidth() / GameData.NBR_CASE_X), ((int) FenetreJeu.TAILLE_PLATEAU.getHeight() / GameData.NBR_CASE_Y), null);
        }
    }

    private void drawLevel(Graphics g)
    {
        g.setFont(titleFont);
        g.setColor(Color.decode("#6536F9"));
        g.drawString("Niveau :", relativePositionX.intValue(), 580);

        g.setFont(scoringFont);
        g.setColor(Color.decode("#F7D300"));
        int niveau = GameData.getInstance().getPlateau().getNiveau();
        g.drawString(String.valueOf(niveau), relativePositionX.intValue(), 630);
    }
}
