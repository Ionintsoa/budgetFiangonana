package mg.itu.mbds.service

import grails.gorm.transactions.Transactional

import mg.itu.mbds.domain.Caisse

@Transactional
class CaisseService {
  def serviceMethod() {

  }

  def save(Caisse caisse) {
    caisse.save(failOnError: true)
  }

  def edit(String id, Caisse caisse) {
    def loadedObj = getById(id)
    loadedObj.properties = caisse.properties
    save(loadedObj)
  }

  def getAll() {
    return Caisse.list()
  }

  def getById(String id) {
    return Caisse.get(Long.parseLong(id))
  }

  def delete(String id) {
    return Caisse.get(Long.parseLong(id)).delete()
  }
}