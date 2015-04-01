# car-tp3
# Auteur : Jean-Serge Monbailly

Implémentation avec RMI d'une application de transfert de données.


Étape 1 
=======
Implémentation d'un programme mettant en place les différents éléments 
(pas encore RMI) permettant d'effectuer le travail voulu.

Écriture d'un main permettant de vérifier ce comportement.

src/entite 
----------
+ SiteItf	: interface représentant un élément de l'arbe de transmission
+ SiteImpl	: implémentation de l'interface décrite ci-dessus

src/main
--------
+ Main		: (main) permet de tester le bon fonctionnement des classes ci-dessus 


Étape 2
=======
Écriture d'un client et d'un serveur RMI pour y associer les objets à manipuler

Écriture d'une classe Tools contenant pour l'instant un champs statique indiquant le port du serveur RMI sur
lequel travailler.

src/rmi
-------
+ ServeurRMI	: (main) créé un serveur rmi et y ajoute les différents objets de l'arbre représenté
+ ClientRMI	: (main) lance un client qui récupère un élément de l'arbre ci-dessus et appelle une de ses fonctions
		(permet de vérifier le bon fonctionnement des objets distants)

src/utils
---------
+ Tools		: propose des champs statiques aux autres classes 


Étape 3
=======
Gestion de transfert de données en parallèle.
Lorsqu'un site enverra des données à ses fils, chaque envoi se fera dans un Thread différent.

src/entite
----------
+ TransfertThread 	:	class (extends Thread) permettant de lancer l'envoi des données dans un Thread 



TODO
====
+ Transformer les main RMI en classes à part entières pour accroitre leur possibilité.
+ Tester le programme de base
+ Tester les accès au entités RMI
+ Essayer d'éclater sur différents appels la définition des éléments de l'arbre
