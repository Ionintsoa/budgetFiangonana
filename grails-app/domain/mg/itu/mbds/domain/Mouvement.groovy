package mg.itu.mbds.domain

class Mouvement {

    static belongsTo = [user: CompteUtilisateur,caisse: Caisse]
    int typeMouvement
    double montant
    String motif
    Date date
    Date dateCreation
    static constraints = {
        montant validator : {
            if(Double.compare(it,0) < 0) "invalid"
        }
    }

    def getStringDate() {
        if(this.date != null) {
            return this.date.toString().split(" ").length > 0 ? this.date.toString().split(" ")[0] : ""
        }
    }

    def getStringMontant() {
        int integerVersion = (int) this.montant
        return integerVersion.toString()
    }
}
