package mg.itu.mbds.service

import grails.gorm.transactions.Transactional

import mg.itu.mbds.domain.Mouvement

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

  def getById(String id) {
    return Mouvement.get(Long.parseLong(id))
  }

  def delete(String id) {
    return Mouvement.get(Long.parseLong(id)).delete()
  }
}