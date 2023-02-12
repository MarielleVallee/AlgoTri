#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h> //Librairie booléen

//Comme il n'existe pas de type booléen on est obligé d'en créer
/*typedef int bool;
enum { false, true };*/

#define SECOND 1000000000 // nb de nanosecondes dans une seconde
#define MILLIS 1000000 // nb de nanosecondes dans une miliseconde

struct timespec start; //Dans la librairie time.h

//Démarre le chrono
void startMyChrono() {
    clock_gettime(CLOCK_MONOTONIC, &start);
}

//Renvoie le temps en nanosecondes du chrono actuel
long readMyChrono() {
    struct timespec end;
    clock_gettime(CLOCK_MONOTONIC, &end);
    //Convertit les secondes en nano
    return (end.tv_sec * SECOND + end.tv_nsec) -
           (start.tv_sec * SECOND + start.tv_nsec);
}
 
void triPeigne(int *tab, int taille) //Fonction tri_peigne
{
	int intervalle = taille;
	bool echange = true;
	int pivot;
	 
	while(intervalle > 1 || echange){
		
		//Pas de problème de conversion en C
		intervalle = intervalle/1.3;
		
		if(intervalle < 1 ){
			intervalle = 1;
		}
		
		int i = 0;
		echange = false;
		
		while( i < taille - intervalle){
			
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

//Remplit le tableau de données random
void genereDonnees (int *tab, int taille ){

        int i;
        for (i = 0 ; i < taille ; i++){
            tab[i] = rand(); // tirage aléatoire d'un int quelconque 
        }

}



//Par convention : le main retourne 0 s'il s'est bien exécuté
int main()
{

     // On initialise le générateur de nombre pseudo-aléatoires.
    srand( time( NULL ) );
    
    
    
    //Déclaration des tableaux
    int t1[] = {3,1,4,1,5,6};
    //int t2[] = {1,7,5,1,8,4,9,10,11,5};
    int tailleTab = sizeof(t1)/sizeof(t1[0]);
    int i;
    
    //Appel fonction triPeigne
    //triPeigne(t1,tailleTab);
    
	//Affichage du tableau trié
    /*for(i = 0; i < tailleTab ; i++ ){
        printf("%d \n", t1[i]);
    }*/

    //Remplissons le tableau de 200 000 valeurs
    int donnees[200000]; //A modifier ici si on veut plus ou moins de valeurs
    int tailleDonnees = sizeof(donnees)/sizeof(donnees[0]);
    
    genereDonnees(donnees,tailleDonnees);
    
    /*for(i = 0; i < tailleDonnees ; i++ ){
        printf("%d \n", donnees[i]);
    }*/
    
    startMyChrono();
    
    triPeigne(donnees,tailleDonnees);
    
    //Convertit les nano en milisecondes
    printf( "Temps écoulé = %ld ms\n", readMyChrono()/MILLIS );

    return 0;
}
