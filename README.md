#<span style="color:orange">Rapport projet</span>
 
 
###Sujet : MiageCoaching!

__MiageCoaching!__ est une application qui permet à un utilisateur de suivre ses performances dans la pratique d’un sport via des statistiques proposées par l'application.


>###1.Cas d’utilisation :
   
* l’utilisateur s’enregistre en fournissant _nom, prénom, login, mail, sexe, date de naissance, taille, poids_ et termine en créant un mot de passe. Il a la possibilité de mettre à jour son poids, son poids désiré ainsi que son nombre d'heures de sommeil.
* L’utilisateur se connecte en fournissant son _login et mot de passe_. 
Il a alors accès au tableau de bord qui lui propose les fonctionnalités suivantes:
 * __Créer un exercice :__ L’application permet  à l’utilisateur de rentrer ses propres exercices (selon ses propres critères). L’utilisateur propose un exercice en lui donnant un titre, une description, le nombre répétitions (combien de fois on répète l'exercice) et sa durée. Chaque exercice est spécifique aux choix de l’utilisateur : par exemple il peut avoir un temps mais pas de répétition (ex: footing).
 * __Enregistrer une séance de l’exercice effectué :__ L’utilisateur peut chaque jour spécifier les exercices qu’il a fait parmi ses exercices personnalisés. L’utilisateur saisie les données réalisés durant la séance par rapport aux objectifs de l’exercice. Par exemple, il a un objectif de 10 km mais ne cours que 7 km.
 * __Enregistrer d’autres mesures dans le temps :__ L’utilisateur peut renseigner son poids actuel, son poids désiré et son temps de sommeil.
 * __Visualiser l’évolution de ces progrès à l’aide de graphiques :__ Ces graphiques montreront l'évolution du poids, du sommeil et la fréquence des exercices réalisés dans le temps par rapport aux objectifs fixés. Il pourra également voir quelle proportion représente chaque grande catégorie d'exercice dans son programme (exemple : 50% cardio, 50% gainage).
 * __L’utilisateur pourra définir un plan d'entraînement :__ pour cela il choisit la série d’exercice qu’il veut effectuer durant un temps donnée et lui associe un niveau de difficulté.Ce niveau de difficulté sera traduit en nombres d'étoiles (de 0 à 5). Si l’utilisateur  ne trouve plus d’idée d’exercice, le système pourra également lui en générer en fonction de ses performances et de ses exercices personnalisés.
 * __Le système génère le plan d'entraînement à effectuer en fonction de l’évolution des performances de l’utilisateur :__ Selon le niveau de performance de l'utilisateur sur ses propres exercices, le système pourra lui proposer des exercices plus adaptés à ses performances. Notons que l’utilisateur ne peut suivre qu’un plan d'entraînement à la fois. 
 * __L’utilisateur peut désactiver son compte.__


>###2.les compléments d’informations nécessaires à la réalisation du projet:

* Informations sur les différents exercices de musculation.
* Informations sur la sécurité et la bonne  pratique des exercices proposés.
* Savoir comment les données mesurés (le sommeil, l’âge, le poids)  influencent les performances de l’utilisateur.

>###3.le diagramme de cas d'utilisation :
![useCase](http://img4.hostingpics.net/pics/561602UseCase.png)




# coaching-muscu
