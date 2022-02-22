package model.block;

import model.PositionBlock;

public abstract class Block
{
    //Définition des valeurs de la classe
    protected PositionBlock position; //position du block sur le plateau étant toujours le même block
    protected int rotation; //1, 2, 3 ou 4
    protected int type; //Couleur.xxx

    public abstract void pivotDroit();
    public abstract void pivotGauche();
    public abstract int getRotation();

    public abstract void deplacementDroit();
    public abstract void deplacementGauche();
    //public abstract PositionBlock getPosition();

    public abstract void slowDown();
    public abstract void hardDown();
}
