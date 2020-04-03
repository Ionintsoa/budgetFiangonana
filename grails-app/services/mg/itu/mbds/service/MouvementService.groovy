package mg.itu.mbds.service

import grails.gorm.transactions.Transactional

import mg.itu.mbds.domain.Mouvement
import mg.itu.mbds.model.TotalMouvement

@Transactional
class MouvementService {
  def serviceMethod() {

  }

  def save(Mouvement mouvement) {
    mouvement.save(failOnError: true)
  }

  def edit(String id, Mouvement mouvement) {
    def loadedObj = getById(id)
    loadedObj.properties = mouvement.properties
    save(loadedObj)
  }

  def getAll() {
    return Mouvement.list()
  }

  def getTotalMouvement(int type_mouvement, String caisse_id, int day, int month, int year) {
    def criteria = TotalMouvement.createCriteria()
    def totalMouvementList = null
    if(criteria!=null){
      totalMouvementList=criteria.list {
        if(type_mouvement>=0){
          eq("typeMouvement",type_mouvement)
        }
        if(Long.parseLong(caisse_id)>0){
          eq("caisse.id",Long.parseLong(caisse_id))
        }
        if(day>0){
          eq("day",day)
        }
        if(month>0){
          eq("month",month)
        }
        if(year>0){
          eq("year",year)
        }
      } as List<TotalMouvement>
    }
    return totalMouvementList
  }

  def getAllMonths() {
    String[] months = new String[13];
    months[0] = "Tous"
    months[1] = "Janvier"
    months[2] = "Février"
    months[3] = "Mars"
    months[4] = "Avril"
    months[5] = "Mai"
    months[6] = "Juin"
    months[7] = "Juillet"
    months[8] = "Août"
    months[9] = "Septembre"
    months[10] = "Octobre"
    months[11] = "Novembre"
    months[12] = "Décembre"

    return months;
  }

  def getAllTypes() {
    String[] types = new String[3];
    types[0] = "Tous"
    types[1] = "Crédit"
    types[2] = "Débit"

    return types;
  }

  def getById(String id) {
    return Mouvement.get(Long.parseLong(id))
  }

  def delete(String id) {
    return Mouvement.get(Long.parseLong(id)).delete()
  }
}