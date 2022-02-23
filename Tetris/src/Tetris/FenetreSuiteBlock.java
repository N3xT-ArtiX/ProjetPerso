package Tetris;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class FenetreSuiteBlock extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private static Dimension TAILLE;

	public FenetreSuiteBlock(Double x, Double y, Double pos)
	{
		TAILLE = new Dimension();
		TAILLE.setSize(x, y);
		this.setSize(TAILLE);
		this.setLocation((int)Math.round(pos), 0);
		this.setBackground(Color.LIGHT_GRAY);
	}
}
