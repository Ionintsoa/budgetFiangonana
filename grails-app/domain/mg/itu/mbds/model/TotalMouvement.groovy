package mg.itu.mbds.model

import mg.itu.mbds.domain.Caisse

class TotalMouvement {

    static belongsTo = [caisse: Caisse]
    int typeMouvement
    double montant
    int day
    int month
    int year
    static constraints = {
        montant validator : {
            if(Double.compare(it,0) < 0) "invalid"
        }
    }

    def getMonth(int month) {
        String[] months = new String[12]
        months[0] = "Janvier"
        months[1] = "Février"
        months[2] = "Mars"
        months[3] = "Avril"
        months[4] = "Mai"
        months[5] = "Juin"
        months[6] = "Juillet"
        months[7] = "Août"
        months[8] = "Septembre"
        months[9] = "Octobre"
        months[10] = "Novembre"
        months[11] = "Décembre"
        if(month<=0) {
            throw new Exception("Mois invalide dans getMonth")
        }
        return months[month-1];
    }
}
