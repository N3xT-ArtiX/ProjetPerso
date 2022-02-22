package model.block.typeBlock;

import données.Couleur;
import model.Coords;
import model.PositionBlock;
import model.block.Block;

public class TetrominoZ extends Block
{
    /* Différente rotation: ( O = position référence )

    1:

    01
     23

    2:

     3
    12
    0

     */

    public TetrominoZ()
    {
        super();
        position = new PositionBlock(
                new Coords(3, 11),
                new Coords(4, 11),
                new Coords(4, 10),
                new Coords(5, 10)
        );
        rotation = 1;
        type = Couleur.TZ;
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
