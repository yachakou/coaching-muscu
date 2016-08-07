#Sujet : MiageCoaching!

##Rapport Architecture

>###1.Les technologies utilisées :

* __Les langages utilisés  :__
Nous utiliserons le langage Java pour le développement de notre application. Pour cela nous utiliserons également 
le langage JSP qui va nous permettre de réaliser une application web et dynamique. Tout cela étant géré par une servlet.


* __Les librairies  :__
Pour la réalisation des graphes, nous utiliserons les librairies JavaScript 
    * [Highcharts] (http://www.highcharts.com/) : Highcharts est une librairie Javascript permettant de créer des graphes de statistiques interactifs pour les sites web.
    * [amCharts] (http://www.amcharts.com/) : AmCharts est une librairie JavaSript pour la création de nombreux types de graphiques en JavaScript/HTML5.
    * [json-simple-1.1.1] (https://code.google.com/p/json-simple/downloads/detail?name=json-simple-1.1.1.jar&can=2&q=): Permet la gestion d'objet JSON.
    * [com.mysql.jdbc_5.1.5] (http://www.java2s.com/Code/Jar/c/Downloadcommysqljdbc515jar.htm) : Permet la connexion avec la base de données MySQL.
    * [javax.faces-2.2.0] (http://mvnrepository.com/artifact/org.glassfish/javax.faces/2.2.0-m01) : Nécessaire pour le bon fonctionnement de JSP. 
    * [tomcat 8.0.3] (https://tomcat.apache.org/download-80.cgi) : Serveur Tomcat nécessaire au bon fonctionnement du projet.
    
    
* __La base de données  :__
Nous utiliserons une base de données mySQL car elle présente plusieurs avantages :

    * __Rapide__: Le serveur MySQL est trés rapide. Des tests de performances sont disponibles sur le site de MySQL.
    * __Facile à utiliser__: MySQL est beaucoup plus simple à utiliser que la plupart des serveurs de bases de données commerciaux.
    * __Connexion et Sécurité__: MySQL dispose d'un système de sécurité permettant de gérer les personnes et les machines pouvant accéder aux différentes bases.
    * __Portabilité__: MySQL tourne sur divers systèmes tels que Unix, Windows, Linux ou OS/2.
    
 * __L'hébergement  :__   
    L'application sera stockée sur un serveur en ligne (gratuit pour le projet). Ce sera un serveur apache. Pour cela nous utiliserons l'hebergeur gratuit "AlwaysData".
    
>###2.Les acteurs :

L'utilisateur est un acteur dans notre cas. C'est lui qui va interagir avec l'application et effectuer les demandes.
L’application va lui répondre en affichant les pages correspondantes.

>###3.Architecture de l'application :

Dans le cadre de ce projet, nous utiliserons une architecture Modèle-Vue-Controlleur (MVC).
Celle ci nous semble être la plus efficace afin de répondre aux problèmes que peut nous poser l’application.
La servlet jouera le rôle de contrôleur, elle va permettre de vérifier les demandes de l’utilisateur et de les traiter avec les modèles correspondants. Une fois que le modèle correspondant a effectué le traitement, la vue est chargée d’afficher le résultat à l’utilisateur.
Dans le modèle, il y aura des classes qui se chargeront d’effectuer le traitement des données. Le diagramme de classes plus bas représente justement les différentes interactions que l’on a entre les classes pour ce projet.
Dans la vue, il y aura essentiellement des fichier jsp. Ces fichier se chargeront d’effectuer l’affichage de manière ergonomique.

>###4.Contraintes:

* __Technologiques:__ 
	L’utilisation de JAVA est rendue obligatoire pour ce projet.

* __De l’application:__ 
Un utilisateur peut creer plusieurs plans d'entrainements mais il ne peux en suivre qu’un seul à la fois.
Un utilisateur a également la possiblité de créer un exercice en renseignant une URL d'un site contenant differents sports.

* __Algorithmique:__
Pour la génération du plan d'entrainenemt en fonction des perfomances de l'utilisateur, on se basera sur les objectifs atteints par l'utilisateur et on appliquera un pourcentage
qui nous permettra de proposer un plan soit superieur ou inferieur à l'objectif défini précedement.

>###5.Diagrammes de séquence :

La classe Exercice des différents diagrammes de séquences est l'équivalent de la classe AbstractExercice présente dans le diagramme de classe.

 * __afficher plan d'entrainement :__ 
 
![affichePlanEntrainement](http://img15.hostingpics.net/pics/177931afficheplan.png)

Quand l'utilisateur veut afficher un plan d'entrainement, on invoque la méthode __afficheExcercice__, qui selectionne tout les exercices selon le programme d'entrainement suivi par l'utilisateur.  

 * __afficher statistiques :__ 
 
 ![afficheStat](http://img11.hostingpics.net/pics/734099afficheStat.png)

On passe un paramêtre utilisateur dans la fonction AfficheStatistiques afin d'avoir accès aux données personnelles de l'utilisateur et également afin de différiencier les différents programmes d'entrainements contenues dans la BDD. Car il n'est pas impossible que deux utilisateurs suivent le même plan d'entrainement mais leurs performances seront différentes.

* __creer exercice :__ 
 
 ![creerExcercice](http://img11.hostingpics.net/pics/861969ajoutexercice.png)

Si l'utilisateur souhaite ajouter un exercice à son plan d'entrainement, il devra rentrer un titre, une description et un temps (durée de l'exercice). Ces éléments permettront de créer un exercice qui sera ensuite ajouté au plan d'entrainement actuellement suivi par l'utilisateur.

* __creer programme :__ 
 
 ![creerProgramme](http://img11.hostingpics.net/pics/539948creerProgramme.png)

Pour créer un plan d'entrainement, l'utilisateur rentre une durée et une difficultée puis le système génère ce nouveau plan d'entrainement et le met dans la liste des plans d'entrainement de l'utilisateur. 

* __saisir les données d'une séance :__ 
 
 ![saisirDonneSceance](http://img11.hostingpics.net/pics/208237entrerseance.png)

Pour saisir les données d'une séance, l'utilisateur va devoir pour chaques exercices qui composent le plan d'entrainement rentrer ses performances. Ces performances seront stockées dans la BDD (avec la date et le numéro de la séance) et seront utilisées pour faire des statistiques et générer des exercices à l'utilisateur en fonction des ses performances. 

* __Generer un plan automatique :__ 
 
 ![GenererPlanAuto](http://img11.hostingpics.net/pics/573627genereplan.png)

Cette fonction génère un plan d'entrainement à l'utilisateur en fonction de ses performances. Le système proposera un ensemble d'exercices et pour chaque exercice, l'utilisateur validera pour son intégration dans son plan d'entrainement ou son rejet. 

* __Modifier ses données personnelles :__ 
 
 ![ModifDonnés](http://img11.hostingpics.net/pics/901406modifierdonnees.png)
 
 La méthode __ModifierDonnerUtilisateur__ renvoi vers un formulaire qui permet a l'utilisateur de modifier son poid désiré, son poid actuel et son temps de sommeil. 

* __Supprimer son compte :__ 
 
 ![SupprimCompte](http://img11.hostingpics.net/pics/690517supprimer.png)

* __Supprimer exercice:__ 
 
 ![SupprimeExcercie](http://img4.hostingpics.net/pics/922890supprimerExercice.png)

Pour supprimer un exercice, l'utilisateur choisit l'exercice en question dans son plan d'entrainement. Puis le système le retire du plan d'entrainement.

>###6. Schéma de la base de données :

![BD](http://img11.hostingpics.net/pics/332737miagecoaching.png)

* __Les différentes tables :__ 
    * __Utilisateur__ : Elle contient toutes les données de l'utilisateur, ces données ne seront pas modifiées (sauf exception ex: changement de mot de passe).
    * __DonneesUtilisateur__ : Elle contient les données de l'utilisateur qui peuvent être mises à jour fréquemment (poids, poids objectif et le temps de sommeil). On stocke la date de la mise à jour en timestamp pour une meilleure précision et pour avoir un historique. 
    * __DonneesUtilisateurGraphe__ : Elle contient l'historique des données de l'utilisateur et permet la réalisation du graphique
    * __Exercice__ : Elle contient les données propre à un exercice (titre, temps, description repetition et distance). Le type d'exercice fait référence à la table TypeExercice. Selon le type d'exercice, on rempli l'un des champs distance ou répétition.
    * __ExerciceDefaut__ : Elle contient des exercices par défaut et permet de générer un plan d'entrainement par défaut.
    * __TypeExercice__ : Elle contient l'id du type et le nom du type. Les valeurs possibles sont : 0 pour aerobis et 1 pour anaerobis.
    * __PlanEntrainement__ : Elle contient les données d'un plan d'entrainement, la difficulté qui prend les valeurs de 0 à 5, et une durée en timestamp.
    * __PlanEntrainementUtilisateur__ : Elle contient la référence de l'utilisateur et celui du plan d'entrainement. Elle dispose d'un attribut actif qui permet de savoir si le plan d'entrainement est celui qui est actuellement suivi par l'utilisateur. Nous avons un attribut date pour suivre l'historique. 
    * __PlanEntrainementExercice__ : Elle contient la référence du plan d'entrainement et celui de l'exercice. Cela permet d'associer les exercices à un plan d'entrainement. 
    * __Seance__ : Elle contient la référence de l'utilisateur et de l'exercice correspondant. Elle dispose des attributs temps, distance et répétition et d'une date. En effet on rempli soit la distance, soit la répétition selon le type d'exercice.
    
    
    
    >###7.Diagramme de classe :
    
    ![class](http://img4.hostingpics.net/pics/990508diagrammeclass.png)
        
        
    Nous avons choisi de reprensenter le diagramme de classe afin de vous donner une representation des differentes interactions entre les classes. Ce diagramme va permettre de se rendre compte du rôle de chaque classe.
        
        
    * __Les différentes classes :__ 
        * __Utilisateur__ : C'est la classe qui regroupe les attributs de l'utilisateur tel que le nom, prenom, mail. Cette classe permet à l'utilisateur de mettre à jour ses données, d'editer son profil. L'utilisateur peut posseder un poids objectif, qui est une option facultative. L'utilisateur est lié à un seul plan d'entrainement à la fois : il peut en suivre plusieurs mais il ne peut en suivre que un seul.
        * __Plan d'entrainement__ : La classe plan d'entrainement est utilisé par l'utilisateur pour creer ou générer un plan d'entrainement. Chaque plan d'entrainement possède une difficulté, qui se lit en nombre d'étoile, et une durée de ce plan d'entrainement.
        * __AbstractExercice__ :  C'est une classe abstraite qui permet de gérer tout les types d'exercices. Elle posséde les attributs commun aux deux types d'exercices (aerobis et anareobis) : un titre pour l'exercice, une description de l'exercice, et un temps qui correspond à la durée de l'exercice.
        * __Aerobis__ : C'est une classe concrète qui hérite de la classe AbstractExercices. C'est un type d'exercice concret, qui posséde une distance comme attribut.
        * __Anaerobis__ : C'est une autre classse concrete qui hérite de la classe AbstractExercices. C'est l'autre type d'exercice concret, qui lui possède des répétitions.
        * __Sexe__ : Enumération du sexe de l'utilisateur.
        * __Graphe__ : Cette classe permet de gérer la génération des graphes.
  
 

    

    
