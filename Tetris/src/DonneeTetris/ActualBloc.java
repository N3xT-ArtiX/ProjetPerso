package DonneeTetris;

public class ActualBloc
{
	private static final ActualBloc instance = new ActualBloc();
	
	String couleur;
	String orientation;
	int x;
	int y;
	boolean actif = false;
	Inventaire inv = new Inventaire();
	
	private ActualBloc()
	{
		
	}
	
	public static final ActualBloc getInstance()
	{
		return instance;
	}
	
	public String getCouleur()
	{
		return couleur;
	}
	
	public String getOrientation()
	{
		return orientation;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	private void newBlock()
	{
		int rand = 1 + (int)(Math.random() * ((7 - 1) + 1));
		actif = true;
		switch(rand)
		{
			case 1:
			{
				couleur = "CYAN";
				orientation = "PIC";
				x = 5 + (int)(Math.random() * ((6 - 5) + 1));
				y = 4;
				break;
			}
			case 2:
			{
				couleur = "YELLOW";
				orientation = "";
				x = 5;
				y = 2;
				break;
			}
			case 3:
			{
				couleur = "MAUVE";
				orientation = "NORTH";
				x = 5 + (int)(Math.random() * ((6 - 5) + 1));
				y = 2;
				break;
			}
			case 4:
			{
				couleur = "ORANGE";
				orientation = "NORTH";
				x = 6;
				y = 3;
				break;
			}
			case 5:
			{
				couleur = "BLUE";
				orientation = "NORTH";
				x = 5;
				y = 3;
				break;
			}
			case 6:
			{
				couleur = "RED";
				orientation = "EST";
				x = 4 + (int)(Math.random() * ((5 - 4) + 1));
				y = 1;
				break;
			}
			case 7:
			{
				couleur = "GREEN";
				orientation = "EST";
				x = 4 + (int)(Math.random() * ((5 - 4) + 1));
				y = 2;
				break;
			}
		}
	}
	
	private void setBlockInventaire(String block)
	{
		switch(block)
		{
			case "CYAN":
			{
				couleur = "CYAN";
				orientation = "PIC";
				x = 5 + (int)(Math.random() * ((6 - 5) + 1));
				y = 4;
				break;
			}
			case "YELLOW":
			{
				couleur = "YELLOW";
				orientation = "";
				x = 5;
				y = 2;
				break;
			}
			case "MAUVE":
			{
				couleur = "MAUVE";
				orientation = "NORTH";
				x = 5 + (int)(Math.random() * ((6 - 5) + 1));
				y = 2;
				break;
			}
			case "ORANGE":
			{
				couleur = "ORANGE";
				orientation = "NORTH";
				x = 6;
				y = 3;
				break;
			}
			case "BLUE":
			{
				couleur = "BLUE";
				orientation = "NORTH";
				x = 5;
				y = 3;
				break;
			}
			case "RED":
			{
				couleur = "RED";
				orientation = "EST";
				x = 4 + (int)(Math.random() * ((5 - 4) + 1));
				y = 1;
				break;
			}
			case "GREEN":
			{
				couleur = "GREEN";
				orientation = "EST";
				x = 4 + (int)(Math.random() * ((5 - 4) + 1));
				y = 2;
				break;
			}
		}
		
		System.out.println(couleur);
	}
	
	public boolean creerBloc()
	{
		if (actif == false)
		{
			newBlock();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void descente()
	{
		y++;
	}
	
	public void stopBloc()
	{
		actif = false;
	}
	
	public boolean verifFond()
	{
		String[][] tempTab = TableauTetris.getInstance().getTableau();
		
		String couleur = ActualBloc.getInstance().getCouleur();
		
		switch(couleur)
		{
			case "GREEN":
			{
				return verifS(tempTab);
			}
			case "RED":
			{
				return verifZ(tempTab);
			}
			case "BLUE":
			{
				return verifJ(tempTab);
			}
			case "ORANGE":
			{
				return verifL(tempTab);
			}
			case "MAUVE":
			{
				return verifT(tempTab);
			}
			case "YELLOW":
			{
				return verifCarre(tempTab);
			}
			case "CYAN":
			{
				return verifBarre(tempTab);
			}
		}
		
		return false;
	}
	
	public boolean verifS(String[][] tab)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		switch(orientation)
		{
			case "NORTH":
			{
				if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x - 1, y) == false)
				{
					return true;
				}
				break;
			}
			case "EST":
			{
				if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x + 1, y + 1) == false || verifBehind(tab, x + 2, y) == false)
				{
					return true;
				}
				break;
			}
		}
		return false;
	}
	
	public boolean verifZ(String[][] tab)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		switch(orientation)
		{
			case "NORTH":
			{
				if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x + 1, y) == false)
				{
					return true;
				}
				break;
			}
			case "EST":
			{
				if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x + 1, y + 2) == false || verifBehind(tab, x + 2, y + 2) == false)
				{
					return true;
				}
				break;
			}
		}
		return false;
	}
	
	public boolean verifJ(String[][] tab)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		switch(orientation)
		{
			case "NORTH":
			{
				if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x - 1, y + 1) == false)
				{
					return true;
				}
				break;
			}
			case "SOUTH":
			{
				if (verifBehind(tab, x + 1, y + 1) == false || verifBehind(tab, x, y + 3) == false)
				{
					return true;
				}
				break;
			}
			case "WEST":
			{
				if (verifBehind(tab, x, y + 2) == false || verifBehind(tab, x - 1, y + 1) == false || verifBehind(tab, x - 2, y + 1) == false)
				{
					return true;
				}
				break;
			}
			case "EST":
			{
				if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x + 1, y + 1) == false || verifBehind(tab, x + 2, y + 1) == false)
				{
					return true;
				}
				break;
			}
		}
		return false;
	}
	
	public boolean verifL(String[][] tab)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		switch(orientation)
		{
			case "NORTH":
			{
				if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x + 1, y + 1) == false)
				{
					return true;
				}
				break;
			}
			case "SOUTH":
			{
				if (verifBehind(tab, x - 1, y + 1) == false || verifBehind(tab, x, y + 3) == false)
				{
					return true;
				}
				break;
			}
			case "WEST":
			{
				if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x - 1, y + 1) == false || verifBehind(tab, x - 2, y + 1) == false)
				{
					return true;
				}
				break;
			}
			case "EST":
			{
				if (verifBehind(tab, x, y + 2) == false || verifBehind(tab, x + 1, y + 1) == false || verifBehind(tab, x + 2, y + 1) == false)
				{
					return true;
				}
				break;
			}
		}
		return false;
	}
	
	public boolean verifT(String[][] tab)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		switch(orientation)
		{
			case "NORTH":
			{
				if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x + 1, y + 1) == false || verifBehind(tab, x - 1, y + 1) == false)
				{
					return true;
				}
				break;
			}
			case "SOUTH":
			{
				if (verifBehind(tab, x, y + 2) == false || verifBehind(tab, x + 1, y + 1) == false || verifBehind(tab, x - 1, y + 1) == false)
				{
					return true;
				}
				break;
			}
			case "WEST":
			{
				if (verifBehind(tab, x, y + 2) == false || verifBehind(tab, x - 1, y + 1) == false)
				{
					return true;
				}
				break;
			}
			case "EST":
			{
				if (verifBehind(tab, x, y + 2) == false || verifBehind(tab, x + 1, y + 1) == false)
				{
					return true;
				}
				break;
			}
		}
		return false;
	}
	
	public boolean verifCarre(String[][] tab)
	{
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		if (verifBehind(tab, x, y + 1) == false || verifBehind(tab, x + 1, y + 1) == false)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean verifBarre(String[][] tab)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		switch(orientation)
		{
			case "PIC":
			{
				if ((verifBehind(tab, x, y + 1)) == false)
				{
					return true;
				}
				break;
			}
			case "COUCH":
			{
				if ((verifBehind(tab, x, y + 1) || verifBehind(tab, x + 1, y + 1) || verifBehind(tab, x + 2, y + 1) || verifBehind(tab, x + 3, y + 1)) == false)
				{
					return true;
				}
				break;
			}
		}
		return false;
	}
	
	private boolean verifBehind(String[][] tab, int x, int y)
	{
		x--;
		y--;
		
		//System.out.println(y);
		
		if (y == 20)
		{
			return false;
		}
		
		if (tab[x][y] != "")
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	private boolean verifLeftRight(String[][] tab, int x, int y)
	{
		x--;
		y--;
		
		if (tab[x][y] != "")
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	public void goRight()
	{
		if (this.verifDeplacement("Right") == true)
		{
			System.out.println(this.verifDeplacement("Right"));
			if (x + 1 < 11)
			{
				x++;
			}
		}
	}
	
	public void goLeft()
	{
		if (this.verifDeplacement("Left") == true)
		{
			System.out.println(this.verifDeplacement("Left"));
			if (x - 1 > 0)
			{
				x--;
			}
		}
	}
	
	private boolean verifDeplacement(String direction)
	{
		if (this.verifSortieEcran(direction) == false)
		{
			return false;
		}
		else
		{
			//verifier si il ne rentre pas dans un autre bloc
			String[][] tempTab = TableauTetris.getInstance().getTableau();
			String couleur = ActualBloc.getInstance().getCouleur();
			
			switch(couleur)
			{
				case "GREEN":
				{
					return verifLRS(tempTab, direction);
				}
				case "RED":
				{
					return verifLRZ(tempTab, direction);
				}
				case "BLUE":
				{
					return verifLRJ(tempTab, direction);
				}
				case "ORANGE":
				{
					return verifLRL(tempTab, direction);
				}
				case "MAUVE":
				{
					return verifLRT(tempTab, direction);
				}
				case "YELLOW":
				{
					return verifLRCarre(tempTab, direction);
				}
				case "CYAN":
				{
					return verifLRBarre(tempTab, direction);
				}
			}
		}
		return true;
	}
	
	public boolean verifLRS(String[][] tab, String direction)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		if (direction == "Right")
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x + 1, y) == false || verifLeftRight(tab, x + 1, y - 1) == false || verifLeftRight(tab, x, y - 2) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x + 2, y) == false || verifLeftRight(tab, x + 3, y - 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		else
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x - 2, y - 1) == false || verifLeftRight(tab, x - 2, y - 2) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x, y - 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		return true;
	}
	
	public boolean verifLRZ(String[][] tab, String direction)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		if (direction == "Right")
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x + 1, y) == false || verifLeftRight(tab, x + 2, y - 1) == false || verifLeftRight(tab, x + 2, y - 2) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x + 2, y) == false || verifLeftRight(tab, x + 3, y + 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		else
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x - 1, y - 1) == false || verifLeftRight(tab, x, y - 2) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x, y + 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		return true;
	}
	
	public boolean verifLRJ(String[][] tab, String direction)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		if (direction == "Right")
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x + 1, y) == false || verifLeftRight(tab, x + 1, y - 1) == false || verifLeftRight(tab, x + 1, y - 2) == false)
					{
						return false;
					}
					break;
				}
				case "SOUTH":
				{
					if (verifLeftRight(tab, x + 2, y) == false || verifLeftRight(tab, x + 1, y + 1) == false || verifLeftRight(tab, x + 1, y + 2) == false)
					{
						return false;
					}
					break;
				}
				case "WEST":
				{
					if (verifLeftRight(tab, x + 1, y) == false || verifLeftRight(tab, x + 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x + 3, y) == false || verifLeftRight(tab, x + 1, y - 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		else
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x - 2, y) == false || verifLeftRight(tab, x - 1, y - 1) == false || verifLeftRight(tab, x - 1, y - 2) == false)
					{
						return false;
					}
					break;
				}
				case "SOUTH":
				{
					if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x - 1, y + 1) == false || verifLeftRight(tab, x - 1, y + 2) == false)
					{
						return false;
					}
					break;
				}
				case "WEST":
				{
					if (verifLeftRight(tab, x - 3, y) == false || verifLeftRight(tab, x - 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x - 1, y - 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		return true;
	}
	
	public boolean verifLRL(String[][] tab, String direction)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		if (direction == "Right")
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x + 2, y) == false || verifLeftRight(tab, x + 1, y - 1) == false || verifLeftRight(tab, x + 1, y - 2) == false)
					{
						return false;
					}
					break;
				}
				case "SOUTH":
				{
					if (verifLeftRight(tab, x + 1, y) == false || verifLeftRight(tab, x + 1, y + 1) == false || verifLeftRight(tab, x + 1, y + 2) == false)
					{
						return false;
					}
					break;
				}
				case "WEST":
				{
					if (verifLeftRight(tab, x + 1, y) == false || verifLeftRight(tab, x + 1, y - 1) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x + 3, y) == false || verifLeftRight(tab, x + 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		else
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x - 1, y - 1) == false || verifLeftRight(tab, x - 1, y - 2) == false)
					{
						return false;
					}
					break;
				}
				case "SOUTH":
				{
					if (verifLeftRight(tab, x - 2, y) == false || verifLeftRight(tab, x - 1, y + 1) == false || verifLeftRight(tab, x - 1, y + 2) == false)
					{
						return false;
					}
					break;
				}
				case "WEST":
				{
					if (verifLeftRight(tab, x - 3, y) == false || verifLeftRight(tab, x - 1, y - 1) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x - 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		return true;
	}
	
	public boolean verifLRT(String[][] tab, String direction)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		
		if (direction == "Right")
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x + 2, y) == false || verifLeftRight(tab, x + 1, y - 1) == false)
					{
						return false;
					}
					break;
				}
				case "SOUTH":
				{
					if (verifLeftRight(tab, x + 2, y) == false || verifLeftRight(tab, x + 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
				case "WEST":
				{
					if (verifLeftRight(tab, x + 1, y) == false || verifLeftRight(tab, x + 1, y - 1) == false || verifLeftRight(tab, x + 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x + 2, y) == false || verifLeftRight(tab, x + 1, y - 1) == false  || verifLeftRight(tab, x + 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		else
		{
			switch(orientation)
			{
				case "NORTH":
				{
					if (verifLeftRight(tab, x - 2, y) == false || verifLeftRight(tab, x - 1, y - 1) == false)
					{
						return false;
					}
					break;
				}
				case "SOUTH":
				{
					if (verifLeftRight(tab, x - 2, y) == false || verifLeftRight(tab, x - 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
				case "WEST":
				{
					if (verifLeftRight(tab, x - 2, y) == false || verifLeftRight(tab, x - 1, y - 1) == false  || verifLeftRight(tab, x - 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
				case "EST":
				{
					if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x - 1, y - 1) == false || verifLeftRight(tab, x - 1, y + 1) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		return true;
	}
	
	public boolean verifLRCarre(String[][] tab, String direction)
	{
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		if (direction == "Right")
		{
			if (verifLeftRight(tab, x + 2, y) == false || verifLeftRight(tab, x + 2, y - 1) == false)
			{
				return false;
			}
		}
		else
		{
			if (verifLeftRight(tab, x - 1, y) == false || verifLeftRight(tab, x - 1, y - 1) == false)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean verifLRBarre(String[][] tab, String direction)
	{
		String orientation = ActualBloc.getInstance().getOrientation();
		int x = ActualBloc.getInstance().getX();
		int y = ActualBloc.getInstance().getY();
		if (direction == "Right")
		{
			switch(orientation)
			{
				case "PIC":
				{
					if ((verifLeftRight(tab, x + 1, y) || verifLeftRight(tab, x + 1, y - 1) || verifLeftRight(tab, x + 1, y - 2) || verifLeftRight(tab, x + 1, y - 3)) == false)
					{
						return false;
					}
					break;
				}
				case "COUCH":
				{
					if (verifLeftRight(tab, x + 4, y) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		else
		{
			switch(orientation)
			{
				case "PIC":
				{
					if ((verifLeftRight(tab, x - 1, y) || verifLeftRight(tab, x - 1, y - 1) || verifLeftRight(tab, x - 1, y - 2) || verifLeftRight(tab, x - 1, y - 3)) == false)
					{
						return false;
					}
					break;
				}
				case "COUCH":
				{
					if (verifLeftRight(tab, x - 1, y) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		return true;
	}
	
	private boolean verifSortieEcran(String direction)
	{
		String couleur = ActualBloc.getInstance().getCouleur();
		
		switch(couleur)
		{
			case "GREEN":
			{
				switch(orientation)
				{
					case "NORTH":
					{
						if (direction == "Left")
						{
							if (x - 2 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 1 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "EST":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 3 < 11)
							{
								return true;
							}
						}
						break;
					}
				}
				break;
			}
			case "RED":
			{
				switch(orientation)
				{
					case "NORTH":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 2 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "EST":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 3 < 11)
							{
								return true;
							}
						}
						break;
					}
				}
				break;
			}
			case "BLUE":
			{
				switch(orientation)
				{
					case "NORTH":
					{
						if (direction == "Left")
						{
							if (x - 2 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 1 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "WEST":
					{
						if (direction == "Left")
						{
							if (x - 3 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 1 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "SOUTH":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 2 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "EST":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 3 < 11)
							{
								return true;
							}
						}
						break;
					}
				}
				break;
			}
			case "ORANGE":
			{
				switch(orientation)
				{
					case "NORTH":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 2 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "WEST":
					{
						if (direction == "Left")
						{
							if (x - 3 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 1 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "SOUTH":
					{
						if (direction == "Left")
						{
							if (x - 2 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 1 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "EST":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 3 < 11)
							{
								return true;
							}
						}
						break;
					}
				}
				break;
			}
			case "MAUVE":
			{
				switch(orientation)
				{
					case "NORTH":
					{
						if (direction == "Left")
						{
							if (x - 2 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 2 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "WEST":
					{
						if (direction == "Left")
						{
							if (x - 2 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 1 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "SOUTH":
					{
						if (direction == "Left")
						{
							if (x - 2 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 2 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "EST":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 2 < 11)
							{
								return true;
							}
						}
						break;
					}
				}
				break;
			}
			case "YELLOW":
			{
				if (direction == "Left")
				{
					if (x - 1 > 0)
					{
						return true;
					}
				}
				else if (direction == "Right")
				{
					if (x + 2 < 11)
					{
						return true;
					}
				}
				break;
			}
			case "CYAN":
			{
				switch(orientation)
				{
					case "PIC":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 1 < 11)
							{
								return true;
							}
						}
						break;
					}
					case "COUCH":
					{
						if (direction == "Left")
						{
							if (x - 1 > 0)
							{
								return true;
							}
						}
						else if (direction == "Right")
						{
							if (x + 4 < 11)
							{
								return true;
							}
						}
						break;
					}
				}
				break;
			}
		}
		return false;
	}
	
	public void inventaireUsed()
	{
		if (!inv.isUse())
		{
			if (inv.isVide())
			{
				inv.inventaireUsed(couleur, orientation);
				actif = false;
				creerBloc();
			}
			else
			{
				String couleurBlock = inv.getCouleurInventaire();
				inv.inventaireUsed(couleur, orientation);
				setBlockInventaire(couleurBlock);
			}
		}
	}

	public void rotate()
	{
		String couleur = ActualBloc.getInstance().getCouleur();

		switch (couleur)
		{
			case "GREEN", "RED" -> {
				switch (orientation)
				{
					case "NORTH" -> {
						orientation = "EST";
					}
					case "EST" -> {
						orientation = "NORTH";
					}
				}
			}
			case "BLUE", "ORANGE", "MAUVE" -> {
				switch (orientation)
				{
					case "NORTH" -> {
						orientation = "WEST";
					}
					case "WEST" -> {
						orientation = "SOUTH";
					}
					case "SOUTH" -> {
						orientation = "EST";
					}
					case "EST" -> {
						orientation = "NORTH";
					}
				}
			}
			case "YELLOW" -> {
			}
			case "CYAN" -> {
				switch (orientation)
				{
					case "PIC" -> {
						orientation = "COUCH";
					}
					case "COUCH" -> {
						orientation = "PIC";
					}
				}
			}
		}
	}
	
	public Inventaire getInventaire()
	{
		return inv;
	}
}
