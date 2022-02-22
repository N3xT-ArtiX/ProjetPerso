package model.block.typeBlock;

import données.Couleur;
import model.Coords;
import model.PositionBlock;
import model.block.Block;

public class TetrominoO extends Block
{
    /* Différente rotation: ( O = position référence )

    1:

     32
     O1

     */

    public TetrominoO()
    {
        super();
        position = new PositionBlock(
                new Coords(4, 10),
                new Coords(5, 10),
                new Coords(5, 11),
                new Coords(4, 11)
        );
        rotation = 1;
        type = Couleur.TO;
    }

    @Override
    public void pivotDroit()
    {

    }

    @Override
    public void pivotGauche()
    {

    }

    @Override
    public int getRotation()
    {
        return 0;
    }

    @Override
    public void deplacementDroit()
    {

    }

    @Override
    public void deplacementGauche()
    {

    }

    @Override
    public void slowDown()
    {

    }

    @Override
    public void hardDown()
    {

    }
}
