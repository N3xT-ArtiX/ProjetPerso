package model.block.typeBlock;

import données.Couleur;
import model.Coords;
import model.PositionBlock;
import model.block.Block;

public class TetrominoL extends Block
{
    /* Différente rotation: ( O = position référence )

    1:

    3
    2
    01

    2:

      1
    320

    3:

    10
     2
     3

    4:

    023
    1

     */

    public TetrominoL()
    {
        super();
        position = new PositionBlock(
                new Coords(3, 11),
                new Coords(3, 10),
                new Coords(4, 11),
                new Coords(5, 11)
        );
        rotation = 4;
        type = Couleur.TL;
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
