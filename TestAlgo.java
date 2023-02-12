import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestAlgo {

    @Test
    public final void testTriComptage (){

        //Rappel ne peut prendre que des entiers positifs

        //Test tableau vide
        int [] t = {};
        int [] tbis = {};
        Algo.triComptage(t);
        assertArrayEquals(t,tbis);

        //Test petit tableau avec petites valeurs
        int [] t1 = {5,8,4,3,2,0,9,7,6};
        int [] t1bis = {0,2,3,4,5,6,7,8,9};
        Algo.triComptage(t1);
        assertArrayEquals(t1,t1bis);

        //Test petit tableau i.e 9 avec petites valeurs répétées
        int [] t2 = {6,1,1,5,8,5,9,9,1};
        int [] t2bis = {1,1,1,5,5,6,8,9,9};
        Algo.triComptage(t2);
        assertArrayEquals(t2,t2bis);

        //Test petit tableau i.e 9 avec grandes valeurs
        int [] t3 = {21,55,78,150,93,55,66,12,45};
        int [] t3bis = {12,21,45,55,55,66,78,93,150};
        Algo.triComptage(t3);
        assertArrayEquals(t3,t3bis);

        //Test moyen tableau i.e 18
        int [] t4 = {15,89,6400,12,3,7,8,9,45,54,798,65,3,454,12,45,48,4};
        int [] t4bis = {3,3,4,7,8,9,12,12,15,45,45,48,54,65,89,454,798,6400};
        Algo.triComptage(t4);
        assertArrayEquals(t4,t4bis);

        //Test grand tableau i.e 27
        int [] t5 = {15,24,686,987,3,25,14,87,687,87,15,45,789,85,23,2,14,5,26,9,7,0,0,45,666,1000,87};
        int [] t5bis = {0,0,2,3,5,7,9,14,14,15,15,23,24,25,26,45,45,85,87,87,87,666,686,687,789,987,1000,};
        Algo.triComptage(t5);
        assertArrayEquals(t5,t5bis);

        //Test un seul pas trié
        int [] t6 = {10,15,20,25,35,30,40,45,50};
        int [] t6bis = {10,15,20,25,30,35,40,45,50};
        Algo.triComptage(t6);
        assertArrayEquals(t6,t6bis);

        //Test déjà trié
        int [] t7 = {80,81,82,83,84,85,86,87,88,89,90};
        int [] t7bis = t7;
        Algo.triComptage(t7);
        assertArrayEquals(t7,t7bis);

        //Test trié en ordre décroissant
        int [] t8 = {72,71,70,69,68,67,66,65,64,63};
        int [] t8bis = {63,64,65,66,67,68,69,70,71,72};
        Algo.triComptage(t8);
        assertArrayEquals(t8,t8bis);

    }

    @Test
    public final void testTriPeigne (){

        //Test tableau vide
        int [] t = {};
        int [] tbis = {};
        Algo.triPeigne(t);
        assertArrayEquals(t,tbis);

        //Test petit tableau avec petites valeurs
        int [] t1 = {5,-8,4,-3,2,0,9,7,6};
        int [] t1bis = {-8,-3,0,2,4,5,6,7,9};
        Algo.triPeigne(t1);
        assertArrayEquals(t1,t1bis);

        //Test petit tableau i.e 9 avec petites valeurs répétées
        int [] t2 = {6,1,1,-5,8,-5,9,9,1};
        int [] t2bis = {-5,-5,1,1,1,6,8,9,9};
        Algo.triPeigne(t2);
        assertArrayEquals(t2,t2bis);

        //Test petit tableau i.e 9 avec grandes valeurs
        int [] t3 = {21,55,78,-150,93,55,66,-66,45};
        int [] t3bis = {-150,-66,21,45,55,55,66,78,93};
        Algo.triPeigne(t3);
        assertArrayEquals(t3,t3bis);

        //Test moyen tableau i.e 18
        int [] t4 = {15,89,6400,-12,3,7,8,9,45,54,798,65,3,-454,12,45,48,4};
        int [] t4bis = {-454,-12,3,3,4,7,8,9,12,15,45,45,48,54,65,89,798,6400};
        Algo.triPeigne(t4);
        assertArrayEquals(t4,t4bis);

        //Test grand tableau i.e 27
        int [] t5 = {15,24,686,987,3,25,14,87,-687,87,15,45,789,85,23,2,14,5,26,9,7,0,0,45,666,1000,87};
        int [] t5bis = {-687,0,0,2,3,5,7,9,14,14,15,15,23,24,25,26,45,45,85,87,87,87,666,686,789,987,1000,};
        Algo.triPeigne(t5);
        assertArrayEquals(t5,t5bis);

        //Test un seul pas trié
        int [] t6 = {10,15,-20,25,35,35,40,45,50};
        int [] t6bis = {-20,10,15,25,35,35,40,45,50};
        Algo.triPeigne(t6);
        assertArrayEquals(t6,t6bis);

        //Test déjà trié
        int [] t7 = {-81,-12,82,83,84,85,86,87,88,89,90};
        int [] t7bis = t7;
        Algo.triPeigne(t7);
        assertArrayEquals(t7,t7bis);

        //Test trié en ordre décroissant
        int [] t8 = {72,71,70,69,68,67,66,65,-63,-64};
        int [] t8bis = {-64,-63,65,66,67,68,69,70,71,72};
        Algo.triPeigne(t8);
        assertArrayEquals(t8,t8bis);
    }

    @Test
    public final void testTrieParCocktail (){

        //Test tableau vide
        int [] t = {};
        int [] tbis = {};
        Algo.trieParCocktail(t);
        assertArrayEquals(t,tbis);

        //Test petit tableau avec petites valeurs
        int [] t1 = {5,-8,4,-3,2,0,9,7,6};
        int [] t1bis = {-8,-3,0,2,4,5,6,7,9};
        Algo.trieParCocktail(t1);
        assertArrayEquals(t1,t1bis);

        //Test petit tableau i.e 9 avec petites valeurs répétées
        int [] t2 = {6,1,1,-5,8,-5,9,9,1};
        int [] t2bis = {-5,-5,1,1,1,6,8,9,9};
        Algo.trieParCocktail(t2);
        assertArrayEquals(t2,t2bis);

        //Test petit tableau i.e 9 avec grandes valeurs
        int [] t3 = {21,55,78,-150,93,55,66,-66,45};
        int [] t3bis = {-150,-66,21,45,55,55,66,78,93};
        Algo.trieParCocktail(t3);
        assertArrayEquals(t3,t3bis);

        //Test moyen tableau i.e 18
        int [] t4 = {15,89,6400,-12,3,7,8,9,45,54,798,65,3,-454,12,45,48,4};
        int [] t4bis = {-454,-12,3,3,4,7,8,9,12,15,45,45,48,54,65,89,798,6400};
        Algo.trieParCocktail(t4);
        assertArrayEquals(t4,t4bis);

        //Test grand tableau i.e 27
        int [] t5 = {15,24,686,987,3,25,14,87,-687,87,15,45,789,85,23,2,14,5,26,9,7,0,0,45,666,1000,87};
        int [] t5bis = {-687,0,0,2,3,5,7,9,14,14,15,15,23,24,25,26,45,45,85,87,87,87,666,686,789,987,1000,};
        Algo.trieParCocktail(t5);
        assertArrayEquals(t5,t5bis);

        //Test un seul pas trié
        int [] t6 = {10,15,-20,25,35,35,40,45,50};
        int [] t6bis = {-20,10,15,25,35,35,40,45,50};
        Algo.trieParCocktail(t6);
        assertArrayEquals(t6,t6bis);

        //Test déjà trié
        int [] t7 = {-81,-12,82,83,84,85,86,87,88,89,90};
        int [] t7bis = t7;
        Algo.trieParCocktail(t7);
        assertArrayEquals(t7,t7bis);

        //Test trié en ordre décroissant
        int [] t8 = {72,71,70,69,68,67,66,65,-63,-64};
        int [] t8bis = {-64,-63,65,66,67,68,69,70,71,72};
        Algo.trieParCocktail(t8);
        assertArrayEquals(t8,t8bis);
    }

    @Test
    public final void testTrieParInsertion (){
        //Test tableau vide
        int [] t = {};
        int [] tbis = {};
        Algo.trieParInsertion(t);
        assertArrayEquals(t,tbis);

        //Test petit tableau avec petites valeurs
        int [] t1 = {5,-8,4,-3,2,0,9,7,6};
        int [] t1bis = {-8,-3,0,2,4,5,6,7,9};
        Algo.trieParInsertion(t1);
        assertArrayEquals(t1,t1bis);

        //Test petit tableau i.e 9 avec petites valeurs répétées
        int [] t2 = {6,1,1,-5,8,-5,9,9,1};
        int [] t2bis = {-5,-5,1,1,1,6,8,9,9};
        Algo.trieParInsertion(t2);
        assertArrayEquals(t2,t2bis);

        //Test petit tableau i.e 9 avec grandes valeurs
        int [] t3 = {21,55,78,-150,93,55,66,-66,45};
        int [] t3bis = {-150,-66,21,45,55,55,66,78,93};
        Algo.trieParInsertion(t3);
        assertArrayEquals(t3,t3bis);

        //Test moyen tableau i.e 18
        int [] t4 = {15,89,6400,-12,3,7,8,9,45,54,798,65,3,-454,12,45,48,4};
        int [] t4bis = {-454,-12,3,3,4,7,8,9,12,15,45,45,48,54,65,89,798,6400};
        Algo.trieParInsertion(t4);
        assertArrayEquals(t4,t4bis);

        //Test grand tableau i.e 27
        int [] t5 = {15,24,686,987,3,25,14,87,-687,87,15,45,789,85,23,2,14,5,26,9,7,0,0,45,666,1000,87};
        int [] t5bis = {-687,0,0,2,3,5,7,9,14,14,15,15,23,24,25,26,45,45,85,87,87,87,666,686,789,987,1000,};
        Algo.trieParInsertion(t5);
        assertArrayEquals(t5,t5bis);

        //Test un seul pas trié
        int [] t6 = {10,15,-20,25,35,35,40,45,50};
        int [] t6bis = {-20,10,15,25,35,35,40,45,50};
        Algo.trieParInsertion(t6);
        assertArrayEquals(t6,t6bis);

        //Test déjà trié
        int [] t7 = {-81,-12,82,83,84,85,86,87,88,89,90};
        int [] t7bis = t7;
        Algo.trieParInsertion(t7);
        assertArrayEquals(t7,t7bis);

        //Test trié en ordre décroissant
        int [] t8 = {72,71,70,69,68,67,66,65,-63,-64};
        int [] t8bis = {-64,-63,65,66,67,68,69,70,71,72};
        Algo.trieParInsertion(t8);
        assertArrayEquals(t8,t8bis);
    }
}
