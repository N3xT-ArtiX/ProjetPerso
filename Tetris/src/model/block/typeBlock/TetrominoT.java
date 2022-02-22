package model.block.typeBlock;

import données.Couleur;
import model.Coords;
import model.PositionBlock;
import model.block.Block;

public class TetrominoT extends Block
{
    /* Différente rotation: ( O = position référence )

    1:

    203
     1

    2:

    3
    01
    2

    3:

     2
    10
     3

    4:

     1
    302

     */

    public TetrominoT()
    {
        super();
        position = new PositionBlock(
                new Coords(4, 11),
                new Coords(4, 10),
                new Coords(3, 11),
                new Coords(5, 11)
        );
        rotation = 1;
        type = Couleur.TT;
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
