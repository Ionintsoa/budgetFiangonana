package mg.itu.mbds.domain

class Mouvement {

    static belongsTo = [user: CompteUtilisateur,caisse: Caisse]
    int typeMouvement
    double montant
    static constraints = {
    }
}
