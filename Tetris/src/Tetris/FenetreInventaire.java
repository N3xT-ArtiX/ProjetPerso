package Tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import DonneeTetris.ActualBloc;

public class FenetreInventaire extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private static Dimension TAILLE;
	
	private double resteDroit;

	public FenetreInventaire(Double x, Double y, Double pos)
	{
		TAILLE = new Dimension();
		TAILLE.setSize(x, y);
		this.setSize(TAILLE);
		this.setLocation((int)Math.round(pos), 0);
		this.setBackground(Color.LIGHT_GRAY);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	
		//Carre de 2 / 4
		
		double tailleTableau = (FenetrePlateau.TAILLE_CASE_REEL * 3);
		resteDroit = (TAILLE.getWidth() - tailleTableau) / 2;
		
		g.setColor(Color.BLUE);
		
		g.drawLine((int)Math.round(resteDroit), 50, (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 3) + (int)Math.round(resteDroit), 50);
		g.drawLine((int)Math.round(resteDroit), 50, (int)Math.round(resteDroit), (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 5) + 50);
		g.drawLine((int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 3) + (int)Math.round(resteDroit), 50, (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 3) + (int)Math.round(resteDroit), (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 5) + 50);
		g.drawLine((int)Math.round(resteDroit), 50 + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 5), (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 3) + (int)Math.round(resteDroit), 50 + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 5));
	
		g.setColor(Color.BLACK);
		
		g.fillRect((int)Math.round(resteDroit) + 1, 50 + 1, (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 3) - 1, (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL * 5) - 1);
		
		if (ActualBloc.getInstance().getInventaire().isVide() != true)
		{
			String couleur = ActualBloc.getInstance().getInventaire().getCouleurInventaire();
			
			switch(couleur)
			{
				case "GREEN":
				{
					dessinerS(g);
					break;
				}
				case "RED":
				{
					dessinerZ(g);
					break;
				}
				case "BLUE":
				{
					dessinerJ(g);
					break;
				}
				case "ORANGE":
				{
					dessinerL(g);
					break;
				}
				case "MAUVE":
				{
					dessinerT(g);
					break;
				}
				case "YELLOW":
				{
					dessinerCarre(g);
					break;
				}
				case "CYAN":
				{
					dessinerBarre(g);
					break;
				}
			}
		}
	}

	private void dessinerBarre(Graphics g)
	{
		double largeur = FenetrePlateau.TAILLE_CASE_REEL * 1;
		double hauteur = FenetrePlateau.TAILLE_CASE_REEL * 4;
		
		double resteHaut = (FenetrePlateau.TAILLE_CASE_REEL * 5 - hauteur) / 2; 
		double resteDroite = (FenetrePlateau.TAILLE_CASE_REEL * 3 - largeur) / 2;
		
		dessinercarre(g, Color.CYAN,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut) + 1);
		
		dessinercarre(g, Color.CYAN,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
		
		dessinercarre(g, Color.CYAN,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL * 2) + 1);
		
		dessinercarre(g, Color.CYAN,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL * 3) + 1);
	}

	private void dessinerCarre(Graphics g)
	{
		double largeur = FenetrePlateau.TAILLE_CASE_REEL * 2;
		double hauteur = FenetrePlateau.TAILLE_CASE_REEL * 2;
		
		double resteHaut = (FenetrePlateau.TAILLE_CASE_REEL * 5 - hauteur) / 2; 
		double resteDroite = (FenetrePlateau.TAILLE_CASE_REEL * 3 - largeur) / 2;
		
		dessinercarre(g, Color.YELLOW,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut) + 1);
		
		dessinercarre(g, Color.YELLOW,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
		
		dessinercarre(g, Color.YELLOW,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut) + 1);
		
		dessinercarre(g, Color.YELLOW,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
	}

	private void dessinerT(Graphics g)
	{
		double largeur = FenetrePlateau.TAILLE_CASE_REEL * 2;
		double hauteur = FenetrePlateau.TAILLE_CASE_REEL * 3;
		
		double resteHaut = (FenetrePlateau.TAILLE_CASE_REEL * 5 - hauteur) / 2; 
		double resteDroite = (FenetrePlateau.TAILLE_CASE_REEL * 3 - largeur) / 2;
		
		dessinercarre(g, FenetrePlateau.MAUVE,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut) + 1);
		
		dessinercarre(g, FenetrePlateau.MAUVE,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
		
		dessinercarre(g, FenetrePlateau.MAUVE,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL * 2) + 1);
		
		dessinercarre(g, FenetrePlateau.MAUVE,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + (FenetrePlateau.TAILLE_CASE_REEL * 1)) + 1);
	}

	private void dessinerL(Graphics g)
	{
		double largeur = FenetrePlateau.TAILLE_CASE_REEL * 2;
		double hauteur = FenetrePlateau.TAILLE_CASE_REEL * 3;
		
		double resteHaut = (FenetrePlateau.TAILLE_CASE_REEL * 5 - hauteur) / 2; 
		double resteDroite = (FenetrePlateau.TAILLE_CASE_REEL * 3 - largeur) / 2;
		
		dessinercarre(g, FenetrePlateau.ORANGE,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut) + 1);
		
		dessinercarre(g, FenetrePlateau.ORANGE,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
		
		dessinercarre(g, FenetrePlateau.ORANGE,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL * 2) + 1);
		
		dessinercarre(g, FenetrePlateau.ORANGE,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut + (FenetrePlateau.TAILLE_CASE_REEL * 2)) + 1);
	}

	private void dessinerJ(Graphics g)
	{
		double largeur = FenetrePlateau.TAILLE_CASE_REEL * 2;
		double hauteur = FenetrePlateau.TAILLE_CASE_REEL * 3;
		
		double resteHaut = (FenetrePlateau.TAILLE_CASE_REEL * 5 - hauteur) / 2; 
		double resteDroite = (FenetrePlateau.TAILLE_CASE_REEL * 3 - largeur) / 2;
		
		dessinercarre(g, Color.BLUE,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut) + 1);
		
		dessinercarre(g, Color.BLUE,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
		
		dessinercarre(g, Color.BLUE,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL * 2) + 1);
		
		dessinercarre(g, Color.BLUE,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + (FenetrePlateau.TAILLE_CASE_REEL * 2)) + 1);
	}

	private void dessinerZ(Graphics g)
	{
		double largeur = FenetrePlateau.TAILLE_CASE_REEL * 2;
		double hauteur = FenetrePlateau.TAILLE_CASE_REEL * 3;
		
		double resteHaut = (FenetrePlateau.TAILLE_CASE_REEL * 5 - hauteur) / 2; 
		double resteDroite = (FenetrePlateau.TAILLE_CASE_REEL * 3 - largeur) / 2;
		
		dessinercarre(g, Color.RED,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut) + 1);
		
		dessinercarre(g, Color.RED,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
		
		dessinercarre(g, Color.RED,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
		
		dessinercarre(g, Color.RED,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + (FenetrePlateau.TAILLE_CASE_REEL * 2)) + 1);
	}

	private void dessinerS(Graphics g)
	{
		double largeur = FenetrePlateau.TAILLE_CASE_REEL * 2;
		double hauteur = FenetrePlateau.TAILLE_CASE_REEL * 3;
		
		double resteHaut = (FenetrePlateau.TAILLE_CASE_REEL * 5 - hauteur) / 2; 
		double resteDroite = (FenetrePlateau.TAILLE_CASE_REEL * 3 - largeur) / 2;
		
		dessinercarre(g, Color.GREEN,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut) + 1);
		
		dessinercarre(g, Color.GREEN,(int)Math.round(resteDroite) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
		
		dessinercarre(g, Color.GREEN,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut + FenetrePlateau.TAILLE_CASE_REEL) + 1);
		
		dessinercarre(g, Color.GREEN,(int)Math.round(resteDroite) + (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut + (FenetrePlateau.TAILLE_CASE_REEL * 2)) + 1);
	}

	private void dessinercarre(Graphics g, Color couleur, int x, int y)
	{
		int width = (int)Math.round(FenetrePlateau.TAILLE_CASE_REEL) - 1;
		
		g.setColor(couleur);
		g.fillRect((int)Math.round(resteDroit + x), 50 + y, width, width);
		
		g.setColor(Color.WHITE);
		g.drawRect((int)Math.round(resteDroit + x) - 1, 50 + y - 1, width + 1, width + 1);
	}
}
