<%--
  Created by IntelliJ IDEA.
  User: yachakou
  Date: 11/03/2015
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>


<br><center><button id='ajoutExo' type='button' value='Creer un exercice' class='btn btn-primary'>Creer un exercice</button></center>



<div id="ajout" style="display:none;">
    <br>
    <br>
    <div style="background: #4390c8;border-radius:3px;"><center><h1 style="color:white;padding: 10px;">Ajout d'un exercice :</h1></center></div>
    <div>
        <label>Type d'exercie</label><br>
        <input type="radio" onclick="afficherblock(2);" name="group1" id="anareobis" value="Anareobis"> Anareobis<br>
        <input type="radio" onclick="afficherblock(1);" name="group1" id="aerobis" value="Aerobis"> Aerobis<br>
    </div>
    <div id='form_anareobis'  style="display:none;">
        <form action="http://localhost:8080/ControlleurAjoutExercice" role="form"  method="POST" >
            <input name='idPlan' type='hidden' value='<%=p.getId()%>'/>
            <div class="form-group">
                <label for="title">Titre:</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="Entrez le titre de votre exercice" required>
            </div>
            <div class="form-group">
                <label for="time">Temps (en minutes) :</label>
                <input type="number"  class="form-control" id="time" name="time" placeholder="Durée de la seance " required>
            </div>
            <div class="form-group">
                <label for="desc">Description :</label>
                <input type="text" class="form-control" id="desc" name="desc" placeholder="Description" required>
            </div>

            <div class="form-group">
                <label for="rep">Repetitions:</label>
                <input type="number" class="form-control" id="rep" name="rep" placeholder="Nombre de repetitions " required>
            </div>

            <input type="hidden" name="type" value="0"/>

            <button type="submit" class="btn btn-default">Ajouter l'exercie</button>

        </form>
    </div>

    <div id='form_aerobis'  style="display:none;">
        <form action="http://localhost:8080/ControlleurAjoutExercice" role="form"  method="POST" >
            <input name='idPlan' type='hidden' value='<%= p.getId() %>'/>
            <div class="form-group">
                <label for="title">Titre:</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="Entrez le titre de votre exercice" required>
            </div>
            <div class="form-group">
                <label for="time">Temps (en minutes) :</label>
                <input type="text" class="form-control" id="time" name="time" placeholder="Durée de la seance " required>
            </div>
            <div class="form-group">
                <label for="desc">Description :</label>
                <input type="text" class="form-control" id="desc" name="desc" placeholder="Description" required>
            </div>

            <div class="form-group">
                <label for="dist">Distance:</label>
                <input type="number" class="form-control" id="dist" name="dist" placeholder="Distance " required>
            </div>
            <input type="hidden" name="type" value="1"/>

            <button type="submit" class="btn btn-default">Ajouter l'exercie</button>

        </form>

    </div>


</div>

<script>
    $("#ajoutExo").click(function(){ document.getElementById("ajout").style.display="block"; });
    function afficherblock(number)
    {
        if(number==1)
        {
            document.getElementById("form_aerobis").style.display="block";
            document.getElementById("form_anareobis").style.display="none";
        }
        else {
            document.getElementById("form_aerobis").style.display="none";
            document.getElementById("form_anareobis").style.display="block";
        }

    }
</script>