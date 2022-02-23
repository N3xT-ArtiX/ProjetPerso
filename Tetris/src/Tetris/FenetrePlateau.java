package Tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import DonneeTetris.ActualBloc;
import DonneeTetris.TableauTetris;

public class FenetrePlateau extends JPanel
{
	private static final long serialVersionUID = 1L;

	public static final Color ORANGE = new Color(255, 102, 0);
	public static final Color MAUVE = new Color(102, 0, 153);	
	
	private static Dimension TAILLE;
	private static Double TAILLE_CASE;
	public static Double TAILLE_CASE_REEL;
	
	private Double largeurTableau;
	private Double hauteurTableau;
	private Double resteDroit;
	private Double resteHaut;
	
	public FenetrePlateau(Double x, Double y, Double pos)
	{
		TAILLE = new Dimension();
		TAILLE.setSize(x, y);
		this.setSize(TAILLE);
		this.setLocation((int)Math.round(pos), 0);
		this.setBackground(Color.GRAY);
		
		//Taille case = hauteur / 22
		
		TAILLE_CASE = TAILLE.getHeight() / 22;
		TAILLE_CASE_REEL = (double) Math.round(TAILLE_CASE);
		
		largeurTableau = TAILLE_CASE_REEL * 10;
		hauteurTableau = TAILLE_CASE_REEL * 20;
		resteDroit = (TAILLE.getWidth() - largeurTableau) / 2;
		resteHaut = (TAILLE.getHeight() - hauteurTableau) / 2;
		
		ActualBloc.getInstance().creerBloc();
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//Dessin du cadre de jeu
		
		g.setColor(Color.BLUE);
		g.drawRect((int)Math.round(resteDroit), (int)Math.round(resteHaut), (int)Math.round(largeurTableau), (int)Math.round(hauteurTableau));
		
		g.setColor(Color.BLACK);
		g.fillRect((int)Math.round(resteDroit) + 1, (int)Math.round(resteHaut) + 1, (int)Math.round(largeurTableau) - 1, (int)Math.round(hauteurTableau) - 1);
	
		//Trais verticaux
		
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 1 ; i < 10 ; i++)
		{
			g.drawLine((int)Math.round(TAILLE_CASE_REEL * i) + (int)Math.round(resteDroit), (int)Math.round(resteHaut) + 1, (int)Math.round(TAILLE_CASE_REEL * i) + (int)Math.round(resteDroit), (int)Math.round(hauteurTableau + TAILLE_CASE_REEL) - 1);
		}
		
		//Trais horizontaux
		
		for (int i = 1 ; i < 20 ; i++)
		{
			g.drawLine((int)Math.round(resteDroit) + 1, (int)Math.round(TAILLE_CASE_REEL * i) + (int)Math.round(resteHaut), ((int)Math.round(largeurTableau) - 1) + (int)Math.round(resteDroit),  (int)Math.round(TAILLE_CASE_REEL * i) + (int)Math.round(resteHaut));
		}
		
		//Dessiner le tableau
		
		String[][] tempTab = TableauTetris.getInstance().getTableau();
		String temp;		
		
