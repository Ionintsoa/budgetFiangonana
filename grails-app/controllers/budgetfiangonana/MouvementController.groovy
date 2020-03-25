package budgetfiangonana

import mg.itu.mbds.service.CaisseService
import mg.itu.mbds.service.MouvementService
import mg.itu.mbds.domain.Mouvement
import mg.itu.mbds.domain.CompteUtilisateur

class MouvementController {

    CaisseService caisseService
    MouvementService mouvementService

    def index() { }

    def create() { 
        def response = caisseService.getAll()
        [caisses: response ?: []]
    }

    def save() {
        Mouvement mouvement = new Mouvement(params)
        // TO DO : id user tokony alaina avy ao am session
        CompteUtilisateur user = new CompteUtilisateur()
        user.id = 1;
        mouvement.user = user;
        mouvementService.save(mouvement);
        redirect(action:"index");
    }
}
