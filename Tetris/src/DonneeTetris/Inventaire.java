package DonneeTetris;

public class Inventaire
{
	String[] inv = new String[2];
	boolean vide = true;
	boolean use = false;
	
	public Inventaire()
	{
		
	}
	
	public void inventaireUsed(String couleur, String orientation)
	{
		inv[0] = couleur;
		inv[1] = orientation;
		vide = false;
		use = true;
	}
	
	public String getCouleurInventaire()
	{	
		return inv[0];
	}
	
	public boolean isVide()
	{
		return vide;
	}
	
	public boolean isUse()
	{
		return use;
	}
	
	public void resetUse()
	{
		use = false;
	}
}
