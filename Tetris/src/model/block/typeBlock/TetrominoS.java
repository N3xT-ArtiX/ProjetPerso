package model.block.typeBlock;

import données.Couleur;
import model.Coords;
import model.PositionBlock;
import model.block.Block;

public class TetrominoS extends Block
{
    /* Différente rotation: ( O = position référence )

    1:

     23
    O1

    2:

    3
    21
     O

     */

    public TetrominoS()
    {
        super();
        position = new PositionBlock(
                new Coords(3, 10),
                new Coords(4, 10),
                new Coords(4, 11),
                new Coords(5, 11)
        );
        rotation = 1;
        type = Couleur.TS;
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
