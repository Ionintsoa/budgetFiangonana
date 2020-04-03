package budgetfiangonana

import mg.itu.mbds.service.CaisseService
import mg.itu.mbds.service.MouvementService
import mg.itu.mbds.domain.Mouvement
import mg.itu.mbds.model.TotalMouvement
import mg.itu.mbds.domain.CompteUtilisateur

class MouvementController {

    CaisseService caisseService
    MouvementService mouvementService

    def index() { 
        def listMouvement = mouvementService.getAll()
        [mouvements: listMouvement ?: []]
    }


    def stats() { 
        def filter = [
            typeMouvement: -1,
            month: -1,
            year: 2019
        ]
        if(params.typeMouvement) filter.typeMouvement = Integer.parseInt(params.typeMouvement)
        if(params.month) filter.month = Integer.parseInt(params.month)
        filter.year = params.year ? Integer.parseInt(params.year) : 0

        def months = mouvementService.getAllMonths()
        def types = mouvementService.getAllTypes()
        // for (String month : months) {
        //     println("Month  : "+month)
        // }

        println("Type: "+filter.typeMouvement)
        println("Month: "+filter.month)
        println("Year: "+filter.year)

        def listTotalMouvement = mouvementService.getTotalMouvement(filter.typeMouvement,"0",0,filter.month,filter.year)
        // for (TotalMouvement totalMouvement : listTotalMouvement) {
        //     println("Id  : "+totalMouvement.id+",  Type : "+totalMouvement.typeMouvement+",  Montant : "+totalMouvement.montant+",  Caisse : "+totalMouvement.caisse.id+",  Day : "+totalMouvement.day+",  Month : "+totalMouvement.month+",  Year : "+totalMouvement.year)
        // }
        [filter: filter, months: months, types: types, mouvements: listTotalMouvement ?: []]
    }

    def create() { 
        def response = caisseService.getAll()
        def pageContent = [
            btnSaveText : "Enregistrer",
            btnSaveClass : "btn-success",
            showCancelBtn : false,
            formAction : "save"
        ]
        Mouvement mouvement = new Mouvement()
        if(params.id) {
            mouvement = mouvementService.getById(params.id)
            if(mouvement.caisse.id > 0) {
                pageContent.btnSaveText = "Modifier"
                pageContent.showCancelBtn = true
                pageContent.formAction = "update"
                pageContent.btnSaveClass = "btn-primary"
            }
        }
        [caisses: response ?: [], mouvement: mouvement, pageContent : pageContent]
    }

    def save() {
        try {
            Mouvement mouvement = new Mouvement(params)
            // TO DO : id user tokony alaina avy ao am session
            CompteUtilisateur user = new CompteUtilisateur()
            user.id = 1;
            mouvement.user = user
            mouvement.dateCreation = new Date()
            mouvementService.save(mouvement)
            redirect(action:"index")
        } catch(Exception ex) {
            render view: "/mouvement/create", model: this.getCreateData()
        }
    }
    def delete() {
        try {
            if(params.id) {
                mouvementService.delete(params.id)
            }
            redirect(action:"index")
        } catch(Exception ex) {
            render view: "/mouvement/create", model: this.getCreateData()
        }
    }

    def update() {
        Mouvement mouvement = null
        try {
            mouvement = new Mouvement(params)
            // TO DO : id user tokony alaina avy ao am session
            CompteUtilisateur user = new CompteUtilisateur()
            user.id = 1;
            mouvement.user = user
            mouvement.dateCreation = new Date()
            mouvementService.edit(mouvement.id,mouvement)
            redirect(action:"index")
        } catch (Exception ex) {
            // println("ex   "+ex.)
            ex.printStackTrace()
            render view: "/mouvement/create", model: this.getCreateData(mouvement)
        }
    }

    def getCreateData(Mouvement mouvement) {
        def response = caisseService.getAll()
        def pageContent = [
            btnSaveText : "Enregistrer",
            btnSaveClass : "btn-success",
            showCancelBtn : false,
            formAction : "save"
        ]
        mouvement = mouvement != null ? mouvement : new Mouvement()
        if(params.id) {
            mouvement = mouvementService.getById(params.id)
            if(mouvement.caisse.id > 0) {
                pageContent.btnSaveText = "Modifier"
                pageContent.showCancelBtn = true
                pageContent.formAction = "update"
                pageContent.btnSaveClass = "btn-primary"
            }
        }
        return [caisses: response ?: [], mouvement: mouvement, pageContent : pageContent]
    }
}
