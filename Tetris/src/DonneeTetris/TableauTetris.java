package DonneeTetris;

public class TableauTetris
{
	private static final TableauTetris instance = new TableauTetris();
	
	private String[][] tableauJeu = new String[10][20];
	
	private TableauTetris()
	{
		for (int y = 0 ; y < 20 ; y++)
		{
			for (int x = 0 ; x < 10 ; x++)
			{
				tableauJeu[x][y] = "";
			}
		}
	}
	
	public static final TableauTetris getInstance()
	{
		return instance;
	}
	
	public String[][] getTableau()
	{
		return tableauJeu;
	}
	
	public void setFormeFinal()
	{
		String couleur = ActualBloc.getInstance().getCouleur();
		
		switch(couleur)
		{
			case "GREEN":
			{
				setFormeFinalS();
				break;
			}
			case "RED":
			{
				setFormeFinalZ();
				break;
			}
			case "BLUE":
			{
				setFormeFinalJ();
				break;
			}
			case "ORANGE":
			{
				setFormeFinalL();
				break;
			}
			case "MAUVE":
			{
				setFormeFinalT();
				break;
			}
			case "YELLOW":
			{
				setFormeFinalCarre();
				break;
			}
			case "CYAN":
			{
				setFormeFinalBarre();
				break;
			}
		}
		
		ActualBloc.getInstance().stopBloc();
	}
	
	private void setFormeFinalS()
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		inscrireCube(x, y, "GREEN");
		
		switch(orientation)
		{
			case "NORTH":
			{
				inscrireCube(x, y - 1, "GREEN");
				inscrireCube(x - 1, y - 1, "GREEN");
				inscrireCube(x - 1, y - 2, "GREEN");
				break;
			}
			case "EST":
			{
				inscrireCube(x + 1, y, "GREEN");
				inscrireCube(x + 1, y - 1, "GREEN");
				inscrireCube(x + 2, y - 1, "GREEN");
				break;
			}
		}
	}
	
	private void setFormeFinalZ()
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		inscrireCube(x, y, "RED");
		
		switch(orientation)
		{
			case "NORTH":
			{
				inscrireCube(x, y - 1, "RED");
				inscrireCube(x + 1, y - 1, "RED");
				inscrireCube(x + 1, y - 2, "RED");
				break;
			}
			case "EST":
			{
				inscrireCube(x + 1, y, "RED");
				inscrireCube(x + 1, y + 1, "RED");
				inscrireCube(x + 2, y + 1, "RED");
				break;
			}
		}
	}
	
	private void setFormeFinalJ()
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		inscrireCube(x, y, "BLUE");
		
		switch(orientation)
		{
			case "NORTH":
			{
				inscrireCube(x - 1, y, "BLUE");
				inscrireCube(x, y - 1, "BLUE");
				inscrireCube(x, y - 2, "BLUE");
				break;
			}
			case "SOUTH":
			{
				inscrireCube(x + 1, y, "BLUE");
				inscrireCube(x, y + 1, "BLUE");
				inscrireCube(x, y + 2, "BLUE");
				break;
			}
			case "WEST":
			{
				inscrireCube(x, y + 1, "BLUE");
				inscrireCube(x - 1, y, "BLUE");
				inscrireCube(x - 2, y, "BLUE");
				break;
			}
			case "EST":
			{
				inscrireCube(x, y - 1, "BLUE");
				inscrireCube(x + 1, y, "BLUE");
				inscrireCube(x + 2, y, "BLUE");
				break;
			}
		}
	}
	
	private void setFormeFinalL()
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		inscrireCube(x, y, "ORANGE");
		
		switch(orientation)
		{
			case "NORTH":
			{
				inscrireCube(x + 1, y, "ORANGE");
				inscrireCube(x, y - 1, "ORANGE");
				inscrireCube(x, y - 2, "ORANGE");
				break;
			}
			case "SOUTH":
			{
				inscrireCube(x - 1, y, "ORANGE");
				inscrireCube(x, y + 1, "ORANGE");
				inscrireCube(x, y + 2, "ORANGE");
				break;
			}
			case "WEST":
			{
				inscrireCube(x, y - 1, "ORANGE");
				inscrireCube(x - 1, y, "ORANGE");
				inscrireCube(x - 2, y, "ORANGE");
				break;
			}
			case "EST":
			{
				inscrireCube(x, y + 1, "ORANGE");
				inscrireCube(x + 1, y, "ORANGE");
				inscrireCube(x + 2, y, "ORANGE");
				break;
			}
		}
	}
	
	private void setFormeFinalT()
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		inscrireCube(x, y, "MAUVE");
		
		switch(orientation)
		{
			case "NORTH":
			{
				inscrireCube(x, y - 1, "MAUVE");
				inscrireCube(x + 1, y, "MAUVE");
				inscrireCube(x - 1, y, "MAUVE");
				break;
			}
			case "SOUTH":
			{
				inscrireCube(x, y + 1, "MAUVE");
				inscrireCube(x + 1, y, "MAUVE");
				inscrireCube(x - 1, y, "MAUVE");
				break;
			}
			case "WEST":
			{
				inscrireCube(x - 1, y, "MAUVE");
				inscrireCube(x, y + 1, "MAUVE");
				inscrireCube(x, y - 1, "MAUVE");
				break;
			}
			case "EST":
			{
				inscrireCube(x + 1, y, "MAUVE");
				inscrireCube(x, y + 1, "MAUVE");
				inscrireCube(x, y - 1, "MAUVE");
				break;
			}
		}
	}
	
	private void setFormeFinalCarre()
	{
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		inscrireCube(x, y, "YELLOW");
		inscrireCube(x, y - 1, "YELLOW");
		inscrireCube(x + 1, y - 1, "YELLOW");
		inscrireCube(x + 1, y, "YELLOW");		
	}
	
	private void setFormeFinalBarre()
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		inscrireCube(x, y, "CYAN");
		
		switch(orientation)
		{
			case "PIC":
			{
				inscrireCube(x, y - 1, "CYAN");
				inscrireCube(x, y - 2, "CYAN");
				inscrireCube(x, y - 3, "CYAN");
				break;
			}
			case "COUCH":
			{
				inscrireCube(x + 1, y, "CYAN");
				inscrireCube(x + 2, y, "CYAN");
				inscrireCube(x + 3, y, "CYAN");
				break;
			}
		}
	}
	
	private void inscrireCube(int x, int y, String couleur)
	{
		x--;
		y--;
		
		tableauJeu[x][y] = couleur;
	}
	
	public boolean verifLigne()
	{
		int ligne = 0;
		for (int y = 0 ; y < 20 ; y++)
		{
			for (int x = 0 ; x < 10 ; x++)
			{
				if (tableauJeu[x][y] != "")
				{
					ligne++;
				}
			}
			if (ligne == 10)
			{
				detruireLigne(y);
			}
			
			ligne = 0;
		}
		return false;
	}

	private void detruireLigne(int i)
	{
		for (int y = i ; y > 0 ; y--)
		{
			for (int x = 0 ; x < 10 ; x++)
			{
				tableauJeu[x][y] = tableauJeu[x][y - 1];
			}
		}
	}
}