		for (int y = 1 ; y <= 20 ; y++)
		{
			for (int x = 1 ; x <= 10 ; x++)
			{
				temp = tempTab[x - 1][y - 1];
				switch(temp)
				{
					case "GREEN":
					{
						dessinerCube(x, y, g, Color.GREEN);
						break;
					}
					case "RED":
					{
						dessinerCube(x, y, g, Color.RED);
						break;
					}
					case "BLUE":
					{
						dessinerCube(x, y, g, Color.BLUE);
						break;
					}
					case "ORANGE":
					{
						dessinerCube(x, y, g, ORANGE);
						break;
					}
					case "MAUVE":
					{
						dessinerCube(x, y, g, MAUVE);
						break;
					}
					case "YELLOW":
					{
						dessinerCube(x, y, g, Color.YELLOW);
						break;
					}
					case "CYAN":
					{
						dessinerCube(x, y, g, Color.CYAN);
						break;
					}
					case "":
					{
						break;
					}
				}
			}
		}
		dessinerActualBloc(g);
	}
	
	public void nouveauTour()
	{
		if (ActualBloc.getInstance().creerBloc() == false)
		{
			if (ActualBloc.getInstance().verifFond() == false)
			{
				ActualBloc.getInstance().descente();
			}
			else
			{
				TableauTetris.getInstance().setFormeFinal();
				ActualBloc.getInstance().creerBloc();
				ActualBloc.getInstance().getInventaire().resetUse();
			}
		}
		
		TableauTetris.getInstance().verifLigne();
	}
	
	private void dessinerActualBloc(Graphics g)
	{
		ActualBloc temp = ActualBloc.getInstance();
		String couleur = temp.getCouleur();
		
		switch(couleur)
		{
			case "GREEN":
			{
				dessinerS(temp.getX(), temp.getY(), temp.getOrientation(), g);
				break;
			}
			case "RED":
			{
				dessinerZ(temp.getX(), temp.getY(), temp.getOrientation(), g);
				break;
			}
			case "BLUE":
			{
				dessinerJ(temp.getX(), temp.getY(), temp.getOrientation(), g);
				break;
			}
			case "ORANGE":
			{
				dessinerL(temp.getX(), temp.getY(), temp.getOrientation(), g);
				break;
			}
			case "MAUVE":
			{
				dessinerT(temp.getX(), temp.getY(), temp.getOrientation(), g);
				break;
			}
			case "YELLOW":
			{
				dessinerCarre(temp.getX(), temp.getY(), g);
				break;
			}
			case "CYAN":
			{
				dessinerBarre(temp.getX(), temp.getY(), temp.getOrientation(), g);
				break;
			}
		}
	}
	
	private void dessinerT(int x, int y, String orientation ,Graphics g)
	{
		g.setColor(MAUVE);
		dessinerCube(x, y, g);
		switch(orientation)
		{
			case "NORTH":
			{
				dessinerCube(x, y - 1, g);
				dessinerCube(x + 1, y, g);
				dessinerCube(x - 1, y, g);
				break;
			}
			case "SOUTH":
			{
				dessinerCube(x, y + 1, g);
				dessinerCube(x + 1, y, g);
				dessinerCube(x - 1, y, g);
				break;
			}
			case "WEST":
			{
				dessinerCube(x - 1, y, g);
				dessinerCube(x, y + 1, g);
				dessinerCube(x, y - 1, g);
				break;
			}
			case "EST":
			{
				dessinerCube(x + 1, y, g);
				dessinerCube(x, y + 1, g);
				dessinerCube(x, y - 1, g);
				break;
			}
		}
		
	}
	
	private void dessinerBarre(int x, int y, String orientation, Graphics g)
	{
		g.setColor(Color.CYAN);
		dessinerCube(x, y, g);
		switch(orientation)
		{
			case "PIC":
			{
				dessinerCube(x, y - 1, g);
				dessinerCube(x, y - 2, g);
				dessinerCube(x, y - 3, g);
				break;
			}
			case "COUCH":
			{
				dessinerCube(x + 1, y, g);
				dessinerCube(x + 2, y, g);
				dessinerCube(x + 3, y, g);
				break;
			}

		}
	}
	
	private void dessinerL(int x, int y, String orientation, Graphics g)
	{
		g.setColor(ORANGE);
		dessinerCube(x, y, g);
		switch(orientation)
		{
			case "NORTH":
			{
				dessinerCube(x, y - 1, g);
				dessinerCube(x, y - 2, g);
				dessinerCube(x + 1, y, g);
				break;
			}
			case "SOUTH":
			{
				dessinerCube(x, y + 1, g);
				dessinerCube(x, y + 2, g);
				dessinerCube(x - 1, y, g);
				break;
			}
			case "WEST":
			{
				dessinerCube(x - 1, y, g);
				dessinerCube(x - 2, y, g);
				dessinerCube(x, y - 1, g);
				break;
			}
			case "EST":
			{
				dessinerCube(x + 1, y, g);
				dessinerCube(x + 2, y, g);
				dessinerCube(x, y + 1, g);
				break;
			}
		}
	}
	
	private void dessinerJ(int x, int y, String orientation, Graphics g)
	{
		g.setColor(Color.BLUE);
		dessinerCube(x, y, g);
		switch(orientation)
		{
			case "NORTH":
			{
				dessinerCube(x, y - 1, g);
				dessinerCube(x, y - 2, g);
				dessinerCube(x - 1, y, g);
				break;
			}
			case "SOUTH":
			{
				dessinerCube(x, y + 1, g);
				dessinerCube(x, y + 2, g);
				dessinerCube(x + 1, y, g);
				break;
			}
			case "WEST":
			{
				dessinerCube(x - 1, y, g);
				dessinerCube(x - 2, y, g);
				dessinerCube(x, y + 1, g);
				break;
			}
			case "EST":
			{
				dessinerCube(x + 1, y, g);
				dessinerCube(x + 2, y, g);
				dessinerCube(x, y - 1, g);
				break;
			}
		}
	}
	
	private void dessinerZ(int x, int y, String orientation, Graphics g)
	{
		g.setColor(Color.RED);
		dessinerCube(x, y, g);
		switch(orientation)
		{
			case "NORTH":
			{
				dessinerCube(x , y - 1, g);
				dessinerCube(x + 1, y - 1, g);
				dessinerCube(x + 1, y - 2, g);
				break;
			}
			case "EST":
			{
				dessinerCube(x + 1, y, g);
				dessinerCube(x + 1, y + 1, g);
				dessinerCube(x + 2, y + 1, g);
				break;
			}
		}
	}
	
	private void dessinerS(int x, int y, String orientation, Graphics g)
	{
		g.setColor(Color.GREEN);
		dessinerCube(x, y, g);
		switch(orientation)
		{
			case "NORTH":
			{
				dessinerCube(x , y - 1, g);
				dessinerCube(x - 1, y - 1, g);
				dessinerCube(x - 1, y - 2, g);
				break;
			}
			case "EST":
			{
				dessinerCube(x + 1, y, g);
				dessinerCube(x + 1, y - 1, g);
				dessinerCube(x + 2, y - 1, g);
				break;
			}
		}
	}
	
	private void dessinerCarre(int x, int y, Graphics g)
	{
		g.setColor(Color.YELLOW);
		dessinerCube(x, y, g);
		dessinerCube(x, y - 1, g);
		dessinerCube(x + 1, y - 1, g);
		dessinerCube(x + 1, y, g);
	}
	
	private void dessinerCube(int x, int y, Graphics g)
	{
		x--;
		y--;
		g.fillRect((int)Math.round(resteDroit) + (int)Math.round(x * TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut) + (int)Math.round(y * TAILLE_CASE_REEL) + 1, (int)Math.round(TAILLE_CASE_REEL) - 1, (int)Math.round(TAILLE_CASE_REEL) - 1);
	}
	
	private void dessinerCube(int x, int y, Graphics g, Color color)
	{
		g.setColor(color);
		x--;
		y--;
		g.fillRect((int)Math.round(resteDroit) + (int)Math.round(x * TAILLE_CASE_REEL) + 1, (int)Math.round(resteHaut) + (int)Math.round(y * TAILLE_CASE_REEL) + 1, (int)Math.round(TAILLE_CASE_REEL) - 1, (int)Math.round(TAILLE_CASE_REEL) - 1);
	}
}
