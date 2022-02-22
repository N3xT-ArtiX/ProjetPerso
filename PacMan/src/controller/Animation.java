package controller;

import vue.Fenetre;

public class Animation
{
    //Partie singleton :
    private static Animation animation;

    private Animation()
    {

    }

    public static Animation getInstance()
    {
        if (animation == null)
        {
            animation = new Animation();
        }

        return animation;
    }

    public void animerPacMan()
    {
        //Repeindre la fenetre :
        Fenetre.getInstance().repaintFenetre();
    }
}
