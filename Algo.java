import java.util.Random;

public class Algo {


    public static void main(String[] args) {
//        int[] donnees = générerDonnéesEntreBornes(50, 0, 20);
//        System.out.println(Arrays.toString(donnees));

        int[] donnees = genererDonnees(200000);
        //int[] donnees = générerDonnéesEntreBornes(200000, 0, 99999999);

        long tempsDebut = System.nanoTime();

        // Arrays.sort(donnees); // trie le tableau en utilisant un algorithme de type Quicksort

        //triComptage(donnees);
        triPeigne(donnees);
        //trieParCocktail(donnees);
        //trieParInsertion(donnees);

        long tempsFin = System.nanoTime();

        System.out.println("Temps de calcul en millisecondes: " + ((tempsFin - tempsDebut) / 1000000) );

//        System.out.println(Arrays.toString(donnees));
    }

    /*
        Retourne un tableau de int de longueur n rempli avec des valeurs aléatoires
        (valeurs comprises entre Integer.MIN_VALUE=-2^31 et Integer.MAX_VALUE=2^31-1 inclus).
    */
    public static int[] genererDonnees(int n) {
        Random random = new Random();
        int[] t = new int[n];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(); // tirage aléatoire d'un int quelconque (compris entre -2^31 et 2^31-1)
        return t;
    }

    /*
        Retourne un tableau de int de longueur n rempli avec des valeurs aléatoires comprises entre min et max inclus.
    */
    public static int[] générerDonnéesEntreBornes(int n, int min, int max) {
        Random random = new Random();
        int[] t = new int[n];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(max-min+1)+min; // nextInt(borne) retourne un int compris entre 0 inclus et borne exclus.
        return t;
    }

    //Que pour des tableaux d'entiers positifs
    //Crée un tableau dans lequel on compte le nombre d'occurences du tableau
    // puis modifie le tableau pris en paramètres en fonction du tableau de nombre d'occurences
    public static void triComptage (int [] tab){

        if(tab.length != 0) {
            //Chercher la plus grande valeur
            int max = tab[0];

            for (int i = 0; i < tab.length; i++) {
                if (tab[i] > max) {
                    max = tab[i];
                }
            }

            //Crée le tableau qui contiendra les occurences
            int[] tabComptage = new int[max + 1];

            //On parcourt le tableau pris en paramètre et on ajoute 1 dans le tableau de comptage à l'indice de même valeur
            for (int i = 0; i < tab.length; i++) {
                tabComptage[tab[i]] += 1;
            }

       /* for (int j = 0; j < tabComptage.length ; j++){
            System.out.println(tabComptage[j]);
        }*/

            //On parcourt le tableauComptage
            //On parcourt la valeur de chaque case du tableauComptage
            //Pour chaque valeur du tableauComptage on ajoute la valeur dans le tableau pris en paramètres
            int ind = 0; //indice du tableau pris en paramètres
            for (int i = 0; i < tabComptage.length; i++) //Permet d'avoir l'indice
            {
                for (int j = 1; j <= tabComptage[i]; j++) //Pour chaque indice on regarde le nombre d'occurences
                {
                    tab[ind] = i;
                    //System.out.println(tab[ind]);
                    ind++;

                }
            }
        }


    }

    //Compare 2 indices plus éloignés
    // puis réduit progressivement l'écart entre les 2 indices comparés
    // jusqu'à retourner sur un tri à bulles classique
    public static void triPeigne (int [] tab){

        //Initialiser l'écart qui va permettre de comparer 2 indices éloignés
        int intervalle = tab.length;
        boolean echange = true;
        int pivot;

        while (intervalle > 1 || echange ){

            //On modifie l'intervalle qu'on réduira à chaque tour de boucle
            intervalle = (int)(intervalle / 1.3 );
            //ATTENTION : On ne peut pas finir avec un intervalle de moins de 1
            if (intervalle < 1){
                intervalle = 1;
            }

            //On crée des variables pour gérer la boucle imbriquée
            int i = 0; //indice du premier qu'on compare à l'autre et qui va augmenter de 1
            echange = false;

            //tab.length - intervalle car on ne veut pas le comparer avec un indice hors du tableau
            while (i < tab.length - intervalle){
                //On compare les 2 indices et on échange si besoin
                if (tab[i] > tab[i+intervalle]){

                    pivot = tab[i];
                    tab[i]= tab[i+intervalle];
                    tab[i+intervalle]=pivot;

                    echange = true;
                }
                i++;
            }
        }

    }

    // tri à bulles avec aller retour
    public static void trieParCocktail (int []tab){

        int debut = 0;
        int fin = tab.length-2;
        // -2 Car on ne veut pas comparer avec un indice hors du tableau quand i+1
        // et tab.length -1 est le dernier indice du tableau
        boolean echange = true;
        int pivot;

        while (echange){
            echange = false;

            //On parcourt en premier dans le sens croissant des indices
            //On compare les indices 1 à 1 i.e celui d'avant avec le suivant (tri à bulles classique)
            for (int i = debut; i<fin; i++) {
                if (tab[i] > tab[i + 1]) {
                    pivot = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = pivot;
                    echange = true;
                }
            }

            //Puis on fait la même chose dans l'autre sens
            echange = false;
            for (int j = fin; j>=0; j--){
                if (tab[j]> tab[j+1]){
                    pivot = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = pivot;
                    echange = true;
                }
            }
        }
    }

    //Classique vu en cours : On commence par le 2 ème indice qu'on compare au premier
    // les élements précédents sont déjà triés
    // Et ainsi de suite : tri avec un pivot
    public static void trieParInsertion (int []tab ){

        int pivot;
        int j;

        for(int i = 1; i < tab.length ; i++ ){
            // On garde en mémoire la valeur de l'indice qu'on utilise
            pivot = tab[i];
            j = i;

            // On décale les éléments précédents tant qu'ils sont plus grands que la valeur de l'indice
            //ATTENTION à ne pas sortir du tableau
            while (j > 0 && tab[j-1] > pivot){
                tab[j] = tab[j-1];
                j--;
            }

            tab[j] = pivot;
        }

    }

}





