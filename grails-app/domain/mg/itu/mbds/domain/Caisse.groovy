package mg.itu.mbds.domain

class Caisse {

    static belongsTo = [idExercice: Exercice]
    static hasMany = [mouvements: Mouvement]
    String label

    static constraints = {
    }


}
