package model.block.typeBlock;

import données.Couleur;
import model.Coords;
import model.PositionBlock;
import model.block.Block;

public class TetrominoI extends Block
{
    /* Différente rotation: ( O = position référence )

    1:

    0123

    2:

    3
    2
    1
    0

     */

    public TetrominoI()
    {
        super();
        position = new PositionBlock(
                new Coords(3, 11),
                new Coords(4, 11),
                new Coords(5, 11),
                new Coords(6, 11)
        );
        rotation = 1;
        type = Couleur.TI;
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
