package model;

import controller.Deplacement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Plateau
{
    //Partie singleton :
    private static Plateau dataPlateau;

    // -4 vide inaccessible
    // -3 = fruit du niveau actuel
    // -2 = gros point blanc
    // -1 = point blanc
    // 0 = vide
    // 1 = coin haut gauche
    // 2 = coin haut droite
    // 3 = coin bas gauche
    // 4 = coin bas droite
    // 5 = mur horizontal
    // 6 = mur vertical
    // 7 = bout bas
    // 8 = bout haut
    // 9 = bout droite
    // 10 = bout gauche
    // 11 = T bas
    // 12 = T haut
    // 13 = T droite
    // 14 = T gauche
    private final int[][] defaultPlateau;
    private int[][] plateau =
    {
        {1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 11, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2},
        {6, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6},
        {6, -1, 1, 5, 2, -1, 1, 5, 2, -1, 6, -1, 1, 5, 2, -1, 1, 5, 2, -1, 6},
        {6, -2, 6, 0, 6, -1, 6, 0, 6, -1, 6, -1, 6, 0, 6, -1, 6, 0, 6, -2, 6},
        {6, -1, 3, 5, 4, -1, 3, 5, 4, -1, 7, -1, 3, 5, 4, -1, 3, 5, 4, -1, 6},
        {6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6},
        {6, -1, 1, 5, 2, -1, 8, -1, 1, 5, 5, 5, 2, -1, 8, -1, 1, 5, 2, -1, 6},
        {6, -1, 3, 5, 4, -1, 6, -1, 3, 5, 11, 5, 4, -1, 6, -1, 3, 5, 4, -1, 6},
        {6, -1, -1, -1, -1, -1, 6, -1, -1, -1, 6, -1, -1, -1, 6, -1, -1, -1, -1, -1, 6},
        {3, 5, 5, 5, 2, -1, 13, 5, 9, -1, 7, -1, 10, 5, 14, -1, 1, 5, 5, 5, 4},
        {0, 0, 0, 0, 6, -1, 6, -1, -1, -1, 0, -1, -1, -1, 6, -1, 6, 0, 0, 0, 0},
        {0, 0, 0, 0, 6, -1, 6, -1, 1, 9, -4, 10, 2, -1, 6, -1, 6, 0, 0, 0, 0},
        {10, 5, 5, 5, 4, -1, 7, -1, 6, -4, -4, -4, 6, -1, 7, -1, 3, 5, 5, 5, 9},
        {-1, -1, -1, -1, -1, -1, -1, -1, 6, -4, -4, -4, 6, -1, -1, -1, -1, -1, -1, -1, -1},
        {10, 5, 5, 5, 2, -1, 8, -1, 3, 5, 5, 5, 4, -1, 8, -1, 1, 5, 5, 5, 9},
        {0, 0, 0, 0, 6, -1, 6, -1, -1, -1, -1, -1, -1, -1, 6, -1, 6, 0, 0, 0, 0},
        {0, 0, 0, 0, 6, -1, 6, -1, 1, 5, 5, 5, 2, -1, 6, -1, 6, 0, 0, 0, 0},
        {1, 5, 5, 5, 4, -1, 7, -1, 3, 5, 11, 5, 4, -1, 7, -1, 3, 5, 5, 5, 2},
        {6, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6},
        {6, -1, 10, 5, 2, -1, 10, 5, 9, -1, 7, -1, 10, 5, 9, -1, 1, 5, 9, -1, 6},
        {6, -2, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6, -1, -1, -2, 6},
        {13, 5, 2, -1, 6, -1, 8, -1, 1, 5, 5, 5, 2, -1, 8, -1, 6, -1, 1, 5, 14},
        {13, 5, 4, -1, 7, -1, 6, -1, 3, 5, 11, 5, 4, -1, 6, -1, 7, -1, 3, 5, 14},
        {6, -1, -1, -1, -1, -1, 6, -1, -1, -1, 6, -1, -1, -1, 6, -1, -1, -1, -1, -1, 6},
        {6, -1, 10, 5, 5, 5, 12, 5, 9, -1, 7, -1, 10, 5, 12, 5, 5, 5, 9, -1, 6},
        {6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 6},
        {3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4}
    };

    //Point du spawn pacman :
    private final Position spawnPacMan = new Position(10, 10);

    //Point du spawn ghost :
    private final ArrayList<Position> spawnGhost = new ArrayList<>();

    //Niveau du jeu :
    private int niveau = 1;

    private Plateau()
    {
        //Définition spawn ghost :
        definedSpawnGhost();

        //Save du plateau de base :
        defaultPlateau = new int [plateau.length][plateau[0].length];
        for (int y = 0 ; y < plateau.length ; y++)
        {
            defaultPlateau[y] = Arrays.copyOf(plateau[y], plateau[y].length);
        }
    }

    public static Plateau getInstance()
    {
        if (dataPlateau == null)
        {
            dataPlateau = new Plateau();
        }

        return dataPlateau;
    }

    public void definedSpawnGhost()
    {
        spawnGhost.clear();
        for (int i = 0 ; i < 3 ; i++)
        {
            for (int j = 0 ; j < 2 ; j++)
            {
                spawnGhost.add(new Position(9 + i, 12 + j));
            }
        }
    }

    public int[][] getPlateau()
    {
        return plateau;
    }

    public void setPlateau(int[][] _plateau)
    {
        for (int y = 0 ; y < _plateau.length ; y++)
        {
            plateau[y] = Arrays.copyOf(_plateau[y], _plateau[y].length);
        }
    }

    public Position getSpawnPacMan()
    {
        return spawnPacMan;
    }

    public Position getSpawnGhost()
    {
        Random rand = new Random();
        int choice = rand.nextInt(spawnGhost.size());
        Position temp = spawnGhost.get(choice);
        spawnGhost.remove(choice);
        return temp;
    }

    public int getNiveau()
    {
        return niveau;
    }

    public void setNiveau(int _niveau)
    {
        niveau = _niveau;
    }

    public void deplacementPersonnage(boolean fast)
    {
        //Deplacement PacMan :
        movePacMan();
        for (Ghost ghst : GameData.getInstance().getGhost())
        {
            if (Objects.equals(ghst.getType(), "Red"))
            {
                ghst.addLastPosition(GameData.getInstance().getPacMan().getPosition());
            }
        }

        //Vérification fruit PacMan :
        eatFruitPacMan();

        if (GameData.getInstance().isGhostActive() && !fast)
        {
            //Deplacement Pink :

            //Deplacement Red (suis pacman à la lettre) :
            moveRedGhost();

            //Deplacement Blue :
            moveBlueGhost();

            //Deplacement Orange :
            moveOrangeGhost();
        }

        //Vérifier si point restant sur le terrain :
        boolean rest = false;
        for ( int[] ints : plateau )
        {
            for ( int anInt : ints )
            {
                if (anInt == -1 || anInt == -2 || anInt == -3)
                {
                    rest = true;
                    break;
                }
            }
        }

        if (!rest)
        {
            //Reset plateau + pacman + fantome :
            resetSome(true);
            niveau++;

            GameData.getInstance().addPoint(5000);
        }

        //Vérifier si pos ghost == pos pacman
        collisionGhost();
    }

    private void collisionGhost()
    {
        for (Ghost ghst : GameData.getInstance().getGhost())
        {
            if (ghst.getPosition().getX() == GameData.getInstance().getPacMan().getPosition().getX() && ghst.getPosition().getY() == GameData.getInstance().getPacMan().getPosition().getY())
            {
                if (GameData.getInstance().getPacMan().isFastMode())
                {
                    //Tuer le fantomes :
                    ghst.setDead(true);
                    ghst.setPosition(getSpawnGhost());
                    definedSpawnGhost();

                    //Ajouter les points :
                    GameData.getInstance().addGhostKilled();
                    GameData.getInstance().addPoint(200 * GameData.getInstance().getGhostKilled());//Normalement 200, 600, 1200, 2000
                }
                else
                {
                    if (GameData.getInstance().getPacMan().getLive() == 0)
                    {
                        System.out.println("Perdu vous avez eu : " + GameData.getInstance().getPoint() + " points");
                        System.exit(0);
                    }
                    else
                    {
                        //Retirer la vie :
                        GameData.getInstance().getPacMan().removeLive();

                        //Reset pacman + Ghost
                        resetSome(false);
                    }
                }
            }
        }
    }

    private void resetSome(boolean plat)
    {
        if (plat)
        {
            setPlateau(defaultPlateau);
        }

        //Reset position pacman :
        GameData.getInstance().getPacMan().getPosition().setPosition(spawnPacMan.getX(), spawnPacMan.getY());

        //Reset position ghost :
        resetGhost();
    }

    private void resetGhost()
    {
        for (Ghost ghst : GameData.getInstance().getGhost())
        {
            ghst.setDead(true);
            ghst.setPosition(getSpawnGhost());

            if (Objects.equals(ghst.getType(), "Red"))
            {
                //reset Historique :
                ghst.resteHistorique();
            }
        }

        definedSpawnGhost();
    }

    private void movePinkGhost()
    {

    }

    private void moveRedGhost()
    {
        for (Ghost ghst : GameData.getInstance().getGhost())
        {
            if (Objects.equals(ghst.getType(), "Red") && !ghst.isDead())
            {
                Position pos = ghst.getNextPosition();
                if (pos != null)
                {
                    ghst.setPosition(pos);
                }
            }
        }
    }

    private void moveBlueGhost()
    {
        /*for (Ghost ghst : GameData.getInstance().getGhost())
        {
            if (Objects.equals(ghst.getType(), "Blue") && !ghst.isDead())
            {
                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX()] == -4)
                {
                    //Cas ou ils sont encore dans la cage
                    ghst.getPosition().setPosition(spawnPacMan.getX(), spawnPacMan.getY());
                }

                Random rand = new Random();
                int choice = rand.nextInt(10);
                boolean deplacement = false;

                int tempX = ghst.getPosition().getX() - GameData.getInstance().getPacMan().getPosition().getX();
                int tempY = ghst.getPosition().getY() - GameData.getInstance().getPacMan().getPosition().getY();

                if (choice < 8) //Ne pas fuir
                {
                    if (tempX > 0 && tempY > 0) //HAUT GAUCHE
                    {
                        do
                        {
                            choice = rand.nextInt(2);
                            if (choice == 0)
                            {
                                if (plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() - 1);
                                    ghst.setDirection("H");
                                    deplacement = true;
                                }
                            }

                            if (choice == 1)
                            {
                                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX() -1, ghst.getPosition().getY());
                                    ghst.setDirection("G");
                                    deplacement = true;
                                }
                            }
                        } while (!deplacement);
                    }
                    else if (tempX < 0 && tempY > 0) //HAUT DROITE
                    {
                        do
                        {
                            choice = rand.nextInt(2);
                            if (choice == 0)
                            {
                                if (plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() - 1);
                                    ghst.setDirection("H");
                                    deplacement = true;
                                }
                            }

                            if (choice == 1)
                            {
                                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() + 1);
                                    ghst.setDirection("D");
                                    deplacement = true;
                                }
                            }
                        } while (!deplacement);
                    }
                    else if (tempX > 0 && tempY < 0) //BAS GAUCHE
                    {
                        do
                        {
                            choice = rand.nextInt(2);
                            if (choice == 0)
                            {
                                if (plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() + 1);
                                    ghst.setDirection("B");
                                    deplacement = true;
                                }
                            }

                            if (choice == 1)
                            {
                                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX() -1, ghst.getPosition().getY());
                                    ghst.setDirection("G");
                                    deplacement = true;
                                }
                            }
                        } while (!deplacement);
                    }
                    else //BAS DROITE
                    {
                        do
                        {
                            choice = rand.nextInt(2);
                            if (choice == 0)
                            {
                                if (plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() + 1);
                                    ghst.setDirection("B");
                                    deplacement = true;
                                }
                            }

                            if (choice == 1)
                            {
                                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() + 1);
                                    ghst.setDirection("D");
                                    deplacement = true;
                                }
                            }
                        } while (!deplacement);
                    }
                }
                else //Fuir
                {
                    if (tempX < 0 && tempY < 0) //HAUT GAUCHE
                    {
                        do
                        {
                            choice = rand.nextInt(2);
                            if (choice == 0)
                            {
                                if (plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() - 1);
                                    ghst.setDirection("H");
                                    deplacement = true;
                                }
                            }

                            if (choice == 1)
                            {
                                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX() -1, ghst.getPosition().getY());
                                    ghst.setDirection("G");
                                    deplacement = true;
                                }
                            }
                        } while (!deplacement);
                    }
                    else if (tempX > 0 && tempY < 0) //HAUT DROITE
                    {
                        do
                        {
                            choice = rand.nextInt(2);
                            if (choice == 0)
                            {
                                if (plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() - 1);
                                    ghst.setDirection("H");
                                    deplacement = true;
                                }
                            }

                            if (choice == 1)
                            {
                                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() + 1);
                                    ghst.setDirection("D");
                                    deplacement = true;
                                }
                            }
                        } while (!deplacement);
                    }
                    else if (tempX < 0 && tempY > 0) //BAS GAUCHE
                    {
                        do
                        {
                            choice = rand.nextInt(2);
                            if (choice == 0)
                            {
                                if (plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() + 1);
                                    ghst.setDirection("B");
                                    deplacement = true;
                                }
                            }

                            if (choice == 1)
                            {
                                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX() -1, ghst.getPosition().getY());
                                    ghst.setDirection("G");
                                    deplacement = true;
                                }
                            }
                        } while (!deplacement);
                    }
                    else //BAS DROITE
                    {
                        do
                        {
                            choice = rand.nextInt(2);
                            if (choice == 0)
                            {
                                if (plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() + 1);
                                    ghst.setDirection("B");
                                    deplacement = true;
                                }
                            }

                            if (choice == 1)
                            {
                                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -3)
                                {
                                    ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() + 1);
                                    ghst.setDirection("D");
                                    deplacement = true;
                                }
                            }
                        } while (!deplacement);
                    }
                }
            }
        }*/
    }

    private void moveOrangeGhost()
    {
        for (Ghost ghst : GameData.getInstance().getGhost())
        {
            if ((Objects.equals(ghst.getType(), "Orange") || Objects.equals(ghst.getType(), "Blue") || Objects.equals(ghst.getType(), "Pink")) && !ghst.isDead())
            {
                if (plateau[ghst.getPosition().getY()][ghst.getPosition().getX()] == -4)
                {
                    //Cas ou ils sont encore dans la cage
                    ghst.getPosition().setPosition(spawnPacMan.getX(), spawnPacMan.getY());
                }

                Random rand = new Random();
                int choice = rand.nextInt(4);
                boolean deplacement = false;

                do
                {
                    switch (choice) // 0 + Haut, 1 = bas, 2 = droite, 3 = gauche
                    {
                        case 0 -> {
                            if (!Objects.equals(ghst.getDirection(), "B") && ((plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() - 1][ghst.getPosition().getX()] == -3)))
                            {
                                ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() - 1);
                                ghst.setDirection("H");
                                deplacement = true;
                            }
                        }

                        case 1 -> {
                            if (!Objects.equals(ghst.getDirection(), "H") && ((plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == 0 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -1 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -2 || plateau[ghst.getPosition().getY() + 1][ghst.getPosition().getX()] == -3)))
                            {
                                ghst.getPosition().setPosition(ghst.getPosition().getX(), ghst.getPosition().getY() + 1);
                                ghst.setDirection("B");
                                deplacement = true;
                            }
                        }

                        case 2 -> {
                            if (ghst.getPosition().getX() + 1 == GameData.NBR_CASE_X)
                            {
                                ghst.getPosition().setPosition(0, ghst.getPosition().getY());
                                ghst.setDirection("D");
                                deplacement = true;
                            }
                            else if (!Objects.equals(ghst.getDirection(), "G") && ((plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() + 1] == -3)))
                            {
                                ghst.getPosition().setPosition(ghst.getPosition().getX() + 1, ghst.getPosition().getY());
                                ghst.setDirection("D");
                                deplacement = true;
                            }
                        }

                        case 3 -> {
                            if (ghst.getPosition().getX() - 1 == -1)
                            {
                                ghst.getPosition().setPosition(GameData.NBR_CASE_X - 1, ghst.getPosition().getY());
                                ghst.setDirection("G");
                                deplacement = true;
                            }
                            else if (!Objects.equals(ghst.getDirection(), "D") && ((plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == 0 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -1 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -2 || plateau[ghst.getPosition().getY()][ghst.getPosition().getX() - 1] == -3)))
                            {
                                ghst.getPosition().setPosition(ghst.getPosition().getX() - 1, ghst.getPosition().getY());
                                ghst.setDirection("G");
                                deplacement = true;
                            }
                        }
                    }

                    choice = rand.nextInt(4);
                } while (!deplacement);
            }
        }
    }

    private void eatFruitPacMan()
    {
        Position pacManPos = GameData.getInstance().getPacMan().getPosition();

        //Cas petit point :
        if (plateau[pacManPos.getY()][pacManPos.getX()] == -1)
        {
            plateau[pacManPos.getY()][pacManPos.getX()] = 0;
            GameData.getInstance().addPoint(10);
        }

        //Cas gros point :
        if (plateau[pacManPos.getY()][pacManPos.getX()] == -2)
        {
            plateau[pacManPos.getY()][pacManPos.getX()] = 0;
            GameData.getInstance().addPoint(50);

            //Passer en mode fast :
            if (!GameData.getInstance().getPacMan().isFastMode())
            {
                GameData.getInstance().getPacMan().setFastMode();
            }
            Deplacement.getInstance().resetTimeFastMode();
        }

        //Cas gros fruit :
        if (plateau[pacManPos.getY()][pacManPos.getX()] == -3)
        {
            plateau[pacManPos.getY()][pacManPos.getX()] = 0;
            GameData.getInstance().addPoint(10); //Changer les points en fonction du niveau et du coup du fruit
        }
    }

    private void movePacMan()
    {
        Position pacManPos = GameData.getInstance().getPacMan().getPosition();

        switch (GameData.getInstance().getPacMan().getNextMove())
        {
            case "B" -> {
                if (plateau[pacManPos.getY() + 1][pacManPos.getX()] == 0 || plateau[pacManPos.getY() + 1][pacManPos.getX()] == -1 || plateau[pacManPos.getY() + 1][pacManPos.getX()] == -2 || plateau[pacManPos.getY() + 1][pacManPos.getX()] == -3)
                {
                    GameData.getInstance().getPacMan().setDirection(GameData.getInstance().getPacMan().getNextMove());
                    GameData.getInstance().getPacMan().setNextMove("A");
                }
            }

            case "H" -> {
                if (plateau[pacManPos.getY() - 1][pacManPos.getX()] == 0 || plateau[pacManPos.getY() - 1][pacManPos.getX()] == -1 || plateau[pacManPos.getY() - 1][pacManPos.getX()] == -2 || plateau[pacManPos.getY() - 1][pacManPos.getX()] == -3)
                {
                    GameData.getInstance().getPacMan().setDirection(GameData.getInstance().getPacMan().getNextMove());
                    GameData.getInstance().getPacMan().setNextMove("A");
                }
            }

            case "G" -> {
                if (pacManPos.getX() - 1 != -1 && (plateau[pacManPos.getY()][pacManPos.getX() - 1] == 0 || plateau[pacManPos.getY()][pacManPos.getX() - 1] == -1 || plateau[pacManPos.getY()][pacManPos.getX() - 1] == -2 || plateau[pacManPos.getY()][pacManPos.getX() - 1] == -3))
                {
                    GameData.getInstance().getPacMan().setDirection(GameData.getInstance().getPacMan().getNextMove());
                    GameData.getInstance().getPacMan().setNextMove("A");
                }
            }

            case "D" -> {
                if (pacManPos.getX() + 1 != -1 && (plateau[pacManPos.getY()][pacManPos.getX() + 1] == 0 || plateau[pacManPos.getY()][pacManPos.getX() + 1] == -1 || plateau[pacManPos.getY()][pacManPos.getX() + 1] == -2 || plateau[pacManPos.getY()][pacManPos.getX() + 1] == -3))
                {
                    GameData.getInstance().getPacMan().setDirection(GameData.getInstance().getPacMan().getNextMove());
                    GameData.getInstance().getPacMan().setNextMove("A");
                }
            }
        }

        switch (GameData.getInstance().getPacMan().getDirection())
        {
            case "A" -> {}

            case "B" -> {
                if (plateau[pacManPos.getY() + 1][pacManPos.getX()] == 0 || plateau[pacManPos.getY() + 1][pacManPos.getX()] == -1 || plateau[pacManPos.getY() + 1][pacManPos.getX()] == -2 || plateau[pacManPos.getY() + 1][pacManPos.getX()] == -3)
                {
                    GameData.getInstance().getPacMan().getPosition().setPosition(pacManPos.getX(), pacManPos.getY() + 1);
                }
            }

            case "H" -> {
                if (plateau[pacManPos.getY() - 1][pacManPos.getX()] == 0 || plateau[pacManPos.getY() - 1][pacManPos.getX()] == -1 || plateau[pacManPos.getY() - 1][pacManPos.getX()] == -2 || plateau[pacManPos.getY() - 1][pacManPos.getX()] == -3)
                {
                    GameData.getInstance().getPacMan().getPosition().setPosition(pacManPos.getX(), pacManPos.getY() - 1);
                }
            }

            case "G" -> {
                if (!(pacManPos.getX() - 1 == -1))
                {
                    if (plateau[pacManPos.getY()][pacManPos.getX() - 1] == 0 || plateau[pacManPos.getY()][pacManPos.getX() - 1] == -1 || plateau[pacManPos.getY()][pacManPos.getX() - 1] == -2 || plateau[pacManPos.getY()][pacManPos.getX() - 1] == -3)
                    {
                        GameData.getInstance().getPacMan().getPosition().setPosition(pacManPos.getX() - 1, pacManPos.getY());
                    }
                }
                else
                {
                    GameData.getInstance().getPacMan().getPosition().setPosition(GameData.NBR_CASE_X - 1, pacManPos.getY());
                }
            }

            case "D" -> {
                if (!(pacManPos.getX() + 1 == GameData.NBR_CASE_X))
                {
                    if (plateau[pacManPos.getY()][pacManPos.getX() + 1] == 0 || plateau[pacManPos.getY()][pacManPos.getX() + 1] == -1 || plateau[pacManPos.getY()][pacManPos.getX() + 1] == -2 || plateau[pacManPos.getY()][pacManPos.getX() + 1] == -3)
                    {
                        GameData.getInstance().getPacMan().getPosition().setPosition(pacManPos.getX() + 1, pacManPos.getY());
                    }
                }
                else
                {
                    GameData.getInstance().getPacMan().getPosition().setPosition(0, pacManPos.getY());
                }
            }
        }

        collisionGhost();
    }
}
