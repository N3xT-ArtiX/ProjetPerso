package Tetris;

import DonneeTetris.ActualBloc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;

public class Fenetre extends JFrame implements KeyListener
{
	@Serial
	private static final long serialVersionUID = 1L;

	public static Dimension TAILLE;

	private FenetreInventaire affichageInventaire = null;
	private FenetrePlateau affichagePlateau = null;
	private FenetreSuiteBlock affichageSuiteBlock = null;

	public Fenetre()
	{
		this.setTitle("Tetris Game");
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TAILLE = new Dimension();
		TAILLE.setSize(this.getSize().width, (double) this.getSize().height);

		affichageInventaire = new FenetreInventaire((TAILLE.getWidth() / 20) * 2, TAILLE.getHeight(), (double) 0);
		affichagePlateau = new FenetrePlateau((TAILLE.getWidth() / 20) * 16, TAILLE.getHeight(), (TAILLE.getWidth() / 20) * 2);
		affichageSuiteBlock = new FenetreSuiteBlock((TAILLE.getWidth() / 20) * 2, TAILLE.getHeight(), (TAILLE.getWidth() / 20) * 18);
		
		this.add(affichageInventaire);
		this.add(affichagePlateau);
		this.add(affichageSuiteBlock);
		
		addKeyListener(this);
		
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e)
			{ 
				requestFocus();	
			}
		});
		
		ActionListener taskPerformer = evt -> {
		   cycle();
		   repaint();
		};

		int delay = 500;
		new Timer(delay, taskPerformer).start();
	}
	
	private void cycle()
	{
		//AVANCEMENT DESCENTE
		affichagePlateau.nouveauTour();
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println("ok");
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT ->
					// Droite
					ActualBloc.getInstance().goRight();
			case KeyEvent.VK_LEFT ->
					// Gauche
					ActualBloc.getInstance().goLeft();
			case KeyEvent.VK_CONTROL ->
					//Inventaire
					ActualBloc.getInstance().inventaireUsed();
			case KeyEvent.VK_SPACE ->
					//Rotation
					ActualBloc.getInstance().rotate();
			case KeyEvent.VK_DOWN ->
					//Descente rapide
					affichagePlateau.nouveauTour();
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		
	}
}
