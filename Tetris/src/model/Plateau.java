package model;

//Import perso
import données.Couleur;

//Import JAVA

public final class Plateau
{
    private static volatile Plateau instance;

    //Définition des valeurs de la classe
    private int[][] plateau = new int[10][22];

    private Plateau()
    {
        for (int x = 0 ; x < plateau.length ; x++)
        {
            for (int y = 0 ; y < plateau[x].length ; y++)
            {
                plateau[x][y] = Couleur.VIDE;
            }
        }
    }

    public static Plateau getInstance()
    {
        Plateau result = instance;

        if (result != null)
        {
            return result;
        }

        synchronized (Plateau.class)
        {
            if (instance == null)
            {
                instance = new Plateau();
            }
            return instance;
        }
    }
}
